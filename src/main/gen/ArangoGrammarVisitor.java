// Generated from D:/Programs/GitHubRepos/Arangui/src/main/antlr\ArangoGrammar.g4 by ANTLR 4.10.1

    package com.example.arangui.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ArangoGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ArangoGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ArangoGrammarParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(ArangoGrammarParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoGrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ArangoGrammarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoGrammarParser#insert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert(ArangoGrammarParser.InsertContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoGrammarParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(ArangoGrammarParser.ForLoopContext ctx);
}