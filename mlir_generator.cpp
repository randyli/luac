#include "mlir_generator.h"

#include "llvm/ADT/StringRef.h"
#include "llvm/IR/Module.h"
#include "llvm/Support/CommandLine.h"
#include "llvm/Support/ErrorOr.h"
#include "llvm/Support/MemoryBuffer.h"
#include "llvm/Support/SourceMgr.h"
#include "llvm/Support/TargetSelect.h"
#include "llvm/Support/raw_ostream.h"
#include "mlir/Conversion/FuncToLLVM/ConvertFuncToLLVMPass.h"
#include "mlir/Dialect/Affine/Passes.h"
#include "mlir/Dialect/Func/IR/FuncOps.h"
#include "mlir/Dialect/LLVMIR/FunctionCallUtils.h"
#include "mlir/Dialect/LLVMIR/LLVMDialect.h"
#include "mlir/ExecutionEngine/ExecutionEngine.h"
#include "mlir/ExecutionEngine/OptUtils.h"
#include "mlir/IR/AsmState.h"
#include "mlir/IR/BuiltinOps.h"
#include "mlir/IR/MLIRContext.h"
#include "mlir/IR/Verifier.h"
#include "mlir/InitAllDialects.h"
#include "mlir/Parser/Parser.h"
#include "mlir/Pass/Pass.h"
#include "mlir/Pass/PassManager.h"
#include "mlir/Target/LLVMIR/Dialect/LLVMIR/LLVMToLLVMIRTranslation.h"
#include "mlir/Target/LLVMIR/Export.h"
#include "mlir/Transforms/Passes.h"

