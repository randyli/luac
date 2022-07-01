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

#include "ast.h"

namespace luac {

class MLIRGenerator {
public:
    MLIRGenerator(mlir::MLIRContext* context, AstContext* ast);

    void gen();
    void dumpMLIR();
    void dumpIR();

private:

    std::any visitBlock(LuaParser::BlockContext *ctx);
    std::any genFunctioncall(FunctionCall* funcCall);  
    std::any visitNameAndArgs(LuaParser::NameAndArgsContext* ctx);

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
    AstContext* ast;
    llvm::ScopedHashTable<llvm::StringRef, mlir::Value> symbolTable;
    llvm::StringMap<mlir::LLVM::LLVMFuncOp> functionMap;
};

}