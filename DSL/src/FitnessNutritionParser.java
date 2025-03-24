// Generated from grammar/FitnessNutrition.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FitnessNutritionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, KEYWORD=28, IDENTIFIER=29, STRING=30, NUMBER=31, 
		TIME=32, BOOLEAN=33, COMMENT=34, WS=35;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_createStmt = 2, RULE_attributeList = 3, 
		RULE_attribute = 4, RULE_generateStmt = 5, RULE_parameterList = 6, RULE_paramList = 7, 
		RULE_param = 8, RULE_value = 9, RULE_selectStmt = 10, RULE_condition = 11, 
		RULE_operator = 12, RULE_loopStmt = 13, RULE_whileStmt = 14, RULE_forStmt = 15, 
		RULE_foreachStmt = 16, RULE_includeStmt = 17, RULE_iterable = 18, RULE_outputStmt = 19, 
		RULE_usingStmt = 20, RULE_block = 21, RULE_expression = 22, RULE_mathExpr = 23, 
		RULE_reference = 24, RULE_array = 25, RULE_timeRange = 26, RULE_object = 27, 
		RULE_identifier = 28, RULE_literal = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "createStmt", "attributeList", "attribute", "generateStmt", 
			"parameterList", "paramList", "param", "value", "selectStmt", "condition", 
			"operator", "loopStmt", "whileStmt", "forStmt", "foreachStmt", "includeStmt", 
			"iterable", "outputStmt", "usingStmt", "block", "expression", "mathExpr", 
			"reference", "array", "timeRange", "object", "identifier", "literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'create'", "'{'", "'}'", "'('", "')'", "'generate'", "','", "'select'", 
			"'where'", "'!='", "'done'", "'='", "'>'", "'<'", "'while'", "'for'", 
			"'in'", "'foreach'", "'include'", "'into'", "'output'", "'as'", "'table'", 
			"'using'", "'.'", "'*'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "KEYWORD", "IDENTIFIER", "STRING", "NUMBER", 
			"TIME", "BOOLEAN", "COMMENT", "WS"
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
	public String getGrammarFileName() { return "FitnessNutrition.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FitnessNutritionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__7) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__23))) != 0)) {
				{
				{
				setState(60);
				statement();
				}
				}
				setState(65);
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

	public static class StatementContext extends ParserRuleContext {
		public CreateStmtContext createStmt() {
			return getRuleContext(CreateStmtContext.class,0);
		}
		public GenerateStmtContext generateStmt() {
			return getRuleContext(GenerateStmtContext.class,0);
		}
		public SelectStmtContext selectStmt() {
			return getRuleContext(SelectStmtContext.class,0);
		}
		public UsingStmtContext usingStmt() {
			return getRuleContext(UsingStmtContext.class,0);
		}
		public OutputStmtContext outputStmt() {
			return getRuleContext(OutputStmtContext.class,0);
		}
		public LoopStmtContext loopStmt() {
			return getRuleContext(LoopStmtContext.class,0);
		}
		public IncludeStmtContext includeStmt() {
			return getRuleContext(IncludeStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				createStmt();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				generateStmt();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				selectStmt();
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				usingStmt();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				outputStmt();
				}
				break;
			case T__14:
			case T__15:
			case T__17:
				enterOuterAlt(_localctx, 6);
				{
				setState(71);
				loopStmt();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 7);
				{
				setState(72);
				includeStmt();
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

	public static class CreateStmtContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public AttributeListContext attributeList() {
			return getRuleContext(AttributeListContext.class,0);
		}
		public CreateStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterCreateStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitCreateStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitCreateStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateStmtContext createStmt() throws RecognitionException {
		CreateStmtContext _localctx = new CreateStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_createStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__0);
			setState(76);
			identifier();
			setState(77);
			identifier();
			setState(78);
			match(T__1);
			setState(79);
			attributeList();
			setState(80);
			match(T__2);
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

	public static class AttributeListContext extends ParserRuleContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public AttributeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterAttributeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitAttributeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitAttributeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeListContext attributeList() throws RecognitionException {
		AttributeListContext _localctx = new AttributeListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_attributeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KEYWORD || _la==IDENTIFIER) {
				{
				{
				setState(82);
				attribute();
				}
				}
				setState(87);
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

	public static class AttributeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public AttributeListContext attributeList() {
			return getRuleContext(AttributeListContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attribute);
		try {
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				identifier();
				{
				setState(89);
				match(T__3);
				setState(90);
				value();
				setState(91);
				match(T__4);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				identifier();
				setState(94);
				match(T__1);
				setState(95);
				attributeList();
				setState(96);
				match(T__2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				identifier();
				setState(99);
				match(T__3);
				setState(100);
				expression();
				setState(101);
				match(T__4);
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

	public static class GenerateStmtContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public GenerateStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generateStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterGenerateStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitGenerateStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitGenerateStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenerateStmtContext generateStmt() throws RecognitionException {
		GenerateStmtContext _localctx = new GenerateStmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_generateStmt);
		int _la;
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(T__5);
				setState(106);
				identifier();
				setState(107);
				match(T__1);
				setState(108);
				paramList();
				setState(109);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(T__5);
				setState(112);
				identifier();
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(113);
					match(T__3);
					setState(114);
					paramList();
					setState(115);
					match(T__4);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				match(T__5);
				setState(120);
				reference();
				setState(121);
				parameterList();
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

	public static class ParameterListContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(125);
				identifier();
				}
				}
				setState(128); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==KEYWORD || _la==IDENTIFIER );
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

	public static class ParamListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			param();
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(131);
				match(T__6);
				setState(132);
				param();
				}
				}
				setState(137);
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

	public static class ParamContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_param);
		int _la;
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				identifier();
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(139);
					match(T__3);
					setState(140);
					value();
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__6) {
						{
						{
						setState(141);
						match(T__6);
						setState(142);
						value();
						}
						}
						setState(147);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(148);
					match(T__4);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				identifier();
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

	public static class ValueContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_value);
		try {
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				identifier();
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

	public static class SelectStmtContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public SelectStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterSelectStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitSelectStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitSelectStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectStmtContext selectStmt() throws RecognitionException {
		SelectStmtContext _localctx = new SelectStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_selectStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__7);
			setState(161);
			identifier();
			setState(162);
			match(T__8);
			setState(163);
			condition();
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

	public static class ConditionContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_condition);
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				reference();
				setState(166);
				operator();
				setState(167);
				value();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				identifier();
				setState(170);
				operator();
				setState(171);
				value();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(173);
				reference();
				setState(174);
				match(T__9);
				setState(175);
				match(T__10);
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

	public static class OperatorContext extends ParserRuleContext {
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
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

	public static class LoopStmtContext extends ParserRuleContext {
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public ForeachStmtContext foreachStmt() {
			return getRuleContext(ForeachStmtContext.class,0);
		}
		public LoopStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterLoopStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitLoopStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitLoopStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStmtContext loopStmt() throws RecognitionException {
		LoopStmtContext _localctx = new LoopStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_loopStmt);
		try {
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				whileStmt();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				forStmt();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
				foreachStmt();
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

	public static class WhileStmtContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(T__14);
			setState(187);
			match(T__3);
			setState(188);
			condition();
			setState(189);
			match(T__4);
			setState(190);
			block();
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

	public static class ForStmtContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IterableContext iterable() {
			return getRuleContext(IterableContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_forStmt);
		try {
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				match(T__15);
				setState(193);
				match(T__3);
				setState(194);
				identifier();
				setState(195);
				match(T__4);
				setState(196);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				match(T__15);
				setState(199);
				identifier();
				setState(200);
				match(T__16);
				setState(201);
				iterable();
				setState(202);
				block();
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

	public static class ForeachStmtContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ForeachStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreachStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterForeachStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitForeachStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitForeachStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForeachStmtContext foreachStmt() throws RecognitionException {
		ForeachStmtContext _localctx = new ForeachStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_foreachStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(T__17);
			setState(207);
			reference();
			setState(208);
			match(T__1);
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__7) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__23))) != 0)) {
				{
				{
				setState(209);
				statement();
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(215);
			match(T__2);
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

	public static class IncludeStmtContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public IncludeStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includeStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterIncludeStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitIncludeStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitIncludeStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncludeStmtContext includeStmt() throws RecognitionException {
		IncludeStmtContext _localctx = new IncludeStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_includeStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(T__18);
			setState(218);
			identifier();
			setState(219);
			match(T__19);
			setState(220);
			identifier();
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

	public static class IterableContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public IterableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterIterable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitIterable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitIterable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterableContext iterable() throws RecognitionException {
		IterableContext _localctx = new IterableContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_iterable);
		try {
			setState(225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				array();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				reference();
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

	public static class OutputStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public OutputStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterOutputStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitOutputStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitOutputStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputStmtContext outputStmt() throws RecognitionException {
		OutputStmtContext _localctx = new OutputStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_outputStmt);
		int _la;
		try {
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(227);
				match(T__20);
				setState(228);
				expression();
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__21) {
					{
					setState(229);
					match(T__21);
					setState(230);
					identifier();
					setState(231);
					match(T__22);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				match(T__20);
				setState(236);
				expression();
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(237);
					match(T__16);
					setState(238);
					match(T__22);
					setState(239);
					match(T__3);
					setState(240);
					identifier();
					setState(241);
					match(T__4);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(245);
				match(T__20);
				setState(246);
				reference();
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

	public static class UsingStmtContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public UsingStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterUsingStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitUsingStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitUsingStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UsingStmtContext usingStmt() throws RecognitionException {
		UsingStmtContext _localctx = new UsingStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_usingStmt);
		try {
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				match(T__23);
				setState(250);
				reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				match(T__23);
				setState(252);
				identifier();
				setState(253);
				match(T__24);
				setState(254);
				identifier();
				setState(255);
				match(T__11);
				setState(256);
				literal();
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__1);
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__7) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__23))) != 0)) {
				{
				{
				setState(261);
				statement();
				}
				}
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(267);
			match(T__2);
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

	public static class ExpressionContext extends ParserRuleContext {
		public MathExprContext mathExpr() {
			return getRuleContext(MathExprContext.class,0);
		}
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expression);
		try {
			setState(272);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				mathExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
				reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(271);
				literal();
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

	public static class MathExprContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(FitnessNutritionParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(FitnessNutritionParser.NUMBER, i);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public MathExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterMathExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitMathExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitMathExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MathExprContext mathExpr() throws RecognitionException {
		MathExprContext _localctx = new MathExprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_mathExpr);
		try {
			setState(285);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				match(NUMBER);
				setState(275);
				operator();
				setState(276);
				match(NUMBER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(278);
				match(NUMBER);
				setState(279);
				match(T__25);
				setState(280);
				reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(281);
				reference();
				setState(282);
				match(T__25);
				setState(283);
				match(NUMBER);
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

	public static class ReferenceContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_reference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			identifier();
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(288);
				match(T__24);
				setState(289);
				identifier();
				}
				}
				setState(294);
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

	public static class ArrayContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<TimeRangeContext> timeRange() {
			return getRuleContexts(TimeRangeContext.class);
		}
		public TimeRangeContext timeRange(int i) {
			return getRuleContext(TimeRangeContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_array);
		int _la;
		try {
			setState(318);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				match(T__1);
				setState(304);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEYWORD) | (1L << IDENTIFIER) | (1L << STRING) | (1L << NUMBER) | (1L << TIME) | (1L << BOOLEAN))) != 0)) {
					{
					setState(296);
					value();
					setState(301);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__6) {
						{
						{
						setState(297);
						match(T__6);
						setState(298);
						value();
						}
						}
						setState(303);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(306);
				match(T__2);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
				match(T__3);
				setState(308);
				timeRange();
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(309);
					match(T__6);
					setState(310);
					timeRange();
					}
					}
					setState(315);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(316);
				match(T__4);
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

	public static class TimeRangeContext extends ParserRuleContext {
		public List<TerminalNode> TIME() { return getTokens(FitnessNutritionParser.TIME); }
		public TerminalNode TIME(int i) {
			return getToken(FitnessNutritionParser.TIME, i);
		}
		public TimeRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterTimeRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitTimeRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitTimeRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeRangeContext timeRange() throws RecognitionException {
		TimeRangeContext _localctx = new TimeRangeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_timeRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(TIME);
			setState(321);
			match(T__26);
			setState(322);
			match(TIME);
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

	public static class ObjectContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public AttributeListContext attributeList() {
			return getRuleContext(AttributeListContext.class,0);
		}
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_object);
		try {
			setState(332);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(324);
				match(T__3);
				setState(325);
				value();
				setState(326);
				match(T__4);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(328);
				match(T__1);
				setState(329);
				attributeList();
				setState(330);
				match(T__2);
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FitnessNutritionParser.IDENTIFIER, 0); }
		public TerminalNode KEYWORD() { return getToken(FitnessNutritionParser.KEYWORD, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			_la = _input.LA(1);
			if ( !(_la==KEYWORD || _la==IDENTIFIER) ) {
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(FitnessNutritionParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(FitnessNutritionParser.NUMBER, 0); }
		public TerminalNode TIME() { return getToken(FitnessNutritionParser.TIME, 0); }
		public TerminalNode BOOLEAN() { return getToken(FitnessNutritionParser.BOOLEAN, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << NUMBER) | (1L << TIME) | (1L << BOOLEAN))) != 0)) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u0155\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\7\2@"+
		"\n\2\f\2\16\2C\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3L\n\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\7\5V\n\5\f\5\16\5Y\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6j\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\5\7x\n\7\3\7\3\7\3\7\3\7\5\7~\n\7\3\b\6\b\u0081\n"+
		"\b\r\b\16\b\u0082\3\t\3\t\3\t\7\t\u0088\n\t\f\t\16\t\u008b\13\t\3\n\3"+
		"\n\3\n\3\n\3\n\7\n\u0092\n\n\f\n\16\n\u0095\13\n\3\n\3\n\5\n\u0099\n\n"+
		"\3\n\5\n\u009c\n\n\3\13\3\13\3\13\5\13\u00a1\n\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b4\n\r\3\16\3"+
		"\16\3\17\3\17\3\17\5\17\u00bb\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00cf\n\21"+
		"\3\22\3\22\3\22\3\22\7\22\u00d5\n\22\f\22\16\22\u00d8\13\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\5\24\u00e4\n\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u00ec\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u00f6\n\25\3\25\3\25\5\25\u00fa\n\25\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\5\26\u0105\n\26\3\27\3\27\7\27\u0109\n\27\f\27\16\27"+
		"\u010c\13\27\3\27\3\27\3\30\3\30\3\30\5\30\u0113\n\30\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0120\n\31\3\32\3\32\3\32"+
		"\7\32\u0125\n\32\f\32\16\32\u0128\13\32\3\33\3\33\3\33\3\33\7\33\u012e"+
		"\n\33\f\33\16\33\u0131\13\33\5\33\u0133\n\33\3\33\3\33\3\33\3\33\3\33"+
		"\7\33\u013a\n\33\f\33\16\33\u013d\13\33\3\33\3\33\5\33\u0141\n\33\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u014f\n\35"+
		"\3\36\3\36\3\37\3\37\3\37\2\2 \2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<\2\5\3\2\16\20\3\2\36\37\3\2 #\2\u0162\2A\3\2"+
		"\2\2\4K\3\2\2\2\6M\3\2\2\2\bW\3\2\2\2\ni\3\2\2\2\f}\3\2\2\2\16\u0080\3"+
		"\2\2\2\20\u0084\3\2\2\2\22\u009b\3\2\2\2\24\u00a0\3\2\2\2\26\u00a2\3\2"+
		"\2\2\30\u00b3\3\2\2\2\32\u00b5\3\2\2\2\34\u00ba\3\2\2\2\36\u00bc\3\2\2"+
		"\2 \u00ce\3\2\2\2\"\u00d0\3\2\2\2$\u00db\3\2\2\2&\u00e3\3\2\2\2(\u00f9"+
		"\3\2\2\2*\u0104\3\2\2\2,\u0106\3\2\2\2.\u0112\3\2\2\2\60\u011f\3\2\2\2"+
		"\62\u0121\3\2\2\2\64\u0140\3\2\2\2\66\u0142\3\2\2\28\u014e\3\2\2\2:\u0150"+
		"\3\2\2\2<\u0152\3\2\2\2>@\5\4\3\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2"+
		"\2\2B\3\3\2\2\2CA\3\2\2\2DL\5\6\4\2EL\5\f\7\2FL\5\26\f\2GL\5*\26\2HL\5"+
		"(\25\2IL\5\34\17\2JL\5$\23\2KD\3\2\2\2KE\3\2\2\2KF\3\2\2\2KG\3\2\2\2K"+
		"H\3\2\2\2KI\3\2\2\2KJ\3\2\2\2L\5\3\2\2\2MN\7\3\2\2NO\5:\36\2OP\5:\36\2"+
		"PQ\7\4\2\2QR\5\b\5\2RS\7\5\2\2S\7\3\2\2\2TV\5\n\6\2UT\3\2\2\2VY\3\2\2"+
		"\2WU\3\2\2\2WX\3\2\2\2X\t\3\2\2\2YW\3\2\2\2Z[\5:\36\2[\\\7\6\2\2\\]\5"+
		"\24\13\2]^\7\7\2\2^j\3\2\2\2_`\5:\36\2`a\7\4\2\2ab\5\b\5\2bc\7\5\2\2c"+
		"j\3\2\2\2de\5:\36\2ef\7\6\2\2fg\5.\30\2gh\7\7\2\2hj\3\2\2\2iZ\3\2\2\2"+
		"i_\3\2\2\2id\3\2\2\2j\13\3\2\2\2kl\7\b\2\2lm\5:\36\2mn\7\4\2\2no\5\20"+
		"\t\2op\7\5\2\2p~\3\2\2\2qr\7\b\2\2rw\5:\36\2st\7\6\2\2tu\5\20\t\2uv\7"+
		"\7\2\2vx\3\2\2\2ws\3\2\2\2wx\3\2\2\2x~\3\2\2\2yz\7\b\2\2z{\5\62\32\2{"+
		"|\5\16\b\2|~\3\2\2\2}k\3\2\2\2}q\3\2\2\2}y\3\2\2\2~\r\3\2\2\2\177\u0081"+
		"\5:\36\2\u0080\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\17\3\2\2\2\u0084\u0089\5\22\n\2\u0085\u0086\7\t\2"+
		"\2\u0086\u0088\5\22\n\2\u0087\u0085\3\2\2\2\u0088\u008b\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\21\3\2\2\2\u008b\u0089\3\2\2"+
		"\2\u008c\u0098\5:\36\2\u008d\u008e\7\6\2\2\u008e\u0093\5\24\13\2\u008f"+
		"\u0090\7\t\2\2\u0090\u0092\5\24\13\2\u0091\u008f\3\2\2\2\u0092\u0095\3"+
		"\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0096\u0097\7\7\2\2\u0097\u0099\3\2\2\2\u0098\u008d\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u009c\5:\36\2\u009b"+
		"\u008c\3\2\2\2\u009b\u009a\3\2\2\2\u009c\23\3\2\2\2\u009d\u00a1\5<\37"+
		"\2\u009e\u00a1\5\62\32\2\u009f\u00a1\5:\36\2\u00a0\u009d\3\2\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1\25\3\2\2\2\u00a2\u00a3\7\n\2"+
		"\2\u00a3\u00a4\5:\36\2\u00a4\u00a5\7\13\2\2\u00a5\u00a6\5\30\r\2\u00a6"+
		"\27\3\2\2\2\u00a7\u00a8\5\62\32\2\u00a8\u00a9\5\32\16\2\u00a9\u00aa\5"+
		"\24\13\2\u00aa\u00b4\3\2\2\2\u00ab\u00ac\5:\36\2\u00ac\u00ad\5\32\16\2"+
		"\u00ad\u00ae\5\24\13\2\u00ae\u00b4\3\2\2\2\u00af\u00b0\5\62\32\2\u00b0"+
		"\u00b1\7\f\2\2\u00b1\u00b2\7\r\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00a7\3\2"+
		"\2\2\u00b3\u00ab\3\2\2\2\u00b3\u00af\3\2\2\2\u00b4\31\3\2\2\2\u00b5\u00b6"+
		"\t\2\2\2\u00b6\33\3\2\2\2\u00b7\u00bb\5\36\20\2\u00b8\u00bb\5 \21\2\u00b9"+
		"\u00bb\5\"\22\2\u00ba\u00b7\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00b9\3"+
		"\2\2\2\u00bb\35\3\2\2\2\u00bc\u00bd\7\21\2\2\u00bd\u00be\7\6\2\2\u00be"+
		"\u00bf\5\30\r\2\u00bf\u00c0\7\7\2\2\u00c0\u00c1\5,\27\2\u00c1\37\3\2\2"+
		"\2\u00c2\u00c3\7\22\2\2\u00c3\u00c4\7\6\2\2\u00c4\u00c5\5:\36\2\u00c5"+
		"\u00c6\7\7\2\2\u00c6\u00c7\5,\27\2\u00c7\u00cf\3\2\2\2\u00c8\u00c9\7\22"+
		"\2\2\u00c9\u00ca\5:\36\2\u00ca\u00cb\7\23\2\2\u00cb\u00cc\5&\24\2\u00cc"+
		"\u00cd\5,\27\2\u00cd\u00cf\3\2\2\2\u00ce\u00c2\3\2\2\2\u00ce\u00c8\3\2"+
		"\2\2\u00cf!\3\2\2\2\u00d0\u00d1\7\24\2\2\u00d1\u00d2\5\62\32\2\u00d2\u00d6"+
		"\7\4\2\2\u00d3\u00d5\5\4\3\2\u00d4\u00d3\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d6\3\2"+
		"\2\2\u00d9\u00da\7\5\2\2\u00da#\3\2\2\2\u00db\u00dc\7\25\2\2\u00dc\u00dd"+
		"\5:\36\2\u00dd\u00de\7\26\2\2\u00de\u00df\5:\36\2\u00df%\3\2\2\2\u00e0"+
		"\u00e4\5:\36\2\u00e1\u00e4\5\64\33\2\u00e2\u00e4\5\62\32\2\u00e3\u00e0"+
		"\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\'\3\2\2\2\u00e5"+
		"\u00e6\7\27\2\2\u00e6\u00eb\5.\30\2\u00e7\u00e8\7\30\2\2\u00e8\u00e9\5"+
		":\36\2\u00e9\u00ea\7\31\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e7\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00fa\3\2\2\2\u00ed\u00ee\7\27\2\2\u00ee\u00f5\5"+
		".\30\2\u00ef\u00f0\7\23\2\2\u00f0\u00f1\7\31\2\2\u00f1\u00f2\7\6\2\2\u00f2"+
		"\u00f3\5:\36\2\u00f3\u00f4\7\7\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00ef\3\2"+
		"\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00fa\3\2\2\2\u00f7\u00f8\7\27\2\2\u00f8"+
		"\u00fa\5\62\32\2\u00f9\u00e5\3\2\2\2\u00f9\u00ed\3\2\2\2\u00f9\u00f7\3"+
		"\2\2\2\u00fa)\3\2\2\2\u00fb\u00fc\7\32\2\2\u00fc\u0105\5\62\32\2\u00fd"+
		"\u00fe\7\32\2\2\u00fe\u00ff\5:\36\2\u00ff\u0100\7\33\2\2\u0100\u0101\5"+
		":\36\2\u0101\u0102\7\16\2\2\u0102\u0103\5<\37\2\u0103\u0105\3\2\2\2\u0104"+
		"\u00fb\3\2\2\2\u0104\u00fd\3\2\2\2\u0105+\3\2\2\2\u0106\u010a\7\4\2\2"+
		"\u0107\u0109\5\4\3\2\u0108\u0107\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108"+
		"\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010d\3\2\2\2\u010c\u010a\3\2\2\2\u010d"+
		"\u010e\7\5\2\2\u010e-\3\2\2\2\u010f\u0113\5\60\31\2\u0110\u0113\5\62\32"+
		"\2\u0111\u0113\5<\37\2\u0112\u010f\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0111"+
		"\3\2\2\2\u0113/\3\2\2\2\u0114\u0115\7!\2\2\u0115\u0116\5\32\16\2\u0116"+
		"\u0117\7!\2\2\u0117\u0120\3\2\2\2\u0118\u0119\7!\2\2\u0119\u011a\7\34"+
		"\2\2\u011a\u0120\5\62\32\2\u011b\u011c\5\62\32\2\u011c\u011d\7\34\2\2"+
		"\u011d\u011e\7!\2\2\u011e\u0120\3\2\2\2\u011f\u0114\3\2\2\2\u011f\u0118"+
		"\3\2\2\2\u011f\u011b\3\2\2\2\u0120\61\3\2\2\2\u0121\u0126\5:\36\2\u0122"+
		"\u0123\7\33\2\2\u0123\u0125\5:\36\2\u0124\u0122\3\2\2\2\u0125\u0128\3"+
		"\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\63\3\2\2\2\u0128"+
		"\u0126\3\2\2\2\u0129\u0132\7\4\2\2\u012a\u012f\5\24\13\2\u012b\u012c\7"+
		"\t\2\2\u012c\u012e\5\24\13\2\u012d\u012b\3\2\2\2\u012e\u0131\3\2\2\2\u012f"+
		"\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2"+
		"\2\2\u0132\u012a\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\3\2\2\2\u0134"+
		"\u0141\7\5\2\2\u0135\u0136\7\6\2\2\u0136\u013b\5\66\34\2\u0137\u0138\7"+
		"\t\2\2\u0138\u013a\5\66\34\2\u0139\u0137\3\2\2\2\u013a\u013d\3\2\2\2\u013b"+
		"\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u013b\3\2"+
		"\2\2\u013e\u013f\7\7\2\2\u013f\u0141\3\2\2\2\u0140\u0129\3\2\2\2\u0140"+
		"\u0135\3\2\2\2\u0141\65\3\2\2\2\u0142\u0143\7\"\2\2\u0143\u0144\7\35\2"+
		"\2\u0144\u0145\7\"\2\2\u0145\67\3\2\2\2\u0146\u0147\7\6\2\2\u0147\u0148"+
		"\5\24\13\2\u0148\u0149\7\7\2\2\u0149\u014f\3\2\2\2\u014a\u014b\7\4\2\2"+
		"\u014b\u014c\5\b\5\2\u014c\u014d\7\5\2\2\u014d\u014f\3\2\2\2\u014e\u0146"+
		"\3\2\2\2\u014e\u014a\3\2\2\2\u014f9\3\2\2\2\u0150\u0151\t\3\2\2\u0151"+
		";\3\2\2\2\u0152\u0153\t\4\2\2\u0153=\3\2\2\2 AKWiw}\u0082\u0089\u0093"+
		"\u0098\u009b\u00a0\u00b3\u00ba\u00ce\u00d6\u00e3\u00eb\u00f5\u00f9\u0104"+
		"\u010a\u0112\u011f\u0126\u012f\u0132\u013b\u0140\u014e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}