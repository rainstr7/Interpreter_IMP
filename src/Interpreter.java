import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Interpreter {
    TreeMap<Integer, Operator> code = new TreeMap<Integer, Operator>(); //code - хранит программу TreeMap отображение
    Map<String, Double> vars = new HashMap<String, Double>();
    Integer curLine;

    //переход на следующую строку
    public void next(){
        curLine = code.higherKey(curLine); //позволяет посмотреть следующую строку

    }
    //переход на заданную строку
    public void goTo(int line){
    curLine = line;
    }

    public void run(){
        curLine = code.firstKey();
        while(true) {
            Operator operator = code.get(curLine);
            operator.exec(this);
            if (curLine == null) break;
        }
    }

    //20 LET x=3 - парсим строку, разбиваем на части по пробелам
    public void parse(String line){
        if (line.equalsIgnoreCase("RUN")) {   //команда запуска
            this.run();
            return;
        }

        if (line.equalsIgnoreCase("LIST" )) {  //команда вывода на экран
            for(int l: code.keySet()){
                System.out.println(l + " " +  code.get(l));
            }
            return;
        }
        String parts[] = line.split(" ");
        int lineNumber = Integer.parseInt(parts[0]);
        String opName = parts[1];
        Operator operator = OperatorFactury.createOperator(opName, line.substring(parts[0].length() + parts[1].length()) + 2);
        code.put(lineNumber, operator);
    }

    public Map<String,Double> getVars(){
        return vars;
    }
}
