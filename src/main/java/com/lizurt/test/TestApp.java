package com.lizurt.test;

import com.lizurt.suggester.LexerWrapper;
import com.lizurt.suggester.ParserWrapper;
import com.lizurt.suggester.Suggester;
import com.lizurt.suggester.CasePreference;
import com.lizurt.suggester.factories.LexerAndParserFactory;
import com.lizurt.suggester.factories.ParserFactory;
import com.lizurt.suggester.factories.ReflectiveLexerAndParserFactory;
import org.antlr.v4.Tool;
import org.antlr.v4.runtime.atn.RuleStartState;
import org.antlr.v4.tool.DOTGenerator;
import org.antlr.v4.tool.Grammar;
import the.grammar.TheLexer;
import the.grammar.TheParser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TestApp {
    public static void main(String[] args) {
        LexerAndParserFactory lexerAndParserfactory = new ReflectiveLexerAndParserFactory(
                TheLexer.class, TheParser.class
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
