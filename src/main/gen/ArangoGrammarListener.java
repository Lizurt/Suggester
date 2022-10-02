// Generated from D:/Programs/GitHubRepos/Arangui/src/main/antlr\ArangoGrammar.g4 by ANTLR 4.10.1

    package com.example.arangui.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArangoGrammarParser}.
 */
public interface ArangoGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ArangoGrammarParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(ArangoGrammarParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoGrammarParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(ArangoGrammarParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ArangoGrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ArangoGrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoGrammarParser#insert}.
	 * @param ctx the parse tree
	 */
	void enterInsert(ArangoGrammarParser.InsertContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoGrammarParser#insert}.
	 * @param ctx the parse tree
	 */
	void exitInsert(ArangoGrammarParser.InsertContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArangoGrammarParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(ArangoGrammarParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArangoGrammarParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(ArangoGrammarParser.ForLoopContext ctx);
}