package es.kiwi.structural.bridge.scenario;

/**
 * 以E-mail的方式发送普通消息
 */
public class CommonMessageEmail implements Message{

    @Override
    public void send(String message, String toUser) {
        System.out.printf("使用E-mail的方式，发送消息‘%s’给%s%n", message, toUser );
    }
}
