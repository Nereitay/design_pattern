package es.kiwi.structural.bridge.mosh;

public class RemoteControl1 {

    protected Device device;

    public RemoteControl1(Device device) {
        this.device = device;
    }

    public void turnOn() {
        device.turnOn();
    }
    public void turnOff() {
        device.turnOff();
    }
}
