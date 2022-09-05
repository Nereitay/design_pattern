package es.kiwi.structural.bridge.mosh;

public class SonyTV implements Device{
    @Override
    public void setChannel(int number) {
        System.out.println("Sony: setChannel");
    }

    @Override
    public void turnOn() {
        System.out.println("Sony: turnOn");
    }

    @Override
    public void turnOff() {
        System.out.println("Sony: turnOff");
    }
}
