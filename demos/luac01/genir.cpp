
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

std::any IRGenerator::visitFunctioncall(LuaParser::FunctioncallContext *ctx) {
  std::string funcName = ctx->varOrExp()->var_()->getText();
  if (funcName == "print") {
    std::string arg =
        ctx->nameAndArgs()[0]->args()->explist()->exp()[0]->string()->getText();
    std::cout << funcName << std::endl;
    std::cout << arg << std::endl;
    // 1 create the function
    std::vector<llvm::Type *> arg_types = {llvm::Type::getInt8PtrTy(*context)};
    llvm::FunctionType *function_type = llvm::FunctionType::get(
        llvm::Type::getVoidTy(*context), arg_types, false);
    llvm::FunctionCallee print_function =
        module->getOrInsertFunction("print", function_type);

    // 2 call the function
    llvm::Value *strPointer = builder->CreateGlobalStringPtr(arg);
    std::vector<llvm::Value *> args;
    args.push_back(strPointer);
    builder->CreateCall(print_function, args);
  }
  return LuaBaseVisitor::visitFunctioncall(ctx);
}

}  // namespace luac