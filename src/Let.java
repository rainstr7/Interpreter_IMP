import javax.script.ScriptException;

public class Let extends Operator {
    public Let(String code) {
        super(code);
    }

    // LET x=x-1
    // code = "x=x-1"
    @Override
    public void exec(Interpreter inte) {
        String[] parts = code.split("=");
        try {
            Object val = Expression.eval(inte.getVars(),parts[1]);
            inte.getVars().put(parts[0].trim(), Double.parseDouble(val.toString()));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        inte.next();
    }
}
