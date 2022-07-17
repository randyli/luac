
#include "genir.h"

#include "llvm/IR/Function.h"
#include "llvm/IR/IRBuilder.h"
#include "llvm/IR/Module.h"
#include "llvm/IR/Type.h"
#include "llvm/IR/Verifier.h"

namespace luac {

std::any IRGenerator::visitChunk(LuaParser::ChunkContext *ctx) {
  // 创建int main() {}
  std::vector<llvm::Type *> arg_types;  // empty
  llvm::FunctionType *function_type = llvm::FunctionType::get(
      llvm::Type::getInt32Ty(*context), arg_types, false);
  llvm::Function *main_function = llvm::Function::Create(
      function_type, llvm::Function::ExternalLinkage, "main", *module);
  current_function = main_function;
  llvm::BasicBlock *BB =
      llvm::BasicBlock::Create(*context, "entry", main_function);
  builder->SetInsertPoint(BB);

  // 生成函数体
  LuaBaseVisitor::visitChunk(ctx);
  
  //创建main函数的返回
  auto RetVal = llvm::ConstantInt::get(
      *context, llvm::APInt(/*nbits*/ 32, 0, /*bool*/ true));
  builder->CreateRet(RetVal);
  return 0;
}
std::any IRGenerator::visitStat(LuaParser::StatContext *ctx){
  // a = 123
  if (ctx->children.size() >= 3 && ctx->children[1]->getText() == "=") {
    std::string varName = ctx->varlist()->var_()[0]->getText();
    
    auto luaVarStruct = this->getOrCreateLuaVarStruct();
    llvm::Value* var = builder->CreateAlloca(luaVarStruct, nullptr, varName);
    vars[varName] = var;
    current_lh = var;
    visitExplist(ctx->explist());
    return 0;
  }

  //while 
  if(ctx->children[0]->getText() == "while") {    
    auto condBB = llvm::BasicBlock::Create(*context, "while.cond", current_function);
    builder->CreateBr(condBB);
    builder->SetInsertPoint(condBB);
    auto cmpResult = builder->CreateICmpNE(
      llvm::ConstantInt::get(builder->getInt32Ty(), 1), 
      llvm::ConstantInt::get(builder->getInt32Ty(), 0)
    );
    auto bodyBB = llvm::BasicBlock::Create(*context, "while.body", current_function);
    auto endBB = llvm::BasicBlock::Create(*context, "while.end", current_function);
    builder->CreateCondBr(cmpResult, bodyBB, endBB);
    builder->SetInsertPoint(bodyBB);
    // 循环体
    visitBlock(ctx->block()[0]);
    builder->CreateBr(condBB);
    builder->SetInsertPoint(endBB);
    return 0;
  }
  LuaBaseVisitor::visitStat(ctx);
  return 0;
}

std::any IRGenerator::visitNumber(LuaParser::NumberContext * ctx) {
  std::string RH = ctx->getText();
  auto luaVarStruct = this->getOrCreateLuaVarStruct();
  
  llvm::Value *typeField = builder->CreateGEP(
      luaVarStruct, current_lh, {builder->getInt32(0), builder->getInt32(0)});
  builder->CreateStore(llvm::ConstantInt::get(builder->getInt32Ty(), 1),
                       typeField);

  llvm::Value *dataField = builder->CreateGEP(
      luaVarStruct, current_lh, {builder->getInt32(0), builder->getInt32(1)});
  llvm::Value *toInt = builder->CreateBitCast(
      dataField, llvm::IntegerType::getInt64PtrTy(*context));
  uint32_t rhValue = stoi(RH);
  builder->CreateStore(llvm::ConstantInt::get(builder->getInt64Ty(), rhValue),
                       toInt);
  return 0;
}

std::any IRGenerator::visitString(LuaParser::StringContext *ctx) {
    std::string RH = ctx->getText();
  auto luaVarStruct = this->getOrCreateLuaVarStruct();
  
  llvm::Value *typeField = builder->CreateGEP(
      luaVarStruct, current_lh, {builder->getInt32(0), builder->getInt32(0)});
  builder->CreateStore(llvm::ConstantInt::get(builder->getInt32Ty(), 2),
                       typeField);

  llvm::Value *dataField = builder->CreateGEP(
      luaVarStruct, current_lh, {builder->getInt32(0), builder->getInt32(1)});
  llvm::Value *toCharPtr = builder->CreateBitCast(
      dataField, llvm::PointerType::getUnqual(llvm::IntegerType::getInt8PtrTy(*context)));

  llvm::Value *strPointer = builder->CreateGlobalStringPtr(RH);
  builder->CreateStore(strPointer,toCharPtr);
  return 0;
}

std::any IRGenerator::visitFunctioncall(LuaParser::FunctioncallContext *ctx) {
  std::string funcName = ctx->varOrExp()->var_()->getText();
  if (funcName == "print") {
    
    std::string arg =
        ctx->nameAndArgs()[0]->args()->explist()->exp()[0]->getText();
    std::cout << funcName << std::endl;
    std::cout << arg << std::endl;
    // 1 create the function
    auto luaVarStructType = this->getOrCreateLuaVarStruct();
    std::vector<llvm::Type *> arg_types = {
        llvm::PointerType::get(luaVarStructType, 0),
    };
    llvm::FunctionType *function_type = llvm::FunctionType::get(
        llvm::Type::getVoidTy(*context), arg_types, false);
    llvm::FunctionCallee print_function =
        module->getOrInsertFunction("print", function_type);

    // 2 call the function
    auto var = vars.find(arg);
    if(var == vars.end()) {
      std::cerr << "variable not defined: " << arg << std::endl;
      return 0;
    }
    //llvm::Value *strPointer = builder->get(var->second);
    std::vector<llvm::Value *> args;
    args.push_back(var->second);
    builder->CreateCall(print_function, args);
    
  }
  return LuaBaseVisitor::visitFunctioncall(ctx);
}
// struct LuaVar {
//   int32 type,
//   union {int64 ival; float fval; char* sval;} val;
// }
llvm::StructType* IRGenerator::getOrCreateLuaVarStruct() {
  auto it = structs.find("struct.LuaVar");
  if (it != structs.end()) {
    return it->second;
  }
  //llvm::StructType* luaVarTy = llvm::StructType::get(*context);
  auto luaVarUnion = llvm::StructType::create(*context, "union.anos");
  auto int64Type = llvm::IntegerType::getInt64Ty(*context);
  luaVarUnion->setBody({int64Type});

  auto luaVar = llvm::StructType::create(*context, "struct.LuaVar");
  auto tyType = llvm::IntegerType::getInt32Ty(*context);
  //auto dataType = llvm::IntegerType::getInt32Ty(*context);
  std::vector<llvm::Type *> items = {tyType, luaVarUnion};
  luaVar->setBody(items);
  structs["struct.LuaVar"] = luaVar;
  return luaVar;
}

}  // namespace luac