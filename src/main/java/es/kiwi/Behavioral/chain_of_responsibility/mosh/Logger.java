package es.kiwi.Behavioral.chain_of_responsibility.mosh;

public class Logger extends Handler{
    public Logger(Handler next) {
        super(next);
    }

    @Override
    public boolean doHandle(HttpRequest request) {
        System.out.println("Log");
        return false;
    }
}
