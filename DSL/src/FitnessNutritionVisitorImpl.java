import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FitnessNutritionVisitorImpl extends FitnessNutritionBaseVisitor<Void> {
    private final JSONObject json = new JSONObject();
    private final JSONArray used = new JSONArray();
    private final JSONArray created = new JSONArray();
    private final JSONArray generated = new JSONArray();
    private final JSONArray outputs = new JSONArray();
    private final JSONArray loops = new JSONArray();

    public JSONObject getJson() {
        json.put("used", used);
        json.put("created", created);
        json.put("generated", generated);
        json.put("outputs", outputs);
        json.put("loops", loops);
        return json;
    }

    @Override
    public Void visitUsingStmt(FitnessNutritionParser.UsingStmtContext ctx) {
        used.put(ctx.getText());
        return null;
    }

    @Override
    public Void visitCreateStmt(FitnessNutritionParser.CreateStmtContext ctx) {
        JSONObject obj = new JSONObject();
        obj.put("type", ctx.identifier(0).getText());
        obj.put("name", ctx.identifier(1).getText());
        created.put(obj);
        return null;
    }

    @Override
    public Void visitGenerateStmt(FitnessNutritionParser.GenerateStmtContext ctx) {
        generated.put(ctx.getText());
        return null;
    }

    @Override
    public Void visitOutputStmt(FitnessNutritionParser.OutputStmtContext ctx) {
        outputs.put(ctx.getText());
        return null;
    }

    @Override
    public Void visitWhileStmt(FitnessNutritionParser.WhileStmtContext ctx) {
        loops.put("while");
        return visitChildren(ctx);
    }

    @Override
    public Void visitForStmt(FitnessNutritionParser.ForStmtContext ctx) {
        loops.put("for");
        return visitChildren(ctx);
    }

    @Override
    public Void visitForeachStmt(FitnessNutritionParser.ForeachStmtContext ctx) {
        loops.put("foreach");
        return visitChildren(ctx);
    }
}