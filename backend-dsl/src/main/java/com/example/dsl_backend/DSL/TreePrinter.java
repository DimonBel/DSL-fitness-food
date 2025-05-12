package com.example.dsl_backend.DSL;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.ParserRuleContext;

public class TreePrinter {
    public static void print(ParseTree tree, Parser parser) {
        print(tree, parser, 0);
    }

    private static void print(ParseTree tree, Parser parser, int indent) {
        String indentStr = "│  ".repeat(indent);

        if (tree instanceof TerminalNode) {
            String text = tree.getText().replace("\"", "\\\""); // escape quotes
            if (!text.equals("<EOF>")) {
                System.out.println(indentStr + "└── " + text);
            }
        } else {
            String ruleName = parser.getRuleNames()[((ParserRuleContext) tree).getRuleIndex()];
            System.out.println(indentStr + "└── " + ruleName);

            for (int i = 0; i < tree.getChildCount(); i++) {
                print(tree.getChild(i), parser, indent + 1);
            }
        }
    }
}
