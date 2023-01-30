parser grammar ArangoParserRules;
options {
    tokenVocab = ArangoLexerRules;
}
@header {
    package com.lizurt.suggester.antlr;

    import java.util.*;
    import org.antlr.v4.tool.Rule;
    import com.lizurt.suggester.arango.grammar.ArangoGrammarRulesSingleton;
}
@parser::members {
    public final static int CONTEXT_POSTFIX_LENGTH = 7;

    private final static List<Class<?>> allContextClasses = Arrays.asList(ArangoParserRules.class.getDeclaredClasses());

    private final static Map<Class<? extends ParseTree>, Rule> rulesByContextClasses = new HashMap<>();

    public ArangoParserRules(TokenStream input, boolean shouldInitRulesByContextClassesMap) {
        this(input);
        if (shouldInitRulesByContextClassesMap) {
            initRulesByContextClassesMap();
        }
    }

    private void initRulesByContextClassesMap() {
        for (Class<?> contextClass : allContextClasses) {
            String rawContextClassName = contextClass.getSimpleName();
            // camelCasing the name
            String contextClassName = String.valueOf(Character.toLowerCase(rawContextClassName.charAt(0)));
            // the first symbol was camelCased already, so we start from a 2nd char.
            // We also need to remove the "Context" postfix
            contextClassName += rawContextClassName.substring(1, rawContextClassName.length() - CONTEXT_POSTFIX_LENGTH);
            if (!ArangoGrammarRulesSingleton.getInstance().getParserRulesByNames().containsKey(contextClassName)) {
                throw new RuntimeException("Cannot find a parser rule by such context class name: \""
                    + contextClassName + "\"."
                );
            }
            Rule parserRule = ArangoGrammarRulesSingleton.getInstance().getParserRulesByNames().get(contextClassName);
            rulesByContextClasses.put((Class<? extends ParseTree>) contextClass, parserRule);
        }
    }

    public static Rule getRuleByContextClass(Class<? extends ParseTree> contextClass) {
        return rulesByContextClasses.containsKey(contextClass) ? rulesByContextClasses.get(contextClass) : null;
    }
}

queryStart
    : with? query
    ;

query
    : statement+
    ;

pruneVar
    : expression
    | varName OP_ASSIGN expression
    ;

withCollection
    : valIdentifier
    | valAnyBindParameter
    ;

with
    : WITH withCollection (CHAR_COMMA withCollection)*
    ;

finalStatement
    : returnStatement
    | removeStatement
    | insertStatement
    | updateStatement
    | replaceStatement
    | upsertStatement
    ;

statement
    : forStatement
    | letStatement
    | filterStatement
    | collectStatement
    | sortStatement
    | limitStatement
    | windowStatement
    | removeStatement
    | insertStatement
    | updateStatement
    | replaceStatement
    | upsertStatement
    ;

forOutputVars
    : varName (CHAR_COMMA varName)*
    ;

pruneAndOptions
    : valIdentifier pruneVar
    | valIdentifier pruneVar valIdentifier valObject
    ;

traversalGraphInfo
    : graphDirectionSteps expression graphSubject
    ;

shortestGraphInfo
    : graphDirection SHORTEST_PATH expression valIdentifier expression graphSubject statementOptions?
    ;

kShortestPathsGraphInfo
    : graphDirection K_SHORTEST_PATHS expression valIdentifier expression graphSubject statementOptions?
    ;

kPathsGraphInfo
    : graphDirectionSteps K_PATHS expression valIdentifier expression graphSubject statementOptions?
    ;

allShortestPathsGraphInfo
    : graphDirection ALL_SHORTEST_PATHS expression valIdentifier expression graphSubject statementOptions?
    ;

forStatement
    : FOR forOutputVars IN expression forOptions?
    | FOR forOutputVars IN traversalGraphInfo pruneAndOptions?
    | FOR forOutputVars IN shortestGraphInfo
    | FOR forOutputVars IN kShortestPathsGraphInfo
    | FOR forOutputVars IN kPathsGraphInfo
    | FOR forOutputVars IN allShortestPathsGraphInfo
    ;

filterStatement
    : FILTER expression
    ;

letStatement
    : LET letElement (CHAR_COMMA letElement)*
    ;

letElement
    : varName OP_ASSIGN expression
    ;

countInto
    : WITH valIdentifier INTO varName
    ;

collectVarList
    : COLLECT collectElement (CHAR_COMMA collectElement)*
    ;

