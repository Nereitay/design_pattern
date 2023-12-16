package es.kiwi.structural.proxy.example2;

public class Client {

    public static void main(String[] args) {
        Subject proxy = new Proxy(new RealSubject());
        proxy.request();
    }
}
