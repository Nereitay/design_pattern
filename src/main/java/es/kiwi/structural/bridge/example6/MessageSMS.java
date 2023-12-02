package es.kiwi.structural.bridge.example6;

/**
 * 以站内短消息的方式发送消息
 */
public class MessageSMS implements MessageImplementor {
    /**
     * 发送消息
     *
     * @param message 要发送的消息内容
     * @param toUser  把消息发送的目的人员
     */
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用站内短消息的方式，发送消息'" + message + "'给" + toUser);
    }
}