collectStatement
    : COLLECT countInto statementOptions?
    | collectVarList countInto statementOptions?
    | COLLECT aggregate collectInto? statementOptions?
    | collectVarList aggregate collectInto? statementOptions?
    | collectVarList collectInto? statementOptions?
    | collectVarList collectInto? keep statementOptions?
    ;

collectElement
    : varName OP_ASSIGN expression
    ;

collectInto
    : INTO varName
    | INTO varName OP_ASSIGN expression
    ;

keep
    : valIdentifier varName (CHAR_COMMA varName)*
    ;

aggregate
    : AGGREGATE aggregateElement (CHAR_COMMA aggregateElement)*
    ;

aggregateElement
    : varName OP_ASSIGN aggregateFunctionCall
    ;

aggregateFunctionCall
    : funcName CHAR_L_ROUND_BR funcCallParams? CHAR_R_ROUND_BR
    ;

sortStatement
    : SORT sortElement (CHAR_COMMA sortElement)*
    ;

sortElement
    : expression sortDirection?
    ;

sortDirection
    : ASC
    | DESC
    | valSimple
    ;

limitStatement
    : LIMIT expression
    | LIMIT expression CHAR_COMMA expression
    ;

windowStatement
    : WINDOW valObject aggregate
    | WINDOW expression WITH valObject aggregate
    ;

returnStatement
    : RETURN distinctExpression
    ;

inOrIntoCollection
    : IN inOrOutCollectionName
    | INTO inOrOutCollectionName
    ;

removeStatement
    : REMOVE expression inOrIntoCollection statementOptions?
    ;

insertStatement
    : INSERT expression inOrIntoCollection statementOptions?
    ;

updateParameters
    : expression inOrIntoCollection statementOptions?
    | expression WITH expression inOrIntoCollection statementOptions?
    ;

updateStatement
    : UPDATE updateParameters
    ;

replaceParameters
    : expression inOrIntoCollection statementOptions?
    | expression WITH expression inOrIntoCollection statementOptions?
    ;

replaceStatement
    : REPLACE replaceParameters
    ;

updateOrReplace
    : UPDATE
    | REPLACE
    ;

upsertStatement
    : UPSERT expression INSERT expression updateOrReplace expression inOrIntoCollection statementOptions?
    ;

quantifier
    : ALL
    | ANY
    | NONE
    ;

distinctExpression
    : DISTINCT expression
    | expression
    ;

expression
    : OP_ADD expression
    | OP_SUB expression
    | OP_NOT expression
    | expression OP_OR expression
    | expression OP_AND expression
    | expression OP_ADD expression
    | expression OP_SUB expression
    | expression OP_MUL expression
    | expression OP_DIV expression
    | expression OP_MOD expression
    | expression OP_EQ expression
    | expression OP_NE expression
    | expression OP_LT expression
    | expression OP_GT expression
    | expression OP_LE expression
    | expression OP_GE expression
    | expression OP_IN expression
    | expression OP_NOT_IN expression
    | expression OP_NOT_LIKE expression
    | expression OP_NOT OP_MATCHES_REGEXP expression
    | expression OP_NOT OP_DOESNT_MATCH_REGEXP expression
    | expression OP_LIKE expression
    | expression OP_MATCHES_REGEXP expression
    | expression OP_DOESNT_MATCH_REGEXP expression
    | expression quantifier OP_EQ expression
    | expression quantifier OP_NE expression
    | expression quantifier OP_LT expression
    | expression quantifier OP_GT expression
    | expression quantifier OP_LE expression
    | expression quantifier OP_GE expression
    | expression quantifier OP_IN expression
    | expression quantifier OP_NOT_IN expression
    | expression AT_LEAST CHAR_L_ROUND_BR expression CHAR_R_ROUND_BR OP_EQ expression
    | expression AT_LEAST CHAR_L_ROUND_BR expression CHAR_R_ROUND_BR OP_LT expression
    | expression AT_LEAST CHAR_L_ROUND_BR expression CHAR_R_ROUND_BR OP_NE expression
    | expression AT_LEAST CHAR_L_ROUND_BR expression CHAR_R_ROUND_BR OP_GT expression
    | expression AT_LEAST CHAR_L_ROUND_BR expression CHAR_R_ROUND_BR OP_LE expression
    | expression AT_LEAST CHAR_L_ROUND_BR expression CHAR_R_ROUND_BR OP_GE expression
    | expression AT_LEAST CHAR_L_ROUND_BR expression CHAR_R_ROUND_BR OP_IN expression
    | expression AT_LEAST CHAR_L_ROUND_BR expression CHAR_R_ROUND_BR OP_NOT_IN expression
    | expression OP_TERNARY_IF expression OP_TERNARY_ELSE expression
    | expression OP_TERNARY_IF OP_TERNARY_ELSE expression
    | valLiteral
    | reference
    | expression OP_RANGE expression
    ;

