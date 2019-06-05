
abstract public class Operator {
    String code;

    public  Operator(String code){
        this.code = code;
    }

    abstract public void exec(Interpreter inte);

    @Override
    public String toString() {
        return getClass().getName().toUpperCase() + " " + code;
    }
}
