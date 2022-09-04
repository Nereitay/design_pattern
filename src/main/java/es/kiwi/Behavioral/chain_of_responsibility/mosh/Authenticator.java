package es.kiwi.Behavioral.chain_of_responsibility.mosh;

public class Authenticator extends Handler{

    public Authenticator(Handler next) {
        super(next);
    }

    @Override
    public boolean doHandle(HttpRequest request) {
        boolean isValid = (request.getUsername().equals("admin") && "1234".equals(request.getPassword()));
        System.out.println("Authentication");
        return !isValid;
    }
}
