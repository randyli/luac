// Generated from /Users/randyli/Documents/dev/luac/demos/fe/java/Lua.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LuaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, NAME=56, NORMALSTRING=57, CHARSTRING=58, 
		LONGSTRING=59, INT=60, HEX=61, FLOAT=62, HEX_FLOAT=63, COMMENT=64, LINE_COMMENT=65, 
		WS=66, SHEBANG=67;
	public static final int
		RULE_chunk = 0, RULE_block = 1, RULE_stat = 2, RULE_attnamelist = 3, RULE_attrib = 4, 
		RULE_retstat = 5, RULE_label = 6, RULE_funcname = 7, RULE_varlist = 8, 
		RULE_namelist = 9, RULE_explist = 10, RULE_exp = 11, RULE_prefixexp = 12, 
		RULE_functioncall = 13, RULE_varOrExp = 14, RULE_var_ = 15, RULE_varSuffix = 16, 
		RULE_nameAndArgs = 17, RULE_args = 18, RULE_functiondef = 19, RULE_funcbody = 20, 
		RULE_parlist = 21, RULE_tableconstructor = 22, RULE_fieldlist = 23, RULE_field = 24, 
		RULE_fieldsep = 25, RULE_operatorOr = 26, RULE_operatorAnd = 27, RULE_operatorComparison = 28, 
		RULE_operatorStrcat = 29, RULE_operatorAddSub = 30, RULE_operatorMulDivMod = 31, 
		RULE_operatorBitwise = 32, RULE_operatorUnary = 33, RULE_operatorPower = 34, 
		RULE_number = 35, RULE_string = 36;
	private static String[] makeRuleNames() {
		return new String[] {
			"chunk", "block", "stat", "attnamelist", "attrib", "retstat", "label", 
			"funcname", "varlist", "namelist", "explist", "exp", "prefixexp", "functioncall", 
			"varOrExp", "var_", "varSuffix", "nameAndArgs", "args", "functiondef", 
			"funcbody", "parlist", "tableconstructor", "fieldlist", "field", "fieldsep", 
			"operatorOr", "operatorAnd", "operatorComparison", "operatorStrcat", 
			"operatorAddSub", "operatorMulDivMod", "operatorBitwise", "operatorUnary", 
			"operatorPower", "number", "string"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'break'", "'goto'", "'do'", "'end'", "'while'", 
			"'repeat'", "'until'", "'if'", "'then'", "'elseif'", "'else'", "'for'", 
			"','", "'in'", "'function'", "'local'", "'<'", "'>'", "'return'", "'::'", 
			"'.'", "':'", "'nil'", "'false'", "'true'", "'...'", "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "'or'", "'and'", "'<='", "'>='", "'~='", "'=='", 
			"'..'", "'+'", "'-'", "'*'", "'/'", "'%'", "'//'", "'&'", "'|'", "'~'", 
			"'<<'", "'>>'", "'not'", "'#'", "'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "NAME", "NORMALSTRING", 
			"CHARSTRING", "LONGSTRING", "INT", "HEX", "FLOAT", "HEX_FLOAT", "COMMENT", 
			"LINE_COMMENT", "WS", "SHEBANG"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Lua.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LuaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ChunkContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LuaParser.EOF, 0); }
		public ChunkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chunk; }
	}

	public final ChunkContext chunk() throws RecognitionException {
		ChunkContext _localctx = new ChunkContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_chunk);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			block();
			setState(75);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public RetstatContext retstat() {
			return getRuleContext(RetstatContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__13) | (1L << T__16) | (1L << T__17) | (1L << T__21) | (1L << T__28) | (1L << NAME))) != 0)) {
				{
				{
				setState(77);
				stat();
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(83);
				retstat();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public VarlistContext varlist() {
			return getRuleContext(VarlistContext.class,0);
		}
		public ExplistContext explist() {
			return getRuleContext(ExplistContext.class,0);
		}
		public FunctioncallContext functioncall() {
			return getRuleContext(FunctioncallContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public TerminalNode NAME() { return getToken(LuaParser.NAME, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public NamelistContext namelist() {
			return getRuleContext(NamelistContext.class,0);
		}
		public FuncnameContext funcname() {
			return getRuleContext(FuncnameContext.class,0);
		}
		public FuncbodyContext funcbody() {
			return getRuleContext(FuncbodyContext.class,0);
		}
		public AttnamelistContext attnamelist() {
			return getRuleContext(AttnamelistContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stat);
		int _la;
		try {
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				varlist();
				setState(88);
				match(T__1);
				setState(89);
				explist();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(91);
				functioncall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(92);
				label();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(93);
				match(T__2);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(94);
				match(T__3);
				setState(95);
				match(NAME);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(96);
				match(T__4);
				setState(97);
				block();
				setState(98);
				match(T__5);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(100);
				match(T__6);
				setState(101);
				exp(0);
				setState(102);
				match(T__4);
				setState(103);
				block();
				setState(104);
				match(T__5);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(106);
				match(T__7);
				setState(107);
				block();
				setState(108);
				match(T__8);
				setState(109);
				exp(0);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(111);
				match(T__9);
				setState(112);
				exp(0);
				setState(113);
				match(T__10);
				setState(114);
				block();
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(115);
					match(T__11);
					setState(116);
					exp(0);
					setState(117);
					match(T__10);
					setState(118);
					block();
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(125);
					match(T__12);
					setState(126);
					block();
					}
				}

				setState(129);
				match(T__5);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(131);
				match(T__13);
				setState(132);
				match(NAME);
				setState(133);
				match(T__1);
				setState(134);
				exp(0);
				setState(135);
				match(T__14);
				setState(136);
				exp(0);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(137);
					match(T__14);
					setState(138);
					exp(0);
					}
				}

				setState(141);
				match(T__4);
				setState(142);
				block();
				setState(143);
				match(T__5);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(145);
				match(T__13);
				setState(146);
				namelist();
				setState(147);
				match(T__15);
				setState(148);
				explist();
				setState(149);
				match(T__4);
				setState(150);
				block();
				setState(151);
				match(T__5);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(153);
				match(T__16);
				setState(154);
				funcname();
				setState(155);
				funcbody();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(157);
				match(T__17);
				setState(158);
				match(T__16);
				setState(159);
				match(NAME);
				setState(160);
				funcbody();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(161);
				match(T__17);
				setState(162);
				attnamelist();
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(163);
					match(T__1);
					setState(164);
					explist();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttnamelistContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(LuaParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(LuaParser.NAME, i);
		}
		public List<AttribContext> attrib() {
			return getRuleContexts(AttribContext.class);
		}
		public AttribContext attrib(int i) {
			return getRuleContext(AttribContext.class,i);
		}
		public AttnamelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attnamelist; }
	}

	public final AttnamelistContext attnamelist() throws RecognitionException {
		AttnamelistContext _localctx = new AttnamelistContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_attnamelist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(NAME);
			setState(170);
			attrib();
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(171);
				match(T__14);
				setState(172);
				match(NAME);
				setState(173);
				attrib();
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttribContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(LuaParser.NAME, 0); }
		public AttribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrib; }
	}

	public final AttribContext attrib() throws RecognitionException {
		AttribContext _localctx = new AttribContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attrib);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(179);
				match(T__18);
				setState(180);
				match(NAME);
				setState(181);
				match(T__19);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RetstatContext extends ParserRuleContext {
		public ExplistContext explist() {
			return getRuleContext(ExplistContext.class,0);
		}
		public RetstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retstat; }
	}

	public final RetstatContext retstat() throws RecognitionException {
		RetstatContext _localctx = new RetstatContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_retstat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(T__20);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__32) | (1L << T__42) | (1L << T__49) | (1L << T__52) | (1L << T__53) | (1L << NAME) | (1L << NORMALSTRING) | (1L << CHARSTRING) | (1L << LONGSTRING) | (1L << INT) | (1L << HEX) | (1L << FLOAT) | (1L << HEX_FLOAT))) != 0)) {
				{
				setState(185);
				explist();
				}
			}

			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(188);
				match(T__0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(LuaParser.NAME, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(T__21);
			setState(192);
			match(NAME);
			setState(193);
			match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncnameContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(LuaParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(LuaParser.NAME, i);
		}
		public FuncnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcname; }
	}

	public final FuncnameContext funcname() throws RecognitionException {
		FuncnameContext _localctx = new FuncnameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funcname);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(NAME);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22) {
				{
				{
				setState(196);
				match(T__22);
				setState(197);
				match(NAME);
				}
				}
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(203);
				match(T__23);
				setState(204);
				match(NAME);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarlistContext extends ParserRuleContext {
		public List<Var_Context> var_() {
			return getRuleContexts(Var_Context.class);
		}
		public Var_Context var_(int i) {
			return getRuleContext(Var_Context.class,i);
		}
		public VarlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varlist; }
	}

	public final VarlistContext varlist() throws RecognitionException {
		VarlistContext _localctx = new VarlistContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			var_();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(208);
				match(T__14);
				setState(209);
				var_();
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamelistContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(LuaParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(LuaParser.NAME, i);
		}
		public NamelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namelist; }
	}

	public final NamelistContext namelist() throws RecognitionException {
		NamelistContext _localctx = new NamelistContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_namelist);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(NAME);
			setState(220);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(216);
					match(T__14);
					setState(217);
					match(NAME);
					}
					} 
				}
				setState(222);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExplistContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExplistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explist; }
	}

	public final ExplistContext explist() throws RecognitionException {
		ExplistContext _localctx = new ExplistContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_explist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			exp(0);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(224);
				match(T__14);
				setState(225);
				exp(0);
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public FunctiondefContext functiondef() {
			return getRuleContext(FunctiondefContext.class,0);
		}
		public PrefixexpContext prefixexp() {
			return getRuleContext(PrefixexpContext.class,0);
		}
		public TableconstructorContext tableconstructor() {
			return getRuleContext(TableconstructorContext.class,0);
		}
		public OperatorUnaryContext operatorUnary() {
			return getRuleContext(OperatorUnaryContext.class,0);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public OperatorPowerContext operatorPower() {
			return getRuleContext(OperatorPowerContext.class,0);
		}
		public OperatorMulDivModContext operatorMulDivMod() {
			return getRuleContext(OperatorMulDivModContext.class,0);
		}
		public OperatorAddSubContext operatorAddSub() {
			return getRuleContext(OperatorAddSubContext.class,0);
		}
		public OperatorStrcatContext operatorStrcat() {
			return getRuleContext(OperatorStrcatContext.class,0);
		}
		public OperatorComparisonContext operatorComparison() {
			return getRuleContext(OperatorComparisonContext.class,0);
		}
		public OperatorAndContext operatorAnd() {
			return getRuleContext(OperatorAndContext.class,0);
		}
		public OperatorOrContext operatorOr() {
			return getRuleContext(OperatorOrContext.class,0);
		}
		public OperatorBitwiseContext operatorBitwise() {
			return getRuleContext(OperatorBitwiseContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_exp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				{
				setState(232);
				match(T__24);
				}
				break;
			case T__25:
				{
				setState(233);
				match(T__25);
				}
				break;
			case T__26:
				{
				setState(234);
				match(T__26);
				}
				break;
			case INT:
			case HEX:
			case FLOAT:
			case HEX_FLOAT:
				{
				setState(235);
				number();
				}
				break;
			case NORMALSTRING:
			case CHARSTRING:
			case LONGSTRING:
				{
				setState(236);
				string();
				}
				break;
			case T__27:
				{
				setState(237);
				match(T__27);
				}
				break;
			case T__16:
				{
				setState(238);
				functiondef();
				}
				break;
			case T__28:
			case NAME:
				{
				setState(239);
				prefixexp();
				}
				break;
			case T__32:
				{
				setState(240);
				tableconstructor();
				}
				break;
			case T__42:
			case T__49:
			case T__52:
			case T__53:
				{
				setState(241);
				operatorUnary();
				setState(242);
				exp(8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(280);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(278);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(246);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(247);
						operatorPower();
						setState(248);
						exp(9);
						}
						break;
					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(250);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(251);
						operatorMulDivMod();
						setState(252);
						exp(8);
						}
						break;
					case 3:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(254);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(255);
						operatorAddSub();
						setState(256);
						exp(7);
						}
						break;
					case 4:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(258);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(259);
						operatorStrcat();
						setState(260);
						exp(5);
						}
						break;
					case 5:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(262);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(263);
						operatorComparison();
						setState(264);
						exp(5);
						}
						break;
					case 6:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(266);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(267);
						operatorAnd();
						setState(268);
						exp(4);
						}
						break;
					case 7:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(270);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(271);
						operatorOr();
						setState(272);
						exp(3);
						}
						break;
					case 8:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(274);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(275);
						operatorBitwise();
						setState(276);
						exp(2);
						}
						break;
					}
					} 
				}
				setState(282);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrefixexpContext extends ParserRuleContext {
		public VarOrExpContext varOrExp() {
			return getRuleContext(VarOrExpContext.class,0);
		}
		public List<NameAndArgsContext> nameAndArgs() {
			return getRuleContexts(NameAndArgsContext.class);
		}
		public NameAndArgsContext nameAndArgs(int i) {
			return getRuleContext(NameAndArgsContext.class,i);
		}
		public PrefixexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixexp; }
	}

	public final PrefixexpContext prefixexp() throws RecognitionException {
		PrefixexpContext _localctx = new PrefixexpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_prefixexp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			varOrExp();
			setState(287);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(284);
					nameAndArgs();
					}
					} 
				}
				setState(289);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctioncallContext extends ParserRuleContext {
		public VarOrExpContext varOrExp() {
			return getRuleContext(VarOrExpContext.class,0);
		}
		public List<NameAndArgsContext> nameAndArgs() {
			return getRuleContexts(NameAndArgsContext.class);
		}
		public NameAndArgsContext nameAndArgs(int i) {
			return getRuleContext(NameAndArgsContext.class,i);
		}
		public FunctioncallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functioncall; }
	}

	public final FunctioncallContext functioncall() throws RecognitionException {
		FunctioncallContext _localctx = new FunctioncallContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_functioncall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			varOrExp();
			setState(292); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(291);
					nameAndArgs();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(294); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarOrExpContext extends ParserRuleContext {
		public Var_Context var_() {
			return getRuleContext(Var_Context.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VarOrExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varOrExp; }
	}

	public final VarOrExpContext varOrExp() throws RecognitionException {
		VarOrExpContext _localctx = new VarOrExpContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_varOrExp);
		try {
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				var_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				match(T__28);
				setState(298);
				exp(0);
				setState(299);
				match(T__29);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_Context extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(LuaParser.NAME, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<VarSuffixContext> varSuffix() {
			return getRuleContexts(VarSuffixContext.class);
		}
		public VarSuffixContext varSuffix(int i) {
			return getRuleContext(VarSuffixContext.class,i);
		}
		public Var_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_; }
	}

	public final Var_Context var_() throws RecognitionException {
		Var_Context _localctx = new Var_Context(_ctx, getState());
		enterRule(_localctx, 30, RULE_var_);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				{
				setState(303);
				match(NAME);
				}
				break;
			case T__28:
				{
				setState(304);
				match(T__28);
				setState(305);
				exp(0);
				setState(306);
				match(T__29);
				setState(307);
				varSuffix();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(314);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(311);
					varSuffix();
					}
					} 
				}
				setState(316);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarSuffixContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode NAME() { return getToken(LuaParser.NAME, 0); }
		public List<NameAndArgsContext> nameAndArgs() {
			return getRuleContexts(NameAndArgsContext.class);
		}
		public NameAndArgsContext nameAndArgs(int i) {
			return getRuleContext(NameAndArgsContext.class,i);
		}
		public VarSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varSuffix; }
	}

	public final VarSuffixContext varSuffix() throws RecognitionException {
		VarSuffixContext _localctx = new VarSuffixContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_varSuffix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__28) | (1L << T__32) | (1L << NORMALSTRING) | (1L << CHARSTRING) | (1L << LONGSTRING))) != 0)) {
				{
				{
				setState(317);
				nameAndArgs();
				}
				}
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(329);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				{
				setState(323);
				match(T__30);
				setState(324);
				exp(0);
				setState(325);
				match(T__31);
				}
				break;
			case T__22:
				{
				setState(327);
				match(T__22);
				setState(328);
				match(NAME);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameAndArgsContext extends ParserRuleContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode NAME() { return getToken(LuaParser.NAME, 0); }
		public NameAndArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameAndArgs; }
	}

	public final NameAndArgsContext nameAndArgs() throws RecognitionException {
		NameAndArgsContext _localctx = new NameAndArgsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_nameAndArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(331);
				match(T__23);
				setState(332);
				match(NAME);
				}
			}

			setState(335);
			args();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public ExplistContext explist() {
			return getRuleContext(ExplistContext.class,0);
		}
		public TableconstructorContext tableconstructor() {
			return getRuleContext(TableconstructorContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_args);
		int _la;
		try {
			setState(344);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				match(T__28);
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__32) | (1L << T__42) | (1L << T__49) | (1L << T__52) | (1L << T__53) | (1L << NAME) | (1L << NORMALSTRING) | (1L << CHARSTRING) | (1L << LONGSTRING) | (1L << INT) | (1L << HEX) | (1L << FLOAT) | (1L << HEX_FLOAT))) != 0)) {
					{
					setState(338);
					explist();
					}
				}

				setState(341);
				match(T__29);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 2);
				{
				setState(342);
				tableconstructor();
				}
				break;
			case NORMALSTRING:
			case CHARSTRING:
			case LONGSTRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(343);
				string();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctiondefContext extends ParserRuleContext {
		public FuncbodyContext funcbody() {
			return getRuleContext(FuncbodyContext.class,0);
		}
		public FunctiondefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functiondef; }
	}

	public final FunctiondefContext functiondef() throws RecognitionException {
		FunctiondefContext _localctx = new FunctiondefContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_functiondef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(T__16);
			setState(347);
			funcbody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncbodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParlistContext parlist() {
			return getRuleContext(ParlistContext.class,0);
		}
		public FuncbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcbody; }
	}

	public final FuncbodyContext funcbody() throws RecognitionException {
		FuncbodyContext _localctx = new FuncbodyContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_funcbody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(T__28);
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__27 || _la==NAME) {
				{
				setState(350);
				parlist();
				}
			}

			setState(353);
			match(T__29);
			setState(354);
			block();
			setState(355);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParlistContext extends ParserRuleContext {
		public NamelistContext namelist() {
			return getRuleContext(NamelistContext.class,0);
		}
		public ParlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parlist; }
	}

	public final ParlistContext parlist() throws RecognitionException {
		ParlistContext _localctx = new ParlistContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_parlist);
		int _la;
		try {
			setState(363);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(357);
				namelist();
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(358);
					match(T__14);
					setState(359);
					match(T__27);
					}
				}

				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				match(T__27);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableconstructorContext extends ParserRuleContext {
		public FieldlistContext fieldlist() {
			return getRuleContext(FieldlistContext.class,0);
		}
		public TableconstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableconstructor; }
	}

	public final TableconstructorContext tableconstructor() throws RecognitionException {
		TableconstructorContext _localctx = new TableconstructorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_tableconstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			match(T__32);
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__30) | (1L << T__32) | (1L << T__42) | (1L << T__49) | (1L << T__52) | (1L << T__53) | (1L << NAME) | (1L << NORMALSTRING) | (1L << CHARSTRING) | (1L << LONGSTRING) | (1L << INT) | (1L << HEX) | (1L << FLOAT) | (1L << HEX_FLOAT))) != 0)) {
				{
				setState(366);
				fieldlist();
				}
			}

			setState(369);
			match(T__33);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldlistContext extends ParserRuleContext {
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<FieldsepContext> fieldsep() {
			return getRuleContexts(FieldsepContext.class);
		}
		public FieldsepContext fieldsep(int i) {
			return getRuleContext(FieldsepContext.class,i);
		}
		public FieldlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldlist; }
	}

	public final FieldlistContext fieldlist() throws RecognitionException {
		FieldlistContext _localctx = new FieldlistContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_fieldlist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			field();
			setState(377);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(372);
					fieldsep();
					setState(373);
					field();
					}
					} 
				}
				setState(379);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0 || _la==T__14) {
				{
				setState(380);
				fieldsep();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode NAME() { return getToken(LuaParser.NAME, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_field);
		try {
			setState(393);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(383);
				match(T__30);
				setState(384);
				exp(0);
				setState(385);
				match(T__31);
				setState(386);
				match(T__1);
				setState(387);
				exp(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(389);
				match(NAME);
				setState(390);
				match(T__1);
				setState(391);
				exp(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(392);
				exp(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldsepContext extends ParserRuleContext {
		public FieldsepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldsep; }
	}

	public final FieldsepContext fieldsep() throws RecognitionException {
		FieldsepContext _localctx = new FieldsepContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_fieldsep);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__14) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorOrContext extends ParserRuleContext {
		public OperatorOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorOr; }
	}

	public final OperatorOrContext operatorOr() throws RecognitionException {
		OperatorOrContext _localctx = new OperatorOrContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_operatorOr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			match(T__34);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorAndContext extends ParserRuleContext {
		public OperatorAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorAnd; }
	}

	public final OperatorAndContext operatorAnd() throws RecognitionException {
		OperatorAndContext _localctx = new OperatorAndContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_operatorAnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			match(T__35);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorComparisonContext extends ParserRuleContext {
		public OperatorComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorComparison; }
	}

	public final OperatorComparisonContext operatorComparison() throws RecognitionException {
		OperatorComparisonContext _localctx = new OperatorComparisonContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_operatorComparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorStrcatContext extends ParserRuleContext {
		public OperatorStrcatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorStrcat; }
	}

	public final OperatorStrcatContext operatorStrcat() throws RecognitionException {
		OperatorStrcatContext _localctx = new OperatorStrcatContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_operatorStrcat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			match(T__40);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorAddSubContext extends ParserRuleContext {
		public OperatorAddSubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorAddSub; }
	}

	public final OperatorAddSubContext operatorAddSub() throws RecognitionException {
		OperatorAddSubContext _localctx = new OperatorAddSubContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_operatorAddSub);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			_la = _input.LA(1);
			if ( !(_la==T__41 || _la==T__42) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorMulDivModContext extends ParserRuleContext {
		public OperatorMulDivModContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorMulDivMod; }
	}

	public final OperatorMulDivModContext operatorMulDivMod() throws RecognitionException {
		OperatorMulDivModContext _localctx = new OperatorMulDivModContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_operatorMulDivMod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorBitwiseContext extends ParserRuleContext {
		public OperatorBitwiseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorBitwise; }
	}

	public final OperatorBitwiseContext operatorBitwise() throws RecognitionException {
		OperatorBitwiseContext _localctx = new OperatorBitwiseContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_operatorBitwise);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorUnaryContext extends ParserRuleContext {
		public OperatorUnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorUnary; }
	}

	public final OperatorUnaryContext operatorUnary() throws RecognitionException {
		OperatorUnaryContext _localctx = new OperatorUnaryContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_operatorUnary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__42) | (1L << T__49) | (1L << T__52) | (1L << T__53))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorPowerContext extends ParserRuleContext {
		public OperatorPowerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorPower; }
	}

	public final OperatorPowerContext operatorPower() throws RecognitionException {
		OperatorPowerContext _localctx = new OperatorPowerContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_operatorPower);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			match(T__54);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(LuaParser.INT, 0); }
		public TerminalNode HEX() { return getToken(LuaParser.HEX, 0); }
		public TerminalNode FLOAT() { return getToken(LuaParser.FLOAT, 0); }
		public TerminalNode HEX_FLOAT() { return getToken(LuaParser.HEX_FLOAT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << HEX) | (1L << FLOAT) | (1L << HEX_FLOAT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public TerminalNode NORMALSTRING() { return getToken(LuaParser.NORMALSTRING, 0); }
		public TerminalNode CHARSTRING() { return getToken(LuaParser.CHARSTRING, 0); }
		public TerminalNode LONGSTRING() { return getToken(LuaParser.LONGSTRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NORMALSTRING) | (1L << CHARSTRING) | (1L << LONGSTRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3E\u01a6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\3\7\3Q\n\3\f\3\16\3"+
		"T\13\3\3\3\5\3W\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\7\4{\n\4\f\4\16\4~\13\4\3\4\3\4\5\4\u0082\n\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u008e\n\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4\u00a8\n\4\5\4\u00aa\n\4\3\5\3\5\3\5\3\5\3\5\7\5\u00b1\n\5\f\5\16"+
		"\5\u00b4\13\5\3\6\3\6\3\6\5\6\u00b9\n\6\3\7\3\7\5\7\u00bd\n\7\3\7\5\7"+
		"\u00c0\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\7\t\u00c9\n\t\f\t\16\t\u00cc\13"+
		"\t\3\t\3\t\5\t\u00d0\n\t\3\n\3\n\3\n\7\n\u00d5\n\n\f\n\16\n\u00d8\13\n"+
		"\3\13\3\13\3\13\7\13\u00dd\n\13\f\13\16\13\u00e0\13\13\3\f\3\f\3\f\7\f"+
		"\u00e5\n\f\f\f\16\f\u00e8\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\5\r\u00f7\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\7\r\u0119\n\r\f\r\16\r\u011c\13\r\3\16\3\16\7\16\u0120"+
		"\n\16\f\16\16\16\u0123\13\16\3\17\3\17\6\17\u0127\n\17\r\17\16\17\u0128"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u0130\n\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u0138\n\21\3\21\7\21\u013b\n\21\f\21\16\21\u013e\13\21\3\22\7\22"+
		"\u0141\n\22\f\22\16\22\u0144\13\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u014c\n\22\3\23\3\23\5\23\u0150\n\23\3\23\3\23\3\24\3\24\5\24\u0156\n"+
		"\24\3\24\3\24\3\24\5\24\u015b\n\24\3\25\3\25\3\25\3\26\3\26\5\26\u0162"+
		"\n\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\5\27\u016b\n\27\3\27\5\27\u016e"+
		"\n\27\3\30\3\30\5\30\u0172\n\30\3\30\3\30\3\31\3\31\3\31\3\31\7\31\u017a"+
		"\n\31\f\31\16\31\u017d\13\31\3\31\5\31\u0180\n\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u018c\n\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&"+
		"\3&\2\3\30\'\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJ\2\n\4\2\3\3\21\21\4\2\25\26\'*\3\2,-\3\2.\61\3\2\62\66\5"+
		"\2--\64\64\678\3\2>A\3\2;=\2\u01c1\2L\3\2\2\2\4R\3\2\2\2\6\u00a9\3\2\2"+
		"\2\b\u00ab\3\2\2\2\n\u00b8\3\2\2\2\f\u00ba\3\2\2\2\16\u00c1\3\2\2\2\20"+
		"\u00c5\3\2\2\2\22\u00d1\3\2\2\2\24\u00d9\3\2\2\2\26\u00e1\3\2\2\2\30\u00f6"+
		"\3\2\2\2\32\u011d\3\2\2\2\34\u0124\3\2\2\2\36\u012f\3\2\2\2 \u0137\3\2"+
		"\2\2\"\u0142\3\2\2\2$\u014f\3\2\2\2&\u015a\3\2\2\2(\u015c\3\2\2\2*\u015f"+
		"\3\2\2\2,\u016d\3\2\2\2.\u016f\3\2\2\2\60\u0175\3\2\2\2\62\u018b\3\2\2"+
		"\2\64\u018d\3\2\2\2\66\u018f\3\2\2\28\u0191\3\2\2\2:\u0193\3\2\2\2<\u0195"+
		"\3\2\2\2>\u0197\3\2\2\2@\u0199\3\2\2\2B\u019b\3\2\2\2D\u019d\3\2\2\2F"+
		"\u019f\3\2\2\2H\u01a1\3\2\2\2J\u01a3\3\2\2\2LM\5\4\3\2MN\7\2\2\3N\3\3"+
		"\2\2\2OQ\5\6\4\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2SV\3\2\2\2TR\3"+
		"\2\2\2UW\5\f\7\2VU\3\2\2\2VW\3\2\2\2W\5\3\2\2\2X\u00aa\7\3\2\2YZ\5\22"+
		"\n\2Z[\7\4\2\2[\\\5\26\f\2\\\u00aa\3\2\2\2]\u00aa\5\34\17\2^\u00aa\5\16"+
		"\b\2_\u00aa\7\5\2\2`a\7\6\2\2a\u00aa\7:\2\2bc\7\7\2\2cd\5\4\3\2de\7\b"+
		"\2\2e\u00aa\3\2\2\2fg\7\t\2\2gh\5\30\r\2hi\7\7\2\2ij\5\4\3\2jk\7\b\2\2"+
		"k\u00aa\3\2\2\2lm\7\n\2\2mn\5\4\3\2no\7\13\2\2op\5\30\r\2p\u00aa\3\2\2"+
		"\2qr\7\f\2\2rs\5\30\r\2st\7\r\2\2t|\5\4\3\2uv\7\16\2\2vw\5\30\r\2wx\7"+
		"\r\2\2xy\5\4\3\2y{\3\2\2\2zu\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\u0081"+
		"\3\2\2\2~|\3\2\2\2\177\u0080\7\17\2\2\u0080\u0082\5\4\3\2\u0081\177\3"+
		"\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\7\b\2\2\u0084"+
		"\u00aa\3\2\2\2\u0085\u0086\7\20\2\2\u0086\u0087\7:\2\2\u0087\u0088\7\4"+
		"\2\2\u0088\u0089\5\30\r\2\u0089\u008a\7\21\2\2\u008a\u008d\5\30\r\2\u008b"+
		"\u008c\7\21\2\2\u008c\u008e\5\30\r\2\u008d\u008b\3\2\2\2\u008d\u008e\3"+
		"\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\7\7\2\2\u0090\u0091\5\4\3\2\u0091"+
		"\u0092\7\b\2\2\u0092\u00aa\3\2\2\2\u0093\u0094\7\20\2\2\u0094\u0095\5"+
		"\24\13\2\u0095\u0096\7\22\2\2\u0096\u0097\5\26\f\2\u0097\u0098\7\7\2\2"+
		"\u0098\u0099\5\4\3\2\u0099\u009a\7\b\2\2\u009a\u00aa\3\2\2\2\u009b\u009c"+
		"\7\23\2\2\u009c\u009d\5\20\t\2\u009d\u009e\5*\26\2\u009e\u00aa\3\2\2\2"+
		"\u009f\u00a0\7\24\2\2\u00a0\u00a1\7\23\2\2\u00a1\u00a2\7:\2\2\u00a2\u00aa"+
		"\5*\26\2\u00a3\u00a4\7\24\2\2\u00a4\u00a7\5\b\5\2\u00a5\u00a6\7\4\2\2"+
		"\u00a6\u00a8\5\26\f\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa"+
		"\3\2\2\2\u00a9X\3\2\2\2\u00a9Y\3\2\2\2\u00a9]\3\2\2\2\u00a9^\3\2\2\2\u00a9"+
		"_\3\2\2\2\u00a9`\3\2\2\2\u00a9b\3\2\2\2\u00a9f\3\2\2\2\u00a9l\3\2\2\2"+
		"\u00a9q\3\2\2\2\u00a9\u0085\3\2\2\2\u00a9\u0093\3\2\2\2\u00a9\u009b\3"+
		"\2\2\2\u00a9\u009f\3\2\2\2\u00a9\u00a3\3\2\2\2\u00aa\7\3\2\2\2\u00ab\u00ac"+
		"\7:\2\2\u00ac\u00b2\5\n\6\2\u00ad\u00ae\7\21\2\2\u00ae\u00af\7:\2\2\u00af"+
		"\u00b1\5\n\6\2\u00b0\u00ad\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\t\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6"+
		"\7\25\2\2\u00b6\u00b7\7:\2\2\u00b7\u00b9\7\26\2\2\u00b8\u00b5\3\2\2\2"+
		"\u00b8\u00b9\3\2\2\2\u00b9\13\3\2\2\2\u00ba\u00bc\7\27\2\2\u00bb\u00bd"+
		"\5\26\f\2\u00bc\u00bb\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bf\3\2\2\2"+
		"\u00be\u00c0\7\3\2\2\u00bf\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\r\3"+
		"\2\2\2\u00c1\u00c2\7\30\2\2\u00c2\u00c3\7:\2\2\u00c3\u00c4\7\30\2\2\u00c4"+
		"\17\3\2\2\2\u00c5\u00ca\7:\2\2\u00c6\u00c7\7\31\2\2\u00c7\u00c9\7:\2\2"+
		"\u00c8\u00c6\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb"+
		"\3\2\2\2\u00cb\u00cf\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce\7\32\2\2"+
		"\u00ce\u00d0\7:\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\21\3"+
		"\2\2\2\u00d1\u00d6\5 \21\2\u00d2\u00d3\7\21\2\2\u00d3\u00d5\5 \21\2\u00d4"+
		"\u00d2\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2"+
		"\2\2\u00d7\23\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00de\7:\2\2\u00da\u00db"+
		"\7\21\2\2\u00db\u00dd\7:\2\2\u00dc\u00da\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de"+
		"\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\25\3\2\2\2\u00e0\u00de\3\2\2"+
		"\2\u00e1\u00e6\5\30\r\2\u00e2\u00e3\7\21\2\2\u00e3\u00e5\5\30\r\2\u00e4"+
		"\u00e2\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2"+
		"\2\2\u00e7\27\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea\b\r\1\2\u00ea\u00f7"+
		"\7\33\2\2\u00eb\u00f7\7\34\2\2\u00ec\u00f7\7\35\2\2\u00ed\u00f7\5H%\2"+
		"\u00ee\u00f7\5J&\2\u00ef\u00f7\7\36\2\2\u00f0\u00f7\5(\25\2\u00f1\u00f7"+
		"\5\32\16\2\u00f2\u00f7\5.\30\2\u00f3\u00f4\5D#\2\u00f4\u00f5\5\30\r\n"+
		"\u00f5\u00f7\3\2\2\2\u00f6\u00e9\3\2\2\2\u00f6\u00eb\3\2\2\2\u00f6\u00ec"+
		"\3\2\2\2\u00f6\u00ed\3\2\2\2\u00f6\u00ee\3\2\2\2\u00f6\u00ef\3\2\2\2\u00f6"+
		"\u00f0\3\2\2\2\u00f6\u00f1\3\2\2\2\u00f6\u00f2\3\2\2\2\u00f6\u00f3\3\2"+
		"\2\2\u00f7\u011a\3\2\2\2\u00f8\u00f9\f\13\2\2\u00f9\u00fa\5F$\2\u00fa"+
		"\u00fb\5\30\r\13\u00fb\u0119\3\2\2\2\u00fc\u00fd\f\t\2\2\u00fd\u00fe\5"+
		"@!\2\u00fe\u00ff\5\30\r\n\u00ff\u0119\3\2\2\2\u0100\u0101\f\b\2\2\u0101"+
		"\u0102\5> \2\u0102\u0103\5\30\r\t\u0103\u0119\3\2\2\2\u0104\u0105\f\7"+
		"\2\2\u0105\u0106\5<\37\2\u0106\u0107\5\30\r\7\u0107\u0119\3\2\2\2\u0108"+
		"\u0109\f\6\2\2\u0109\u010a\5:\36\2\u010a\u010b\5\30\r\7\u010b\u0119\3"+
		"\2\2\2\u010c\u010d\f\5\2\2\u010d\u010e\58\35\2\u010e\u010f\5\30\r\6\u010f"+
		"\u0119\3\2\2\2\u0110\u0111\f\4\2\2\u0111\u0112\5\66\34\2\u0112\u0113\5"+
		"\30\r\5\u0113\u0119\3\2\2\2\u0114\u0115\f\3\2\2\u0115\u0116\5B\"\2\u0116"+
		"\u0117\5\30\r\4\u0117\u0119\3\2\2\2\u0118\u00f8\3\2\2\2\u0118\u00fc\3"+
		"\2\2\2\u0118\u0100\3\2\2\2\u0118\u0104\3\2\2\2\u0118\u0108\3\2\2\2\u0118"+
		"\u010c\3\2\2\2\u0118\u0110\3\2\2\2\u0118\u0114\3\2\2\2\u0119\u011c\3\2"+
		"\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\31\3\2\2\2\u011c\u011a"+
		"\3\2\2\2\u011d\u0121\5\36\20\2\u011e\u0120\5$\23\2\u011f\u011e\3\2\2\2"+
		"\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\33"+
		"\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0126\5\36\20\2\u0125\u0127\5$\23\2"+
		"\u0126\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129"+
		"\3\2\2\2\u0129\35\3\2\2\2\u012a\u0130\5 \21\2\u012b\u012c\7\37\2\2\u012c"+
		"\u012d\5\30\r\2\u012d\u012e\7 \2\2\u012e\u0130\3\2\2\2\u012f\u012a\3\2"+
		"\2\2\u012f\u012b\3\2\2\2\u0130\37\3\2\2\2\u0131\u0138\7:\2\2\u0132\u0133"+
		"\7\37\2\2\u0133\u0134\5\30\r\2\u0134\u0135\7 \2\2\u0135\u0136\5\"\22\2"+
		"\u0136\u0138\3\2\2\2\u0137\u0131\3\2\2\2\u0137\u0132\3\2\2\2\u0138\u013c"+
		"\3\2\2\2\u0139\u013b\5\"\22\2\u013a\u0139\3\2\2\2\u013b\u013e\3\2\2\2"+
		"\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d!\3\2\2\2\u013e\u013c\3"+
		"\2\2\2\u013f\u0141\5$\23\2\u0140\u013f\3\2\2\2\u0141\u0144\3\2\2\2\u0142"+
		"\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u014b\3\2\2\2\u0144\u0142\3\2"+
		"\2\2\u0145\u0146\7!\2\2\u0146\u0147\5\30\r\2\u0147\u0148\7\"\2\2\u0148"+
		"\u014c\3\2\2\2\u0149\u014a\7\31\2\2\u014a\u014c\7:\2\2\u014b\u0145\3\2"+
		"\2\2\u014b\u0149\3\2\2\2\u014c#\3\2\2\2\u014d\u014e\7\32\2\2\u014e\u0150"+
		"\7:\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\3\2\2\2\u0151"+
		"\u0152\5&\24\2\u0152%\3\2\2\2\u0153\u0155\7\37\2\2\u0154\u0156\5\26\f"+
		"\2\u0155\u0154\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u015b"+
		"\7 \2\2\u0158\u015b\5.\30\2\u0159\u015b\5J&\2\u015a\u0153\3\2\2\2\u015a"+
		"\u0158\3\2\2\2\u015a\u0159\3\2\2\2\u015b\'\3\2\2\2\u015c\u015d\7\23\2"+
		"\2\u015d\u015e\5*\26\2\u015e)\3\2\2\2\u015f\u0161\7\37\2\2\u0160\u0162"+
		"\5,\27\2\u0161\u0160\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\3\2\2\2\u0163"+
		"\u0164\7 \2\2\u0164\u0165\5\4\3\2\u0165\u0166\7\b\2\2\u0166+\3\2\2\2\u0167"+
		"\u016a\5\24\13\2\u0168\u0169\7\21\2\2\u0169\u016b\7\36\2\2\u016a\u0168"+
		"\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016e\7\36\2\2"+
		"\u016d\u0167\3\2\2\2\u016d\u016c\3\2\2\2\u016e-\3\2\2\2\u016f\u0171\7"+
		"#\2\2\u0170\u0172\5\60\31\2\u0171\u0170\3\2\2\2\u0171\u0172\3\2\2\2\u0172"+
		"\u0173\3\2\2\2\u0173\u0174\7$\2\2\u0174/\3\2\2\2\u0175\u017b\5\62\32\2"+
		"\u0176\u0177\5\64\33\2\u0177\u0178\5\62\32\2\u0178\u017a\3\2\2\2\u0179"+
		"\u0176\3\2\2\2\u017a\u017d\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2"+
		"\2\2\u017c\u017f\3\2\2\2\u017d\u017b\3\2\2\2\u017e\u0180\5\64\33\2\u017f"+
		"\u017e\3\2\2\2\u017f\u0180\3\2\2\2\u0180\61\3\2\2\2\u0181\u0182\7!\2\2"+
		"\u0182\u0183\5\30\r\2\u0183\u0184\7\"\2\2\u0184\u0185\7\4\2\2\u0185\u0186"+
		"\5\30\r\2\u0186\u018c\3\2\2\2\u0187\u0188\7:\2\2\u0188\u0189\7\4\2\2\u0189"+
		"\u018c\5\30\r\2\u018a\u018c\5\30\r\2\u018b\u0181\3\2\2\2\u018b\u0187\3"+
		"\2\2\2\u018b\u018a\3\2\2\2\u018c\63\3\2\2\2\u018d\u018e\t\2\2\2\u018e"+
		"\65\3\2\2\2\u018f\u0190\7%\2\2\u0190\67\3\2\2\2\u0191\u0192\7&\2\2\u0192"+
		"9\3\2\2\2\u0193\u0194\t\3\2\2\u0194;\3\2\2\2\u0195\u0196\7+\2\2\u0196"+
		"=\3\2\2\2\u0197\u0198\t\4\2\2\u0198?\3\2\2\2\u0199\u019a\t\5\2\2\u019a"+
		"A\3\2\2\2\u019b\u019c\t\6\2\2\u019cC\3\2\2\2\u019d\u019e\t\7\2\2\u019e"+
		"E\3\2\2\2\u019f\u01a0\79\2\2\u01a0G\3\2\2\2\u01a1\u01a2\t\b\2\2\u01a2"+
		"I\3\2\2\2\u01a3\u01a4\t\t\2\2\u01a4K\3\2\2\2&RV|\u0081\u008d\u00a7\u00a9"+
		"\u00b2\u00b8\u00bc\u00bf\u00ca\u00cf\u00d6\u00de\u00e6\u00f6\u0118\u011a"+
		"\u0121\u0128\u012f\u0137\u013c\u0142\u014b\u014f\u0155\u015a\u0161\u016a"+
		"\u016d\u0171\u017b\u017f\u018b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}