#pragma once

#include <llvm/ADT/Triple.h>      // for Triple
#include <llvm/ADT/Twine.h>       // for Twine
#include <llvm/IR/LLVMContext.h>  // for LLVMContext
#include <llvm/Support/Host.h>    // for getDefaultTargetTriple
#include <mlir/IR/MLIRContext.h>
#include <mlir/IR/MLIRContext.h>
#include "mlir/Dialect/Func/IR/FuncOps.h"


#include <functional>  // for function
#include <memory>      // for make_unique, unique_ptr
#include <string>      // for string, basic_string
#include <vector>      // for vector

namespace luac {

/// This enum describes the different operational phases for the compiler
/// in order. Anything below `NoOptimization` is considered only for debugging
enum class CompilationPhase {
  Parse,
  Analysis,
  SLIR,
  MLIR,  // Lowered slir to other dialects
  LIR,   // Lowered to the llvm ir dialect
  IR,    // Lowered to the LLVMIR itself
  NoOptimization,
  O1,
  O2,
  O3,
};
class Context {
 public:
  const llvm::Triple triple;

  explicit Context()
      : triple(llvm::sys::getDefaultTargetTriple()),
        targetPhase(CompilationPhase::NoOptimization){
            // mlirContext.getOrLoadDialect(mlir::);
        };

  /// Set the target compilation phase of the compiler. The compilation
  /// phase dictates the behavior and the output type of the compiler.
  void setOperationPhase(CompilationPhase phase);

  CompilationPhase getTargetPhase() { return targetPhase; };
  int getOptimizatioLevel();

  static std::unique_ptr<llvm::LLVMContext> genLLVMContext() {
    return std::make_unique<llvm::LLVMContext>();
  };

  static std::unique_ptr<mlir::MLIRContext> genMLIRContext() {
    auto context = std::make_unique<mlir::MLIRContext>();
    context->getOrLoadDialect<mlir::func::FuncDialect>();
    return context;
  };

 private:
  CompilationPhase targetPhase;
};

std::unique_ptr<Context> makeContext();

}  // namespace luac