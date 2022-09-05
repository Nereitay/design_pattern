package es.kiwi.Structural.bridge.solution;
/**
 * 以E-mail的方式发送消息
 */
public class MessageEmail implements MessageImplementor{
    @Override
    public void send(String message, String toUser) {
        System.out.printf("使用E-mail的方式，发送消息‘%s’给%s%n", message, toUser );
    }
}
