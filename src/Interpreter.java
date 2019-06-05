import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Interpreter {
    private TreeMap<Integer, Operator> code = new TreeMap<Integer, Operator>(); //code - хранит программу TreeMap отображение
    private Map<String, Double> vars = new HashMap<String, Double>(); // ?? использовал HashMap для хранения переменной, а для хранения программы использовал TreeMap (в TreeMap дубликаты не храняться)
    private Integer curLine;

    //переход на следующую строку
    public void next(){
        curLine = code.higherKey(curLine); //позволяет посмотреть следующую строку

    }
    //переход на заданную строку
    public void goTo(int line){
    curLine = line;
    }

    public void run(){
        curLine = code.firstKey(); // возвращает первый ключ
        while(true) {
            Operator operator = code.get(curLine); //вытаскиваем оператор
            operator.exec(this); // вызываем exec-у этого оператора
            if (curLine == null) break; // если строки кончились то выходим
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
        try {
            String parts[] = line.split(" ");
            int lineNumber = Integer.parseInt(parts[0]);
            String opName = parts[1];
            Operator operator = OperatorFactury.createOperator(opName, line.substring(parts[0].length() + parts[1].length()) + 2); // взял длину первого кусочка, потом взял длину второго кусочка, сложил, прибавил размер двух пробелов и отрезал все оставшееся (все после названия оператора)
            code.put(lineNumber, operator);
        } catch (RuntimeException e) {
            System.err.println("Wrong operation!");
        }

    }

    public Map<String,Double> getVars(){
        return vars;
    }
}
