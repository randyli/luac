
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
    llvm::Value *var = vars->getOrCreateVar(varName);
    std::any rv = LuaBaseVisitor::visitExplist(ctx->explist());
    llvm::Value *v = std::any_cast<llvm::Value*>(rv);
    //vars->setVarInt(var, v);
    vars->assign(v, var);
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

std::any IRGenerator::visitExp(LuaParser::ExpContext *ctx) {
  if(ctx->children.size() == 3 && ctx->children[1]->getText() == "+"){
    auto l = visitExp((LuaParser::ExpContext *)ctx->children[0]);
    auto r = visitExp((LuaParser::ExpContext *)ctx->children[2]);

    llvm::Value *lv = std::any_cast<llvm::Value *>(l);
    llvm::Value *rv = std::any_cast<llvm::Value *>(r);
    auto tmp = callAdd(lv, rv);
    return std::any_cast<llvm::Value*>(tmp);  // builder->CreateAdd(lv, rv); //create function call
  }
  return LuaBaseVisitor::visitExp(ctx);
}

std::any IRGenerator::visitVar_(LuaParser::Var_Context* ctx){
  std::string varName = ctx->getText();
  return vars->getOrCreateVar(varName);
}

std::any IRGenerator::visitNumber(LuaParser::NumberContext * ctx) {
  std::string RH = ctx->getText();
  uint32_t rhValue = stoi(RH);
  auto var = vars->getOrCreateGlobalVar(RH);
  llvm::Value *num = llvm::ConstantInt::get(builder->getInt64Ty(), rhValue);
  vars->setVarInt(var, num);
  return var;
}

std::any IRGenerator::visitString(LuaParser::StringContext *ctx) {
    std::string RH = ctx->getText();
    auto var = vars->getOrCreateGlobalVar(RH);
    
    llvm::Value *strPointer = builder->CreateGlobalStringPtr(RH);
    vars->setVarStr(var, strPointer);
    return var;
}

std::any IRGenerator::visitFunctioncall(LuaParser::FunctioncallContext *ctx) {
  std::string funcName = ctx->varOrExp()->var_()->getText();
  if (funcName == "print") {
    
    std::string arg =
        ctx->nameAndArgs()[0]->args()->explist()->exp()[0]->getText();
    std::cout << funcName << std::endl;
    std::cout << arg << std::endl;
    // 1 create the function
    auto luaVarStructType = vars->getLuaVarStruct();
    std::vector<llvm::Type *> arg_types = {
        llvm::PointerType::get(luaVarStructType, 0),
    };
    llvm::FunctionType *function_type = llvm::FunctionType::get(
        llvm::Type::getVoidTy(*context), arg_types, false);
    llvm::FunctionCallee print_function =
        module->getOrInsertFunction("print", function_type);

    // 2 call the function
    auto var = vars->getOrCreateVar(arg);
    // llvm::Value *strPointer = builder->get(var->second);
    std::vector<llvm::Value *> args;
    args.push_back(var);
    builder->CreateCall(print_function, args);
    
  }
  return LuaBaseVisitor::visitFunctioncall(ctx);
}

llvm::Value *IRGenerator::callAdd(llvm::Value *lv, llvm::Value *rv) {
// 1 create the function
    auto luaVarStructType = vars->getLuaVarStruct();
    std::vector<llvm::Type *> arg_types = {
        llvm::PointerType::get(luaVarStructType, 0), // left value
        llvm::PointerType::get(luaVarStructType, 0), // right value
        llvm::PointerType::get(luaVarStructType, 0), // result
    };
    llvm::FunctionType *function_type = llvm::FunctionType::get(
        llvm::Type::getVoidTy(*context), arg_types, false);
    llvm::FunctionCallee lua_add_function =
        module->getOrInsertFunction("lua_add", function_type);

    // 2 call the function
    auto tmpVar = std::string("tmp");
    auto tmp = vars->getOrCreateVar(tmpVar);
    // llvm::Value *strPointer = builder->get(var->second);
    std::vector<llvm::Value *> args;
    args.push_back(lv);
    args.push_back(rv);
    args.push_back(tmp);
    builder->CreateCall(lua_add_function, args);
    return tmp;
}

}  // namespace luac