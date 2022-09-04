package es.kiwi.Behavioral.chain_of_responsibility.mosh;

public class Main {

    public static void main(String[] args) {
        // Authentication -> Logging -> Compression
        Compressor compressor = new Compressor(null);
        Logger logger = new Logger(compressor);
        Authenticator authenticator = new Authenticator(logger);
        WebServer server = new WebServer(authenticator);
        server.handle(new HttpRequest("-", "1234"));
    }
}
