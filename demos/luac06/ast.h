#pragma once

#include "LuaBaseVisitor.h"

namespace luac {
namespace ast{

enum class BinaryOp{
  ADD,
  MINUS,
  MULTI,
  DIV,
  MOD
};

class Exp {
  public:
   virtual ~Exp() {}
};

class BinaryExp {
  public:
   BinaryOp op;
   
};

class AssignExp {
  public:
   std::string lvalue;
   BinaryExp rvalue;
};

class AstBuilder : public LuaBaseVisitor {

    public:
     std::any visitStat(LuaParser::StatContext *ctx) override;
};
}
}