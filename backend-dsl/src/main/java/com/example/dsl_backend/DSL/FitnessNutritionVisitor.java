package com.example.dsl_backend.DSL;
// Generated from grammar/FitnessNutrition.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FitnessNutritionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FitnessNutritionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(FitnessNutritionParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(FitnessNutritionParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#createStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateStmt(FitnessNutritionParser.CreateStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#attributeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeList(FitnessNutritionParser.AttributeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(FitnessNutritionParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#generateStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenerateStmt(FitnessNutritionParser.GenerateStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(FitnessNutritionParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(FitnessNutritionParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(FitnessNutritionParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(FitnessNutritionParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#selectStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStmt(FitnessNutritionParser.SelectStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(FitnessNutritionParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(FitnessNutritionParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#loopStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStmt(FitnessNutritionParser.LoopStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(FitnessNutritionParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(FitnessNutritionParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#foreachStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeachStmt(FitnessNutritionParser.ForeachStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#includeStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludeStmt(FitnessNutritionParser.IncludeStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#iterable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterable(FitnessNutritionParser.IterableContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#outputStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputStmt(FitnessNutritionParser.OutputStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#usingStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingStmt(FitnessNutritionParser.UsingStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(FitnessNutritionParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(FitnessNutritionParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#mathExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathExpr(FitnessNutritionParser.MathExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(FitnessNutritionParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(FitnessNutritionParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#timeRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeRange(FitnessNutritionParser.TimeRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(FitnessNutritionParser.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(FitnessNutritionParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link FitnessNutritionParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(FitnessNutritionParser.LiteralContext ctx);
}