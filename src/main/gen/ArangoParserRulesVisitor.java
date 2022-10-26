// Generated from D:/Programs/GitHubRepos/Arangui/src/main/antlr\ArangoParserRules.g4 by ANTLR 4.10.1

    package com.example.arangui.antlr;

    import java.util.*;
    import org.antlr.v4.tool.Rule;
    import com.example.arangui.arango.grammar.AranagoGrammarRulesSingleton;

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
	 * Visit a parse tree produced by {@link ArangoParserRules#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(ArangoParserRules.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#insert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert(ArangoParserRules.InsertContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(ArangoParserRules.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#into}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInto(ArangoParserRules.IntoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#forStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatements(ArangoParserRules.ForStatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#keysAndVals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeysAndVals(ArangoParserRules.KeysAndValsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#keyAndVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyAndVal(ArangoParserRules.KeyAndValContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(ArangoParserRules.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(ArangoParserRules.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArangoParserRules#returnSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnSt(ArangoParserRules.ReturnStContext ctx);
}