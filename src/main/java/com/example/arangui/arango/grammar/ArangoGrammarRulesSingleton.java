package com.example.arangui.arango.grammar;

import org.antlr.v4.Tool;
import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.tool.Alternative;
import org.antlr.v4.tool.Grammar;
import org.antlr.v4.tool.Rule;
import org.antlr.v4.tool.ast.*;

import java.util.*;

public class ArangoGrammarRulesSingleton implements RuleGrammarASTVisitor {

    // region instance stuff

    private static class InstanceHolder {
        private static final ArangoGrammarRulesSingleton instance = new ArangoGrammarRulesSingleton();
    }

    private ArangoGrammarRulesSingleton() {
        init();
    }

    public static ArangoGrammarRulesSingleton getInstance() {
        return InstanceHolder.instance;
    }

    // endregion

    private final String antlrGeneratedClassesDirectoryPath
            = System.getProperty("user.dir") + "/build/generated-src/antlr/main/com/example/arangui/antlr";

    private final String antlrParserGrammarFilePath = "src/main/antlr/TheParser.g4";
    private final String antlrLexerGrammarFilePath = "src/main/antlr/TheLexer.g4";

    private Grammar parserGrammar;

    private Grammar lexerGrammar;

    // for quick access
    private OrderedHashMap<String, Rule> parserRulesByNames;

    private OrderedHashMap<String, Rule> lexerRulesByNames;

    // <node name, node regexp variants>
    private Map<String, Set<String>> lexerRegexpsByNames = new HashMap<>();

    private void init() {
        initGrammarAST();
        initRegexpsByNames();
    }

    private void initGrammarAST() {
        Tool tool = new Tool();
        tool.outputDirectory = antlrGeneratedClassesDirectoryPath;
        setParserGrammar(tool.loadGrammar(antlrParserGrammarFilePath));
        setLexerGrammar(tool.loadGrammar(antlrLexerGrammarFilePath));

        setParserRulesByNames(getParserGrammar().rules);
        setLexerRulesByNames(getLexerGrammar().rules);
    }

    public void initRegexpsByNames() {
        for (Rule rule : lexerRulesByNames.values()) {
            initRegexp(rule);
        }
    }

    public void initRegexp(Rule rule, String value) {
        if (!lexerRegexpsByNames.containsKey(rule.name)) {
            lexerRegexpsByNames.put(rule.name, new HashSet<>());
        }
        lexerRegexpsByNames.get(rule.name).add(value);
    }

    public void initRegexp(Rule rule) {
        for (Alternative alternative : rule.alt) {
            // i have no idea why antlr tool builds null alternatives as well
            if (alternative == null) {
                continue;
            }
            initRegexp(rule, alternative.ast);
        }
    }

    public void initRegexp(Rule rule, GrammarAST grammarAST) {
        String value = (String) visit(rule, grammarAST);
        initRegexp(rule, value);
    }

    // region visitor stuff

    @Override
    public Object visit(Rule rule, GrammarAST node) {
        // how sad New Switch is only in a preview mode. Have to use such horrible construction
        if (node instanceof RuleAST ruleAST) {
            return visit(rule, ruleAST);
        } else if (node instanceof BlockAST) {
            return visit(rule, (BlockAST) node);
        } else if (node instanceof OptionalBlockAST) {
            return visit(rule, (OptionalBlockAST) node);
        } else if (node instanceof PlusBlockAST) {
            return visit(rule, (PlusBlockAST) node);
        } else if (node instanceof StarBlockAST) {
            return visit(rule, (StarBlockAST) node);
        } else if (node instanceof AltAST) {
            return visit(rule, (AltAST) node);
        } else if (node instanceof NotAST) {
            return visit(rule, (NotAST) node);
        } else if (node instanceof PredAST) {
            return visit(rule, (PredAST) node);
        } else if (node instanceof RangeAST) {
            return visit(rule, (RangeAST) node);
        } else if (node instanceof SetAST) {
            return visit(rule, (SetAST) node);
        } else if (node instanceof RuleRefAST) {
            return visit(rule, (RuleRefAST) node);
        } else if (node instanceof TerminalAST) {
            return visit(rule, (TerminalAST) node);
        }
        return node.toString();
    }

