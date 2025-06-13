// Generated from D:\u005Cuni\a\backend-dsl\src\main\java\com\example\dsl_backend\DSL\FitnessNutrition.g4 by ANTLR 4.9.3
package com.example.dsl_backend.DSL;
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
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, KEYWORD=51, TIME_RANGE=52, 
		IDENTIFIER=53, STRING=54, NUMBER=55, TIME=56, BOOLEAN=57, COMMENT=58, 
		WS=59;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_exercisesStmt = 2, RULE_exerciseEntry = 3, 
		RULE_exerciseParams = 4, RULE_createStmt = 5, RULE_attributeList = 6, 
		RULE_attribute = 7, RULE_generateStmt = 8, RULE_parameterList = 9, RULE_paramList = 10, 
		RULE_param = 11, RULE_value = 12, RULE_selectStmt = 13, RULE_condition = 14, 
		RULE_operator = 15, RULE_loopStmt = 16, RULE_whileStmt = 17, RULE_forStmt = 18, 
		RULE_foreachStmt = 19, RULE_includeStmt = 20, RULE_iterable = 21, RULE_outputStmt = 22, 
		RULE_usingStmt = 23, RULE_block = 24, RULE_expression = 25, RULE_mathExpr = 26, 
		RULE_reference = 27, RULE_array = 28, RULE_timeRange = 29, RULE_object = 30, 
		RULE_identifier = 31, RULE_literal = 32, RULE_findOptimalTimesStmt = 33, 
		RULE_userSpec = 34, RULE_userPropertyList = 35, RULE_userProperty = 36, 
		RULE_timeRangeArray = 37, RULE_timeRangePair = 38, RULE_exerciseArray = 39, 
		RULE_exerciseObject = 40, RULE_exercisePropertyList = 41, RULE_exerciseProperty = 42, 
		RULE_createWeeklyTrainingScheduleStmt = 43, RULE_createDailyMealPlanStmt = 44, 
		RULE_stringArray = 45;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "exercisesStmt", "exerciseEntry", "exerciseParams", 
			"createStmt", "attributeList", "attribute", "generateStmt", "parameterList", 
			"paramList", "param", "value", "selectStmt", "condition", "operator", 
			"loopStmt", "whileStmt", "forStmt", "foreachStmt", "includeStmt", "iterable", 
			"outputStmt", "usingStmt", "block", "expression", "mathExpr", "reference", 
			"array", "timeRange", "object", "identifier", "literal", "findOptimalTimesStmt", 
			"userSpec", "userPropertyList", "userProperty", "timeRangeArray", "timeRangePair", 
			"exerciseArray", "exerciseObject", "exercisePropertyList", "exerciseProperty", 
			"createWeeklyTrainingScheduleStmt", "createDailyMealPlanStmt", "stringArray"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Exercises'", "'='", "'{'", "'}'", "'Weight'", "','", "'Sets'", 
			"'Reps'", "'create'", "'('", "')'", "'generate'", "'select'", "'where'", 
			"'!='", "'done'", "'>'", "'<'", "'while'", "'for'", "'in'", "'foreach'", 
			"'include'", "'into'", "'output'", "'as'", "'table'", "'using'", "'.'", 
			"'*'", "'to'", "'find_optimal_times'", "'user'", "'id'", "':'", "'name'", 
			"'weight'", "'height'", "'age'", "'goal'", "'diet'", "'allergies'", "'['", 
			"']'", "'busyTime'", "'exercises'", "'sets'", "'reps'", "'create_weekly_training_schedule'", 
			"'create_daily_meal_plan'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "KEYWORD", "TIME_RANGE", "IDENTIFIER", "STRING", "NUMBER", 
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
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__18) | (1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << T__27) | (1L << T__31) | (1L << T__48) | (1L << T__49))) != 0)) {
				{
				{
				setState(92);
				statement();
				}
				}
				setState(97);
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
		public FindOptimalTimesStmtContext findOptimalTimesStmt() {
			return getRuleContext(FindOptimalTimesStmtContext.class,0);
		}
		public CreateWeeklyTrainingScheduleStmtContext createWeeklyTrainingScheduleStmt() {
			return getRuleContext(CreateWeeklyTrainingScheduleStmtContext.class,0);
		}
		public CreateDailyMealPlanStmtContext createDailyMealPlanStmt() {
			return getRuleContext(CreateDailyMealPlanStmtContext.class,0);
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
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				createStmt();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				generateStmt();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				selectStmt();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				usingStmt();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 5);
				{
				setState(102);
				outputStmt();
				}
				break;
			case T__18:
			case T__19:
			case T__21:
				enterOuterAlt(_localctx, 6);
				{
				setState(103);
				loopStmt();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 7);
				{
				setState(104);
				includeStmt();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 8);
				{
				setState(105);
				exercisesStmt();
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 9);
				{
				setState(106);
				findOptimalTimesStmt();
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 10);
				{
				setState(107);
				createWeeklyTrainingScheduleStmt();
				}
				break;
			case T__49:
				enterOuterAlt(_localctx, 11);
				{
				setState(108);
				createDailyMealPlanStmt();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitExercisesStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExercisesStmtContext exercisesStmt() throws RecognitionException {
		ExercisesStmtContext _localctx = new ExercisesStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_exercisesStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__0);
			setState(112);
			match(T__1);
			setState(113);
			match(T__2);
			setState(115); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(114);
				exerciseEntry();
				}
				}
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitExerciseEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExerciseEntryContext exerciseEntry() throws RecognitionException {
		ExerciseEntryContext _localctx = new ExerciseEntryContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_exerciseEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(IDENTIFIER);
			setState(122);
			match(T__2);
			setState(123);
			exerciseParams();
			setState(124);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitExerciseParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExerciseParamsContext exerciseParams() throws RecognitionException {
		ExerciseParamsContext _localctx = new ExerciseParamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_exerciseParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(126);
				match(T__4);
				setState(127);
				match(T__1);
				setState(128);
				match(NUMBER);
				}
			}

			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(131);
				match(T__5);
				setState(132);
				match(T__6);
				setState(133);
				match(T__1);
				setState(134);
				match(NUMBER);
				}
				break;
			}
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(137);
				match(T__5);
				setState(138);
				match(T__7);
				setState(139);
				match(T__1);
				setState(140);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitCreateStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateStmtContext createStmt() throws RecognitionException {
		CreateStmtContext _localctx = new CreateStmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_createStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(T__8);
			setState(144);
			identifier();
			setState(145);
			identifier();
			setState(146);
			match(T__2);
			setState(147);
			attributeList();
			setState(148);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitAttributeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeListContext attributeList() throws RecognitionException {
		AttributeListContext _localctx = new AttributeListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_attributeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KEYWORD || _la==IDENTIFIER) {
				{
				{
				setState(150);
				attribute();
				}
				}
				setState(155);
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
		enterRule(_localctx, 14, RULE_attribute);
		try {
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				identifier();
				{
				setState(157);
				match(T__9);
				setState(158);
				value();
				setState(159);
				match(T__10);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				identifier();
				setState(162);
				match(T__2);
				setState(163);
				attributeList();
				setState(164);
				match(T__3);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(166);
				identifier();
				setState(167);
				match(T__9);
				setState(168);
				expression();
				setState(169);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitGenerateStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenerateStmtContext generateStmt() throws RecognitionException {
		GenerateStmtContext _localctx = new GenerateStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_generateStmt);
		int _la;
		try {
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				match(T__11);
				setState(174);
				identifier();
				setState(175);
				match(T__2);
				setState(176);
				paramList();
				setState(177);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(T__11);
				setState(180);
				identifier();
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(181);
					match(T__9);
					setState(182);
					paramList();
					setState(183);
					match(T__10);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(187);
				match(T__11);
				setState(188);
				reference();
				setState(189);
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
		enterRule(_localctx, 18, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(193);
				identifier();
				}
				}
				setState(196); 
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
		enterRule(_localctx, 20, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			param();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(199);
				match(T__5);
				setState(200);
				param();
				}
				}
				setState(205);
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
		enterRule(_localctx, 22, RULE_param);
		int _la;
		try {
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				identifier();
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(207);
					match(T__9);
					setState(208);
					value();
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__5) {
						{
						{
						setState(209);
						match(T__5);
						setState(210);
						value();
						}
						}
						setState(215);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(216);
					match(T__10);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
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
		enterRule(_localctx, 24, RULE_value);
		try {
			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(224);
				reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(225);
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
		enterRule(_localctx, 26, RULE_selectStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(T__12);
			setState(229);
			identifier();
			setState(230);
			match(T__13);
			setState(231);
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
		enterRule(_localctx, 28, RULE_condition);
		try {
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				reference();
				setState(234);
				operator();
				setState(235);
				value();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				identifier();
				setState(238);
				operator();
				setState(239);
				value();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(241);
				reference();
				setState(242);
				match(T__14);
				setState(243);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitLoopStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStmtContext loopStmt() throws RecognitionException {
		LoopStmtContext _localctx = new LoopStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_loopStmt);
		try {
			setState(252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				whileStmt();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				forStmt();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 3);
				{
				setState(251);
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
		enterRule(_localctx, 34, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(T__18);
			setState(255);
			match(T__9);
			setState(256);
			condition();
			setState(257);
			match(T__10);
			setState(258);
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
		enterRule(_localctx, 36, RULE_forStmt);
		try {
			setState(272);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				match(T__19);
				setState(261);
				match(T__9);
				setState(262);
				identifier();
				setState(263);
				match(T__10);
				setState(264);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				match(T__19);
				setState(267);
				identifier();
				setState(268);
				match(T__20);
				setState(269);
				iterable();
				setState(270);
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
		enterRule(_localctx, 38, RULE_foreachStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(T__21);
			setState(275);
			reference();
			setState(276);
			match(T__2);
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__18) | (1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << T__27) | (1L << T__31) | (1L << T__48) | (1L << T__49))) != 0)) {
				{
				{
				setState(277);
				statement();
				}
				}
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(283);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitIncludeStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncludeStmtContext includeStmt() throws RecognitionException {
		IncludeStmtContext _localctx = new IncludeStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_includeStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(T__22);
			setState(286);
			identifier();
			setState(287);
			match(T__23);
			setState(288);
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
		enterRule(_localctx, 42, RULE_iterable);
		try {
			setState(293);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(290);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(291);
				array();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(292);
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
		enterRule(_localctx, 44, RULE_outputStmt);
		int _la;
		try {
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				match(T__24);
				setState(296);
				expression();
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__25) {
					{
					setState(297);
					match(T__25);
					setState(298);
					identifier();
					setState(299);
					match(T__26);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				match(T__24);
				setState(304);
				expression();
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__20) {
					{
					setState(305);
					match(T__20);
					setState(306);
					match(T__26);
					setState(307);
					match(T__9);
					setState(308);
					identifier();
					setState(309);
					match(T__10);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(313);
				match(T__24);
				setState(314);
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
		enterRule(_localctx, 46, RULE_usingStmt);
		try {
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(317);
				match(T__27);
				setState(318);
				reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
				match(T__27);
				setState(320);
				identifier();
				setState(321);
				match(T__28);
				setState(322);
				identifier();
				setState(323);
				match(T__1);
				setState(324);
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
		enterRule(_localctx, 48, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(T__2);
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__18) | (1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << T__27) | (1L << T__31) | (1L << T__48) | (1L << T__49))) != 0)) {
				{
				{
				setState(329);
				statement();
				}
				}
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(335);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_expression);
		try {
			setState(340);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				mathExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
				reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(339);
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
		enterRule(_localctx, 52, RULE_mathExpr);
		try {
			setState(353);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(342);
				match(NUMBER);
				setState(343);
				operator();
				setState(344);
				match(NUMBER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(346);
				match(NUMBER);
				setState(347);
				match(T__29);
				setState(348);
				reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(349);
				reference();
				setState(350);
				match(T__29);
				setState(351);
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
		enterRule(_localctx, 54, RULE_reference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			identifier();
			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__28) {
				{
				{
				setState(356);
				match(T__28);
				setState(357);
				identifier();
				}
				}
				setState(362);
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
		enterRule(_localctx, 56, RULE_array);
		int _la;
		try {
			setState(386);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(363);
				match(T__2);
				setState(372);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEYWORD) | (1L << IDENTIFIER) | (1L << STRING) | (1L << NUMBER) | (1L << TIME) | (1L << BOOLEAN))) != 0)) {
					{
					setState(364);
					value();
					setState(369);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__5) {
						{
						{
						setState(365);
						match(T__5);
						setState(366);
						value();
						}
						}
						setState(371);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(374);
				match(T__3);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(375);
				match(T__9);
				setState(376);
				timeRange();
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(377);
					match(T__5);
					setState(378);
					timeRange();
					}
					}
					setState(383);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(384);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitTimeRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeRangeContext timeRange() throws RecognitionException {
		TimeRangeContext _localctx = new TimeRangeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_timeRange);
		try {
			setState(392);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TIME_RANGE:
				enterOuterAlt(_localctx, 1);
				{
				setState(388);
				match(TIME_RANGE);
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(389);
				match(TIME);
				setState(390);
				match(T__30);
				setState(391);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_object);
		try {
			setState(402);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(394);
				match(T__9);
				setState(395);
				value();
				setState(396);
				match(T__10);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(398);
				match(T__2);
				setState(399);
				attributeList();
				setState(400);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
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
		enterRule(_localctx, 64, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
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

	public static class FindOptimalTimesStmtContext extends ParserRuleContext {
		public UserSpecContext userSpec() {
			return getRuleContext(UserSpecContext.class,0);
		}
		public FindOptimalTimesStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_findOptimalTimesStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterFindOptimalTimesStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitFindOptimalTimesStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitFindOptimalTimesStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FindOptimalTimesStmtContext findOptimalTimesStmt() throws RecognitionException {
		FindOptimalTimesStmtContext _localctx = new FindOptimalTimesStmtContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_findOptimalTimesStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			match(T__31);
			setState(409);
			match(T__9);
			setState(410);
			userSpec();
			setState(411);
			match(T__10);
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

	public static class UserSpecContext extends ParserRuleContext {
		public UserPropertyListContext userPropertyList() {
			return getRuleContext(UserPropertyListContext.class,0);
		}
		public UserSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterUserSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitUserSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitUserSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserSpecContext userSpec() throws RecognitionException {
		UserSpecContext _localctx = new UserSpecContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_userSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			match(T__32);
			setState(414);
			match(T__2);
			setState(415);
			userPropertyList();
			setState(416);
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

	public static class UserPropertyListContext extends ParserRuleContext {
		public List<UserPropertyContext> userProperty() {
			return getRuleContexts(UserPropertyContext.class);
		}
		public UserPropertyContext userProperty(int i) {
			return getRuleContext(UserPropertyContext.class,i);
		}
		public UserPropertyListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userPropertyList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterUserPropertyList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitUserPropertyList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitUserPropertyList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserPropertyListContext userPropertyList() throws RecognitionException {
		UserPropertyListContext _localctx = new UserPropertyListContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_userPropertyList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			userProperty();
			setState(423);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(419);
				match(T__5);
				setState(420);
				userProperty();
				}
				}
				setState(425);
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

	public static class UserPropertyContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(FitnessNutritionParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(FitnessNutritionParser.STRING, 0); }
		public StringArrayContext stringArray() {
			return getRuleContext(StringArrayContext.class,0);
		}
		public TimeRangeArrayContext timeRangeArray() {
			return getRuleContext(TimeRangeArrayContext.class,0);
		}
		public ExerciseArrayContext exerciseArray() {
			return getRuleContext(ExerciseArrayContext.class,0);
		}
		public UserPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterUserProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitUserProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitUserProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserPropertyContext userProperty() throws RecognitionException {
		UserPropertyContext _localctx = new UserPropertyContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_userProperty);
		try {
			setState(465);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(426);
				match(T__33);
				setState(427);
				match(T__34);
				setState(428);
				match(NUMBER);
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 2);
				{
				setState(429);
				match(T__35);
				setState(430);
				match(T__34);
				setState(431);
				match(STRING);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 3);
				{
				setState(432);
				match(T__36);
				setState(433);
				match(T__34);
				setState(434);
				match(NUMBER);
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 4);
				{
				setState(435);
				match(T__37);
				setState(436);
				match(T__34);
				setState(437);
				match(NUMBER);
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 5);
				{
				setState(438);
				match(T__38);
				setState(439);
				match(T__34);
				setState(440);
				match(NUMBER);
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 6);
				{
				setState(441);
				match(T__39);
				setState(442);
				match(T__34);
				setState(443);
				match(STRING);
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 7);
				{
				setState(444);
				match(T__40);
				setState(445);
				match(T__34);
				setState(446);
				match(STRING);
				}
				break;
			case T__41:
				enterOuterAlt(_localctx, 8);
				{
				setState(447);
				match(T__41);
				setState(448);
				match(T__34);
				setState(449);
				match(T__42);
				setState(450);
				stringArray();
				setState(451);
				match(T__43);
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 9);
				{
				setState(453);
				match(T__44);
				setState(454);
				match(T__34);
				setState(455);
				match(T__42);
				setState(456);
				timeRangeArray();
				setState(457);
				match(T__43);
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 10);
				{
				setState(459);
				match(T__45);
				setState(460);
				match(T__34);
				setState(461);
				match(T__42);
				setState(462);
				exerciseArray();
				setState(463);
				match(T__43);
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

	public static class TimeRangeArrayContext extends ParserRuleContext {
		public List<TimeRangePairContext> timeRangePair() {
			return getRuleContexts(TimeRangePairContext.class);
		}
		public TimeRangePairContext timeRangePair(int i) {
			return getRuleContext(TimeRangePairContext.class,i);
		}
		public TimeRangeArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeRangeArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterTimeRangeArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitTimeRangeArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitTimeRangeArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeRangeArrayContext timeRangeArray() throws RecognitionException {
		TimeRangeArrayContext _localctx = new TimeRangeArrayContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_timeRangeArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			timeRangePair();
			setState(472);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(468);
				match(T__5);
				setState(469);
				timeRangePair();
				}
				}
				setState(474);
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

	public static class TimeRangePairContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(FitnessNutritionParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(FitnessNutritionParser.STRING, i);
		}
		public TimeRangePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeRangePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterTimeRangePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitTimeRangePair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitTimeRangePair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeRangePairContext timeRangePair() throws RecognitionException {
		TimeRangePairContext _localctx = new TimeRangePairContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_timeRangePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			match(T__42);
			setState(476);
			match(STRING);
			setState(477);
			match(T__5);
			setState(478);
			match(STRING);
			setState(479);
			match(T__43);
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

	public static class ExerciseArrayContext extends ParserRuleContext {
		public List<ExerciseObjectContext> exerciseObject() {
			return getRuleContexts(ExerciseObjectContext.class);
		}
		public ExerciseObjectContext exerciseObject(int i) {
			return getRuleContext(ExerciseObjectContext.class,i);
		}
		public ExerciseArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exerciseArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterExerciseArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitExerciseArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitExerciseArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExerciseArrayContext exerciseArray() throws RecognitionException {
		ExerciseArrayContext _localctx = new ExerciseArrayContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_exerciseArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			exerciseObject();
			setState(486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(482);
				match(T__5);
				setState(483);
				exerciseObject();
				}
				}
				setState(488);
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

	public static class ExerciseObjectContext extends ParserRuleContext {
		public ExercisePropertyListContext exercisePropertyList() {
			return getRuleContext(ExercisePropertyListContext.class,0);
		}
		public ExerciseObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exerciseObject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterExerciseObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitExerciseObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitExerciseObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExerciseObjectContext exerciseObject() throws RecognitionException {
		ExerciseObjectContext _localctx = new ExerciseObjectContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_exerciseObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			match(T__2);
			setState(490);
			exercisePropertyList();
			setState(491);
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

	public static class ExercisePropertyListContext extends ParserRuleContext {
		public List<ExercisePropertyContext> exerciseProperty() {
			return getRuleContexts(ExercisePropertyContext.class);
		}
		public ExercisePropertyContext exerciseProperty(int i) {
			return getRuleContext(ExercisePropertyContext.class,i);
		}
		public ExercisePropertyListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exercisePropertyList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterExercisePropertyList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitExercisePropertyList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitExercisePropertyList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExercisePropertyListContext exercisePropertyList() throws RecognitionException {
		ExercisePropertyListContext _localctx = new ExercisePropertyListContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_exercisePropertyList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			exerciseProperty();
			setState(498);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(494);
				match(T__5);
				setState(495);
				exerciseProperty();
				}
				}
				setState(500);
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

	public static class ExercisePropertyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(FitnessNutritionParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(FitnessNutritionParser.NUMBER, 0); }
		public ExercisePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exerciseProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterExerciseProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitExerciseProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitExerciseProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExercisePropertyContext exerciseProperty() throws RecognitionException {
		ExercisePropertyContext _localctx = new ExercisePropertyContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_exerciseProperty);
		try {
			setState(510);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(501);
				match(T__35);
				setState(502);
				match(T__34);
				setState(503);
				match(STRING);
				}
				break;
			case T__46:
				enterOuterAlt(_localctx, 2);
				{
				setState(504);
				match(T__46);
				setState(505);
				match(T__34);
				setState(506);
				match(NUMBER);
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 3);
				{
				setState(507);
				match(T__47);
				setState(508);
				match(T__34);
				setState(509);
				match(NUMBER);
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

	public static class CreateWeeklyTrainingScheduleStmtContext extends ParserRuleContext {
		public UserSpecContext userSpec() {
			return getRuleContext(UserSpecContext.class,0);
		}
		public CreateWeeklyTrainingScheduleStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createWeeklyTrainingScheduleStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterCreateWeeklyTrainingScheduleStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitCreateWeeklyTrainingScheduleStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitCreateWeeklyTrainingScheduleStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateWeeklyTrainingScheduleStmtContext createWeeklyTrainingScheduleStmt() throws RecognitionException {
		CreateWeeklyTrainingScheduleStmtContext _localctx = new CreateWeeklyTrainingScheduleStmtContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_createWeeklyTrainingScheduleStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(512);
			match(T__48);
			setState(513);
			match(T__9);
			setState(514);
			userSpec();
			setState(515);
			match(T__10);
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

	public static class CreateDailyMealPlanStmtContext extends ParserRuleContext {
		public UserSpecContext userSpec() {
			return getRuleContext(UserSpecContext.class,0);
		}
		public CreateDailyMealPlanStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createDailyMealPlanStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterCreateDailyMealPlanStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitCreateDailyMealPlanStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitCreateDailyMealPlanStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateDailyMealPlanStmtContext createDailyMealPlanStmt() throws RecognitionException {
		CreateDailyMealPlanStmtContext _localctx = new CreateDailyMealPlanStmtContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_createDailyMealPlanStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517);
			match(T__49);
			setState(518);
			match(T__9);
			setState(519);
			userSpec();
			setState(520);
			match(T__10);
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

	public static class StringArrayContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(FitnessNutritionParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(FitnessNutritionParser.STRING, i);
		}
		public StringArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).enterStringArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FitnessNutritionListener ) ((FitnessNutritionListener)listener).exitStringArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FitnessNutritionVisitor ) return ((FitnessNutritionVisitor<? extends T>)visitor).visitStringArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringArrayContext stringArray() throws RecognitionException {
		StringArrayContext _localctx = new StringArrayContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_stringArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(522);
				match(STRING);
				setState(527);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(523);
					match(T__5);
					setState(524);
					match(STRING);
					}
					}
					setState(529);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3=\u0217\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\7\2`\n\2\f\2\16\2c\13\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3p\n\3\3\4\3\4\3\4\3\4\6\4v\n\4\r\4\16\4w\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\5\6\u0084\n\6\3\6\3\6\3\6\3\6\5"+
		"\6\u008a\n\6\3\6\3\6\3\6\3\6\5\6\u0090\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\7\b\u009a\n\b\f\b\16\b\u009d\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00ae\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\5\n\u00bc\n\n\3\n\3\n\3\n\3\n\5\n\u00c2\n\n\3\13"+
		"\6\13\u00c5\n\13\r\13\16\13\u00c6\3\f\3\f\3\f\7\f\u00cc\n\f\f\f\16\f\u00cf"+
		"\13\f\3\r\3\r\3\r\3\r\3\r\7\r\u00d6\n\r\f\r\16\r\u00d9\13\r\3\r\3\r\5"+
		"\r\u00dd\n\r\3\r\5\r\u00e0\n\r\3\16\3\16\3\16\5\16\u00e5\n\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\5\20\u00f8\n\20\3\21\3\21\3\22\3\22\3\22\5\22\u00ff\n\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\5\24\u0113\n\24\3\25\3\25\3\25\3\25\7\25\u0119\n\25\f\25"+
		"\16\25\u011c\13\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\5"+
		"\27\u0128\n\27\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0130\n\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u013a\n\30\3\30\3\30\5\30\u013e\n"+
		"\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0149\n\31\3\32"+
		"\3\32\7\32\u014d\n\32\f\32\16\32\u0150\13\32\3\32\3\32\3\33\3\33\3\33"+
		"\5\33\u0157\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\5\34\u0164\n\34\3\35\3\35\3\35\7\35\u0169\n\35\f\35\16\35\u016c\13\35"+
		"\3\36\3\36\3\36\3\36\7\36\u0172\n\36\f\36\16\36\u0175\13\36\5\36\u0177"+
		"\n\36\3\36\3\36\3\36\3\36\3\36\7\36\u017e\n\36\f\36\16\36\u0181\13\36"+
		"\3\36\3\36\5\36\u0185\n\36\3\37\3\37\3\37\3\37\5\37\u018b\n\37\3 \3 \3"+
		" \3 \3 \3 \3 \3 \5 \u0195\n \3!\3!\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$"+
		"\3$\3%\3%\3%\7%\u01a8\n%\f%\16%\u01ab\13%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\5&\u01d4\n&\3\'\3\'\3\'\7\'\u01d9\n\'\f\'\16\'\u01dc"+
		"\13\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\7)\u01e7\n)\f)\16)\u01ea\13)\3*\3*\3"+
		"*\3*\3+\3+\3+\7+\u01f3\n+\f+\16+\u01f6\13+\3,\3,\3,\3,\3,\3,\3,\3,\3,"+
		"\5,\u0201\n,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\7/\u0210\n/\f/\16"+
		"/\u0213\13/\5/\u0215\n/\3/\2\2\60\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\\2\5\4\2\4\4\23\24\4\2\65"+
		"\65\67\67\3\28;\2\u022e\2a\3\2\2\2\4o\3\2\2\2\6q\3\2\2\2\b{\3\2\2\2\n"+
		"\u0083\3\2\2\2\f\u0091\3\2\2\2\16\u009b\3\2\2\2\20\u00ad\3\2\2\2\22\u00c1"+
		"\3\2\2\2\24\u00c4\3\2\2\2\26\u00c8\3\2\2\2\30\u00df\3\2\2\2\32\u00e4\3"+
		"\2\2\2\34\u00e6\3\2\2\2\36\u00f7\3\2\2\2 \u00f9\3\2\2\2\"\u00fe\3\2\2"+
		"\2$\u0100\3\2\2\2&\u0112\3\2\2\2(\u0114\3\2\2\2*\u011f\3\2\2\2,\u0127"+
		"\3\2\2\2.\u013d\3\2\2\2\60\u0148\3\2\2\2\62\u014a\3\2\2\2\64\u0156\3\2"+
		"\2\2\66\u0163\3\2\2\28\u0165\3\2\2\2:\u0184\3\2\2\2<\u018a\3\2\2\2>\u0194"+
		"\3\2\2\2@\u0196\3\2\2\2B\u0198\3\2\2\2D\u019a\3\2\2\2F\u019f\3\2\2\2H"+
		"\u01a4\3\2\2\2J\u01d3\3\2\2\2L\u01d5\3\2\2\2N\u01dd\3\2\2\2P\u01e3\3\2"+
		"\2\2R\u01eb\3\2\2\2T\u01ef\3\2\2\2V\u0200\3\2\2\2X\u0202\3\2\2\2Z\u0207"+
		"\3\2\2\2\\\u0214\3\2\2\2^`\5\4\3\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2"+
		"\2\2b\3\3\2\2\2ca\3\2\2\2dp\5\f\7\2ep\5\22\n\2fp\5\34\17\2gp\5\60\31\2"+
		"hp\5.\30\2ip\5\"\22\2jp\5*\26\2kp\5\6\4\2lp\5D#\2mp\5X-\2np\5Z.\2od\3"+
		"\2\2\2oe\3\2\2\2of\3\2\2\2og\3\2\2\2oh\3\2\2\2oi\3\2\2\2oj\3\2\2\2ok\3"+
		"\2\2\2ol\3\2\2\2om\3\2\2\2on\3\2\2\2p\5\3\2\2\2qr\7\3\2\2rs\7\4\2\2su"+
		"\7\5\2\2tv\5\b\5\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2xy\3\2\2\2y"+
		"z\7\6\2\2z\7\3\2\2\2{|\7\67\2\2|}\7\5\2\2}~\5\n\6\2~\177\7\6\2\2\177\t"+
		"\3\2\2\2\u0080\u0081\7\7\2\2\u0081\u0082\7\4\2\2\u0082\u0084\79\2\2\u0083"+
		"\u0080\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0089\3\2\2\2\u0085\u0086\7\b"+
		"\2\2\u0086\u0087\7\t\2\2\u0087\u0088\7\4\2\2\u0088\u008a\79\2\2\u0089"+
		"\u0085\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008f\3\2\2\2\u008b\u008c\7\b"+
		"\2\2\u008c\u008d\7\n\2\2\u008d\u008e\7\4\2\2\u008e\u0090\79\2\2\u008f"+
		"\u008b\3\2\2\2\u008f\u0090\3\2\2\2\u0090\13\3\2\2\2\u0091\u0092\7\13\2"+
		"\2\u0092\u0093\5@!\2\u0093\u0094\5@!\2\u0094\u0095\7\5\2\2\u0095\u0096"+
		"\5\16\b\2\u0096\u0097\7\6\2\2\u0097\r\3\2\2\2\u0098\u009a\5\20\t\2\u0099"+
		"\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\17\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f\5@!\2\u009f\u00a0"+
		"\7\f\2\2\u00a0\u00a1\5\32\16\2\u00a1\u00a2\7\r\2\2\u00a2\u00ae\3\2\2\2"+
		"\u00a3\u00a4\5@!\2\u00a4\u00a5\7\5\2\2\u00a5\u00a6\5\16\b\2\u00a6\u00a7"+
		"\7\6\2\2\u00a7\u00ae\3\2\2\2\u00a8\u00a9\5@!\2\u00a9\u00aa\7\f\2\2\u00aa"+
		"\u00ab\5\64\33\2\u00ab\u00ac\7\r\2\2\u00ac\u00ae\3\2\2\2\u00ad\u009e\3"+
		"\2\2\2\u00ad\u00a3\3\2\2\2\u00ad\u00a8\3\2\2\2\u00ae\21\3\2\2\2\u00af"+
		"\u00b0\7\16\2\2\u00b0\u00b1\5@!\2\u00b1\u00b2\7\5\2\2\u00b2\u00b3\5\26"+
		"\f\2\u00b3\u00b4\7\6\2\2\u00b4\u00c2\3\2\2\2\u00b5\u00b6\7\16\2\2\u00b6"+
		"\u00bb\5@!\2\u00b7\u00b8\7\f\2\2\u00b8\u00b9\5\26\f\2\u00b9\u00ba\7\r"+
		"\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b7\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\u00c2\3\2\2\2\u00bd\u00be\7\16\2\2\u00be\u00bf\58\35\2\u00bf\u00c0\5"+
		"\24\13\2\u00c0\u00c2\3\2\2\2\u00c1\u00af\3\2\2\2\u00c1\u00b5\3\2\2\2\u00c1"+
		"\u00bd\3\2\2\2\u00c2\23\3\2\2\2\u00c3\u00c5\5@!\2\u00c4\u00c3\3\2\2\2"+
		"\u00c5\u00c6\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\25"+
		"\3\2\2\2\u00c8\u00cd\5\30\r\2\u00c9\u00ca\7\b\2\2\u00ca\u00cc\5\30\r\2"+
		"\u00cb\u00c9\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce"+
		"\3\2\2\2\u00ce\27\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00dc\5@!\2\u00d1"+
		"\u00d2\7\f\2\2\u00d2\u00d7\5\32\16\2\u00d3\u00d4\7\b\2\2\u00d4\u00d6\5"+
		"\32\16\2\u00d5\u00d3\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00db\7\r"+
		"\2\2\u00db\u00dd\3\2\2\2\u00dc\u00d1\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"\u00e0\3\2\2\2\u00de\u00e0\5@!\2\u00df\u00d0\3\2\2\2\u00df\u00de\3\2\2"+
		"\2\u00e0\31\3\2\2\2\u00e1\u00e5\5B\"\2\u00e2\u00e5\58\35\2\u00e3\u00e5"+
		"\5@!\2\u00e4\u00e1\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5"+
		"\33\3\2\2\2\u00e6\u00e7\7\17\2\2\u00e7\u00e8\5@!\2\u00e8\u00e9\7\20\2"+
		"\2\u00e9\u00ea\5\36\20\2\u00ea\35\3\2\2\2\u00eb\u00ec\58\35\2\u00ec\u00ed"+
		"\5 \21\2\u00ed\u00ee\5\32\16\2\u00ee\u00f8\3\2\2\2\u00ef\u00f0\5@!\2\u00f0"+
		"\u00f1\5 \21\2\u00f1\u00f2\5\32\16\2\u00f2\u00f8\3\2\2\2\u00f3\u00f4\5"+
		"8\35\2\u00f4\u00f5\7\21\2\2\u00f5\u00f6\7\22\2\2\u00f6\u00f8\3\2\2\2\u00f7"+
		"\u00eb\3\2\2\2\u00f7\u00ef\3\2\2\2\u00f7\u00f3\3\2\2\2\u00f8\37\3\2\2"+
		"\2\u00f9\u00fa\t\2\2\2\u00fa!\3\2\2\2\u00fb\u00ff\5$\23\2\u00fc\u00ff"+
		"\5&\24\2\u00fd\u00ff\5(\25\2\u00fe\u00fb\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe"+
		"\u00fd\3\2\2\2\u00ff#\3\2\2\2\u0100\u0101\7\25\2\2\u0101\u0102\7\f\2\2"+
		"\u0102\u0103\5\36\20\2\u0103\u0104\7\r\2\2\u0104\u0105\5\62\32\2\u0105"+
		"%\3\2\2\2\u0106\u0107\7\26\2\2\u0107\u0108\7\f\2\2\u0108\u0109\5@!\2\u0109"+
		"\u010a\7\r\2\2\u010a\u010b\5\62\32\2\u010b\u0113\3\2\2\2\u010c\u010d\7"+
		"\26\2\2\u010d\u010e\5@!\2\u010e\u010f\7\27\2\2\u010f\u0110\5,\27\2\u0110"+
		"\u0111\5\62\32\2\u0111\u0113\3\2\2\2\u0112\u0106\3\2\2\2\u0112\u010c\3"+
		"\2\2\2\u0113\'\3\2\2\2\u0114\u0115\7\30\2\2\u0115\u0116\58\35\2\u0116"+
		"\u011a\7\5\2\2\u0117\u0119\5\4\3\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2"+
		"\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011d\3\2\2\2\u011c"+
		"\u011a\3\2\2\2\u011d\u011e\7\6\2\2\u011e)\3\2\2\2\u011f\u0120\7\31\2\2"+
		"\u0120\u0121\5@!\2\u0121\u0122\7\32\2\2\u0122\u0123\5@!\2\u0123+\3\2\2"+
		"\2\u0124\u0128\5@!\2\u0125\u0128\5:\36\2\u0126\u0128\58\35\2\u0127\u0124"+
		"\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0126\3\2\2\2\u0128-\3\2\2\2\u0129"+
		"\u012a\7\33\2\2\u012a\u012f\5\64\33\2\u012b\u012c\7\34\2\2\u012c\u012d"+
		"\5@!\2\u012d\u012e\7\35\2\2\u012e\u0130\3\2\2\2\u012f\u012b\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130\u013e\3\2\2\2\u0131\u0132\7\33\2\2\u0132\u0139\5"+
		"\64\33\2\u0133\u0134\7\27\2\2\u0134\u0135\7\35\2\2\u0135\u0136\7\f\2\2"+
		"\u0136\u0137\5@!\2\u0137\u0138\7\r\2\2\u0138\u013a\3\2\2\2\u0139\u0133"+
		"\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013e\3\2\2\2\u013b\u013c\7\33\2\2"+
		"\u013c\u013e\58\35\2\u013d\u0129\3\2\2\2\u013d\u0131\3\2\2\2\u013d\u013b"+
		"\3\2\2\2\u013e/\3\2\2\2\u013f\u0140\7\36\2\2\u0140\u0149\58\35\2\u0141"+
		"\u0142\7\36\2\2\u0142\u0143\5@!\2\u0143\u0144\7\37\2\2\u0144\u0145\5@"+
		"!\2\u0145\u0146\7\4\2\2\u0146\u0147\5B\"\2\u0147\u0149\3\2\2\2\u0148\u013f"+
		"\3\2\2\2\u0148\u0141\3\2\2\2\u0149\61\3\2\2\2\u014a\u014e\7\5\2\2\u014b"+
		"\u014d\5\4\3\2\u014c\u014b\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c\3\2"+
		"\2\2\u014e\u014f\3\2\2\2\u014f\u0151\3\2\2\2\u0150\u014e\3\2\2\2\u0151"+
		"\u0152\7\6\2\2\u0152\63\3\2\2\2\u0153\u0157\5\66\34\2\u0154\u0157\58\35"+
		"\2\u0155\u0157\5B\"\2\u0156\u0153\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0155"+
		"\3\2\2\2\u0157\65\3\2\2\2\u0158\u0159\79\2\2\u0159\u015a\5 \21\2\u015a"+
		"\u015b\79\2\2\u015b\u0164\3\2\2\2\u015c\u015d\79\2\2\u015d\u015e\7 \2"+
		"\2\u015e\u0164\58\35\2\u015f\u0160\58\35\2\u0160\u0161\7 \2\2\u0161\u0162"+
		"\79\2\2\u0162\u0164\3\2\2\2\u0163\u0158\3\2\2\2\u0163\u015c\3\2\2\2\u0163"+
		"\u015f\3\2\2\2\u0164\67\3\2\2\2\u0165\u016a\5@!\2\u0166\u0167\7\37\2\2"+
		"\u0167\u0169\5@!\2\u0168\u0166\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168"+
		"\3\2\2\2\u016a\u016b\3\2\2\2\u016b9\3\2\2\2\u016c\u016a\3\2\2\2\u016d"+
		"\u0176\7\5\2\2\u016e\u0173\5\32\16\2\u016f\u0170\7\b\2\2\u0170\u0172\5"+
		"\32\16\2\u0171\u016f\3\2\2\2\u0172\u0175\3\2\2\2\u0173\u0171\3\2\2\2\u0173"+
		"\u0174\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0176\u016e\3\2"+
		"\2\2\u0176\u0177\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0185\7\6\2\2\u0179"+
		"\u017a\7\f\2\2\u017a\u017f\5<\37\2\u017b\u017c\7\b\2\2\u017c\u017e\5<"+
		"\37\2\u017d\u017b\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u017d\3\2\2\2\u017f"+
		"\u0180\3\2\2\2\u0180\u0182\3\2\2\2\u0181\u017f\3\2\2\2\u0182\u0183\7\r"+
		"\2\2\u0183\u0185\3\2\2\2\u0184\u016d\3\2\2\2\u0184\u0179\3\2\2\2\u0185"+
		";\3\2\2\2\u0186\u018b\7\66\2\2\u0187\u0188\7:\2\2\u0188\u0189\7!\2\2\u0189"+
		"\u018b\7:\2\2\u018a\u0186\3\2\2\2\u018a\u0187\3\2\2\2\u018b=\3\2\2\2\u018c"+
		"\u018d\7\f\2\2\u018d\u018e\5\32\16\2\u018e\u018f\7\r\2\2\u018f\u0195\3"+
		"\2\2\2\u0190\u0191\7\5\2\2\u0191\u0192\5\16\b\2\u0192\u0193\7\6\2\2\u0193"+
		"\u0195\3\2\2\2\u0194\u018c\3\2\2\2\u0194\u0190\3\2\2\2\u0195?\3\2\2\2"+
		"\u0196\u0197\t\3\2\2\u0197A\3\2\2\2\u0198\u0199\t\4\2\2\u0199C\3\2\2\2"+
		"\u019a\u019b\7\"\2\2\u019b\u019c\7\f\2\2\u019c\u019d\5F$\2\u019d\u019e"+
		"\7\r\2\2\u019eE\3\2\2\2\u019f\u01a0\7#\2\2\u01a0\u01a1\7\5\2\2\u01a1\u01a2"+
		"\5H%\2\u01a2\u01a3\7\6\2\2\u01a3G\3\2\2\2\u01a4\u01a9\5J&\2\u01a5\u01a6"+
		"\7\b\2\2\u01a6\u01a8\5J&\2\u01a7\u01a5\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9"+
		"\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aaI\3\2\2\2\u01ab\u01a9\3\2\2\2"+
		"\u01ac\u01ad\7$\2\2\u01ad\u01ae\7%\2\2\u01ae\u01d4\79\2\2\u01af\u01b0"+
		"\7&\2\2\u01b0\u01b1\7%\2\2\u01b1\u01d4\78\2\2\u01b2\u01b3\7\'\2\2\u01b3"+
		"\u01b4\7%\2\2\u01b4\u01d4\79\2\2\u01b5\u01b6\7(\2\2\u01b6\u01b7\7%\2\2"+
		"\u01b7\u01d4\79\2\2\u01b8\u01b9\7)\2\2\u01b9\u01ba\7%\2\2\u01ba\u01d4"+
		"\79\2\2\u01bb\u01bc\7*\2\2\u01bc\u01bd\7%\2\2\u01bd\u01d4\78\2\2\u01be"+
		"\u01bf\7+\2\2\u01bf\u01c0\7%\2\2\u01c0\u01d4\78\2\2\u01c1\u01c2\7,\2\2"+
		"\u01c2\u01c3\7%\2\2\u01c3\u01c4\7-\2\2\u01c4\u01c5\5\\/\2\u01c5\u01c6"+
		"\7.\2\2\u01c6\u01d4\3\2\2\2\u01c7\u01c8\7/\2\2\u01c8\u01c9\7%\2\2\u01c9"+
		"\u01ca\7-\2\2\u01ca\u01cb\5L\'\2\u01cb\u01cc\7.\2\2\u01cc\u01d4\3\2\2"+
		"\2\u01cd\u01ce\7\60\2\2\u01ce\u01cf\7%\2\2\u01cf\u01d0\7-\2\2\u01d0\u01d1"+
		"\5P)\2\u01d1\u01d2\7.\2\2\u01d2\u01d4\3\2\2\2\u01d3\u01ac\3\2\2\2\u01d3"+
		"\u01af\3\2\2\2\u01d3\u01b2\3\2\2\2\u01d3\u01b5\3\2\2\2\u01d3\u01b8\3\2"+
		"\2\2\u01d3\u01bb\3\2\2\2\u01d3\u01be\3\2\2\2\u01d3\u01c1\3\2\2\2\u01d3"+
		"\u01c7\3\2\2\2\u01d3\u01cd\3\2\2\2\u01d4K\3\2\2\2\u01d5\u01da\5N(\2\u01d6"+
		"\u01d7\7\b\2\2\u01d7\u01d9\5N(\2\u01d8\u01d6\3\2\2\2\u01d9\u01dc\3\2\2"+
		"\2\u01da\u01d8\3\2\2\2\u01da\u01db\3\2\2\2\u01dbM\3\2\2\2\u01dc\u01da"+
		"\3\2\2\2\u01dd\u01de\7-\2\2\u01de\u01df\78\2\2\u01df\u01e0\7\b\2\2\u01e0"+
		"\u01e1\78\2\2\u01e1\u01e2\7.\2\2\u01e2O\3\2\2\2\u01e3\u01e8\5R*\2\u01e4"+
		"\u01e5\7\b\2\2\u01e5\u01e7\5R*\2\u01e6\u01e4\3\2\2\2\u01e7\u01ea\3\2\2"+
		"\2\u01e8\u01e6\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9Q\3\2\2\2\u01ea\u01e8"+
		"\3\2\2\2\u01eb\u01ec\7\5\2\2\u01ec\u01ed\5T+\2\u01ed\u01ee\7\6\2\2\u01ee"+
		"S\3\2\2\2\u01ef\u01f4\5V,\2\u01f0\u01f1\7\b\2\2\u01f1\u01f3\5V,\2\u01f2"+
		"\u01f0\3\2\2\2\u01f3\u01f6\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f4\u01f5\3\2"+
		"\2\2\u01f5U\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f7\u01f8\7&\2\2\u01f8\u01f9"+
		"\7%\2\2\u01f9\u0201\78\2\2\u01fa\u01fb\7\61\2\2\u01fb\u01fc\7%\2\2\u01fc"+
		"\u0201\79\2\2\u01fd\u01fe\7\62\2\2\u01fe\u01ff\7%\2\2\u01ff\u0201\79\2"+
		"\2\u0200\u01f7\3\2\2\2\u0200\u01fa\3\2\2\2\u0200\u01fd\3\2\2\2\u0201W"+
		"\3\2\2\2\u0202\u0203\7\63\2\2\u0203\u0204\7\f\2\2\u0204\u0205\5F$\2\u0205"+
		"\u0206\7\r\2\2\u0206Y\3\2\2\2\u0207\u0208\7\64\2\2\u0208\u0209\7\f\2\2"+
		"\u0209\u020a\5F$\2\u020a\u020b\7\r\2\2\u020b[\3\2\2\2\u020c\u0211\78\2"+
		"\2\u020d\u020e\7\b\2\2\u020e\u0210\78\2\2\u020f\u020d\3\2\2\2\u0210\u0213"+
		"\3\2\2\2\u0211\u020f\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0215\3\2\2\2\u0213"+
		"\u0211\3\2\2\2\u0214\u020c\3\2\2\2\u0214\u0215\3\2\2\2\u0215]\3\2\2\2"+
		"-aow\u0083\u0089\u008f\u009b\u00ad\u00bb\u00c1\u00c6\u00cd\u00d7\u00dc"+
		"\u00df\u00e4\u00f7\u00fe\u0112\u011a\u0127\u012f\u0139\u013d\u0148\u014e"+
		"\u0156\u0163\u016a\u0173\u0176\u017f\u0184\u018a\u0194\u01a9\u01d3\u01da"+
		"\u01e8\u01f4\u0200\u0211\u0214";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}