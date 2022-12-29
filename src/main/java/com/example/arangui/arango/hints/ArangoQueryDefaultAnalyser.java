package com.example.arangui.arango.hints;

import com.example.arangui.antlr.ArangoParserRules;
import com.example.arangui.arango.grammar.ArangoGrammarRulesSingleton;
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
    public final static String EOF_NODE_TEXT = "<EOF>";

    public List<String> getHints(ParseTree contextNode) {
        ParseTree lastDeepestNode = getLastDeepestNode(contextNode);
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
        } else  {
            // genius antlr generates empty error nodes sometimes instead of counting next nodes as the error one.
            // We have to check all the previous nodes to find a missing one if it exists
            ParseTree possibleErrorMissingNode = tryFindErrorMissingNodeInSiblingsAndAncestors(lastDeepestNode);
            if (possibleErrorMissingNode == null) {
                // alright no missing nodes, but this node is probably haven't been written completely, let's try to
                // find hints for it
                if (lastDeepestNode instanceof TerminalNode) {
                    nodeForHints = lastDeepestNode.getParent();
                    for (int i = 0; i < nodeForHints.getChildCount(); i++) {
                        writtenNodesInIncompleteToken.addAll(
                                getAllChildesOf(nodeForHints.getChild(i))
                        );
                    }
                }
            } else {
                // alright there were error missing nodes, let's assume a user is writing that missing node but their
                // input was misidentified as some other nodes
                nodeForHints = possibleErrorMissingNode.getParent();
                int nodeIndex = getNodeIndexInParentNode(possibleErrorMissingNode);
                for (int i = nodeIndex + 1; i < possibleErrorMissingNode.getChildCount(); i++) {
                    writtenNodesInIncompleteToken.addLast(nodeForHints.getChild(i));
                    writtenNodesInIncompleteToken.addAll(
                            getAllChildesOf(possibleErrorMissingNode.getChild(i))
                    );
                }
            }
        }
        String userWrittenTokenPart = nodesToString(writtenNodesInIncompleteToken);
        Rule ruleForHints = ArangoParserRules.getRuleByContextClass(nodeForHints.getClass());
        if (ruleForHints == null) {
            throw new RuntimeException("RuleForHints is null which shouldn't happen");
        }
        // so at the moment we know what a user wrote (the part where parser failed to create a correct node) and what
        // rule we're expecting the user to follow when writing. Now we can generate possible words
        // the user can write here
        return getHints(ruleForHints, userWrittenTokenPart);
    }

    private List<String> getHints(Rule ruleForHints, String userWrittenTokenPart) {
        List<Tree> rawHints = getFirstHintableNodesInRule(ruleForHints);
        List<String> hints = new ArrayList<>();
        for (Tree node : rawHints) {
            Set<String> regexpsForTheNode =
                    ArangoGrammarRulesSingleton.getInstance().getLexerRegexpsByNames().get(node.getText());
            for (String regexp : regexpsForTheNode) {
                RgxGen rgxGen = new RgxGen(regexp);
                if (rgxGen.getUniqueEstimation().isEmpty()) {
                    continue;
                }
                String generatedPossibleHint = rgxGen.generate(HINTS_GENERATOR_RANDOM);
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

    private List<ParseTree> getAllChildesOf(ParseTree parent) {
        if (parent.getChildCount() == 0) {
            return Collections.emptyList();
        }
        ArrayList<ParseTree> result = new ArrayList<>();
        for (int i = 0; i < parent.getChildCount(); i++) {
            result.add(parent.getChild(i));
            result.addAll(getAllChildesOf(parent.getChild(i)));
        }
        return result;
    }

    private int getNodeIndexInParentNode(ParseTree child) {
        ParseTree parent = child.getParent();
        if (parent == null) {
            return -1;
        }
        for (int i = 0; i < parent.getChildCount(); i++) {
            if (child == parent.getChild(i)) {
                return i;
            }
        }
        return -1;
    }

    private ParseTree tryFindErrorMissingNodeInSiblingsAndAncestors(ParseTree node) {
        if (isNodeErrorMissing(node)) {
            return node;
        }
        ParseTree parent = node.getParent();
        if (parent == null) {
            return null;
        }
        for (int i = parent.getChildCount() - 1; i >= 0; i--) {
            // yes we're duplicating the check above for the argument node, but I haven't found any good solution for it
            if (isNodeErrorMissing(parent.getChild(i))) {
                return parent.getChild(i);
            }
        }
        return tryFindErrorMissingNodeInSiblingsAndAncestors(parent);
    }

    private boolean isNodeErrorMissing(ParseTree node) {
        if (node instanceof ErrorNode possibleMissingNode) {
            if (possibleMissingNode.getSymbol().getStartIndex() < 0
                    && possibleMissingNode.getSymbol().getStopIndex() < 0
            ) {
                return true;
            }
            // not sure if we can reach this line. Let's throw an exception in case if we do to debug this later
            throw new RuntimeException("The node was an ErrorNode but not a missing one. Unexpected behaviour");
        }
        return false;
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
                            ArangoGrammarRulesSingleton.getInstance().getParserRulesByNames().get(child.toString())
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
        if (parent.getChildCount() > 1 && node.getText().equals(EOF_NODE_TEXT)) {
            node = parent.getChild(parent.getChildCount() - 2);
        }
        while (node.getChildCount() > 0) {
            node = node.getChild(node.getChildCount() - 1);
        }
        return node;
    }
}
