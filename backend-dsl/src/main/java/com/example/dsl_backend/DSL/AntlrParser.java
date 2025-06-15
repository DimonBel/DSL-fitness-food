package com.example.dsl_backend.DSL;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileWriter;
import java.io.IOException;

public class AntlrParser {

        
        public static void parse() throws IOException {
                String[] files = {
                        "src/main/resources/example.txt",
                };

                for (String file : files) {
                        System.out.println("parsing file: " + file);

                        CharStream input = CharStreams.fromFileName(file);
                        FitnessNutritionLexer lexer = new FitnessNutritionLexer(input);
                        CommonTokenStream tokens = new CommonTokenStream(lexer);
                        FitnessNutritionParser parser = new FitnessNutritionParser(tokens);

                        ParseTree tree = parser.program();

                        // print tree in terminal
                        TreePrinter.print(tree, parser);

                        // get json representation of the parse tree
                        String parseTreeJson = ParseTreeToJsonUtil.toJson(tree);
                        System.out.println("\nparse tree as json:\n");
                        System.out.println(parseTreeJson);

                        // save the parse tree json to file
                        try (FileWriter fw = new FileWriter("parseTree.json")) {
                                fw.write(parseTreeJson);
                                System.out.println("saved parseTree.json");
                        }
                }
        }

}