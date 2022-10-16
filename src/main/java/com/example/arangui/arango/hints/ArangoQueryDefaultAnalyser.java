package com.example.arangui.arango.hints;

import com.example.arangui.antlr.ArangoParserRules;
import com.example.arangui.arango.grammar.AranagoGrammarRulesSingleton;
import com.github.curiousoddman.rgxgen.RgxGen;
import org.antlr.runtime.tree.Tree;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.tool.Alternative;
import org.antlr.v4.tool.Rule;
import org.antlr.v4.tool.ast.RuleRefAST;
import org.antlr.v4.tool.ast.TerminalAST;

import java.util.*;

public class ArangoQueryDefaultAnalyser implements ArangoQueryAnalyser {
    public final static Random HINTS_GENERATOR_RANDOM = new Random(123456789);
    // fixme: "insert {a:5} i" generates error node in the start (an empty "INTO" node)
    public List<String> getHints(ArangoParserRules.QueryContext queryContext) {
        ParseTree lastDeepestNode = getLastDeepestNode(queryContext);
        ParseTree nodeForHints = lastDeepestNode;
        LinkedList<ParseTree> writtenNodesInIncompleteToken = new LinkedList<>();
        if (lastDeepestNode instanceof ErrorNode) {
            nodeForHints = lastDeepestNode.getParent();
            // firstly let's check its parent in case if there are other error nodes
            ParseTree nodeParent = lastDeepestNode.getParent();
            for (int i = nodeParent.getChildCount() - 1; i >= 0; i--) {
                if (nodeParent.getChild(i) instanceof ErrorNode) {
                    writtenNodesInIncompleteToken.addFirst(nodeParent.getChild(i));
                }
            }
        } else if (lastDeepestNode instanceof TerminalNode) {
            nodeForHints = lastDeepestNode.getParent();
            ParseTree nodeParent = lastDeepestNode.getParent();
            for (int i = nodeParent.getChildCount() - 1; i >= 0; i--) {
                if (nodeParent.getChild(i) instanceof TerminalNode) {
                    writtenNodesInIncompleteToken.addFirst(nodeParent.getChild(i));
                }
            }
        }
        String userWrittenTokenPart = nodesToString(writtenNodesInIncompleteToken);
        Rule ruleForHints = ArangoParserRules.getRuleByContextClass(nodeForHints.getClass());
        if (ruleForHints == null) {
            throw new RuntimeException("RuleForHints is null which shouldn't happen");
        }
        List<String> hints = new ArrayList<>();
        // so at the moment we know what a user wrote (the part where parser failed to create a correct node) and what
        // rule we're expecting the user to follow when writing. Now we can generate possible words
        // the user can write here
        List<Tree> rawHints = getFirstHintableNodesInRule(ruleForHints);
        for (Tree node : rawHints) {
            Set<String> regexpsForTheNode =
                    AranagoGrammarRulesSingleton.getInstance().getLexerRegexpsByNames().get(node.getText());
            for (String regexp : regexpsForTheNode) {
                RgxGen rgxGen = new RgxGen(regexp);
                if (rgxGen.getUniqueEstimation().isEmpty()) {
                    continue;
                }
                String generatedPossibleHint = rgxGen.generate();
                String lowercasedHint = generatedPossibleHint.toLowerCase();
                String lowercasedUserWrittenTokenPart = userWrittenTokenPart.toLowerCase();
                if (!lowercasedHint.startsWith(lowercasedUserWrittenTokenPart)) {
                    continue;
                }
                hints.add(lowercasedHint.matches(regexp) ? lowercasedHint : generatedPossibleHint);
            }
        }

        return hints;
    }

    private List<Tree> getFirstHintableNodesInRule(Rule ruleForHints) {
        List<Tree> hintableNodes = new ArrayList<>();
        for (Alternative alternative : ruleForHints.alt) {
            if (alternative == null) {
                continue;
            }
            for (int i = 0; i < alternative.ast.getChildCount(); i++) {
                Tree child = alternative.ast.getChild(i);
                if (child instanceof TerminalAST) {
                    // we already know in which rule we currently are, and know what node should be here
                    hintableNodes.add(child);
                    break;
                }
                if (child instanceof RuleRefAST) {
                    // we don't know in which rule we currently are, we only know "it could be in this node",
                    // but this node is actually a reference, so let's check it instead
                    hintableNodes.addAll(getFirstHintableNodesInRule(
                            AranagoGrammarRulesSingleton.getInstance().getParserRulesByNames().get(child.toString())
                    ));
                    break;
                }
            }
        }
        return hintableNodes;
    }

    private String nodesToString(Collection<ParseTree> nodes) {
        StringBuilder sbStringedNodes = new StringBuilder();
        for (ParseTree node : nodes) {
            sbStringedNodes.append(node.getText());
        }
        return sbStringedNodes.toString();
    }

    public ParseTree getLastDeepestNonTerminalNode(ParseTree parent) {
        ParseTree node = parent;
        while (!(node instanceof TerminalNode) && node.getChildCount() > 0) {
            node = node.getChild(node.getChildCount() - 1);
        }
        return node;
    }

    public ParseTree getLastDeepestNode(ParseTree parent) {
        if (parent.getChildCount() == 0) {
            return parent;
        }
        ParseTree node = parent.getChild(parent.getChildCount() - 1);
        while (node.getChildCount() > 0) {
            node = node.getChild(node.getChildCount() - 1);
        }
        return node;
    }
}
