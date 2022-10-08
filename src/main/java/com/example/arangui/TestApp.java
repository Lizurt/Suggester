package com.example.arangui;

import com.example.arangui.antlr.ArangoLexerRules;
import com.example.arangui.antlr.ArangoParserRules;
import com.example.arangui.arango.grammar.AranagoGrammarRulesSingleton;
import com.github.curiousoddman.rgxgen.RgxGen;
import org.antlr.runtime.tree.Tree;
import org.antlr.v4.runtime.*;
import org.antlr.v4.tool.Rule;
import org.snt.inmemantlr.GenericParser;
import org.snt.inmemantlr.exceptions.CompilationException;
import org.snt.inmemantlr.exceptions.IllegalWorkflowException;
import org.snt.inmemantlr.exceptions.ParsingException;
import org.snt.inmemantlr.listener.DefaultTreeListener;
import org.snt.inmemantlr.tree.ParseTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

public class TestApp {
    public static void main(String[] args) {
        if (true) {
            testAutocompletionHints();
        }
        if (false) {
            testAST();
        }
        if (true) {
            testGrammarAST();
        }
        AranagoGrammarRulesSingleton.getInstance().initRegexpsByNames();
    }

    private static void testAutocompletionHints() {

    }

    private static void testAST() {
        CharStream in = CharStreams.fromString("INSerT {str: \" dasd dt } {}{{[]'4.512 \", num: -3.14 } INTO testt");
        ArangoLexerRules lexer = new ArangoLexerRules(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ArangoParserRules parser = new ArangoParserRules(tokens);

        parser.setBuildParseTree(true);
        String baseG4Path = "src/main/antlr/";
        File fParser = new File(baseG4Path + "ArangoParserRules.g4");
        File fLexer = new File(baseG4Path + "ArangoLexerRules.g4");
        String s = "INSerT {str: \" dasd dt } {}{{[]'4.512 \", num: -3.14 } INTO testt";
        try {
            GenericParser gp = new GenericParser(fLexer, fParser);
            DefaultTreeListener defaultTreeListener = new DefaultTreeListener();
            gp.setListener(defaultTreeListener);
            gp.compile();
            // have to set these 2 manually - inmemantlr ignores @header-packages while reading names
            gp.setLexerName("com.example.arangui.antlr.ArangoLexerRules");
            gp.setParserName("com.example.arangui.antlr.ArangoParserRules");
            ParserRuleContext ctx = gp.parse(s, "query", GenericParser.CaseSensitiveType.NONE);
            ParseTree parseTree = defaultTreeListener.getParseTree();
            System.out.println("================================================================");
            System.out.println(parseTree.toDot());
            System.out.println("================================================================");
        } catch (IllegalWorkflowException | ParsingException | FileNotFoundException | CompilationException e) {
            throw new RuntimeException(e);
        }
    }

    private static void testGrammarAST() {
        System.out.println(toStringTree(
                AranagoGrammarRulesSingleton.getInstance().getParserGrammar().ast,
                0,
                new StringBuilder()
        ));
        System.out.println("================================================================");
        System.out.println(toStringTree(
                AranagoGrammarRulesSingleton.getInstance().getLexerGrammar().ast,
                0,
                new StringBuilder()
        ));
    }

    public static String toStringTree(Map<String, Rule> rulesByNames, int level, StringBuilder buf) {
        for (Map.Entry<String, Rule> ruleByName : rulesByNames.entrySet()) {
            buf.append(ruleByName.getKey());
            //toStringTree(ruleByName.getValue(), 1, buf);
            //ruleByName.getValue()
        }

        return buf.toString();
    }
    public static String toStringTree(Tree node, int level, StringBuilder buf) {
        buf.append("\n");
        buf.append("  ".repeat(level));
        buf.append(node);
        Tree child;
        for (int i = 0; i < node.getChildCount(); i++) {
            child = node.getChild(i);
            toStringTree(child, level + 1, buf);
        }
        return buf.toString();
    }
}
