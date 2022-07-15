
// Generated from Lua.g4 by ANTLR 4.10.1

#pragma once


#include "antlr4-runtime.h"
#include "LuaParser.h"


namespace luac {

/**
 * This class defines an abstract visitor for a parse tree
 * produced by LuaParser.
 */
class  LuaVisitor : public antlr4::tree::AbstractParseTreeVisitor {
public:

  /**
   * Visit parse trees produced by LuaParser.
   */
    virtual std::any visitChunk(LuaParser::ChunkContext *context) = 0;

    virtual std::any visitBlock(LuaParser::BlockContext *context) = 0;

    virtual std::any visitStat(LuaParser::StatContext *context) = 0;

    virtual std::any visitAttnamelist(LuaParser::AttnamelistContext *context) = 0;

    virtual std::any visitAttrib(LuaParser::AttribContext *context) = 0;

    virtual std::any visitRetstat(LuaParser::RetstatContext *context) = 0;

    virtual std::any visitLabel(LuaParser::LabelContext *context) = 0;

    virtual std::any visitFuncname(LuaParser::FuncnameContext *context) = 0;

    virtual std::any visitVarlist(LuaParser::VarlistContext *context) = 0;

    virtual std::any visitNamelist(LuaParser::NamelistContext *context) = 0;

    virtual std::any visitExplist(LuaParser::ExplistContext *context) = 0;

    virtual std::any visitExp(LuaParser::ExpContext *context) = 0;

    virtual std::any visitPrefixexp(LuaParser::PrefixexpContext *context) = 0;

    virtual std::any visitFunctioncall(LuaParser::FunctioncallContext *context) = 0;

    virtual std::any visitVarOrExp(LuaParser::VarOrExpContext *context) = 0;

    virtual std::any visitVar_(LuaParser::Var_Context *context) = 0;

    virtual std::any visitVarSuffix(LuaParser::VarSuffixContext *context) = 0;

    virtual std::any visitNameAndArgs(LuaParser::NameAndArgsContext *context) = 0;

    virtual std::any visitArgs(LuaParser::ArgsContext *context) = 0;

    virtual std::any visitFunctiondef(LuaParser::FunctiondefContext *context) = 0;

    virtual std::any visitFuncbody(LuaParser::FuncbodyContext *context) = 0;

    virtual std::any visitParlist(LuaParser::ParlistContext *context) = 0;

    virtual std::any visitTableconstructor(LuaParser::TableconstructorContext *context) = 0;

    virtual std::any visitFieldlist(LuaParser::FieldlistContext *context) = 0;

    virtual std::any visitField(LuaParser::FieldContext *context) = 0;

    virtual std::any visitFieldsep(LuaParser::FieldsepContext *context) = 0;

    virtual std::any visitOperatorOr(LuaParser::OperatorOrContext *context) = 0;

    virtual std::any visitOperatorAnd(LuaParser::OperatorAndContext *context) = 0;

    virtual std::any visitOperatorComparison(LuaParser::OperatorComparisonContext *context) = 0;

    virtual std::any visitOperatorStrcat(LuaParser::OperatorStrcatContext *context) = 0;

    virtual std::any visitOperatorAddSub(LuaParser::OperatorAddSubContext *context) = 0;

    virtual std::any visitOperatorMulDivMod(LuaParser::OperatorMulDivModContext *context) = 0;

    virtual std::any visitOperatorBitwise(LuaParser::OperatorBitwiseContext *context) = 0;

    virtual std::any visitOperatorUnary(LuaParser::OperatorUnaryContext *context) = 0;

    virtual std::any visitOperatorPower(LuaParser::OperatorPowerContext *context) = 0;

    virtual std::any visitNumber(LuaParser::NumberContext *context) = 0;

    virtual std::any visitString(LuaParser::StringContext *context) = 0;


};

}  // namespace luac
