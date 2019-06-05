import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader fr = new BufferedReader(new FileReader("/home/ihahn/IdeaProjects/Interpreter_IMP(JB)/quard.bas"));
        //  Scanner s = new Scanner(System.in);
        Interpreter interpreter = new Interpreter();
        while (true){
        // String line = s.nextLine();
            String line = fr.readLine();
            System.out.println(line);
            if (line == null) break;
            interpreter.parse(line);
        }
        interpreter.run();
    }
}
