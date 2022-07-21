#pragma once
#include "llvm/ADT/Triple.h"
#include "llvm/Support/Host.h"
#include "llvm/IR/IRBuilder.h"
#include "llvm/IR/LLVMContext.h"
#include "llvm/IR/Module.h"
#include "LuaBaseVisitor.h"

#include "vars.h"

namespace luac{
class IRGenerator : public LuaBaseVisitor {
 public:
  IRGenerator(const char* name) {
    context = std::make_unique<llvm::LLVMContext>();
    module = std::make_unique<llvm::Module>(name, *context);
    builder = std::make_unique<llvm::IRBuilder<>>(*context);
    module->setTargetTriple(llvm::sys::getDefaultTargetTriple());
    vars = std::make_unique<LuaVarManager>(module.get(), context.get(),
                                           builder.get());
  }
  std::any visitFunctioncall(LuaParser::FunctioncallContext *ctx) override;
  std::any visitStat(LuaParser::StatContext *ctx) override;
  std::any visitExp(LuaParser::ExpContext *ctx) override;
  std::any visitVar_(LuaParser::Var_Context *ctx) override;
  std::any visitNumber(LuaParser::NumberContext *ctx) override;
  std::any visitString(LuaParser::StringContext *ctx) override;
  
  std::any visitChunk(LuaParser::ChunkContext *ctx) override;

  void dump() { module->print(llvm::errs(), nullptr); }

 private:
  llvm::Value *callAdd(llvm::Value *lv, llvm::Value *rv);

  std::unique_ptr<llvm::LLVMContext> context;
  std::unique_ptr<llvm::Module> module;
  std::unique_ptr<llvm::IRBuilder<>> builder;

  std::unique_ptr<LuaVarManager> vars;
  std::map<std::string, llvm::StructType *> structs;
  //std::map<std::string, llvm::Value *> vars;
  llvm::Function *current_function;
};
}