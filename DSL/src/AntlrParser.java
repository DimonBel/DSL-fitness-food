import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class AntlrParser {
        public static void main(String[] args) throws IOException {
                String[] files = {
                        "example.txt",
//                        "example2.txt",
//                        "example3.txt"
                };

                JSONObject output = new JSONObject();

                for (String file : files) {
                        System.out.println("\n📄 Parsing file: " + file + "\n");

                        CharStream input = CharStreams.fromFileName(file);
                        FitnessNutritionLexer lexer = new FitnessNutritionLexer(input);
                        CommonTokenStream tokens = new CommonTokenStream(lexer);
                        FitnessNutritionParser parser = new FitnessNutritionParser(tokens);

                        ParseTree tree = parser.program();

                        // 💡 Pretty print the tree in terminal
                        TreePrinter.print(tree, parser);

                        // 💡 Visit the tree and build JSON
                        FitnessNutritionVisitorImpl visitor = new FitnessNutritionVisitorImpl();
                        visitor.visit(tree);
                        output.put(file, visitor.getJson());
                }

                // 💾 Save final combined JSON
                try (FileWriter fw = new FileWriter("output.json")) {
                        fw.write(output.toString(4));
                        System.out.println("\n✅ Saved output.json");
                }
        }
}