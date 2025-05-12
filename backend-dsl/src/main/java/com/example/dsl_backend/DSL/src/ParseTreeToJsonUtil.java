import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class ParseTreeToJsonUtil {

    // converts a parse tree to a json string with pretty printing
    public static String toJson(ParseTree tree) {
        JSONObject jsonObject = new JSONObject();
        traverse(tree, jsonObject);
        return jsonObject.toString(4);
    }

    // recursive method to traverse the parse tree and build json structure
    private static void traverse(ParseTree tree, JSONObject json) {
        if (tree == null) return;

        if (tree instanceof TerminalNode) {
            // terminal nodes (tokens)
            Token token = ((TerminalNode) tree).getSymbol();
            json.put("text", token.getText());
        } else {
            // non-terminal nodes (rules)
            String className = tree.getClass().getSimpleName();
            String ruleName = className.endsWith("Context") ?
                    className.substring(0, className.length() - 7) :
                    className;

            // convert first character to lowercase for consistency
            ruleName = Character.toLowerCase(ruleName.charAt(0)) + ruleName.substring(1);

            // create array for children of this rule
            JSONArray children = new JSONArray();
            json.put(ruleName, children);

            // process all children
            for (int i = 0; i < tree.getChildCount(); i++) {
                JSONObject childJson = new JSONObject();
                children.put(childJson);
                traverse(tree.getChild(i), childJson);
            }
        }
    }

    // saves json representation of parse tree to file
    public static void saveJsonToFile(ParseTree tree, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(toJson(tree));
            System.out.println("parse tree json saved to " + filePath);
        }
    }
}