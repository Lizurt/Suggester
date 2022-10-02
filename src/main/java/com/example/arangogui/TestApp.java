package com.example.arangui;

import com.example.arangui.antlr.ArangoLexerRules;
import com.example.arangui.antlr.ArangoParserRules;
import org.antlr.runtime.tree.BaseTree;
import org.antlr.runtime.tree.Tree;
import org.antlr.v4.Tool;
import org.antlr.v4.runtime.*;
import org.antlr.v4.tool.Grammar;
import org.antlr.v4.tool.ast.GrammarRootAST;
import org.snt.inmemantlr.GenericParser;
import org.snt.inmemantlr.exceptions.CompilationException;
import org.snt.inmemantlr.exceptions.IllegalWorkflowException;
import org.snt.inmemantlr.exceptions.ParsingException;
import org.snt.inmemantlr.listener.DefaultListener;
import org.snt.inmemantlr.listener.DefaultTreeListener;
import org.snt.inmemantlr.tree.ParseTree;
import org.snt.inmemantlr.utils.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
module com.example.arangui {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.antlr.antlr4.runtime;

    opens com.example.arangui to javafx.fxml;
    exports com.example.arangui;
}
 */

public class TestApp {
    public static void main(String[] args) {

        CharStream in = CharStreams.fromString("INSerT {str: \" dasd dt } {}{{[]'4.512 \", num: -3.14 } INTO testt");
        ArangoLexerRules lexer = new ArangoLexerRules(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ArangoParserRules parser = new ArangoParserRules(tokens);
        System.out.println();

        Tool tool = new Tool();
        tool.outputDirectory = System.getProperty("user.dir") + "/build/generated-src/antlr/main/com/example/arangui/antlr";
        Grammar g = tool.loadGrammar("src/main/antlr/ArangoParserRules.g4");
        System.out.println(toStringTree((BaseTree) g.ast.getChild(3), 0, new StringBuilder()));
        /*parser.setBuildParseTree(true);
        RuleContext tree = parser.query();
        List<String> ruleNames = Arrays.asList(parser.getRuleNames());
        RuleContext rc = parser.getRuleContext();
        System.out.println("");

        System.out.println("================================================================");
        System.out.println(AntlrTreeUtils.toPrettyTree(tree, ruleNames));
        System.out.println("================================================================");


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
        }*/
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
