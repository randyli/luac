#pragma once

#include "ast.h"

#include "LuaBaseVisitor.h"

namespace luac {

class Sema : public LuaBaseVisitor{
 public:
  Sema(const Sema &) = delete;
  void operator=(const Sema &) = delete;
  Sema() { ast = std::make_unique<AstContext>(); }

  std::unique_ptr<AstContext> Ast() { return std::move(ast); }

  std::any visitFunctioncall(LuaParser::FunctioncallContext *ctx) override;

 private:
  std::unique_ptr<AstContext> ast;
};
}  // namespace luac