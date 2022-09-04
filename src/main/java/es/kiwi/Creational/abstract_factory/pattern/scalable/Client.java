package es.kiwi.Creational.abstract_factory.pattern.scalable;

public class Client {

    public static void main(String[] args) {
        ComputerEngineer engineer = new ComputerEngineer();
        AbstractFactory schema = new Schema3();
        engineer.makeHardware(schema);
    }
}
