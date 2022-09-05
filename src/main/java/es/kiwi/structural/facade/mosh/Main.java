package es.kiwi.structural.facade.mosh;

public class Main {
    public static void main(String[] args) {

        NotificationServer server = new NotificationServer();
        Connection connection = server.connect("ip");
        AuthToken authToken = server.authenticate("appID", "key");
        Message message = new Message("Hello World");
        server.send(authToken, message, "target");
        connection.disconnect();

        System.out.println("------------Facade Pattern------------");

        NotificationService service = new NotificationService();
        service.send("Hello World", "target");

    }
}
