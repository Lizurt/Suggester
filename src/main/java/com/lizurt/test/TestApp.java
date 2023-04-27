package com.lizurt.test;

import com.lizurt.suggester.LexerWrapper;
import com.lizurt.suggester.ParserWrapper;
import com.lizurt.suggester.Suggester;
import com.lizurt.suggester.CasePreference;
import com.lizurt.suggester.factories.LexerAndParserFactory;
import com.lizurt.suggester.factories.ParserFactory;
import com.lizurt.suggester.factories.ReflectiveLexerAndParserFactory;
import org.antlr.v4.Tool;
import org.antlr.v4.runtime.atn.ATNState;
import org.antlr.v4.runtime.atn.RuleStartState;
import org.antlr.v4.tool.DOTGenerator;
import org.antlr.v4.tool.Grammar;
import the.grammar.TheLexer;
import the.grammar.TheParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class TestApp {
    public static void main(String[] args) throws IOException {
        if (true) {
            Grammar grammar = Grammar.load("src/main/antlr/TheLexer.g4");
            DOTGenerator dotGenerator = new DOTGenerator(grammar);
            StringBuilder sbDot = new StringBuilder();
            for (ATNState atnState : grammar.getATN().ruleToStartState) {
                String text = dotGenerator.getDOT(atnState);
                text = text.substring(26, text.length() - 2);
                sbDot.append(text);
            }
            sbDot.insert(0, "digraph ATN {\nrankdir=LR;");
            sbDot.append("}");
            File file = new File("thelexer.dot");
            FileWriter fw = new FileWriter(file);
            fw.write(sbDot.toString());
            fw.close();

            sbDot = new StringBuilder();
            grammar = Grammar.load("src/main/antlr/TheParser.g4");
            dotGenerator = new DOTGenerator(grammar);
            for (ATNState atnState : grammar.getATN().ruleToStartState) {
                String text = dotGenerator.getDOT(atnState);
                text = text.substring(26, text.length() - 2);
                sbDot.append(text);
            }
            sbDot.insert(0, "digraph ATN {\nrankdir=LR;");
            sbDot.append("}");
            file = new File("theparser.dot");
            fw = new FileWriter(file);
            fw.write(sbDot.toString());
            fw.close();
        }
        LexerAndParserFactory lexerAndParserfactory = new ReflectiveLexerAndParserFactory(
                the.grammar.TheLexer.class, the.grammar.TheParser.class
        );
        LexerWrapper lexerWrapper = new LexerWrapper(lexerAndParserfactory);
        ParserWrapper parserWrapper = new ParserWrapper(lexerAndParserfactory);
        Suggester suggester = new Suggester(lexerWrapper, parserWrapper);
        suggester.setCasePreference(CasePreference.LOWER);
        while (true) {
            System.out.print(">> ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            long a = System.currentTimeMillis();
            List<String> suggestions = suggester.generateAndGetSuggestions(input);
            long b = System.currentTimeMillis();
            System.out.println("It took " + (b - a) + " ms, including the time spent on SOUT");
            System.out.println("Suggestions:");
            for (int i = 0; i < suggestions.size(); i++) {
                System.out.println((i + 1) + ") " + suggestions.get(i));
            }
        }
    }
}
