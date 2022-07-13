#include "ast.h"

namespace luac {
namespace ast {

std::any AstBuilder::visitStat(LuaParser::StatContext *ctx) {
  // std::cout << "visit stat";
  if (ctx->children.size() < 1) {
    return 0;
  }
  // expression a = b + c
  if (typeid(*ctx->children[0]) == typeid(LuaParser::VarlistContext)) {
    std::cout << "terminal\n";
      if (ctx->children[1]->getText() == "=") {
        std::cout << "visit assignment" << std::endl;
        // parse LH
        
        // parse RH
      }
  }
  return 1;
}
}  // namespace ast
}  // namespace luac