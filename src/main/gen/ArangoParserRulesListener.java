// Generated from D:/Programs/GitHubRepos/Suggester/src/main/antlr\ArangoParserRules.g4 by ANTLR 4.10.1

    package com.lizurt.suggester.antlr;

    import java.util.*;
    import org.antlr.v4.tool.Rule;
    import com.lizurt.suggester.arango.grammar.AranagoGrammarRulesSingleton;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArangoParserRules}.
 */
public interface ArangoParserRulesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#optionalPruneVariable}.
	 * @param ctx the parse tree
	 */
	void enterOptionalPruneVariable(ArangoParserRules.OptionalPruneVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#optionalPruneVariable}.
	 * @param ctx the parse tree
	 */
	void exitOptionalPruneVariable(ArangoParserRules.OptionalPruneVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#withCollection}.
	 * @param ctx the parse tree
	 */
	void enterWithCollection(ArangoParserRules.WithCollectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#withCollection}.
	 * @param ctx the parse tree
	 */
	void exitWithCollection(ArangoParserRules.WithCollectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#optionalWith}.
	 * @param ctx the parse tree
	 */
	void enterOptionalWith(ArangoParserRules.OptionalWithContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#optionalWith}.
	 * @param ctx the parse tree
	 */
	void exitOptionalWith(ArangoParserRules.OptionalWithContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#queryStart}.
	 * @param ctx the parse tree
	 */
	void enterQueryStart(ArangoParserRules.QueryStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#queryStart}.
	 * @param ctx the parse tree
	 */
	void exitQueryStart(ArangoParserRules.QueryStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(ArangoParserRules.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(ArangoParserRules.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#finalStatement}.
	 * @param ctx the parse tree
	 */
	void enterFinalStatement(ArangoParserRules.FinalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#finalStatement}.
	 * @param ctx the parse tree
	 */
	void exitFinalStatement(ArangoParserRules.FinalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#stataments}.
	 * @param ctx the parse tree
	 */
	void enterStataments(ArangoParserRules.StatamentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#stataments}.
	 * @param ctx the parse tree
	 */
	void exitStataments(ArangoParserRules.StatamentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#forOutputVars}.
	 * @param ctx the parse tree
	 */
	void enterForOutputVars(ArangoParserRules.ForOutputVarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#forOutputVars}.
	 * @param ctx the parse tree
	 */
	void exitForOutputVars(ArangoParserRules.ForOutputVarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#pruneAndOptions}.
	 * @param ctx the parse tree
	 */
	void enterPruneAndOptions(ArangoParserRules.PruneAndOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#pruneAndOptions}.
	 * @param ctx the parse tree
	 */
	void exitPruneAndOptions(ArangoParserRules.PruneAndOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#traversalGraphInfo}.
	 * @param ctx the parse tree
	 */
	void enterTraversalGraphInfo(ArangoParserRules.TraversalGraphInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#traversalGraphInfo}.
	 * @param ctx the parse tree
	 */
	void exitTraversalGraphInfo(ArangoParserRules.TraversalGraphInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#shortestGraphInfo}.
	 * @param ctx the parse tree
	 */
	void enterShortestGraphInfo(ArangoParserRules.ShortestGraphInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#shortestGraphInfo}.
	 * @param ctx the parse tree
	 */
	void exitShortestGraphInfo(ArangoParserRules.ShortestGraphInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#kShortestPathsGraphInfo}.
	 * @param ctx the parse tree
	 */
	void enterKShortestPathsGraphInfo(ArangoParserRules.KShortestPathsGraphInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#kShortestPathsGraphInfo}.
	 * @param ctx the parse tree
	 */
	void exitKShortestPathsGraphInfo(ArangoParserRules.KShortestPathsGraphInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#kPathsGraphInfo}.
	 * @param ctx the parse tree
	 */
	void enterKPathsGraphInfo(ArangoParserRules.KPathsGraphInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#kPathsGraphInfo}.
	 * @param ctx the parse tree
	 */
	void exitKPathsGraphInfo(ArangoParserRules.KPathsGraphInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#allShortestPathsGraphInfo}.
	 * @param ctx the parse tree
	 */
	void enterAllShortestPathsGraphInfo(ArangoParserRules.AllShortestPathsGraphInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#allShortestPathsGraphInfo}.
	 * @param ctx the parse tree
	 */
	void exitAllShortestPathsGraphInfo(ArangoParserRules.AllShortestPathsGraphInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(ArangoParserRules.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(ArangoParserRules.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#filterStatement}.
	 * @param ctx the parse tree
	 */
	void enterFilterStatement(ArangoParserRules.FilterStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#filterStatement}.
	 * @param ctx the parse tree
	 */
	void exitFilterStatement(ArangoParserRules.FilterStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#letStatement}.
	 * @param ctx the parse tree
	 */
	void enterLetStatement(ArangoParserRules.LetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#letStatement}.
	 * @param ctx the parse tree
	 */
	void exitLetStatement(ArangoParserRules.LetStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#letElement}.
	 * @param ctx the parse tree
	 */
	void enterLetElement(ArangoParserRules.LetElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#letElement}.
	 * @param ctx the parse tree
	 */
	void exitLetElement(ArangoParserRules.LetElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#countInto}.
	 * @param ctx the parse tree
	 */
	void enterCountInto(ArangoParserRules.CountIntoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#countInto}.
	 * @param ctx the parse tree
	 */
	void exitCountInto(ArangoParserRules.CountIntoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#collectVarList}.
	 * @param ctx the parse tree
	 */
	void enterCollectVarList(ArangoParserRules.CollectVarListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#collectVarList}.
	 * @param ctx the parse tree
	 */
	void exitCollectVarList(ArangoParserRules.CollectVarListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#collectStatement}.
	 * @param ctx the parse tree
	 */
	void enterCollectStatement(ArangoParserRules.CollectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#collectStatement}.
	 * @param ctx the parse tree
	 */
	void exitCollectStatement(ArangoParserRules.CollectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#collectElement}.
	 * @param ctx the parse tree
	 */
	void enterCollectElement(ArangoParserRules.CollectElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#collectElement}.
	 * @param ctx the parse tree
	 */
	void exitCollectElement(ArangoParserRules.CollectElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#collectOptionalInto}.
	 * @param ctx the parse tree
	 */
	void enterCollectOptionalInto(ArangoParserRules.CollectOptionalIntoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#collectOptionalInto}.
	 * @param ctx the parse tree
	 */
	void exitCollectOptionalInto(ArangoParserRules.CollectOptionalIntoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#keep}.
	 * @param ctx the parse tree
	 */
	void enterKeep(ArangoParserRules.KeepContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#keep}.
	 * @param ctx the parse tree
	 */
	void exitKeep(ArangoParserRules.KeepContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#aggregate}.
	 * @param ctx the parse tree
	 */
	void enterAggregate(ArangoParserRules.AggregateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#aggregate}.
	 * @param ctx the parse tree
	 */
	void exitAggregate(ArangoParserRules.AggregateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#aggregateElement}.
	 * @param ctx the parse tree
	 */
	void enterAggregateElement(ArangoParserRules.AggregateElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#aggregateElement}.
	 * @param ctx the parse tree
	 */
	void exitAggregateElement(ArangoParserRules.AggregateElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#aggregateFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterAggregateFunctionCall(ArangoParserRules.AggregateFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#aggregateFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitAggregateFunctionCall(ArangoParserRules.AggregateFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#sortStatement}.
	 * @param ctx the parse tree
	 */
	void enterSortStatement(ArangoParserRules.SortStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#sortStatement}.
	 * @param ctx the parse tree
	 */
	void exitSortStatement(ArangoParserRules.SortStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#sortElement}.
	 * @param ctx the parse tree
	 */
	void enterSortElement(ArangoParserRules.SortElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#sortElement}.
	 * @param ctx the parse tree
	 */
	void exitSortElement(ArangoParserRules.SortElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#sortDirection}.
	 * @param ctx the parse tree
	 */
	void enterSortDirection(ArangoParserRules.SortDirectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#sortDirection}.
	 * @param ctx the parse tree
	 */
	void exitSortDirection(ArangoParserRules.SortDirectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#limitStatement}.
	 * @param ctx the parse tree
	 */
	void enterLimitStatement(ArangoParserRules.LimitStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#limitStatement}.
	 * @param ctx the parse tree
	 */
	void exitLimitStatement(ArangoParserRules.LimitStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#windowStatement}.
	 * @param ctx the parse tree
	 */
	void enterWindowStatement(ArangoParserRules.WindowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#windowStatement}.
	 * @param ctx the parse tree
	 */
	void exitWindowStatement(ArangoParserRules.WindowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(ArangoParserRules.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(ArangoParserRules.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#inOrIntoCollection}.
	 * @param ctx the parse tree
	 */
	void enterInOrIntoCollection(ArangoParserRules.InOrIntoCollectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#inOrIntoCollection}.
	 * @param ctx the parse tree
	 */
	void exitInOrIntoCollection(ArangoParserRules.InOrIntoCollectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#removeStatement}.
	 * @param ctx the parse tree
	 */
	void enterRemoveStatement(ArangoParserRules.RemoveStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#removeStatement}.
	 * @param ctx the parse tree
	 */
	void exitRemoveStatement(ArangoParserRules.RemoveStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#insertStatement}.
	 * @param ctx the parse tree
	 */
	void enterInsertStatement(ArangoParserRules.InsertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#insertStatement}.
	 * @param ctx the parse tree
	 */
	void exitInsertStatement(ArangoParserRules.InsertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#updateParameters}.
	 * @param ctx the parse tree
	 */
	void enterUpdateParameters(ArangoParserRules.UpdateParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#updateParameters}.
	 * @param ctx the parse tree
	 */
	void exitUpdateParameters(ArangoParserRules.UpdateParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#updateStatement}.
	 * @param ctx the parse tree
	 */
	void enterUpdateStatement(ArangoParserRules.UpdateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#updateStatement}.
	 * @param ctx the parse tree
	 */
	void exitUpdateStatement(ArangoParserRules.UpdateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#replaceParameters}.
	 * @param ctx the parse tree
	 */
	void enterReplaceParameters(ArangoParserRules.ReplaceParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#replaceParameters}.
	 * @param ctx the parse tree
	 */
	void exitReplaceParameters(ArangoParserRules.ReplaceParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#replaceStatement}.
	 * @param ctx the parse tree
	 */
	void enterReplaceStatement(ArangoParserRules.ReplaceStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#replaceStatement}.
	 * @param ctx the parse tree
	 */
	void exitReplaceStatement(ArangoParserRules.ReplaceStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#updateOrReplace}.
	 * @param ctx the parse tree
	 */
	void enterUpdateOrReplace(ArangoParserRules.UpdateOrReplaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#updateOrReplace}.
	 * @param ctx the parse tree
	 */
	void exitUpdateOrReplace(ArangoParserRules.UpdateOrReplaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#upsertStatement}.
	 * @param ctx the parse tree
	 */
	void enterUpsertStatement(ArangoParserRules.UpsertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#upsertStatement}.
	 * @param ctx the parse tree
	 */
	void exitUpsertStatement(ArangoParserRules.UpsertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterQuantifier(ArangoParserRules.QuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitQuantifier(ArangoParserRules.QuantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#distinctExpression}.
	 * @param ctx the parse tree
	 */
	void enterDistinctExpression(ArangoParserRules.DistinctExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#distinctExpression}.
	 * @param ctx the parse tree
	 */
	void exitDistinctExpression(ArangoParserRules.DistinctExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ArangoParserRules.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ArangoParserRules.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#funcName}.
	 * @param ctx the parse tree
	 */
	void enterFuncName(ArangoParserRules.FuncNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#funcName}.
	 * @param ctx the parse tree
	 */
	void exitFuncName(ArangoParserRules.FuncNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(ArangoParserRules.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(ArangoParserRules.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#optionalFuncCallParams}.
	 * @param ctx the parse tree
	 */
	void enterOptionalFuncCallParams(ArangoParserRules.OptionalFuncCallParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#optionalFuncCallParams}.
	 * @param ctx the parse tree
	 */
	void exitOptionalFuncCallParams(ArangoParserRules.OptionalFuncCallParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#expressionOrQuery}.
	 * @param ctx the parse tree
	 */
	void enterExpressionOrQuery(ArangoParserRules.ExpressionOrQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#expressionOrQuery}.
	 * @param ctx the parse tree
	 */
	void exitExpressionOrQuery(ArangoParserRules.ExpressionOrQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#optionalArrayElems}.
	 * @param ctx the parse tree
	 */
	void enterOptionalArrayElems(ArangoParserRules.OptionalArrayElemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#optionalArrayElems}.
	 * @param ctx the parse tree
	 */
	void exitOptionalArrayElems(ArangoParserRules.OptionalArrayElemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#forOptions}.
	 * @param ctx the parse tree
	 */
	void enterForOptions(ArangoParserRules.ForOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#forOptions}.
	 * @param ctx the parse tree
	 */
	void exitForOptions(ArangoParserRules.ForOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#statementOptions}.
	 * @param ctx the parse tree
	 */
	void enterStatementOptions(ArangoParserRules.StatementOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#statementOptions}.
	 * @param ctx the parse tree
	 */
	void exitStatementOptions(ArangoParserRules.StatementOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#optionalObjectElems}.
	 * @param ctx the parse tree
	 */
	void enterOptionalObjectElems(ArangoParserRules.OptionalObjectElemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#optionalObjectElems}.
	 * @param ctx the parse tree
	 */
	void exitOptionalObjectElems(ArangoParserRules.OptionalObjectElemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#objectElem}.
	 * @param ctx the parse tree
	 */
	void enterObjectElem(ArangoParserRules.ObjectElemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#objectElem}.
	 * @param ctx the parse tree
	 */
	void exitObjectElem(ArangoParserRules.ObjectElemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#arrayFilterOperator}.
	 * @param ctx the parse tree
	 */
	void enterArrayFilterOperator(ArangoParserRules.ArrayFilterOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#arrayFilterOperator}.
	 * @param ctx the parse tree
	 */
	void exitArrayFilterOperator(ArangoParserRules.ArrayFilterOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#arrayMapOperator}.
	 * @param ctx the parse tree
	 */
	void enterArrayMapOperator(ArangoParserRules.ArrayMapOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#arrayMapOperator}.
	 * @param ctx the parse tree
	 */
	void exitArrayMapOperator(ArangoParserRules.ArrayMapOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#optionalArrayFilter}.
	 * @param ctx the parse tree
	 */
	void enterOptionalArrayFilter(ArangoParserRules.OptionalArrayFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#optionalArrayFilter}.
	 * @param ctx the parse tree
	 */
	void exitOptionalArrayFilter(ArangoParserRules.OptionalArrayFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#optionalArrayLimit}.
	 * @param ctx the parse tree
	 */
	void enterOptionalArrayLimit(ArangoParserRules.OptionalArrayLimitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#optionalArrayLimit}.
	 * @param ctx the parse tree
	 */
	void exitOptionalArrayLimit(ArangoParserRules.OptionalArrayLimitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#optionalArrayReturn}.
	 * @param ctx the parse tree
	 */
	void enterOptionalArrayReturn(ArangoParserRules.OptionalArrayReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#optionalArrayReturn}.
	 * @param ctx the parse tree
	 */
	void exitOptionalArrayReturn(ArangoParserRules.OptionalArrayReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#graphCollection}.
	 * @param ctx the parse tree
	 */
	void enterGraphCollection(ArangoParserRules.GraphCollectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#graphCollection}.
	 * @param ctx the parse tree
	 */
	void exitGraphCollection(ArangoParserRules.GraphCollectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#graphSubject}.
	 * @param ctx the parse tree
	 */
	void enterGraphSubject(ArangoParserRules.GraphSubjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#graphSubject}.
	 * @param ctx the parse tree
	 */
	void exitGraphSubject(ArangoParserRules.GraphSubjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#graphDirection}.
	 * @param ctx the parse tree
	 */
	void enterGraphDirection(ArangoParserRules.GraphDirectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#graphDirection}.
	 * @param ctx the parse tree
	 */
	void exitGraphDirection(ArangoParserRules.GraphDirectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#graphDirectionSteps}.
	 * @param ctx the parse tree
	 */
	void enterGraphDirectionSteps(ArangoParserRules.GraphDirectionStepsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#graphDirectionSteps}.
	 * @param ctx the parse tree
	 */
	void exitGraphDirectionSteps(ArangoParserRules.GraphDirectionStepsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(ArangoParserRules.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(ArangoParserRules.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#in_or_into_collection_name}.
	 * @param ctx the parse tree
	 */
	void enterIn_or_into_collection_name(ArangoParserRules.In_or_into_collection_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#in_or_into_collection_name}.
	 * @param ctx the parse tree
	 */
	void exitIn_or_into_collection_name(ArangoParserRules.In_or_into_collection_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#objecelemenname}.
	 * @param ctx the parse tree
	 */
	void enterObjecelemenname(ArangoParserRules.ObjecelemennameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#objecelemenname}.
	 * @param ctx the parse tree
	 */
	void exitObjecelemenname(ArangoParserRules.ObjecelemennameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#varName}.
	 * @param ctx the parse tree
	 */
	void enterVarName(ArangoParserRules.VarNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#varName}.
	 * @param ctx the parse tree
	 */
	void exitVarName(ArangoParserRules.VarNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#valAnyBindParameter}.
	 * @param ctx the parse tree
	 */
	void enterValAnyBindParameter(ArangoParserRules.ValAnyBindParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#valAnyBindParameter}.
	 * @param ctx the parse tree
	 */
	void exitValAnyBindParameter(ArangoParserRules.ValAnyBindParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#valBindParameter}.
	 * @param ctx the parse tree
	 */
	void enterValBindParameter(ArangoParserRules.ValBindParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#valBindParameter}.
	 * @param ctx the parse tree
	 */
	void exitValBindParameter(ArangoParserRules.ValBindParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#valBindDataSourceParameter}.
	 * @param ctx the parse tree
	 */
	void enterValBindDataSourceParameter(ArangoParserRules.ValBindDataSourceParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#valBindDataSourceParameter}.
	 * @param ctx the parse tree
	 */
	void exitValBindDataSourceParameter(ArangoParserRules.ValBindDataSourceParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#valIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterValIdentifier(ArangoParserRules.ValIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#valIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitValIdentifier(ArangoParserRules.ValIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#valString}.
	 * @param ctx the parse tree
	 */
	void enterValString(ArangoParserRules.ValStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#valString}.
	 * @param ctx the parse tree
	 */
	void exitValString(ArangoParserRules.ValStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#valNumber}.
	 * @param ctx the parse tree
	 */
	void enterValNumber(ArangoParserRules.ValNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#valNumber}.
	 * @param ctx the parse tree
	 */
	void exitValNumber(ArangoParserRules.ValNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#valFloat}.
	 * @param ctx the parse tree
	 */
	void enterValFloat(ArangoParserRules.ValFloatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#valFloat}.
	 * @param ctx the parse tree
	 */
	void exitValFloat(ArangoParserRules.ValFloatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#valInt}.
	 * @param ctx the parse tree
	 */
	void enterValInt(ArangoParserRules.ValIntContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#valInt}.
	 * @param ctx the parse tree
	 */
	void exitValInt(ArangoParserRules.ValIntContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#valUint}.
	 * @param ctx the parse tree
	 */
	void enterValUint(ArangoParserRules.ValUintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#valUint}.
	 * @param ctx the parse tree
	 */
	void exitValUint(ArangoParserRules.ValUintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#valBool}.
	 * @param ctx the parse tree
	 */
	void enterValBool(ArangoParserRules.ValBoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#valBool}.
	 * @param ctx the parse tree
	 */
	void exitValBool(ArangoParserRules.ValBoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#valObject}.
	 * @param ctx the parse tree
	 */
	void enterValObject(ArangoParserRules.ValObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#valObject}.
	 * @param ctx the parse tree
	 */
	void exitValObject(ArangoParserRules.ValObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#valCompound}.
	 * @param ctx the parse tree
	 */
	void enterValCompound(ArangoParserRules.ValCompoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#valCompound}.
	 * @param ctx the parse tree
	 */
	void exitValCompound(ArangoParserRules.ValCompoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#valSimple}.
	 * @param ctx the parse tree
	 */
	void enterValSimple(ArangoParserRules.ValSimpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#valSimple}.
	 * @param ctx the parse tree
	 */
	void exitValSimple(ArangoParserRules.ValSimpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#valArray}.
	 * @param ctx the parse tree
	 */
	void enterValArray(ArangoParserRules.ValArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#valArray}.
	 * @param ctx the parse tree
	 */
	void exitValArray(ArangoParserRules.ValArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#valLiteral}.
	 * @param ctx the parse tree
	 */
	void enterValLiteral(ArangoParserRules.ValLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#valLiteral}.
	 * @param ctx the parse tree
	 */
	void exitValLiteral(ArangoParserRules.ValLiteralContext ctx);
}