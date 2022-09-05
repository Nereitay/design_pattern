package es.kiwi.behavioral.chain_of_responsibility.mosh;

public class Encryptor extends Handler{
    public Encryptor(Handler next) {
        super(next);
    }

    @Override
    public boolean doHandle(HttpRequest request) {
        System.out.println("Encryption");
        return false;
    }
}
