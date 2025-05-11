// Generated from d:/uni/project_ELSD/DSL-fitness-food/DSL/grammar/FitnessNutrition.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class FitnessNutritionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

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

	@SuppressWarnings("CheckReturnValue")
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 316158466L) != 0)) {
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 393220L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 316158466L) != 0)) {
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 316158466L) != 0)) {
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536870912000L) != 0)) {
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 515396075520L) != 0)) ) {
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
		"\u0004\u0001(\u017c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000\u0005\u0000D\b\u0000"+
		"\n\u0000\f\u0000G\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001Q\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u0002W\b\u0002"+
		"\u000b\u0002\f\u0002X\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004e\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004k\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004q\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0005\u0006{\b\u0006"+
		"\n\u0006\f\u0006~\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u008f\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u009d\b\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u00a3\b\b\u0001\t\u0004\t\u00a6\b\t\u000b\t"+
		"\f\t\u00a7\u0001\n\u0001\n\u0001\n\u0005\n\u00ad\b\n\n\n\f\n\u00b0\t\n"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u00b7\b\u000b\n\u000b\f\u000b\u00ba\t\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00be\b\u000b\u0001\u000b\u0003\u000b\u00c1\b\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u00c6\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u00d9\b\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u00e0\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00f4\b\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u00fa\b\u0013\n\u0013\f\u0013"+
		"\u00fd\t\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015"+
		"\u0109\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0003\u0016\u0111\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u011b\b\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u011f\b\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u012a\b\u0017\u0001\u0018\u0001"+
		"\u0018\u0005\u0018\u012e\b\u0018\n\u0018\f\u0018\u0131\t\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0138\b\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a"+
		"\u0145\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u014a\b"+
		"\u001b\n\u001b\f\u001b\u014d\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0005\u001c\u0153\b\u001c\n\u001c\f\u001c\u0156\t\u001c\u0003"+
		"\u001c\u0158\b\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0005\u001c\u015f\b\u001c\n\u001c\f\u001c\u0162\t\u001c\u0001\u001c"+
		"\u0001\u001c\u0003\u001c\u0166\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0003\u001d\u016c\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e"+
		"\u0176\b\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0000\u0000"+
		"!\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@\u0000\u0003\u0002\u0000\u0002\u0002\u0011"+
		"\u0012\u0002\u0000  \"\"\u0001\u0000#&\u018c\u0000E\u0001\u0000\u0000"+
		"\u0000\u0002P\u0001\u0000\u0000\u0000\u0004R\u0001\u0000\u0000\u0000\u0006"+
		"\\\u0001\u0000\u0000\u0000\bd\u0001\u0000\u0000\u0000\nr\u0001\u0000\u0000"+
		"\u0000\f|\u0001\u0000\u0000\u0000\u000e\u008e\u0001\u0000\u0000\u0000"+
		"\u0010\u00a2\u0001\u0000\u0000\u0000\u0012\u00a5\u0001\u0000\u0000\u0000"+
		"\u0014\u00a9\u0001\u0000\u0000\u0000\u0016\u00c0\u0001\u0000\u0000\u0000"+
		"\u0018\u00c5\u0001\u0000\u0000\u0000\u001a\u00c7\u0001\u0000\u0000\u0000"+
		"\u001c\u00d8\u0001\u0000\u0000\u0000\u001e\u00da\u0001\u0000\u0000\u0000"+
		" \u00df\u0001\u0000\u0000\u0000\"\u00e1\u0001\u0000\u0000\u0000$\u00f3"+
		"\u0001\u0000\u0000\u0000&\u00f5\u0001\u0000\u0000\u0000(\u0100\u0001\u0000"+
		"\u0000\u0000*\u0108\u0001\u0000\u0000\u0000,\u011e\u0001\u0000\u0000\u0000"+
		".\u0129\u0001\u0000\u0000\u00000\u012b\u0001\u0000\u0000\u00002\u0137"+
		"\u0001\u0000\u0000\u00004\u0144\u0001\u0000\u0000\u00006\u0146\u0001\u0000"+
		"\u0000\u00008\u0165\u0001\u0000\u0000\u0000:\u016b\u0001\u0000\u0000\u0000"+
		"<\u0175\u0001\u0000\u0000\u0000>\u0177\u0001\u0000\u0000\u0000@\u0179"+
		"\u0001\u0000\u0000\u0000BD\u0003\u0002\u0001\u0000CB\u0001\u0000\u0000"+
		"\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000"+
		"\u0000\u0000F\u0001\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000"+
		"HQ\u0003\n\u0005\u0000IQ\u0003\u0010\b\u0000JQ\u0003\u001a\r\u0000KQ\u0003"+
		".\u0017\u0000LQ\u0003,\u0016\u0000MQ\u0003 \u0010\u0000NQ\u0003(\u0014"+
		"\u0000OQ\u0003\u0004\u0002\u0000PH\u0001\u0000\u0000\u0000PI\u0001\u0000"+
		"\u0000\u0000PJ\u0001\u0000\u0000\u0000PK\u0001\u0000\u0000\u0000PL\u0001"+
		"\u0000\u0000\u0000PM\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000"+
		"PO\u0001\u0000\u0000\u0000Q\u0003\u0001\u0000\u0000\u0000RS\u0005\u0001"+
		"\u0000\u0000ST\u0005\u0002\u0000\u0000TV\u0005\u0003\u0000\u0000UW\u0003"+
		"\u0006\u0003\u0000VU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000"+
		"XV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000"+
		"\u0000Z[\u0005\u0004\u0000\u0000[\u0005\u0001\u0000\u0000\u0000\\]\u0005"+
		"\"\u0000\u0000]^\u0005\u0003\u0000\u0000^_\u0003\b\u0004\u0000_`\u0005"+
		"\u0004\u0000\u0000`\u0007\u0001\u0000\u0000\u0000ab\u0005\u0005\u0000"+
		"\u0000bc\u0005\u0002\u0000\u0000ce\u0005$\u0000\u0000da\u0001\u0000\u0000"+
		"\u0000de\u0001\u0000\u0000\u0000ej\u0001\u0000\u0000\u0000fg\u0005\u0006"+
		"\u0000\u0000gh\u0005\u0007\u0000\u0000hi\u0005\u0002\u0000\u0000ik\u0005"+
		"$\u0000\u0000jf\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000kp\u0001"+
		"\u0000\u0000\u0000lm\u0005\u0006\u0000\u0000mn\u0005\b\u0000\u0000no\u0005"+
		"\u0002\u0000\u0000oq\u0005$\u0000\u0000pl\u0001\u0000\u0000\u0000pq\u0001"+
		"\u0000\u0000\u0000q\t\u0001\u0000\u0000\u0000rs\u0005\t\u0000\u0000st"+
		"\u0003>\u001f\u0000tu\u0003>\u001f\u0000uv\u0005\u0003\u0000\u0000vw\u0003"+
		"\f\u0006\u0000wx\u0005\u0004\u0000\u0000x\u000b\u0001\u0000\u0000\u0000"+
		"y{\u0003\u000e\u0007\u0000zy\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000"+
		"\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\r\u0001\u0000"+
		"\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0080\u0003>\u001f\u0000"+
		"\u0080\u0081\u0005\n\u0000\u0000\u0081\u0082\u0003\u0018\f\u0000\u0082"+
		"\u0083\u0005\u000b\u0000\u0000\u0083\u008f\u0001\u0000\u0000\u0000\u0084"+
		"\u0085\u0003>\u001f\u0000\u0085\u0086\u0005\u0003\u0000\u0000\u0086\u0087"+
		"\u0003\f\u0006\u0000\u0087\u0088\u0005\u0004\u0000\u0000\u0088\u008f\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0003>\u001f\u0000\u008a\u008b\u0005\n"+
		"\u0000\u0000\u008b\u008c\u00032\u0019\u0000\u008c\u008d\u0005\u000b\u0000"+
		"\u0000\u008d\u008f\u0001\u0000\u0000\u0000\u008e\u007f\u0001\u0000\u0000"+
		"\u0000\u008e\u0084\u0001\u0000\u0000\u0000\u008e\u0089\u0001\u0000\u0000"+
		"\u0000\u008f\u000f\u0001\u0000\u0000\u0000\u0090\u0091\u0005\f\u0000\u0000"+
		"\u0091\u0092\u0003>\u001f\u0000\u0092\u0093\u0005\u0003\u0000\u0000\u0093"+
		"\u0094\u0003\u0014\n\u0000\u0094\u0095\u0005\u0004\u0000\u0000\u0095\u00a3"+
		"\u0001\u0000\u0000\u0000\u0096\u0097\u0005\f\u0000\u0000\u0097\u009c\u0003"+
		">\u001f\u0000\u0098\u0099\u0005\n\u0000\u0000\u0099\u009a\u0003\u0014"+
		"\n\u0000\u009a\u009b\u0005\u000b\u0000\u0000\u009b\u009d\u0001\u0000\u0000"+
		"\u0000\u009c\u0098\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000"+
		"\u0000\u009d\u00a3\u0001\u0000\u0000\u0000\u009e\u009f\u0005\f\u0000\u0000"+
		"\u009f\u00a0\u00036\u001b\u0000\u00a0\u00a1\u0003\u0012\t\u0000\u00a1"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a2\u0090\u0001\u0000\u0000\u0000\u00a2"+
		"\u0096\u0001\u0000\u0000\u0000\u00a2\u009e\u0001\u0000\u0000\u0000\u00a3"+
		"\u0011\u0001\u0000\u0000\u0000\u00a4\u00a6\u0003>\u001f\u0000\u00a5\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u0013"+
		"\u0001\u0000\u0000\u0000\u00a9\u00ae\u0003\u0016\u000b\u0000\u00aa\u00ab"+
		"\u0005\u0006\u0000\u0000\u00ab\u00ad\u0003\u0016\u000b\u0000\u00ac\u00aa"+
		"\u0001\u0000\u0000\u0000\u00ad\u00b0\u0001\u0000\u0000\u0000\u00ae\u00ac"+
		"\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u0015"+
		"\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b1\u00bd"+
		"\u0003>\u001f\u0000\u00b2\u00b3\u0005\n\u0000\u0000\u00b3\u00b8\u0003"+
		"\u0018\f\u0000\u00b4\u00b5\u0005\u0006\u0000\u0000\u00b5\u00b7\u0003\u0018"+
		"\f\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b7\u00ba\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000"+
		"\u0000\u00b9\u00bb\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000"+
		"\u0000\u00bb\u00bc\u0005\u000b\u0000\u0000\u00bc\u00be\u0001\u0000\u0000"+
		"\u0000\u00bd\u00b2\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000"+
		"\u0000\u00be\u00c1\u0001\u0000\u0000\u0000\u00bf\u00c1\u0003>\u001f\u0000"+
		"\u00c0\u00b1\u0001\u0000\u0000\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000"+
		"\u00c1\u0017\u0001\u0000\u0000\u0000\u00c2\u00c6\u0003@ \u0000\u00c3\u00c6"+
		"\u00036\u001b\u0000\u00c4\u00c6\u0003>\u001f\u0000\u00c5\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c6\u0019\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005\r\u0000"+
		"\u0000\u00c8\u00c9\u0003>\u001f\u0000\u00c9\u00ca\u0005\u000e\u0000\u0000"+
		"\u00ca\u00cb\u0003\u001c\u000e\u0000\u00cb\u001b\u0001\u0000\u0000\u0000"+
		"\u00cc\u00cd\u00036\u001b\u0000\u00cd\u00ce\u0003\u001e\u000f\u0000\u00ce"+
		"\u00cf\u0003\u0018\f\u0000\u00cf\u00d9\u0001\u0000\u0000\u0000\u00d0\u00d1"+
		"\u0003>\u001f\u0000\u00d1\u00d2\u0003\u001e\u000f\u0000\u00d2\u00d3\u0003"+
		"\u0018\f\u0000\u00d3\u00d9\u0001\u0000\u0000\u0000\u00d4\u00d5\u00036"+
		"\u001b\u0000\u00d5\u00d6\u0005\u000f\u0000\u0000\u00d6\u00d7\u0005\u0010"+
		"\u0000\u0000\u00d7\u00d9\u0001\u0000\u0000\u0000\u00d8\u00cc\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d0\u0001\u0000\u0000\u0000\u00d8\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d9\u001d\u0001\u0000\u0000\u0000\u00da\u00db\u0007\u0000"+
		"\u0000\u0000\u00db\u001f\u0001\u0000\u0000\u0000\u00dc\u00e0\u0003\"\u0011"+
		"\u0000\u00dd\u00e0\u0003$\u0012\u0000\u00de\u00e0\u0003&\u0013\u0000\u00df"+
		"\u00dc\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00df"+
		"\u00de\u0001\u0000\u0000\u0000\u00e0!\u0001\u0000\u0000\u0000\u00e1\u00e2"+
		"\u0005\u0013\u0000\u0000\u00e2\u00e3\u0005\n\u0000\u0000\u00e3\u00e4\u0003"+
		"\u001c\u000e\u0000\u00e4\u00e5\u0005\u000b\u0000\u0000\u00e5\u00e6\u0003"+
		"0\u0018\u0000\u00e6#\u0001\u0000\u0000\u0000\u00e7\u00e8\u0005\u0014\u0000"+
		"\u0000\u00e8\u00e9\u0005\n\u0000\u0000\u00e9\u00ea\u0003>\u001f\u0000"+
		"\u00ea\u00eb\u0005\u000b\u0000\u0000\u00eb\u00ec\u00030\u0018\u0000\u00ec"+
		"\u00f4\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005\u0014\u0000\u0000\u00ee"+
		"\u00ef\u0003>\u001f\u0000\u00ef\u00f0\u0005\u0015\u0000\u0000\u00f0\u00f1"+
		"\u0003*\u0015\u0000\u00f1\u00f2\u00030\u0018\u0000\u00f2\u00f4\u0001\u0000"+
		"\u0000\u0000\u00f3\u00e7\u0001\u0000\u0000\u0000\u00f3\u00ed\u0001\u0000"+
		"\u0000\u0000\u00f4%\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005\u0016\u0000"+
		"\u0000\u00f6\u00f7\u00036\u001b\u0000\u00f7\u00fb\u0005\u0003\u0000\u0000"+
		"\u00f8\u00fa\u0003\u0002\u0001\u0000\u00f9\u00f8\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fd\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000"+
		"\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fe\u0001\u0000\u0000\u0000"+
		"\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005\u0004\u0000\u0000"+
		"\u00ff\'\u0001\u0000\u0000\u0000\u0100\u0101\u0005\u0017\u0000\u0000\u0101"+
		"\u0102\u0003>\u001f\u0000\u0102\u0103\u0005\u0018\u0000\u0000\u0103\u0104"+
		"\u0003>\u001f\u0000\u0104)\u0001\u0000\u0000\u0000\u0105\u0109\u0003>"+
		"\u001f\u0000\u0106\u0109\u00038\u001c\u0000\u0107\u0109\u00036\u001b\u0000"+
		"\u0108\u0105\u0001\u0000\u0000\u0000\u0108\u0106\u0001\u0000\u0000\u0000"+
		"\u0108\u0107\u0001\u0000\u0000\u0000\u0109+\u0001\u0000\u0000\u0000\u010a"+
		"\u010b\u0005\u0019\u0000\u0000\u010b\u0110\u00032\u0019\u0000\u010c\u010d"+
		"\u0005\u001a\u0000\u0000\u010d\u010e\u0003>\u001f\u0000\u010e\u010f\u0005"+
		"\u001b\u0000\u0000\u010f\u0111\u0001\u0000\u0000\u0000\u0110\u010c\u0001"+
		"\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u011f\u0001"+
		"\u0000\u0000\u0000\u0112\u0113\u0005\u0019\u0000\u0000\u0113\u011a\u0003"+
		"2\u0019\u0000\u0114\u0115\u0005\u0015\u0000\u0000\u0115\u0116\u0005\u001b"+
		"\u0000\u0000\u0116\u0117\u0005\n\u0000\u0000\u0117\u0118\u0003>\u001f"+
		"\u0000\u0118\u0119\u0005\u000b\u0000\u0000\u0119\u011b\u0001\u0000\u0000"+
		"\u0000\u011a\u0114\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000"+
		"\u0000\u011b\u011f\u0001\u0000\u0000\u0000\u011c\u011d\u0005\u0019\u0000"+
		"\u0000\u011d\u011f\u00036\u001b\u0000\u011e\u010a\u0001\u0000\u0000\u0000"+
		"\u011e\u0112\u0001\u0000\u0000\u0000\u011e\u011c\u0001\u0000\u0000\u0000"+
		"\u011f-\u0001\u0000\u0000\u0000\u0120\u0121\u0005\u001c\u0000\u0000\u0121"+
		"\u012a\u00036\u001b\u0000\u0122\u0123\u0005\u001c\u0000\u0000\u0123\u0124"+
		"\u0003>\u001f\u0000\u0124\u0125\u0005\u001d\u0000\u0000\u0125\u0126\u0003"+
		">\u001f\u0000\u0126\u0127\u0005\u0002\u0000\u0000\u0127\u0128\u0003@ "+
		"\u0000\u0128\u012a\u0001\u0000\u0000\u0000\u0129\u0120\u0001\u0000\u0000"+
		"\u0000\u0129\u0122\u0001\u0000\u0000\u0000\u012a/\u0001\u0000\u0000\u0000"+
		"\u012b\u012f\u0005\u0003\u0000\u0000\u012c\u012e\u0003\u0002\u0001\u0000"+
		"\u012d\u012c\u0001\u0000\u0000\u0000\u012e\u0131\u0001\u0000\u0000\u0000"+
		"\u012f\u012d\u0001\u0000\u0000\u0000\u012f\u0130\u0001\u0000\u0000\u0000"+
		"\u0130\u0132\u0001\u0000\u0000\u0000\u0131\u012f\u0001\u0000\u0000\u0000"+
		"\u0132\u0133\u0005\u0004\u0000\u0000\u01331\u0001\u0000\u0000\u0000\u0134"+
		"\u0138\u00034\u001a\u0000\u0135\u0138\u00036\u001b\u0000\u0136\u0138\u0003"+
		"@ \u0000\u0137\u0134\u0001\u0000\u0000\u0000\u0137\u0135\u0001\u0000\u0000"+
		"\u0000\u0137\u0136\u0001\u0000\u0000\u0000\u01383\u0001\u0000\u0000\u0000"+
		"\u0139\u013a\u0005$\u0000\u0000\u013a\u013b\u0003\u001e\u000f\u0000\u013b"+
		"\u013c\u0005$\u0000\u0000\u013c\u0145\u0001\u0000\u0000\u0000\u013d\u013e"+
		"\u0005$\u0000\u0000\u013e\u013f\u0005\u001e\u0000\u0000\u013f\u0145\u0003"+
		"6\u001b\u0000\u0140\u0141\u00036\u001b\u0000\u0141\u0142\u0005\u001e\u0000"+
		"\u0000\u0142\u0143\u0005$\u0000\u0000\u0143\u0145\u0001\u0000\u0000\u0000"+
		"\u0144\u0139\u0001\u0000\u0000\u0000\u0144\u013d\u0001\u0000\u0000\u0000"+
		"\u0144\u0140\u0001\u0000\u0000\u0000\u01455\u0001\u0000\u0000\u0000\u0146"+
		"\u014b\u0003>\u001f\u0000\u0147\u0148\u0005\u001d\u0000\u0000\u0148\u014a"+
		"\u0003>\u001f\u0000\u0149\u0147\u0001\u0000\u0000\u0000\u014a\u014d\u0001"+
		"\u0000\u0000\u0000\u014b\u0149\u0001\u0000\u0000\u0000\u014b\u014c\u0001"+
		"\u0000\u0000\u0000\u014c7\u0001\u0000\u0000\u0000\u014d\u014b\u0001\u0000"+
		"\u0000\u0000\u014e\u0157\u0005\u0003\u0000\u0000\u014f\u0154\u0003\u0018"+
		"\f\u0000\u0150\u0151\u0005\u0006\u0000\u0000\u0151\u0153\u0003\u0018\f"+
		"\u0000\u0152\u0150\u0001\u0000\u0000\u0000\u0153\u0156\u0001\u0000\u0000"+
		"\u0000\u0154\u0152\u0001\u0000\u0000\u0000\u0154\u0155\u0001\u0000\u0000"+
		"\u0000\u0155\u0158\u0001\u0000\u0000\u0000\u0156\u0154\u0001\u0000\u0000"+
		"\u0000\u0157\u014f\u0001\u0000\u0000\u0000\u0157\u0158\u0001\u0000\u0000"+
		"\u0000\u0158\u0159\u0001\u0000\u0000\u0000\u0159\u0166\u0005\u0004\u0000"+
		"\u0000\u015a\u015b\u0005\n\u0000\u0000\u015b\u0160\u0003:\u001d\u0000"+
		"\u015c\u015d\u0005\u0006\u0000\u0000\u015d\u015f\u0003:\u001d\u0000\u015e"+
		"\u015c\u0001\u0000\u0000\u0000\u015f\u0162\u0001\u0000\u0000\u0000\u0160"+
		"\u015e\u0001\u0000\u0000\u0000\u0160\u0161\u0001\u0000\u0000\u0000\u0161"+
		"\u0163\u0001\u0000\u0000\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0163"+
		"\u0164\u0005\u000b\u0000\u0000\u0164\u0166\u0001\u0000\u0000\u0000\u0165"+
		"\u014e\u0001\u0000\u0000\u0000\u0165\u015a\u0001\u0000\u0000\u0000\u0166"+
		"9\u0001\u0000\u0000\u0000\u0167\u016c\u0005!\u0000\u0000\u0168\u0169\u0005"+
		"%\u0000\u0000\u0169\u016a\u0005\u001f\u0000\u0000\u016a\u016c\u0005%\u0000"+
		"\u0000\u016b\u0167\u0001\u0000\u0000\u0000\u016b\u0168\u0001\u0000\u0000"+
		"\u0000\u016c;\u0001\u0000\u0000\u0000\u016d\u016e\u0005\n\u0000\u0000"+
		"\u016e\u016f\u0003\u0018\f\u0000\u016f\u0170\u0005\u000b\u0000\u0000\u0170"+
		"\u0176\u0001\u0000\u0000\u0000\u0171\u0172\u0005\u0003\u0000\u0000\u0172"+
		"\u0173\u0003\f\u0006\u0000\u0173\u0174\u0005\u0004\u0000\u0000\u0174\u0176"+
		"\u0001\u0000\u0000\u0000\u0175\u016d\u0001\u0000\u0000\u0000\u0175\u0171"+
		"\u0001\u0000\u0000\u0000\u0176=\u0001\u0000\u0000\u0000\u0177\u0178\u0007"+
		"\u0001\u0000\u0000\u0178?\u0001\u0000\u0000\u0000\u0179\u017a\u0007\u0002"+
		"\u0000\u0000\u017aA\u0001\u0000\u0000\u0000#EPXdjp|\u008e\u009c\u00a2"+
		"\u00a7\u00ae\u00b8\u00bd\u00c0\u00c5\u00d8\u00df\u00f3\u00fb\u0108\u0110"+
		"\u011a\u011e\u0129\u012f\u0137\u0144\u014b\u0154\u0157\u0160\u0165\u016b"+
		"\u0175";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}