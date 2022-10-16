// Generated from D:/Programs/GitHubRepos/Arangui/src/main/antlr\ArangoParserRules.g4 by ANTLR 4.10.1

    package com.example.arangui.antlr;

    import java.util.*;
    import org.antlr.v4.tool.Rule;
    import com.example.arangui.arango.grammar.AranagoGrammarRulesSingleton;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArangoParserRules}.
 */
public interface ArangoParserRulesListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by {@link ArangoParserRules#insertSt}.
	 * @param ctx the parse tree
	 */
	void enterInsertSt(ArangoParserRules.InsertStContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#insertSt}.
	 * @param ctx the parse tree
	 */
	void exitInsertSt(ArangoParserRules.InsertStContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#forSt}.
	 * @param ctx the parse tree
	 */
	void enterForSt(ArangoParserRules.ForStContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#forSt}.
	 * @param ctx the parse tree
	 */
	void exitForSt(ArangoParserRules.ForStContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#into}.
	 * @param ctx the parse tree
	 */
	void enterInto(ArangoParserRules.IntoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#into}.
	 * @param ctx the parse tree
	 */
	void exitInto(ArangoParserRules.IntoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#forStatements}.
	 * @param ctx the parse tree
	 */
	void enterForStatements(ArangoParserRules.ForStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#forStatements}.
	 * @param ctx the parse tree
	 */
	void exitForStatements(ArangoParserRules.ForStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#keysAndVals}.
	 * @param ctx the parse tree
	 */
	void enterKeysAndVals(ArangoParserRules.KeysAndValsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#keysAndVals}.
	 * @param ctx the parse tree
	 */
	void exitKeysAndVals(ArangoParserRules.KeysAndValsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#keyAndVal}.
	 * @param ctx the parse tree
	 */
	void enterKeyAndVal(ArangoParserRules.KeyAndValContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#keyAndVal}.
	 * @param ctx the parse tree
	 */
	void exitKeyAndVal(ArangoParserRules.KeyAndValContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(ArangoParserRules.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(ArangoParserRules.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(ArangoParserRules.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(ArangoParserRules.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoParserRules#returnSt}.
	 * @param ctx the parse tree
	 */
	void enterReturnSt(ArangoParserRules.ReturnStContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoParserRules#returnSt}.
	 * @param ctx the parse tree
	 */
	void exitReturnSt(ArangoParserRules.ReturnStContext ctx);
}