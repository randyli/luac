
// Generated from Lua.g4 by ANTLR 4.10.1

#pragma once


#include "antlr4-runtime.h"
#include "LuaVisitor.h"


namespace luac {

/**
 * This class provides an empty implementation of LuaVisitor, which can be
 * extended to create a visitor which only needs to handle a subset of the available methods.
 */
class  LuaBaseVisitor : public LuaVisitor {
public:

  virtual std::any visitChunk(LuaParser::ChunkContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitBlock(LuaParser::BlockContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitStat(LuaParser::StatContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitAttnamelist(LuaParser::AttnamelistContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitAttrib(LuaParser::AttribContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitRetstat(LuaParser::RetstatContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitLabel(LuaParser::LabelContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFuncname(LuaParser::FuncnameContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitVarlist(LuaParser::VarlistContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitNamelist(LuaParser::NamelistContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitExplist(LuaParser::ExplistContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitExp(LuaParser::ExpContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitPrefixexp(LuaParser::PrefixexpContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFunctioncall(LuaParser::FunctioncallContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitVarOrExp(LuaParser::VarOrExpContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitVar_(LuaParser::Var_Context *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitVarSuffix(LuaParser::VarSuffixContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitNameAndArgs(LuaParser::NameAndArgsContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitArgs(LuaParser::ArgsContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFunctiondef(LuaParser::FunctiondefContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFuncbody(LuaParser::FuncbodyContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitParlist(LuaParser::ParlistContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitTableconstructor(LuaParser::TableconstructorContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFieldlist(LuaParser::FieldlistContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitField(LuaParser::FieldContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitFieldsep(LuaParser::FieldsepContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOperatorOr(LuaParser::OperatorOrContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOperatorAnd(LuaParser::OperatorAndContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOperatorComparison(LuaParser::OperatorComparisonContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOperatorStrcat(LuaParser::OperatorStrcatContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOperatorAddSub(LuaParser::OperatorAddSubContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOperatorMulDivMod(LuaParser::OperatorMulDivModContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOperatorBitwise(LuaParser::OperatorBitwiseContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOperatorUnary(LuaParser::OperatorUnaryContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOperatorPower(LuaParser::OperatorPowerContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitNumber(LuaParser::NumberContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitString(LuaParser::StringContext *ctx) override {
    return visitChildren(ctx);
  }


};

}  // namespace luac
