package es.kiwi.structural.bridge.solution;
/**
 * 以站内短消息的方式发送消息
 */
public class MessageSMS implements MessageImplementor{
    @Override
    public void send(String message, String toUser) {
        System.out.printf("使用站内短消息的方式，发送消息‘%s’给%s%n", message, toUser );
    }
}