namespace luac {

MLIRGenerator::MLIRGenerator(mlir::MLIRContext* context, AstContext* ast) : builder(context), ast(ast) {
  module = builder.create<mlir::ModuleOp>(loc(0, 0));
}

void MLIRGenerator::gen() {
  createLuaVarSturct();
  createLuaStringSturct();
  createMainFunction();
  for (int i = 0; i < ast->stats.size(); i++){
    Stat* stat = ast->stats[i].get();
    if (typeid(*stat) == typeid(FunctionCall)){
      //
      std::cout << "function call" << std::endl;
      genFunctioncall(dynamic_cast<FunctionCall*>(stat));
    }
  }
  endMainFunction();
}

void MLIRGenerator::createLuaVarSturct() {
  auto context = module->getContext();
  context->getOrLoadDialect<mlir::LLVM::LLVMDialect>();
  // struct LuaVar {}
  auto varStruct =
      mlir::LLVM::LLVMStructType::getIdentified(context, "struct.LuaVar");
  llvm::SmallVector<mlir::Type, 4> fields;
  fields.push_back(mlir::IntegerType::get(context, 64));
  fields.push_back(mlir::IntegerType::get(context, 64));
  varStruct.setBody(fields, false);
}

void MLIRGenerator::createLuaStringSturct() {
  auto context = module->getContext();
  context->getOrLoadDialect<mlir::LLVM::LLVMDialect>();
  // struct LuaString {}
  auto varStruct =
      mlir::LLVM::LLVMStructType::getIdentified(context, "struct.LuaString");
  llvm::SmallVector<mlir::Type, 4> fields;
    fields.push_back(
      mlir::LLVM::LLVMPointerType::get(mlir::IntegerType::get(context, 8)));
  fields.push_back(mlir::IntegerType::get(context, 32));
  varStruct.setBody(fields, false);
}

mlir::LLVM::LLVMStructType MLIRGenerator::getLuaStringSturct() {
  auto context = module->getContext();
  context->getOrLoadDialect<mlir::LLVM::LLVMDialect>();
  // struct LuaString {}
  return mlir::LLVM::LLVMStructType::getIdentified(context, "struct.LuaString");

}


mlir::Value MLIRGenerator::getOrCreateGlobalString(llvm::StringRef name, llvm::StringRef value) {
    // Create the global at the entry of the module.
    mlir::LLVM::GlobalOp global;
    if (!(global = module.lookupSymbol<mlir::LLVM::GlobalOp>(name))) {
      mlir::OpBuilder::InsertionGuard insertGuard(builder);
      builder.setInsertionPointToStart(module.getBody());
      auto type = mlir::LLVM::LLVMArrayType::get(
          mlir::IntegerType::get(builder.getContext(), 8), value.size());
      global = builder.create<mlir::LLVM::GlobalOp>(loc(0,0), type, /*isConstant=*/true,
                                              mlir::LLVM::Linkage::Internal, name,
                                              builder.getStringAttr(value),
                                              /*alignment=*/0);
    }

    // Get the pointer to the first character in the global string.
    mlir::Value globalPtr = builder.create<mlir::LLVM::AddressOfOp>(loc(0,0), global);
    mlir::Value cst0 = builder.create<mlir::LLVM::ConstantOp>(
        loc(0,0), mlir::IntegerType::get(builder.getContext(), 64),
        builder.getIntegerAttr(builder.getIndexType(), 0));
    return builder.create<mlir::LLVM::GEPOp>(
        loc(0,0),
        mlir::LLVM::LLVMPointerType::get(mlir::IntegerType::get(builder.getContext(), 8)),
        globalPtr, llvm::ArrayRef<mlir::Value>({cst0, cst0}));
  }

void MLIRGenerator::createMainFunction() {
  llvm::SmallVector<mlir::Type, 4> args;
  auto retType = mlir::IntegerType::get(module->getContext(), 32);
  auto func = mlir::LLVM::lookupOrCreateFn(module, "main", args, retType);
  auto entryBlock = func.addEntryBlock();
  builder.setInsertionPointToStart(entryBlock);
}

void MLIRGenerator::endMainFunction() {
  auto res = builder.create<mlir::arith::ConstantIntOp>(loc(0, 0), 0,
                                                        builder.getI32Type());
  builder.create<mlir::LLVM::ReturnOp>(loc(0, 0), res.getResult());
}
    


mlir::LLVM::LLVMFuncOp MLIRGenerator::getFunction(llvm::StringRef name) {
  auto item = functionMap.find(name);
  if(item == functionMap.end()) {
    if(name == "print") {
       auto strStruct = getLuaStringSturct();
  
  llvm::SmallVector<mlir::Type> params;
  params.push_back( strStruct);
  
  return mlir::LLVM::lookupOrCreateFn(
      module, "print", params, mlir::LLVM::LLVMVoidType::get(module->getContext()));
    }
  }

   return nullptr;
}

std::any MLIRGenerator::genFunctioncall(FunctionCall* funcCall) {

  std::cout << "enter function call" << std::endl;
  llvm::SmallVector<mlir::Type> params;
  
  auto funcOp = getFunction(funcCall->name);
  if(funcOp == nullptr) { // function not exist
    return 0;
  }
  
 // visit Args 
  auto helloStr = getOrCreateGlobalString("hello", "hello");

  auto zero = builder.create<mlir::LLVM::ConstantOp>(loc(0,0), builder.getI32Type(), builder.getI32IntegerAttr(0)); 
  auto one = builder.create<mlir::LLVM::ConstantOp>(loc(0,0), builder.getI32Type(), builder.getI32IntegerAttr(1));
  auto strStruct = getLuaStringSturct(); 
  mlir::Value strInstance = builder.create<mlir::LLVM::UndefOp>(loc(0,0), strStruct);

  auto ptrToNs = helloStr;//builder.create<mlir::LLVM::AddressOfOp>(loc(0,0), helloStr);

  strInstance = builder.create<mlir::LLVM::InsertValueOp>(
         loc(0,0), strInstance.getType(), strInstance, ptrToNs,
         builder.getI64ArrayAttr(0));
  auto len = builder.create<mlir::LLVM::ConstantOp>(loc(0,0), builder.getI32Type(), builder.getI32IntegerAttr(5));
  strInstance = builder.create<mlir::LLVM::InsertValueOp>(
         loc(0,0), strInstance.getType(), strInstance, len,
         builder.getI64ArrayAttr(1));
  
  //auto s = builder.create<mlir::LLVM::AddressOfOp>(loc(0,0), mlir::ValueRange{strInstance});
  builder.create<mlir::LLVM::CallOp>(loc(0,0), funcOp, mlir::ValueRange{strInstance});
  return 0;
}
std::any MLIRGenerator::visitNameAndArgs(LuaParser::NameAndArgsContext* ctx) {

}

/*
void MLIRGenerator::visitFuncname(LuaParser::FuncnameContext* ctx) {
  std::cout << "enter into a function declear" << ctx->getStart()->getText()
            << std::endl;
  llvm::ScopedHashTableScope<llvm::StringRef, mlir::Value> varScope(
      symbolTable);
  builder.setInsertionPointToEnd(module.getBody());

  llvm::SmallVector<mlir::Type> argTypes;
  llvm::SmallVector<mlir::Type> results;
  argTypes.push_back(builder.getI64Type());
  argTypes.push_back(builder.getI64Type());
  auto varStruct = mlir::LLVM::LLVMStructType::getIdentified(
      module.getContext(), "struct.LuaVar");
  argTypes.push_back(varStruct);
  // argTypes.push_back()
  results.push_back(builder.getI64Type());
  auto funcType = builder.getFunctionType(argTypes, results);
  // ctx->getToken()->getText();
  auto funcOp = builder.create<mlir::func::FuncOp>(
      loc(0, 0), ctx->getStart()->getText(), funcType);
  funcOp.addEntryBlock();
  mlir::Block& entryBlock = funcOp.front();
  builder.setInsertionPointToStart(&entryBlock);
}

void MLIRGenerator::exitFuncname(LuaParser::FuncnameContext* ctx) {
  auto res = builder.create<mlir::arith::ConstantIntOp>(loc(0, 0), 123,
                                                        builder.getI64Type());
  builder.create<mlir::func::ReturnOp>(loc(0, 0), res.getResult());
}
*/
void MLIRGenerator::dumpMLIR() {
  if (mlir::failed(mlir::verify(module))) {
    module.emitError("module verification error");
    // return nullptr;
  }
  module.dump();
}

void MLIRGenerator::dumpIR() {
  mlir::PassManager pm(module->getContext());
  pm.addPass(mlir::createConvertFuncToLLVMPass());
  pm.run(module);

  llvm::LLVMContext llvmContext;
  mlir::registerLLVMDialectTranslation(*module.getContext());
  auto llvmModule = mlir::translateModuleToLLVMIR(module, llvmContext);
  if (!llvmModule) {
    llvm::errs() << "Failed to emit LLVM IR\n";
    return;
  }

  auto optPipeline = mlir::makeOptimizingTransformer(
      /*optLevel=*/0, /*sizeLevel=*/0,
      /*targetMachine=*/nullptr);
  llvm::InitializeNativeTarget();
  llvm::InitializeNativeTargetAsmPrinter();
  mlir::ExecutionEngine::setupTargetTriple(llvmModule.get());
  if (auto err = optPipeline(llvmModule.get())) {
    llvm::errs() << "Failed to optimize LLVM IR " << err << "\n";
    return;
  }
  llvm::errs() << *llvmModule << "\n";
}

}  // namespace luac