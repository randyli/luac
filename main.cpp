#include <antlr4-runtime.h>

#include <iostream>
#include <typeinfo>

#include "LuaBaseListener.h"
#include "LuaLexer.h"
#include "LuaParser.h"
#include "context.h"
#include "mlir_generator.h"

#include "ast.h"
#include "sema.h"

int main(int argc, char* argv[]) {
  auto context = luac::makeContext();
  
  std::ifstream stream;
  stream.open(argv[1]);
  antlr4::ANTLRInputStream input(stream);
  luac::LuaLexer lexer(&input);
  antlr4::CommonTokenStream tokens(&lexer);
  luac::LuaParser parser(&tokens);
  //luac::MLIRGenerator generator(luac::Context::genMLIRContext().release());
  //parser.addParseListener(&generator);
  auto chunk = parser.chunk();
  std::cout << chunk->toStringTree(&parser, true) << std::endl;
  //generator.dumpMLIR();
  //generator.dumpIR();
  //std::cout << doc->toStringTree() << std::endl << std::endl;

  // antlr4::tree::ParseTree *tree = parser.keyedSimpleFieldName();
  // TreeShapeListener listener;
  // antlr4::tree::ParseTreeWalker::DEFAULT.walk(&listener, tree);
  //luac::MLIRGenerator generator(luac::Context::genMLIRContext().release());

  //generator.visitChunk(ast);
  //generator.dumpMLIR();
  //generator.dumpIR();
  luac::Sema sema;
  sema.visitChunk(chunk);
  std::unique_ptr<luac::AstContext> ast = sema.Ast();
  luac::MLIRGenerator generator(luac::Context::genMLIRContext().release(), ast.get());
  generator.gen();
  generator.dumpMLIR();
  generator.dumpIR();

  return 0;
}
