import javax.script.ScriptException;

public class Print extends Operator {
    public Print(String code) {
        super(code);
    }

    @Override
    public void exec(Interpreter inte) { //публичный конструктор с одним аргументом
        Object res = null;
        inte.next(); // переход на следующую строку
        String trim = code.trim();
        if (trim.startsWith("\"")) {
            String qoutedStr = trim.substring(1, trim.length() - 2);
            if (trim.endsWith(";")){
                System.out.print(qoutedStr);
            } else {
                System.out.println(qoutedStr);
            }
            return;
        }
        try {
            res = Expression.eval(inte.getVars(), code); //!!! вызываем класс Expression который считает выражение
            System.out.println(res);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
