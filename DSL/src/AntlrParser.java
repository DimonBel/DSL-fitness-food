import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class AntlrParser {
        public static void main(String[] args) throws IOException {
                String[] files = {
                        "example.txt",
                };

                // We'll now store the final JSON object directly
                JSONObject finalOutput = null;

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

                        // Get the inner JSON structure directly
                        finalOutput = visitor.getJson();

                        // If you're processing multiple files, you might want to break after first one
                        // or handle them differently
                        break;
                }

                // 💾 Save final JSON (without file wrapper)
                if (finalOutput != null) {
                        try (FileWriter fw = new FileWriter("output.json")) {
                                fw.write(finalOutput.toString(4));
                                System.out.println("\n✅ Saved output.json");
                        }
                } else {
                        System.out.println("\n❌ No output generated");
                }
        }
}