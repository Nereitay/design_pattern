package es.kiwi.Structural.bridge.solution;


public class MessageMobile implements MessageImplementor {
    @Override
    public void send(String message, String toUser) {
        System.out.printf("使用手机短消息的方式，发送消息‘%s’给%s%n", message, toUser );
    }
}
