package com.lizurt.test;

import com.lizurt.suggester.Suggester;
import com.lizurt.suggester.CasePreference;
import com.lizurt.suggester.factories.LexerAndParserFactory;
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
    public static void main(String[] args) throws IOException {
        LexerAndParserFactory lexerAndParserfactory = new ReflectiveLexerAndParserFactory(
                grammar.java.Java8Lexer.class, grammar.java.Java8Parser.class
        );
        Suggester suggester = new Suggester(lexerAndParserfactory);
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
