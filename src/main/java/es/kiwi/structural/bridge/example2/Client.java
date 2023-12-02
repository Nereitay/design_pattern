package es.kiwi.structural.bridge.example2;

public class Client {
	public static void main(String[] args) {
		Message m = new UrgentMessageEmail();
		m.send("aa", "au");

		m = new CommonMessageEmail();
		m.send("aa", "au");
	}
}