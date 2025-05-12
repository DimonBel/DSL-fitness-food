// Generated from C:\Users\Duma\OneDrive\������� ����\DSL\DSL-fitness-food\DSL\grammar\FitnessNutrition.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FitnessNutritionParser}.
 */
public interface FitnessNutritionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(FitnessNutritionParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(FitnessNutritionParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(FitnessNutritionParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(FitnessNutritionParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#exercisesStmt}.
	 * @param ctx the parse tree
	 */
	void enterExercisesStmt(FitnessNutritionParser.ExercisesStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#exercisesStmt}.
	 * @param ctx the parse tree
	 */
	void exitExercisesStmt(FitnessNutritionParser.ExercisesStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#exerciseEntry}.
	 * @param ctx the parse tree
	 */
	void enterExerciseEntry(FitnessNutritionParser.ExerciseEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#exerciseEntry}.
	 * @param ctx the parse tree
	 */
	void exitExerciseEntry(FitnessNutritionParser.ExerciseEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#exerciseParams}.
	 * @param ctx the parse tree
	 */
	void enterExerciseParams(FitnessNutritionParser.ExerciseParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#exerciseParams}.
	 * @param ctx the parse tree
	 */
	void exitExerciseParams(FitnessNutritionParser.ExerciseParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#createStmt}.
	 * @param ctx the parse tree
	 */
	void enterCreateStmt(FitnessNutritionParser.CreateStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#createStmt}.
	 * @param ctx the parse tree
	 */
	void exitCreateStmt(FitnessNutritionParser.CreateStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#attributeList}.
	 * @param ctx the parse tree
	 */
	void enterAttributeList(FitnessNutritionParser.AttributeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#attributeList}.
	 * @param ctx the parse tree
	 */
	void exitAttributeList(FitnessNutritionParser.AttributeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(FitnessNutritionParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(FitnessNutritionParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#generateStmt}.
	 * @param ctx the parse tree
	 */
	void enterGenerateStmt(FitnessNutritionParser.GenerateStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#generateStmt}.
	 * @param ctx the parse tree
	 */
	void exitGenerateStmt(FitnessNutritionParser.GenerateStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(FitnessNutritionParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(FitnessNutritionParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(FitnessNutritionParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(FitnessNutritionParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(FitnessNutritionParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(FitnessNutritionParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(FitnessNutritionParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(FitnessNutritionParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#selectStmt}.
	 * @param ctx the parse tree
	 */
	void enterSelectStmt(FitnessNutritionParser.SelectStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#selectStmt}.
	 * @param ctx the parse tree
	 */
	void exitSelectStmt(FitnessNutritionParser.SelectStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(FitnessNutritionParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(FitnessNutritionParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(FitnessNutritionParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(FitnessNutritionParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#loopStmt}.
	 * @param ctx the parse tree
	 */
	void enterLoopStmt(FitnessNutritionParser.LoopStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#loopStmt}.
	 * @param ctx the parse tree
	 */
	void exitLoopStmt(FitnessNutritionParser.LoopStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(FitnessNutritionParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(FitnessNutritionParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(FitnessNutritionParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(FitnessNutritionParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#foreachStmt}.
	 * @param ctx the parse tree
	 */
	void enterForeachStmt(FitnessNutritionParser.ForeachStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#foreachStmt}.
	 * @param ctx the parse tree
	 */
	void exitForeachStmt(FitnessNutritionParser.ForeachStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#includeStmt}.
	 * @param ctx the parse tree
	 */
	void enterIncludeStmt(FitnessNutritionParser.IncludeStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#includeStmt}.
	 * @param ctx the parse tree
	 */
	void exitIncludeStmt(FitnessNutritionParser.IncludeStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#iterable}.
	 * @param ctx the parse tree
	 */
	void enterIterable(FitnessNutritionParser.IterableContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#iterable}.
	 * @param ctx the parse tree
	 */
	void exitIterable(FitnessNutritionParser.IterableContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#outputStmt}.
	 * @param ctx the parse tree
	 */
	void enterOutputStmt(FitnessNutritionParser.OutputStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#outputStmt}.
	 * @param ctx the parse tree
	 */
	void exitOutputStmt(FitnessNutritionParser.OutputStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#usingStmt}.
	 * @param ctx the parse tree
	 */
	void enterUsingStmt(FitnessNutritionParser.UsingStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#usingStmt}.
	 * @param ctx the parse tree
	 */
	void exitUsingStmt(FitnessNutritionParser.UsingStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(FitnessNutritionParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(FitnessNutritionParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(FitnessNutritionParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(FitnessNutritionParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#mathExpr}.
	 * @param ctx the parse tree
	 */
	void enterMathExpr(FitnessNutritionParser.MathExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#mathExpr}.
	 * @param ctx the parse tree
	 */
	void exitMathExpr(FitnessNutritionParser.MathExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(FitnessNutritionParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(FitnessNutritionParser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(FitnessNutritionParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(FitnessNutritionParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#timeRange}.
	 * @param ctx the parse tree
	 */
	void enterTimeRange(FitnessNutritionParser.TimeRangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#timeRange}.
	 * @param ctx the parse tree
	 */
	void exitTimeRange(FitnessNutritionParser.TimeRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(FitnessNutritionParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(FitnessNutritionParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(FitnessNutritionParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(FitnessNutritionParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link FitnessNutritionParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(FitnessNutritionParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link FitnessNutritionParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(FitnessNutritionParser.LiteralContext ctx);
}