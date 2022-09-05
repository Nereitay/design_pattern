package es.kiwi.structural.bridge.mosh;

public class Main {

    public static void main(String[] args) {

        RemoteControl1 remoteControl1 = new RemoteControl1(new SonyTV());
        remoteControl1.turnOn();
        AdvancedRemoteControl1 advancedRemoteControl1 = new AdvancedRemoteControl1(new SonyTV());
        advancedRemoteControl1.setChannel(1);

        AdvancedRemoteControl1 advancedRemoteControl2 = new AdvancedRemoteControl1(new SamsungTV());
        advancedRemoteControl2.setChannel(2);
    }
}
