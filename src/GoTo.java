public class GoTo extends Operator {
    public GoTo(String code) {
        super(code);
    }

    @Override
    public void exec(Interpreter inte) {
        inte.goTo(Integer.parseInt(code));
    }
}
