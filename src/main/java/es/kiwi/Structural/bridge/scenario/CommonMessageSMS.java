package es.kiwi.Structural.bridge.scenario;

/**
 * 以站内短消息的方式发送普通消息
 */
public class CommonMessageSMS implements Message{

    @Override
    public void send(String message, String toUser) {
        System.out.printf("使用站内短消息的方式，发送消息‘%s’给%s%n", message, toUser );
    }
}
