package com.example.arangui.arango.grammar;

import org.antlr.v4.tool.Rule;
import org.antlr.v4.tool.ast.*;

public interface RuleGrammarASTVisitor {
        Object visit(Rule rule, GrammarAST node);

        Object visit(Rule rule, GrammarRootAST node);
        Object visit(Rule rule, RuleAST node);

        Object visit(Rule rule, BlockAST node);
        Object visit(Rule rule, OptionalBlockAST node);
        Object visit(Rule rule, PlusBlockAST node);
        Object visit(Rule rule, StarBlockAST node);

        Object visit(Rule rule, AltAST node);

        Object visit(Rule rule, NotAST node);
        Object visit(Rule rule, PredAST node);
        Object visit(Rule rule, RangeAST node);
        Object visit(Rule rule, SetAST node);
        Object visit(Rule rule, RuleRefAST node);
        Object visit(Rule rule, TerminalAST node);
}
