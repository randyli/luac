#include "vars.h"

namespace luac {
llvm::Value* LuaVarManager::getOrCreateVar(std::string& name) {
  auto it = vars.find(name);
  if(it != vars.end()) {
    return it->second;
  }
  llvm::Value* var = builder->CreateAlloca(varStruct, nullptr, name);
  vars[name] = var;
  return var;
}

llvm::Value* LuaVarManager::getOrCreateGlobalVar(std::string& name) {
  auto it = vars.find(name);
  if(it != vars.end()) {
    return it->second;
  }

  //llvm::Value* var = module->getOrInsertGlobal(name, varStruct);

  llvm::GlobalVariable* var = new llvm::GlobalVariable(*module, 
        /*Type=*/varStruct,
        /*isConstant=*/false,
        /*Linkage=*/llvm::GlobalValue::CommonLinkage,
        /*Initializer=*/llvm::Constant::getNullValue(varStruct) // has initializer, specified below
        /*Name=*/);

  vars[name] = var;
  return var;
}

 void LuaVarManager::setVarStr(llvm::Value* var, llvm::Value* intv) {
    llvm::Value *typeField = builder->CreateGEP(
      varStruct, var, {builder->getInt32(0), builder->getInt32(0)});
  builder->CreateStore(llvm::ConstantInt::get(builder->getInt64Ty(), 2),
                       typeField);

  llvm::Value *dataField = builder->CreateGEP(
      varStruct, var, {builder->getInt32(0), builder->getInt32(1)});
  llvm::Value *toCharPtr = builder->CreateBitCast(
      dataField, llvm::PointerType::getUnqual(llvm::IntegerType::getInt8PtrTy(*context)));

  //llvm::Value *strPointer = builder->CreateGlobalStringPtr(RH);
  builder->CreateStore(intv,toCharPtr);
 }
 void LuaVarManager::setVarInt(llvm::Value* var, llvm::Value* intv) {
    llvm::Value *typeField = builder->CreateGEP(
      varStruct, var, {builder->getInt32(0), builder->getInt32(0)});
  builder->CreateStore(llvm::ConstantInt::get(builder->getInt64Ty(), 1),
                       typeField);

  llvm::Value *dataField = builder->CreateGEP(
      varStruct, var, {builder->getInt32(0), builder->getInt32(1)});
  llvm::Value *toInt = builder->CreateBitCast(
      dataField, llvm::IntegerType::getInt64PtrTy(*context));
  builder->CreateStore(intv,toInt);
 }
 // a = b
 void LuaVarManager::assign(llvm::Value* from, llvm::Value* to) {
   builder->CreateMemCpy(to, llvm::MaybeAlign(0), from, llvm::MaybeAlign(0), this->getLuaVarSize());
 }
}