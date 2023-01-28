package com.example.arangui;

import com.example.arangui.antlr.ArangoLexerRules;
import com.example.arangui.antlr.ArangoParserRules;
import com.example.arangui.arango.grammar.ArangoGrammarRulesSingleton;
import com.example.arangui.arango.hints.ArangoQueryDefaultAnalyser;
import com.example.suggester.AutoSuggester;
import com.example.suggester.LexerAndParserFactory;
import com.example.suggester.ReflectionLexerAndParserFactory;
import org.antlr.runtime.tree.Tree;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.RuleStartState;
import org.antlr.v4.tool.DOTGenerator;
import org.snt.inmemantlr.GenericParser;
import org.snt.inmemantlr.exceptions.CompilationException;
import org.snt.inmemantlr.exceptions.IllegalWorkflowException;
import org.snt.inmemantlr.exceptions.ParsingException;
import org.snt.inmemantlr.listener.DefaultTreeListener;
import org.snt.inmemantlr.tree.ParseTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TestApp {
    public static void main(String[] args) throws IOException {
        if (true) {
            DOTGenerator dotGenerator = new DOTGenerator(ArangoGrammarRulesSingleton.getInstance().getLexerGrammar());
            FileWriter fw = new FileWriter("lexer.dot");
            fw.write("digraph ATN { rankdir=LR;");
            for (RuleStartState ruleStartState : ArangoGrammarRulesSingleton.getInstance().getLexerGrammar().atn.ruleToStartState) {
                String dot = dotGenerator.getDOT(ruleStartState);
                dot = dot.replace("digraph ATN {", "");
                dot = dot.replace("rankdir=LR;", "");
                dot = dot.substring(0, dot.length() - 1);
                fw.append(dot);
            }
            fw.append("}");
            fw.close();
        }
        if (true) {
            DOTGenerator dotGenerator = new DOTGenerator(ArangoGrammarRulesSingleton.getInstance().getParserGrammar());
            FileWriter fw = new FileWriter("parser.dot");
            fw.write("digraph ATN { rankdir=LR;");
            for (RuleStartState ruleStartState : ArangoGrammarRulesSingleton.getInstance().getParserGrammar().atn.ruleToStartState) {
                String dot = dotGenerator.getDOT(ruleStartState);
                dot = dot.replace("digraph ATN {", "");
                dot = dot.replace("rankdir=LR;", "");
                dot = dot.substring(0, dot.length() - 1);
                fw.append(dot);
            }
            fw.append("}");
            fw.close();
        }
        if (true) {
            LexerAndParserFactory lexerAndParserfactory = new ReflectionLexerAndParserFactory(
                    the.grammar.TheLexer.class, the.grammar.TheParser.class
            );
            Collection<String> suggestions = new AutoSuggester(lexerAndParserfactory)
                    .generateAndGetSuggestions("hello ");
            System.out.println("$$$$$$$$ SUGGESTIONS: ");
            for (String s : suggestions) {
                System.out.println(s);
            }
            return;
        }
        if (false) {
            System.out.println("----------------------------");
            testAST();
        }
        if (false) {
            System.out.println("----------------------------");
            testGrammarAST();
        }
        if (false) {
            System.out.println("----------------------------");
            for (Map.Entry<String, Set<String>> a : ArangoGrammarRulesSingleton.getInstance().getLexerRegexpsByNames().entrySet()) {
                System.out.println(a.getKey() + " <=> " + a.getValue());
            }
        }
        if (false) {
            System.out.println("----------------------------");
            testAutocompletionHints();
        }
    }

    private static void testAutocompletionHints() {
        Scanner scanner = new Scanner(System.in);
        String line;
        while (true) {
            System.out.println("> ");
            line = scanner.nextLine();
            if (line.equals("exit")) {
                return;
            }

            CharStream charStream = CharStreams.fromString(line);
            ArangoLexerRules lexer = new ArangoLexerRules(charStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ArangoParserRules parser = new ArangoParserRules(tokens, true);
            ArangoParserRules.QueryStartContext queryContext = parser.queryStart();
            System.out.println(queryContext.toStringTree());

            ArangoQueryDefaultAnalyser arangoQueryDefaultAnalyser = new ArangoQueryDefaultAnalyser();
            System.out.println("Options are:");
            for (String hint : arangoQueryDefaultAnalyser.getHints(queryContext)) {
                System.out.println("    " + hint);
            }
        }
    }

    private static void testAST() {
        String s = "INSerT {str: \" dasd dt } {}{{[]'4.512 \", num: -3.14 } INTO testt";
        CharStream in = CharStreams.fromString(s);
        ArangoLexerRules lexer = new ArangoLexerRules(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ArangoParserRules parser = new ArangoParserRules(tokens);

        parser.setBuildParseTree(true);
        String baseG4Path = "src/main/antlr/";
        File fParser = new File(baseG4Path + "ArangoParserRules.g4");
        File fLexer = new File(baseG4Path + "ArangoLexerRules.g4");
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
                ArangoGrammarRulesSingleton.getInstance().getParserGrammar().ast,
                0,
                new StringBuilder()
        ));
        System.out.println("================================================================");
        System.out.println(toStringTree(
                ArangoGrammarRulesSingleton.getInstance().getLexerGrammar().ast,
                0,
                new StringBuilder()
        ));
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
