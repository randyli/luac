// 变量管理
#pragma once

#include <map>
#include <string>

#include "llvm/IR/DerivedTypes.h"
#include "llvm/IR/IRBuilder.h"
#include "llvm/IR/LLVMContext.h"
#include "llvm/IR/Type.h"
#include "llvm/IR/Value.h"

namespace luac {

class LuaVarManager {
 public:
  LuaVarManager(llvm::Module* module, llvm::LLVMContext* ctx, llvm::IRBuilder<>* builder)
      : module(module), context(ctx), builder(builder) {
    auto luaVarUnion = llvm::StructType::create(*context, "union.anos");
    auto int64Type = llvm::IntegerType::getInt64Ty(*context);
    luaVarUnion->setBody({int64Type});

    auto luaVar = llvm::StructType::create(*context, "struct.LuaVar");
    auto tyType = llvm::IntegerType::getInt64Ty(*context);
    std::vector<llvm::Type*> items = {tyType, luaVarUnion};
    luaVar->setBody(items);
    varStruct = luaVar;
  }

  llvm::Value* getOrCreateVar(std::string& name);
  llvm::Value* getOrCreateGlobalVar(std::string& name);
  void setVarInt(llvm::Value* var, llvm::Value* intv);
  void setVarStr(llvm::Value* var, llvm::Value* strv);
  llvm::StructType* getLuaVarStruct() { return varStruct; }
  
  llvm::Value* getLuaVarSize() {
    return llvm::ConstantInt::get(llvm::Type::getInt64Ty(*context),
                           module->getDataLayout().getTypeAllocSize(varStruct));
  }

  void assign(llvm::Value* from, llvm::Value* to);

 private:
  llvm::Module* module;
  llvm::LLVMContext* context;
  llvm::IRBuilder<>* builder;
  llvm::StructType* varStruct;
  std::map<std::string, llvm::Value*> vars;
};
}  // namespace luac