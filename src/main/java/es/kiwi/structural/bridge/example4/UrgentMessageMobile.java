package es.kiwi.structural.bridge.example4;

public class UrgentMessageMobile implements UrgentMessage {
    /**
     * 发送消息
     *
     * @param message 要发送的消息内容
     * @param toUser  把消息发送的目的人员
     */
    @Override
    public void send(String message, String toUser) {
        message = "加急：" + message;
        System.out.println("使用手机的方式，发送消息'" + message + "'给" + toUser);
    }

    /**
     * 监控某消息的处理过程
     *
     * @param messageId 被监控的消息的编号
     * @return 包含监控到的数据对象，这里示意一下，所以用了Object
     */
    @Override
    public Object watch(String messageId) {
        //获取相应的数据，组织成监控的数据对象，然后返回
        return null;
    }
}
