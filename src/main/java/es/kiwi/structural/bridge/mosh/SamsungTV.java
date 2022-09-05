package es.kiwi.structural.bridge.mosh;

public class SamsungTV implements Device{
    @Override
    public void setChannel(int number) {
        System.out.println("Samsung: setChannel");
    }

    @Override
    public void turnOn() {
        System.out.println("Samsung: turnOn");
    }

    @Override
    public void turnOff() {
        System.out.println("Samsung: turnOff");
    }
}
