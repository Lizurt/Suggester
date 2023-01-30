// Generated from D:/Programs/GitHubRepos/Suggester/src/main/antlr\ArangoParserRules.g4 by ANTLR 4.10.1

    package com.lizurt.suggester.antlr;

    import java.util.*;
    import org.antlr.v4.tool.Rule;
    import com.lizurt.suggester.arango.grammar.AranagoGrammarRulesSingleton;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ArangoParserRules}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ArangoParserRulesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#optionalPruneVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalPruneVariable(ArangoParserRules.OptionalPruneVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#withCollection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithCollection(ArangoParserRules.WithCollectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#optionalWith}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalWith(ArangoParserRules.OptionalWithContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#queryStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryStart(ArangoParserRules.QueryStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(ArangoParserRules.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#finalStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalStatement(ArangoParserRules.FinalStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#stataments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStataments(ArangoParserRules.StatamentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#forOutputVars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForOutputVars(ArangoParserRules.ForOutputVarsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#pruneAndOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPruneAndOptions(ArangoParserRules.PruneAndOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#traversalGraphInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTraversalGraphInfo(ArangoParserRules.TraversalGraphInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#shortestGraphInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortestGraphInfo(ArangoParserRules.ShortestGraphInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#kShortestPathsGraphInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKShortestPathsGraphInfo(ArangoParserRules.KShortestPathsGraphInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#kPathsGraphInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKPathsGraphInfo(ArangoParserRules.KPathsGraphInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#allShortestPathsGraphInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllShortestPathsGraphInfo(ArangoParserRules.AllShortestPathsGraphInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(ArangoParserRules.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#filterStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterStatement(ArangoParserRules.FilterStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#letStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetStatement(ArangoParserRules.LetStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#letElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetElement(ArangoParserRules.LetElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#countInto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCountInto(ArangoParserRules.CountIntoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#collectVarList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectVarList(ArangoParserRules.CollectVarListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#collectStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectStatement(ArangoParserRules.CollectStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#collectElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectElement(ArangoParserRules.CollectElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#collectOptionalInto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectOptionalInto(ArangoParserRules.CollectOptionalIntoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#keep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeep(ArangoParserRules.KeepContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#aggregate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregate(ArangoParserRules.AggregateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#aggregateElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateElement(ArangoParserRules.AggregateElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#aggregateFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunctionCall(ArangoParserRules.AggregateFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#sortStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSortStatement(ArangoParserRules.SortStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#sortElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSortElement(ArangoParserRules.SortElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#sortDirection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSortDirection(ArangoParserRules.SortDirectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#limitStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitStatement(ArangoParserRules.LimitStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#windowStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowStatement(ArangoParserRules.WindowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(ArangoParserRules.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#inOrIntoCollection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInOrIntoCollection(ArangoParserRules.InOrIntoCollectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#removeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemoveStatement(ArangoParserRules.RemoveStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#insertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertStatement(ArangoParserRules.InsertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#updateParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateParameters(ArangoParserRules.UpdateParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#updateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateStatement(ArangoParserRules.UpdateStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#replaceParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplaceParameters(ArangoParserRules.ReplaceParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#replaceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplaceStatement(ArangoParserRules.ReplaceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#updateOrReplace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateOrReplace(ArangoParserRules.UpdateOrReplaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#upsertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpsertStatement(ArangoParserRules.UpsertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#quantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifier(ArangoParserRules.QuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#distinctExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDistinctExpression(ArangoParserRules.DistinctExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ArangoParserRules.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#funcName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncName(ArangoParserRules.FuncNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(ArangoParserRules.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#optionalFuncCallParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalFuncCallParams(ArangoParserRules.OptionalFuncCallParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#expressionOrQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionOrQuery(ArangoParserRules.ExpressionOrQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#optionalArrayElems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalArrayElems(ArangoParserRules.OptionalArrayElemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#forOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForOptions(ArangoParserRules.ForOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#statementOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementOptions(ArangoParserRules.StatementOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#optionalObjectElems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalObjectElems(ArangoParserRules.OptionalObjectElemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#objectElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectElem(ArangoParserRules.ObjectElemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#arrayFilterOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayFilterOperator(ArangoParserRules.ArrayFilterOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#arrayMapOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayMapOperator(ArangoParserRules.ArrayMapOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#optionalArrayFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalArrayFilter(ArangoParserRules.OptionalArrayFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#optionalArrayLimit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalArrayLimit(ArangoParserRules.OptionalArrayLimitContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#optionalArrayReturn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalArrayReturn(ArangoParserRules.OptionalArrayReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#graphCollection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphCollection(ArangoParserRules.GraphCollectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#graphSubject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphSubject(ArangoParserRules.GraphSubjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#graphDirection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphDirection(ArangoParserRules.GraphDirectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#graphDirectionSteps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphDirectionSteps(ArangoParserRules.GraphDirectionStepsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(ArangoParserRules.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#in_or_into_collection_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn_or_into_collection_name(ArangoParserRules.In_or_into_collection_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#objecelemenname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjecelemenname(ArangoParserRules.ObjecelemennameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#varName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarName(ArangoParserRules.VarNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#valAnyBindParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValAnyBindParameter(ArangoParserRules.ValAnyBindParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#valBindParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValBindParameter(ArangoParserRules.ValBindParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#valBindDataSourceParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValBindDataSourceParameter(ArangoParserRules.ValBindDataSourceParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#valIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValIdentifier(ArangoParserRules.ValIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#valString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValString(ArangoParserRules.ValStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#valNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValNumber(ArangoParserRules.ValNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#valFloat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValFloat(ArangoParserRules.ValFloatContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#valInt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValInt(ArangoParserRules.ValIntContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#valUint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValUint(ArangoParserRules.ValUintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#valBool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValBool(ArangoParserRules.ValBoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#valObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValObject(ArangoParserRules.ValObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#valCompound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValCompound(ArangoParserRules.ValCompoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#valSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValSimple(ArangoParserRules.ValSimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#valArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValArray(ArangoParserRules.ValArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#valLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValLiteral(ArangoParserRules.ValLiteralContext ctx);
}