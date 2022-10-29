// todo list:
// https://www.arangodb.com/docs/stable/aql/functions-string.html
// https://www.arangodb.com/docs/stable/aql/fundamentals-bind-parameters.html
// https://www.arangodb.com/docs/stable/aql/operators.html - tokens are done, but not allthe parser rules. Also - check array operators (all, any, none etc)
// https://www.arangodb.com/docs/stable/aql/graphs-traversals.html

parser grammar ArangoParserRules;
options {
    tokenVocab = ArangoLexerRules;
}
@header {
    package com.example.arangui.antlr;

    import java.util.*;
    import org.antlr.v4.tool.Rule;
    import com.example.arangui.arango.grammar.AranagoGrammarRulesSingleton;
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
            if (!AranagoGrammarRulesSingleton.getInstance().getParserRulesByNames().containsKey(contextClassName)) {
                throw new RuntimeException("Cannot find a parser rule by such context class name: \""
                    + contextClassName + "\"."
                );
            }
            Rule parserRule = AranagoGrammarRulesSingleton.getInstance().getParserRulesByNames().get(contextClassName);
            rulesByContextClasses.put((Class<? extends ParseTree>) contextClass, parserRule);
        }
    }

    public static Rule getRuleByContextClass(Class<? extends ParseTree> contextClass) {
        return rulesByContextClasses.containsKey(contextClass) ? rulesByContextClasses.get(contextClass) : null;
    }
}
query :
    insert
    | forLoop
;
// Basic queries ################################################################
insert :
    INSERT CHAR_L_CUR_BR insertKeysVals CHAR_R_CUR_BR insertInto
;
forLoop :
    FOR identifier IN identifier forStatements
;
// ################################################################
forOptions :
    OPTIONS CHAR_L_CUR_BR forOptKeysVals CHAR_R_CUR_BR
;
forIn :
    identifier
    | array
;
forStatements :
    forLoop
    | (forFilter? forReturn)
;
forReturn :
    RETURN
    dottableIdentifiers
    | (CHAR_L_CUR_BR
            (VAL_STRING CHAR_COLON mathExpr (CHAR_COMMA VAL_STRING CHAR_COLON mathExpr)*)?
        CHAR_R_CUR_BR)

;
forFilter :
    FILTER dottableIdentifiers
;

insertInto :
    INTO identifier
;
insertKeysVals :
    insertKeyVal (CHAR_COMMA insertKeyVal)*
;
insertKeyVal :
    identifier CHAR_COLON value
;
// ForLoop options ################################################################
forOptKeysVals :
    forOptKeyVal (CHAR_COMMA forOptKeyVal)*
;
forOptKeyVal :
    (forOptIndexHintKey CHAR_COLON forOptIndexHintVal)
    | (forOptForceIndexHintKey CHAR_COLON forOptForceIndexHintVal)
    | (forOptDisableIndexKey CHAR_COLON forOptDisableIndexVal)
    | (forOptMaxProjectionsKey CHAR_COLON forOptMaxProjectionsVal)
    | (forOptUseCacheKey CHAR_COLON forOptUseCacheVal)
    | (forOptLookaheadKey CHAR_COLON forOptLookaheadVal)
;
forOptIndexHintKey :
    INDEX_HINT
;
forOptForceIndexHintKey :
    FORCE_INDEX_HINT
;
forOptDisableIndexKey :
    DISABLE_INDEX
;
forOptMaxProjectionsKey :
    MAX_PROJECTIONS
;
forOptUseCacheKey :
    USE_CACHE
;
forOptLookaheadKey :
    LOOKAHEAD
;
forOptIndexHintVal :
    valueString | arrayString
;
forOptForceIndexHintVal :
    valueBool
;
forOptDisableIndexVal :
    valueBool
;
forOptMaxProjectionsVal :
    valueUint
;
forOptUseCacheVal :
    valueBool
;
forOptLookaheadVal :
    valueUint
;
// Values ################################################################
array :
    CHAR_L_BR (value (CHAR_COMMA value)*)? CHAR_R_BR
;
arrayString :
    CHAR_L_BR (valueString (CHAR_COMMA valueString)*)? CHAR_R_BR
;
dottableIdentifiers :
    identifier (CHAR_DOT identifier)*
;
identifier :
    VAL_IDENTIFIER
;
value :
    valueString valueFloat
;
valueString :
    VAL_STRING
;
valueFloat :
    VAL_FLOAT
;
valueInt :
    VAL_INT
;
valueUint :
    VAL_UINT
;
valueBool :
    VAL_BOOL
;
// Functions ################################################################
funcCall :
    identifier CHAR_L_BR identifier* CHAR_R_BR
;
// Math ################################################################
mathExpr :
    mathAdd
;
mathAdd :
    mathMult (mathOpAdd mathMult)*
;
mathMult :
    mathGroup (mathOpMult mathGroup)*
;
mathGroup :
    (VAL_FLOAT)
    | (dottableIdentifiers)
    | (funcCall)
    | (CHAR_L_BR mathExpr CHAR_R_BR)
;
mathOpMult :
    CHAR_ASTERISK | CHAR_SLASH
;
mathOpAdd :
    CHAR_MINUS | CHAR_PLUS
;