funcName
    : valIdentifier (OP_SCOPE valIdentifier)*
    ;

funcCall
    : funcName CHAR_L_ROUND_BR funcCallParams? CHAR_R_ROUND_BR
    | LIKE CHAR_L_ROUND_BR funcCallParams? CHAR_R_ROUND_BR
    ;

funcCallParams
    : expressionOrQuery (CHAR_COMMA expressionOrQuery)*
    ;

expressionOrQuery
    : expression
    | query
    ;

arrayElems
    : expression (CHAR_COMMA expression)* CHAR_COMMA?
    ;

forOptions
    : valIdentifier expression
    | valIdentifier expression valIdentifier expression
    ;

statementOptions
    : OPTIONS valObject
    ;

objectElems
    : objectElem (CHAR_COMMA objectElem)*
    ;

objectElem
    : valIdentifier
    | objectElement CHAR_COLON expression
    | valBindParameter CHAR_COLON expression
    | CHAR_L_BR expression CHAR_R_BR CHAR_COLON expression
    ;

arrayFilterOperator
    : CHAR_QUESTION_MARK
    | arrayFilterOperator CHAR_QUESTION_MARK
    ;

arrayMapOperator
    : CHAR_ASTERISK
    | arrayMapOperator CHAR_ASTERISK
    ;

arrayFilter
    : FILTER expression
    | quantifier FILTER expression
    | AT_LEAST CHAR_L_ROUND_BR expression CHAR_R_ROUND_BR FILTER expression
    | expression FILTER expression
    ;

arrayLimit
    : LIMIT expression
    | LIMIT expression CHAR_COMMA expression
    ;

arrayReturn
    : RETURN expression
    ;

graphCollection
    : valIdentifier
    | valAnyBindParameter
    | graphDirection valIdentifier
    | graphDirection valAnyBindParameter
    ;

graphSubject
    : graphCollection
    | graphCollection (CHAR_COMMA graphCollection)*
    | GRAPH valAnyBindParameter
    | GRAPH VAL_STRING
    | GRAPH valIdentifier
    ;

graphDirection
    : OUTBOUND
    | INBOUND
    | ANY
    ;

graphDirectionSteps
    : graphDirection
    | expression graphDirection
    ;

reference
    : valIdentifier
    | valCompound
    | valAnyBindParameter
    | funcCall
    | CHAR_L_ROUND_BR expression CHAR_R_ROUND_BR
    | CHAR_L_ROUND_BR query CHAR_R_ROUND_BR
    | reference CHAR_DOT valIdentifier
    | reference CHAR_DOT valAnyBindParameter
    | reference CHAR_L_BR expression CHAR_R_BR
    | reference CHAR_L_BR arrayFilterOperator arrayFilter? CHAR_R_BR
    | reference CHAR_L_BR arrayMapOperator arrayFilter? arrayLimit? arrayReturn? CHAR_R_BR
    ;

inOrOutCollectionName
    : valIdentifier
    | VAL_STRING
    | valBindDataSourceParameter
    ;

objectElement
    : valIdentifier
    | VAL_STRING;

varName
    : valString
    ;
// ################################################################
// VALUES
// ################################################################
valAnyBindParameter
    : valBindDataSourceParameter
    | valBindParameter
    ;

valBindParameter
    : CHAR_AT_SIGN valIdentifier
    ;

valBindDataSourceParameter
    : CHAR_AT_SIGN CHAR_AT_SIGN valIdentifier
    ;

valIdentifier
    : VAL_IDENTIFIER
    ;

valString
    : VAL_STRING
    ;

valNumber
    : VAL_INT
    | VAL_FLOAT
    ;

valFloat
    : VAL_FLOAT
    ;

valInt
    : VAL_INT
    ;

valUint
    : VAL_UINT
    ;

valBool
    : VAL_BOOL
    ;

valObject
    : CHAR_L_CUR_BR objectElems? CHAR_R_CUR_BR
    ;

valCompound
    : valArray
    | valObject
    ;

valSimple
    : valLiteral
    | valAnyBindParameter
    ;

valArray
    : CHAR_L_BR arrayElems? CHAR_R_BR
    ;

valLiteral
    : VAL_STRING
    | valNumber
    | NULL
    | TRUE
    | FALSE
    ;
