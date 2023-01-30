package com.lizurt.test;

import com.lizurt.suggester.Suggester;
import com.lizurt.suggester.CasePreference;
import com.lizurt.suggester.factories.LexerAndParserFactory;
import com.lizurt.suggester.factories.ReflectiveLexerAndParserFactory;

import java.util.*;

public class TestApp {
    public static void main(String[] args) {
        LexerAndParserFactory lexerAndParserfactory = new ReflectiveLexerAndParserFactory(
                the.grammar.TheLexer.class, the.grammar.TheParser.class
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
