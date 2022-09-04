package es.kiwi.Structural.bridge.mosh;

public class SonyAdvancedRemoteControl extends AdvancedRemoteControl{
    @Override
    public void setChannel() {
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
