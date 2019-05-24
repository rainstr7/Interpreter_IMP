import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        Interpreter interpreter = new Interpreter();
        while (true){
            String line = s.nextLine();
            interpreter.parse(line);
        }
    }
}
