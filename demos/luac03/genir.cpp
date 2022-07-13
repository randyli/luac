
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
    std::string RH = ctx->explist()->exp()[0]->number()->getText();
    auto luaVarStruct = this->getOrCreateLuaVarStruct();
    llvm::Value* var = builder->CreateAlloca(luaVarStruct, nullptr, varName);
    llvm::Value *typeField = builder->CreateGEP(luaVarStruct, var, 
      {
        builder->getInt32(0), 
        builder->getInt32(0)
      });
    builder->CreateStore(llvm::ConstantInt::get(builder->getInt32Ty(), 1), typeField);

    llvm::Value *dataField = builder->CreateGEP(luaVarStruct, var, 
      {
        builder->getInt32(0), 
        builder->getInt32(1)
      });
    uint32_t rhValue = stoi(RH);
    builder->CreateStore(llvm::ConstantInt::get(builder->getInt32Ty(), rhValue),
                         dataField);
    vars[varName] = var;

  } else {
    LuaBaseVisitor::visitStat(ctx);
  }
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
//   int32 data,
// }
llvm::StructType* IRGenerator::getOrCreateLuaVarStruct() {
  auto it = structs.find("struct.LuaVar");
  if (it != structs.end()) {
    return it->second;
  }
  //llvm::StructType* luaVarTy = llvm::StructType::get(*context);

  auto luaVar = llvm::StructType::create(*context, "struct.LuaVar");
  auto tyType = llvm::IntegerType::getInt32Ty(*context);
  auto dataType = llvm::IntegerType::getInt32Ty(*context);
  std::vector<llvm::Type *> items = {tyType, dataType};
  luaVar->setBody(items);
  structs["struct.LuaVar"] = luaVar;
  return luaVar;
}

}  // namespace luac