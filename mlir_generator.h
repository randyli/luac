#pragma once

#include "mlir/IR/Attributes.h"
#include "mlir/IR/Builders.h"
#include "mlir/IR/BuiltinOps.h"
#include "mlir/IR/BuiltinTypes.h"
#include "mlir/IR/MLIRContext.h"
#include "mlir/IR/Verifier.h"
#include "mlir/Dialect/LLVMIR/LLVMDialect.h"

#include "llvm/ADT/STLExtras.h"
#include "llvm/ADT/ScopedHashTable.h"
#include "llvm/Support/raw_ostream.h"


#include "LuaBaseVisitor.h"

namespace luac {

class MLIRGenerator : public LuaBaseVisitor {
public:
    MLIRGenerator(mlir::MLIRContext* context);
    std::any visitChunk(LuaParser::ChunkContext *ctx) override;
    std::any visitBlock(LuaParser::BlockContext *ctx) override;
    std::any visitFunctioncall(LuaParser::FunctioncallContext * ctx) override;  
    
    void dumpMLIR();
    void dumpIR();

private:
     mlir::Location loc(unsigned int line, unsigned int column) {
        return mlir::FileLineColLoc::get(builder.getStringAttr(""), line, column);
    }

    void addLuacBaseType();

    void createLuaVarSturct();

    void createLuaStringSturct();

    mlir::LLVM::LLVMStructType getLuaStringSturct();

    mlir::Value getOrCreateGlobalString(llvm::StringRef name, llvm::StringRef value);

    void createMainFunction();
    void endMainFunction();

    mlir::LLVM::LLVMFuncOp getFunction(llvm::StringRef name);
    
private:
    mlir::OpBuilder builder;
    mlir::ModuleOp module;
    
    llvm::ScopedHashTable<llvm::StringRef, mlir::Value> symbolTable;

    llvm::StringMap<mlir::LLVM::LLVMFuncOp> functionMap;
};

}