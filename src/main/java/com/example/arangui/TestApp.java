package com.example.arangui;

import com.example.arangui.antlr.ArangoLexerRules;
import com.example.arangui.antlr.ArangoParserRules;
import com.example.arangui.arango.grammar.ArangoGrammarRulesSingleton;
import com.example.arangui.arango.hints.ArangoQueryDefaultAnalyser;
import com.example.suggester.AutoSuggester;
import com.example.suggester.CasePreference;
import com.example.suggester.LexerAndParserFactory;
import com.example.suggester.ReflectionLexerAndParserFactory;
import org.antlr.v4.runtime.atn.RuleStartState;
import org.antlr.v4.tool.DOTGenerator;
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
            AutoSuggester autoSuggester = new AutoSuggester(lexerAndParserfactory);
            autoSuggester.setCasePreference(CasePreference.LOWER);
            while (true) {
                System.out.print(">> ");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                long a = System.currentTimeMillis();
                List<String> suggestions = autoSuggester.generateAndGetSuggestions(input);
                long b = System.currentTimeMillis();
                System.out.println("It took " + (b - a) + " ms, including the time spent on SOUT");
                System.out.println("Suggestions:");
                for (int i = 0; i < suggestions.size(); i++) {
                    System.out.println((i + 1) + ") " + suggestions.get(i));
                }
            }
        }
    }
}