    @Override
    public Object visit(Rule rule, GrammarRootAST node) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object child : node.getChildren()) {
            stringBuilder.append(visit( rule, (GrammarAST) child));
        }
        return stringBuilder.toString();
    }

    @Override
    public Object visit(Rule rule, RuleAST node) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object child : node.getChildren()) {
            stringBuilder.append(visit(rule, (GrammarAST) child));
        }
        return stringBuilder.toString();
    }

    @Override
    public Object visit(Rule rule, BlockAST node) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object child : node.getChildren()) {
            stringBuilder.append(visit(rule, (GrammarAST) child));
        }
        return stringBuilder.toString();
    }

    @Override
    public Object visit(Rule rule, OptionalBlockAST node) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        for (Object child : node.getChildren()) {
            stringBuilder.append(visit(rule, (GrammarAST) child));
        }
        stringBuilder.append(")?");
        return stringBuilder.toString();
    }

    @Override
    public Object visit(Rule rule, PlusBlockAST node) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        for (Object child : node.getChildren()) {
            stringBuilder.append(visit(rule, (GrammarAST) child));
        }
        stringBuilder.append(")+");
        return stringBuilder.toString();
    }

    @Override
    public Object visit(Rule rule, StarBlockAST node) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        for (Object child : node.getChildren()) {
            stringBuilder.append(visit(rule, (GrammarAST) child));
        }
        stringBuilder.append(")*");
        return stringBuilder.toString();
    }

    @Override
    public Object visit(Rule rule, AltAST node) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object child : node.getChildren()) {
            stringBuilder.append((String) visit(rule, (GrammarAST) child));
        }
        return stringBuilder.toString();
    }

    @Override
    public Object visit(Rule rule, NotAST node) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object child : node.getChildren()) {
            stringBuilder.append(visit(rule, (GrammarAST) child));
        }
        return stringBuilder.toString();
    }

    @Override
    public Object visit(Rule rule, PredAST node) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object child : node.getChildren()) {
            stringBuilder.append(visit(rule, (GrammarAST) child));
        }
        return stringBuilder.toString();
    }

    @Override
    public Object visit(Rule rule, RangeAST node) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object child : node.getChildren()) {
            stringBuilder.append(visit(rule, (GrammarAST) child));
        }
        return stringBuilder.toString();
    }

    @Override
    public Object visit(Rule rule, SetAST node) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object child : node.getChildren()) {
            stringBuilder.append(visit(rule, (GrammarAST) child));
        }
        return stringBuilder.toString();
    }

    @Override
    public Object visit(Rule rule, RuleRefAST node) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object child : node.getChildren()) {
            stringBuilder.append(visit(rule, (GrammarAST) child));
        }
        return stringBuilder.toString();
    }

    @Override
    public Object visit(Rule rule, TerminalAST node) {
        // haven't we built at least one regexp for the rule?
        if (!getLexerRegexpsByNames().containsKey(node.getText())) {
            // if so, do it now
            Rule otherRule = getLexerRulesByNames().get(node.getText());
            if (otherRule == null) {
                // the rule isn't actually a rule but a regexpable node
                String value = node.toString();
                initRegexp(rule, value);
                return value;

            }
            initRegexp(otherRule);
        }
        Set<String> availableRegexes = getLexerRegexpsByNames().get(node.getText());
        if (availableRegexes.size() == 1) {
            return availableRegexes.stream().findFirst().get();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        Iterator<String> iterator = availableRegexes.iterator();
        stringBuilder.append(iterator.next());
        while (iterator.hasNext()) {
            stringBuilder.append('|').append(iterator.next());
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    // endregion

    // region getters & setters

    public Map<String, Set<String>> getLexerRegexpsByNames() {
        return lexerRegexpsByNames;
    }

    private void setLexerRegexpsByNames(Map<String, Set<String>> lexerRegexpsByNames) {
        this.lexerRegexpsByNames = lexerRegexpsByNames;
    }

    public OrderedHashMap<String, Rule> getLexerRulesByNames() {
        return lexerRulesByNames;
    }

    private void setLexerRulesByNames(OrderedHashMap<String, Rule> lexerRulesByNames) {
        this.lexerRulesByNames = lexerRulesByNames;
    }

    public Grammar getLexerGrammar() {
        return lexerGrammar;
    }

    private void setLexerGrammar(Grammar lexerGrammar) {
        this.lexerGrammar = lexerGrammar;
    }

    public OrderedHashMap<String, Rule> getParserRulesByNames() {
        return parserRulesByNames;
    }

    private void setParserRulesByNames(OrderedHashMap<String, Rule> parserRulesByNames) {
        this.parserRulesByNames = parserRulesByNames;
    }

    public Grammar getParserGrammar() {
        return parserGrammar;
    }

    private void setParserGrammar(Grammar parserGrammar) {
        this.parserGrammar = parserGrammar;
    }

    // endregion
}
