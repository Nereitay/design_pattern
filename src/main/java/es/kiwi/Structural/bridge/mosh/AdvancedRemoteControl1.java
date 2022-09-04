package es.kiwi.Structural.bridge.mosh;

public class AdvancedRemoteControl1 extends RemoteControl1{

    public AdvancedRemoteControl1(Device device) {
        super(device);
    }

    public void setChannel(int number) {
        device.setChannel(number);
    }
}
