#include "llvm/IR/BasicBlock.h"
#include "llvm/IR/Constants.h"
#include "llvm/IR/DerivedTypes.h"
#include "llvm/IR/Function.h"
#include "llvm/IR/IRBuilder.h"
#include "llvm/IR/LLVMContext.h"
#include "llvm/IR/Module.h"
#include "llvm/IR/Type.h"
#include "llvm/IR/Verifier.h"

#include "LuaLexer.h"
#include "ast.h"
#include "genir.h"

int main(int argc, const char* argv[]) {
  std::ifstream stream;
  stream.open(argv[1]);
  antlr4::ANTLRInputStream input(stream);
  luac::LuaLexer lexer(&input);
  antlr4::CommonTokenStream tokens(&lexer);
  luac::LuaParser parser(&tokens);
  //luac::MLIRGenerator generator(luac::Context::genMLIRContext().release());
  //parser.addParseListener(&generator);
  auto chunk = parser.chunk();
  luac::IRGenerator irGenerator(argv[1]);
  irGenerator.visitChunk(chunk);
  irGenerator.dump();
  //luac::ast::AstBuilder astBuilder;
  //astBuilder.visit(chunk);
  return 0;
}