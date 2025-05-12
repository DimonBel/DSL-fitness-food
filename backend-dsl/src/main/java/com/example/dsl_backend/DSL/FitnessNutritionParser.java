package com.example.dsl_backend.DSL;
// Generated from C:\Users\Duma\OneDrive\������� ����\DSL\DSL-fitness-food\DSL\grammar\FitnessNutrition.g4 by ANTLR 4.9.3
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
			T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31,
			KEYWORD=32, TIME_RANGE=33, IDENTIFIER=34, STRING=35, NUMBER=36, TIME=37,
			BOOLEAN=38, COMMENT=39, WS=40;
	public static final int
			RULE_program = 0, RULE_statement = 1, RULE_exercisesStmt = 2, RULE_exerciseEntry = 3,
			RULE_exerciseParams = 4, RULE_createStmt = 5, RULE_attributeList = 6,
			RULE_attribute = 7, RULE_generateStmt = 8, RULE_parameterList = 9, RULE_paramList = 10,
			RULE_param = 11, RULE_value = 12, RULE_selectStmt = 13, RULE_condition = 14,
			RULE_operator = 15, RULE_loopStmt = 16, RULE_whileStmt = 17, RULE_forStmt = 18,
			RULE_foreachStmt = 19, RULE_includeStmt = 20, RULE_iterable = 21, RULE_outputStmt = 22,
			RULE_usingStmt = 23, RULE_block = 24, RULE_expression = 25, RULE_mathExpr = 26,
			RULE_reference = 27, RULE_array = 28, RULE_timeRange = 29, RULE_object = 30,
			RULE_identifier = 31, RULE_literal = 32;
	private static String[] makeRuleNames() {
		return new String[] {
				"program", "statement", "exercisesStmt", "exerciseEntry", "exerciseParams",
				"createStmt", "attributeList", "attribute", "generateStmt", "parameterList",
				"paramList", "param", "value", "selectStmt", "condition", "operator",
				"loopStmt", "whileStmt", "forStmt", "foreachStmt", "includeStmt", "iterable",
				"outputStmt", "usingStmt", "block", "expression", "mathExpr", "reference",
				"array", "timeRange", "object", "identifier", "literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
				null, "'Exercises'", "'='", "'{'", "'}'", "'Weight'", "','", "'Sets'",
				"'Reps'", "'create'", "'('", "')'", "'generate'", "'select'", "'where'",
				"'!='", "'done'", "'>'", "'<'", "'while'", "'for'", "'in'", "'foreach'",
				"'include'", "'into'", "'output'", "'as'", "'table'", "'using'", "'.'",
				"'*'", "'to'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
				null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, "KEYWORD", "TIME_RANGE",
				"IDENTIFIER", "STRING", "NUMBER", "TIME", "BOOLEAN", "COMMENT", "WS"
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
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__18) | (1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << T__27))) != 0)) {
					{
						{
							setState(66);
							statement();
						}
					}
					setState(71);
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
		public ExercisesStmtContext exercisesStmt() {
			return getRuleContext(ExercisesStmtContext.class,0);
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
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case T__8:
					enterOuterAlt(_localctx, 1);
				{
					setState(72);
					createStmt();
				}
				break;
				case T__11:
					enterOuterAlt(_localctx, 2);
				{
					setState(73);
					generateStmt();
				}
				break;
				case T__12:
					enterOuterAlt(_localctx, 3);
				{
					setState(74);
					selectStmt();
				}
				break;
				case T__27:
					enterOuterAlt(_localctx, 4);
				{
					setState(75);
					usingStmt();
				}
				break;
				case T__24:
					enterOuterAlt(_localctx, 5);
				{
					setState(76);
					outputStmt();
				}
				break;
				case T__18:
				case T__19:
				case T__21:
					enterOuterAlt(_localctx, 6);
				{
					setState(77);
					loopStmt();
				}
				break;
				case T__22:
					enterOuterAlt(_localctx, 7);
				{
					setState(78);
					includeStmt();
				}
				break;
				case T__0:
					enterOuterAlt(_localctx, 8);
				{
					setState(79);
					exercisesStmt();
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

	public static class ExercisesStmtContext extends ParserRuleContext {
		public List<ExerciseEntryContext> exerciseEntry() {
			return getRuleContexts(ExerciseEntryContext.class);
		}
		public ExerciseEntryContext exerciseEntry(int i) {
			return getRuleContext(ExerciseEntryContext.class,i);
		}
		public ExercisesStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exercisesStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterExercisesStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitExercisesStmt(this);
		}
	}

	public final ExercisesStmtContext exercisesStmt() throws RecognitionException {
		ExercisesStmtContext _localctx = new ExercisesStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_exercisesStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(82);
				match(T__0);
				setState(83);
				match(T__1);
				setState(84);
				match(T__2);
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
						{
							setState(85);
							exerciseEntry();
						}
					}
					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==IDENTIFIER );
				setState(90);
				match(T__3);
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

	public static class ExerciseEntryContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FitnessNutritionParser.IDENTIFIER, 0); }
		public ExerciseParamsContext exerciseParams() {
			return getRuleContext(ExerciseParamsContext.class,0);
		}
		public ExerciseEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exerciseEntry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterExerciseEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitExerciseEntry(this);
		}
	}

	public final ExerciseEntryContext exerciseEntry() throws RecognitionException {
		ExerciseEntryContext _localctx = new ExerciseEntryContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_exerciseEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(92);
				match(IDENTIFIER);
				setState(93);
				match(T__2);
				setState(94);
				exerciseParams();
				setState(95);
				match(T__3);
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

	public static class ExerciseParamsContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(FitnessNutritionParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(FitnessNutritionParser.NUMBER, i);
		}
		public ExerciseParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exerciseParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterExerciseParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitExerciseParams(this);
		}
	}

	public final ExerciseParamsContext exerciseParams() throws RecognitionException {
		ExerciseParamsContext _localctx = new ExerciseParamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_exerciseParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
						setState(97);
						match(T__4);
						setState(98);
						match(T__1);
						setState(99);
						match(NUMBER);
					}
				}

				setState(106);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
					{
						setState(102);
						match(T__5);
						setState(103);
						match(T__6);
						setState(104);
						match(T__1);
						setState(105);
						match(NUMBER);
					}
					break;
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
						setState(108);
						match(T__5);
						setState(109);
						match(T__7);
						setState(110);
						match(T__1);
						setState(111);
						match(NUMBER);
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
	}

	public final CreateStmtContext createStmt() throws RecognitionException {
		CreateStmtContext _localctx = new CreateStmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_createStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(114);
				match(T__8);
				setState(115);
				identifier();
				setState(116);
				identifier();
				setState(117);
				match(T__2);
				setState(118);
				attributeList();
				setState(119);
				match(T__3);
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
	}

	public final AttributeListContext attributeList() throws RecognitionException {
		AttributeListContext _localctx = new AttributeListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_attributeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==KEYWORD || _la==IDENTIFIER) {
					{
						{
							setState(121);
							attribute();
						}
					}
					setState(126);
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
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_attribute);
		try {
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(127);
					identifier();
					{
						setState(128);
						match(T__9);
						setState(129);
						value();
						setState(130);
						match(T__10);
					}
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(132);
					identifier();
					setState(133);
					match(T__2);
					setState(134);
					attributeList();
					setState(135);
					match(T__3);
				}
				break;
				case 3:
					enterOuterAlt(_localctx, 3);
				{
					setState(137);
					identifier();
					setState(138);
					match(T__9);
					setState(139);
					expression();
					setState(140);
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
	}

	public final GenerateStmtContext generateStmt() throws RecognitionException {
		GenerateStmtContext _localctx = new GenerateStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_generateStmt);
		int _la;
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(144);
					match(T__11);
					setState(145);
					identifier();
					setState(146);
					match(T__2);
					setState(147);
					paramList();
					setState(148);
					match(T__3);
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(150);
					match(T__11);
					setState(151);
					identifier();
					setState(156);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__9) {
						{
							setState(152);
							match(T__9);
							setState(153);
							paramList();
							setState(154);
							match(T__10);
						}
					}

				}
				break;
				case 3:
					enterOuterAlt(_localctx, 3);
				{
					setState(158);
					match(T__11);
					setState(159);
					reference();
					setState(160);
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
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
						{
							setState(164);
							identifier();
						}
					}
					setState(167);
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
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(169);
				param();
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
						{
							setState(170);
							match(T__5);
							setState(171);
							param();
						}
					}
					setState(176);
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
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_param);
		int _la;
		try {
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(177);
					identifier();
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__9) {
						{
							setState(178);
							match(T__9);
							setState(179);
							value();
							setState(184);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__5) {
								{
									{
										setState(180);
										match(T__5);
										setState(181);
										value();
									}
								}
								setState(186);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							setState(187);
							match(T__10);
						}
					}

				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(191);
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
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_value);
		try {
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(194);
					literal();
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(195);
					reference();
				}
				break;
				case 3:
					enterOuterAlt(_localctx, 3);
				{
					setState(196);
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
	}

	public final SelectStmtContext selectStmt() throws RecognitionException {
		SelectStmtContext _localctx = new SelectStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_selectStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(199);
				match(T__12);
				setState(200);
				identifier();
				setState(201);
				match(T__13);
				setState(202);
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
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_condition);
		try {
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(204);
					reference();
					setState(205);
					operator();
					setState(206);
					value();
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(208);
					identifier();
					setState(209);
					operator();
					setState(210);
					value();
				}
				break;
				case 3:
					enterOuterAlt(_localctx, 3);
				{
					setState(212);
					reference();
					setState(213);
					match(T__14);
					setState(214);
					match(T__15);
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
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(218);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__16) | (1L << T__17))) != 0)) ) {
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
	}

	public final LoopStmtContext loopStmt() throws RecognitionException {
		LoopStmtContext _localctx = new LoopStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_loopStmt);
		try {
			setState(223);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case T__18:
					enterOuterAlt(_localctx, 1);
				{
					setState(220);
					whileStmt();
				}
				break;
				case T__19:
					enterOuterAlt(_localctx, 2);
				{
					setState(221);
					forStmt();
				}
				break;
				case T__21:
					enterOuterAlt(_localctx, 3);
				{
					setState(222);
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
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(225);
				match(T__18);
				setState(226);
				match(T__9);
				setState(227);
				condition();
				setState(228);
				match(T__10);
				setState(229);
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
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_forStmt);
		try {
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(231);
					match(T__19);
					setState(232);
					match(T__9);
					setState(233);
					identifier();
					setState(234);
					match(T__10);
					setState(235);
					block();
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(237);
					match(T__19);
					setState(238);
					identifier();
					setState(239);
					match(T__20);
					setState(240);
					iterable();
					setState(241);
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
	}

	public final ForeachStmtContext foreachStmt() throws RecognitionException {
		ForeachStmtContext _localctx = new ForeachStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_foreachStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(245);
				match(T__21);
				setState(246);
				reference();
				setState(247);
				match(T__2);
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__18) | (1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << T__27))) != 0)) {
					{
						{
							setState(248);
							statement();
						}
					}
					setState(253);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(254);
				match(T__3);
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
	}

	public final IncludeStmtContext includeStmt() throws RecognitionException {
		IncludeStmtContext _localctx = new IncludeStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_includeStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(256);
				match(T__22);
				setState(257);
				identifier();
				setState(258);
				match(T__23);
				setState(259);
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
	}

	public final IterableContext iterable() throws RecognitionException {
		IterableContext _localctx = new IterableContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_iterable);
		try {
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(261);
					identifier();
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(262);
					array();
				}
				break;
				case 3:
					enterOuterAlt(_localctx, 3);
				{
					setState(263);
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
	}

	public final OutputStmtContext outputStmt() throws RecognitionException {
		OutputStmtContext _localctx = new OutputStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_outputStmt);
		int _la;
		try {
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(266);
					match(T__24);
					setState(267);
					expression();
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__25) {
						{
							setState(268);
							match(T__25);
							setState(269);
							identifier();
							setState(270);
							match(T__26);
						}
					}

				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(274);
					match(T__24);
					setState(275);
					expression();
					setState(282);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__20) {
						{
							setState(276);
							match(T__20);
							setState(277);
							match(T__26);
							setState(278);
							match(T__9);
							setState(279);
							identifier();
							setState(280);
							match(T__10);
						}
					}

				}
				break;
				case 3:
					enterOuterAlt(_localctx, 3);
				{
					setState(284);
					match(T__24);
					setState(285);
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
	}

	public final UsingStmtContext usingStmt() throws RecognitionException {
		UsingStmtContext _localctx = new UsingStmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_usingStmt);
		try {
			setState(297);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(288);
					match(T__27);
					setState(289);
					reference();
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(290);
					match(T__27);
					setState(291);
					identifier();
					setState(292);
					match(T__28);
					setState(293);
					identifier();
					setState(294);
					match(T__1);
					setState(295);
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
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(299);
				match(T__2);
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__18) | (1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << T__27))) != 0)) {
					{
						{
							setState(300);
							statement();
						}
					}
					setState(305);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(306);
				match(T__3);
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
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_expression);
		try {
			setState(311);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(308);
					mathExpr();
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(309);
					reference();
				}
				break;
				case 3:
					enterOuterAlt(_localctx, 3);
				{
					setState(310);
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
	}

	public final MathExprContext mathExpr() throws RecognitionException {
		MathExprContext _localctx = new MathExprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_mathExpr);
		try {
			setState(324);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(313);
					match(NUMBER);
					setState(314);
					operator();
					setState(315);
					match(NUMBER);
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(317);
					match(NUMBER);
					setState(318);
					match(T__29);
					setState(319);
					reference();
				}
				break;
				case 3:
					enterOuterAlt(_localctx, 3);
				{
					setState(320);
					reference();
					setState(321);
					match(T__29);
					setState(322);
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
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_reference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(326);
				identifier();
				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__28) {
					{
						{
							setState(327);
							match(T__28);
							setState(328);
							identifier();
						}
					}
					setState(333);
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
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_array);
		int _la;
		try {
			setState(357);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case T__2:
					enterOuterAlt(_localctx, 1);
				{
					setState(334);
					match(T__2);
					setState(343);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEYWORD) | (1L << IDENTIFIER) | (1L << STRING) | (1L << NUMBER) | (1L << TIME) | (1L << BOOLEAN))) != 0)) {
						{
							setState(335);
							value();
							setState(340);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__5) {
								{
									{
										setState(336);
										match(T__5);
										setState(337);
										value();
									}
								}
								setState(342);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
						}
					}

					setState(345);
					match(T__3);
				}
				break;
				case T__9:
					enterOuterAlt(_localctx, 2);
				{
					setState(346);
					match(T__9);
					setState(347);
					timeRange();
					setState(352);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__5) {
						{
							{
								setState(348);
								match(T__5);
								setState(349);
								timeRange();
							}
						}
						setState(354);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(355);
					match(T__10);
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
		public TerminalNode TIME_RANGE() { return getToken(FitnessNutritionParser.TIME_RANGE, 0); }
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
	}

	public final TimeRangeContext timeRange() throws RecognitionException {
		TimeRangeContext _localctx = new TimeRangeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_timeRange);
		try {
			setState(363);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case TIME_RANGE:
					enterOuterAlt(_localctx, 1);
				{
					setState(359);
					match(TIME_RANGE);
				}
				break;
				case TIME:
					enterOuterAlt(_localctx, 2);
				{
					setState(360);
					match(TIME);
					setState(361);
					match(T__30);
					setState(362);
					match(TIME);
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
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_object);
		try {
			setState(373);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case T__9:
					enterOuterAlt(_localctx, 1);
				{
					setState(365);
					match(T__9);
					setState(366);
					value();
					setState(367);
					match(T__10);
				}
				break;
				case T__2:
					enterOuterAlt(_localctx, 2);
				{
					setState(369);
					match(T__2);
					setState(370);
					attributeList();
					setState(371);
					match(T__3);
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
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(375);
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
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(377);
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
			"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u017e\4\2\t\2\4"+
					"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
					"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
					"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
					"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
					"\t!\4\"\t\"\3\2\7\2F\n\2\f\2\16\2I\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
					"\3\5\3S\n\3\3\4\3\4\3\4\3\4\6\4Y\n\4\r\4\16\4Z\3\4\3\4\3\5\3\5\3\5\3\5"+
					"\3\5\3\6\3\6\3\6\5\6g\n\6\3\6\3\6\3\6\3\6\5\6m\n\6\3\6\3\6\3\6\3\6\5\6"+
					"s\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\7\b}\n\b\f\b\16\b\u0080\13\b\3\t"+
					"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0091\n\t"+
					"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u009f\n\n\3\n\3\n"+
					"\3\n\3\n\5\n\u00a5\n\n\3\13\6\13\u00a8\n\13\r\13\16\13\u00a9\3\f\3\f\3"+
					"\f\7\f\u00af\n\f\f\f\16\f\u00b2\13\f\3\r\3\r\3\r\3\r\3\r\7\r\u00b9\n\r"+
					"\f\r\16\r\u00bc\13\r\3\r\3\r\5\r\u00c0\n\r\3\r\5\r\u00c3\n\r\3\16\3\16"+
					"\3\16\5\16\u00c8\n\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
					"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00db\n\20\3\21\3\21\3\22\3\22"+
					"\3\22\5\22\u00e2\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
					"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00f6\n\24\3\25\3\25\3\25"+
					"\3\25\7\25\u00fc\n\25\f\25\16\25\u00ff\13\25\3\25\3\25\3\26\3\26\3\26"+
					"\3\26\3\26\3\27\3\27\3\27\5\27\u010b\n\27\3\30\3\30\3\30\3\30\3\30\3\30"+
					"\5\30\u0113\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u011d\n"+
					"\30\3\30\3\30\5\30\u0121\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
					"\3\31\5\31\u012c\n\31\3\32\3\32\7\32\u0130\n\32\f\32\16\32\u0133\13\32"+
					"\3\32\3\32\3\33\3\33\3\33\5\33\u013a\n\33\3\34\3\34\3\34\3\34\3\34\3\34"+
					"\3\34\3\34\3\34\3\34\3\34\5\34\u0147\n\34\3\35\3\35\3\35\7\35\u014c\n"+
					"\35\f\35\16\35\u014f\13\35\3\36\3\36\3\36\3\36\7\36\u0155\n\36\f\36\16"+
					"\36\u0158\13\36\5\36\u015a\n\36\3\36\3\36\3\36\3\36\3\36\7\36\u0161\n"+
					"\36\f\36\16\36\u0164\13\36\3\36\3\36\5\36\u0168\n\36\3\37\3\37\3\37\3"+
					"\37\5\37\u016e\n\37\3 \3 \3 \3 \3 \3 \3 \3 \5 \u0178\n \3!\3!\3\"\3\""+
					"\3\"\2\2#\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
					"8:<>@B\2\5\4\2\4\4\23\24\4\2\"\"$$\3\2%(\2\u018e\2G\3\2\2\2\4R\3\2\2\2"+
					"\6T\3\2\2\2\b^\3\2\2\2\nf\3\2\2\2\ft\3\2\2\2\16~\3\2\2\2\20\u0090\3\2"+
					"\2\2\22\u00a4\3\2\2\2\24\u00a7\3\2\2\2\26\u00ab\3\2\2\2\30\u00c2\3\2\2"+
					"\2\32\u00c7\3\2\2\2\34\u00c9\3\2\2\2\36\u00da\3\2\2\2 \u00dc\3\2\2\2\""+
					"\u00e1\3\2\2\2$\u00e3\3\2\2\2&\u00f5\3\2\2\2(\u00f7\3\2\2\2*\u0102\3\2"+
					"\2\2,\u010a\3\2\2\2.\u0120\3\2\2\2\60\u012b\3\2\2\2\62\u012d\3\2\2\2\64"+
					"\u0139\3\2\2\2\66\u0146\3\2\2\28\u0148\3\2\2\2:\u0167\3\2\2\2<\u016d\3"+
					"\2\2\2>\u0177\3\2\2\2@\u0179\3\2\2\2B\u017b\3\2\2\2DF\5\4\3\2ED\3\2\2"+
					"\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\3\3\2\2\2IG\3\2\2\2JS\5\f\7\2KS\5\22"+
					"\n\2LS\5\34\17\2MS\5\60\31\2NS\5.\30\2OS\5\"\22\2PS\5*\26\2QS\5\6\4\2"+
					"RJ\3\2\2\2RK\3\2\2\2RL\3\2\2\2RM\3\2\2\2RN\3\2\2\2RO\3\2\2\2RP\3\2\2\2"+
					"RQ\3\2\2\2S\5\3\2\2\2TU\7\3\2\2UV\7\4\2\2VX\7\5\2\2WY\5\b\5\2XW\3\2\2"+
					"\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7\6\2\2]\7\3\2\2\2^_\7"+
					"$\2\2_`\7\5\2\2`a\5\n\6\2ab\7\6\2\2b\t\3\2\2\2cd\7\7\2\2de\7\4\2\2eg\7"+
					"&\2\2fc\3\2\2\2fg\3\2\2\2gl\3\2\2\2hi\7\b\2\2ij\7\t\2\2jk\7\4\2\2km\7"+
					"&\2\2lh\3\2\2\2lm\3\2\2\2mr\3\2\2\2no\7\b\2\2op\7\n\2\2pq\7\4\2\2qs\7"+
					"&\2\2rn\3\2\2\2rs\3\2\2\2s\13\3\2\2\2tu\7\13\2\2uv\5@!\2vw\5@!\2wx\7\5"+
					"\2\2xy\5\16\b\2yz\7\6\2\2z\r\3\2\2\2{}\5\20\t\2|{\3\2\2\2}\u0080\3\2\2"+
					"\2~|\3\2\2\2~\177\3\2\2\2\177\17\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\5"+
					"@!\2\u0082\u0083\7\f\2\2\u0083\u0084\5\32\16\2\u0084\u0085\7\r\2\2\u0085"+
					"\u0091\3\2\2\2\u0086\u0087\5@!\2\u0087\u0088\7\5\2\2\u0088\u0089\5\16"+
					"\b\2\u0089\u008a\7\6\2\2\u008a\u0091\3\2\2\2\u008b\u008c\5@!\2\u008c\u008d"+
					"\7\f\2\2\u008d\u008e\5\64\33\2\u008e\u008f\7\r\2\2\u008f\u0091\3\2\2\2"+
					"\u0090\u0081\3\2\2\2\u0090\u0086\3\2\2\2\u0090\u008b\3\2\2\2\u0091\21"+
					"\3\2\2\2\u0092\u0093\7\16\2\2\u0093\u0094\5@!\2\u0094\u0095\7\5\2\2\u0095"+
					"\u0096\5\26\f\2\u0096\u0097\7\6\2\2\u0097\u00a5\3\2\2\2\u0098\u0099\7"+
					"\16\2\2\u0099\u009e\5@!\2\u009a\u009b\7\f\2\2\u009b\u009c\5\26\f\2\u009c"+
					"\u009d\7\r\2\2\u009d\u009f\3\2\2\2\u009e\u009a\3\2\2\2\u009e\u009f\3\2"+
					"\2\2\u009f\u00a5\3\2\2\2\u00a0\u00a1\7\16\2\2\u00a1\u00a2\58\35\2\u00a2"+
					"\u00a3\5\24\13\2\u00a3\u00a5\3\2\2\2\u00a4\u0092\3\2\2\2\u00a4\u0098\3"+
					"\2\2\2\u00a4\u00a0\3\2\2\2\u00a5\23\3\2\2\2\u00a6\u00a8\5@!\2\u00a7\u00a6"+
					"\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
					"\25\3\2\2\2\u00ab\u00b0\5\30\r\2\u00ac\u00ad\7\b\2\2\u00ad\u00af\5\30"+
					"\r\2\u00ae\u00ac\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0"+
					"\u00b1\3\2\2\2\u00b1\27\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00bf\5@!\2"+
					"\u00b4\u00b5\7\f\2\2\u00b5\u00ba\5\32\16\2\u00b6\u00b7\7\b\2\2\u00b7\u00b9"+
					"\5\32\16\2\u00b8\u00b6\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2"+
					"\u00ba\u00bb\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be"+
					"\7\r\2\2\u00be\u00c0\3\2\2\2\u00bf\u00b4\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
					"\u00c3\3\2\2\2\u00c1\u00c3\5@!\2\u00c2\u00b3\3\2\2\2\u00c2\u00c1\3\2\2"+
					"\2\u00c3\31\3\2\2\2\u00c4\u00c8\5B\"\2\u00c5\u00c8\58\35\2\u00c6\u00c8"+
					"\5@!\2\u00c7\u00c4\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8"+
					"\33\3\2\2\2\u00c9\u00ca\7\17\2\2\u00ca\u00cb\5@!\2\u00cb\u00cc\7\20\2"+
					"\2\u00cc\u00cd\5\36\20\2\u00cd\35\3\2\2\2\u00ce\u00cf\58\35\2\u00cf\u00d0"+
					"\5 \21\2\u00d0\u00d1\5\32\16\2\u00d1\u00db\3\2\2\2\u00d2\u00d3\5@!\2\u00d3"+
					"\u00d4\5 \21\2\u00d4\u00d5\5\32\16\2\u00d5\u00db\3\2\2\2\u00d6\u00d7\5"+
					"8\35\2\u00d7\u00d8\7\21\2\2\u00d8\u00d9\7\22\2\2\u00d9\u00db\3\2\2\2\u00da"+
					"\u00ce\3\2\2\2\u00da\u00d2\3\2\2\2\u00da\u00d6\3\2\2\2\u00db\37\3\2\2"+
					"\2\u00dc\u00dd\t\2\2\2\u00dd!\3\2\2\2\u00de\u00e2\5$\23\2\u00df\u00e2"+
					"\5&\24\2\u00e0\u00e2\5(\25\2\u00e1\u00de\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1"+
					"\u00e0\3\2\2\2\u00e2#\3\2\2\2\u00e3\u00e4\7\25\2\2\u00e4\u00e5\7\f\2\2"+
					"\u00e5\u00e6\5\36\20\2\u00e6\u00e7\7\r\2\2\u00e7\u00e8\5\62\32\2\u00e8"+
					"%\3\2\2\2\u00e9\u00ea\7\26\2\2\u00ea\u00eb\7\f\2\2\u00eb\u00ec\5@!\2\u00ec"+
					"\u00ed\7\r\2\2\u00ed\u00ee\5\62\32\2\u00ee\u00f6\3\2\2\2\u00ef\u00f0\7"+
					"\26\2\2\u00f0\u00f1\5@!\2\u00f1\u00f2\7\27\2\2\u00f2\u00f3\5,\27\2\u00f3"+
					"\u00f4\5\62\32\2\u00f4\u00f6\3\2\2\2\u00f5\u00e9\3\2\2\2\u00f5\u00ef\3"+
					"\2\2\2\u00f6\'\3\2\2\2\u00f7\u00f8\7\30\2\2\u00f8\u00f9\58\35\2\u00f9"+
					"\u00fd\7\5\2\2\u00fa\u00fc\5\4\3\2\u00fb\u00fa\3\2\2\2\u00fc\u00ff\3\2"+
					"\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff"+
					"\u00fd\3\2\2\2\u0100\u0101\7\6\2\2\u0101)\3\2\2\2\u0102\u0103\7\31\2\2"+
					"\u0103\u0104\5@!\2\u0104\u0105\7\32\2\2\u0105\u0106\5@!\2\u0106+\3\2\2"+
					"\2\u0107\u010b\5@!\2\u0108\u010b\5:\36\2\u0109\u010b\58\35\2\u010a\u0107"+
					"\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u0109\3\2\2\2\u010b-\3\2\2\2\u010c"+
					"\u010d\7\33\2\2\u010d\u0112\5\64\33\2\u010e\u010f\7\34\2\2\u010f\u0110"+
					"\5@!\2\u0110\u0111\7\35\2\2\u0111\u0113\3\2\2\2\u0112\u010e\3\2\2\2\u0112"+
					"\u0113\3\2\2\2\u0113\u0121\3\2\2\2\u0114\u0115\7\33\2\2\u0115\u011c\5"+
					"\64\33\2\u0116\u0117\7\27\2\2\u0117\u0118\7\35\2\2\u0118\u0119\7\f\2\2"+
					"\u0119\u011a\5@!\2\u011a\u011b\7\r\2\2\u011b\u011d\3\2\2\2\u011c\u0116"+
					"\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u0121\3\2\2\2\u011e\u011f\7\33\2\2"+
					"\u011f\u0121\58\35\2\u0120\u010c\3\2\2\2\u0120\u0114\3\2\2\2\u0120\u011e"+
					"\3\2\2\2\u0121/\3\2\2\2\u0122\u0123\7\36\2\2\u0123\u012c\58\35\2\u0124"+
					"\u0125\7\36\2\2\u0125\u0126\5@!\2\u0126\u0127\7\37\2\2\u0127\u0128\5@"+
					"!\2\u0128\u0129\7\4\2\2\u0129\u012a\5B\"\2\u012a\u012c\3\2\2\2\u012b\u0122"+
					"\3\2\2\2\u012b\u0124\3\2\2\2\u012c\61\3\2\2\2\u012d\u0131\7\5\2\2\u012e"+
					"\u0130\5\4\3\2\u012f\u012e\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2"+
					"\2\2\u0131\u0132\3\2\2\2\u0132\u0134\3\2\2\2\u0133\u0131\3\2\2\2\u0134"+
					"\u0135\7\6\2\2\u0135\63\3\2\2\2\u0136\u013a\5\66\34\2\u0137\u013a\58\35"+
					"\2\u0138\u013a\5B\"\2\u0139\u0136\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u0138"+
					"\3\2\2\2\u013a\65\3\2\2\2\u013b\u013c\7&\2\2\u013c\u013d\5 \21\2\u013d"+
					"\u013e\7&\2\2\u013e\u0147\3\2\2\2\u013f\u0140\7&\2\2\u0140\u0141\7 \2"+
					"\2\u0141\u0147\58\35\2\u0142\u0143\58\35\2\u0143\u0144\7 \2\2\u0144\u0145"+
					"\7&\2\2\u0145\u0147\3\2\2\2\u0146\u013b\3\2\2\2\u0146\u013f\3\2\2\2\u0146"+
					"\u0142\3\2\2\2\u0147\67\3\2\2\2\u0148\u014d\5@!\2\u0149\u014a\7\37\2\2"+
					"\u014a\u014c\5@!\2\u014b\u0149\3\2\2\2\u014c\u014f\3\2\2\2\u014d\u014b"+
					"\3\2\2\2\u014d\u014e\3\2\2\2\u014e9\3\2\2\2\u014f\u014d\3\2\2\2\u0150"+
					"\u0159\7\5\2\2\u0151\u0156\5\32\16\2\u0152\u0153\7\b\2\2\u0153\u0155\5"+
					"\32\16\2\u0154\u0152\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0156"+
					"\u0157\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0159\u0151\3\2"+
					"\2\2\u0159\u015a\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u0168\7\6\2\2\u015c"+
					"\u015d\7\f\2\2\u015d\u0162\5<\37\2\u015e\u015f\7\b\2\2\u015f\u0161\5<"+
					"\37\2\u0160\u015e\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162"+
					"\u0163\3\2\2\2\u0163\u0165\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0166\7\r"+
					"\2\2\u0166\u0168\3\2\2\2\u0167\u0150\3\2\2\2\u0167\u015c\3\2\2\2\u0168"+
					";\3\2\2\2\u0169\u016e\7#\2\2\u016a\u016b\7\'\2\2\u016b\u016c\7!\2\2\u016c"+
					"\u016e\7\'\2\2\u016d\u0169\3\2\2\2\u016d\u016a\3\2\2\2\u016e=\3\2\2\2"+
					"\u016f\u0170\7\f\2\2\u0170\u0171\5\32\16\2\u0171\u0172\7\r\2\2\u0172\u0178"+
					"\3\2\2\2\u0173\u0174\7\5\2\2\u0174\u0175\5\16\b\2\u0175\u0176\7\6\2\2"+
					"\u0176\u0178\3\2\2\2\u0177\u016f\3\2\2\2\u0177\u0173\3\2\2\2\u0178?\3"+
					"\2\2\2\u0179\u017a\t\3\2\2\u017aA\3\2\2\2\u017b\u017c\t\4\2\2\u017cC\3"+
					"\2\2\2%GRZflr~\u0090\u009e\u00a4\u00a9\u00b0\u00ba\u00bf\u00c2\u00c7\u00da"+
					"\u00e1\u00f5\u00fd\u010a\u0112\u011c\u0120\u012b\u0131\u0139\u0146\u014d"+
					"\u0156\u0159\u0162\u0167\u016d\u0177";
	public static final ATN _ATN =
			new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}