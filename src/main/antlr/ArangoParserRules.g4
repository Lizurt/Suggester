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

// ################################################################
query :
    insertSt
    | forSt
;
// ################################################################
insertSt :
    INSERT L_CUR_BR keysAndVals R_CUR_BR into
;
forSt :
    FOR identifier IN identifier forStatements
;
// ################################################################
into :
    INTO identifier
;
forStatements :
    returnSt
;
keysAndVals :
    keyAndVal (COMMA keyAndVal)*
;
keyAndVal :
    identifier COLON value
;
value :
    STR_VAL | NUM_VAL
;
identifier :
    AL_NUM+
;
returnSt :
    RETURN identifier (DOT identifier)?
;
