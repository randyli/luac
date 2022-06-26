#pragma once

#include "mlir/IR/Attributes.h"
#include "mlir/IR/Builders.h"
#include "mlir/IR/BuiltinOps.h"
#include "mlir/IR/BuiltinTypes.h"
#include "mlir/IR/MLIRContext.h"
#include "mlir/IR/Verifier.h"

#include "llvm/ADT/STLExtras.h"
#include "llvm/ADT/ScopedHashTable.h"
#include "llvm/Support/raw_ostream.h"


#include "LuaBaseListener.h"

namespace luac {

class MLIRGenerator : public LuaBaseListener {
public:
    MLIRGenerator(mlir::MLIRContext* context);
    void enterChunk(LuaParser::ChunkContext *ctx) override;
    void exitChunk(LuaParser::ChunkContext *ctx) override;

    void enterFuncname(LuaParser::FuncnameContext * ctx) override;
    void exitFuncname(LuaParser::FuncnameContext * ctx) override;
     
    void enterFunctioncall(LuaParser::FunctioncallContext * ctx) override;
    void exitFunctioncall(LuaParser::FunctioncallContext * ctx) override;
  
    
    void dumpMLIR();
    void dumpIR();

private:
     mlir::Location loc(unsigned int line, unsigned int column) {
        return mlir::FileLineColLoc::get(builder.getStringAttr(""), line, column);
    }

    void addLuacBaseType();
    // helper function of create a struct
    void createLuaVarSturct();
    void createLuaStringSturct();

    mlir::Value getOrCreateGlobalString(llvm::StringRef name, llvm::StringRef value);

private:
    mlir::OpBuilder builder;
    mlir::ModuleOp module;
    mlir::MLIRContext* context;

    llvm::ScopedHashTable<llvm::StringRef, mlir::Value> symbolTable;

};

}