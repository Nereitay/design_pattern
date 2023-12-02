package es.kiwi.structural.bridge.example6;

/**
 * 特急消息
 */
public class SpecialUrgentMessage extends AbstractMessage {
    /**
     * 构造方法，传入实现部分的对象
     *
     * @param impl 实现部分的对象
     */
    public SpecialUrgentMessage(MessageImplementor impl) {
        super(impl);
    }

    /**
     * 发送消息，转调实现部分的方法
     *
     * @param message 要发送的消息内容
     * @param toUser  把消息发送的目的人员
     */
    @Override
    public void sendMessage(String message, String toUser) {
        message = "特急："+message;
        super.sendMessage(message, toUser);
        //还需要增加一条待催促的信息
    }

    /**
     * 扩展自己的新功能
     * @param messageId
     */
    public void hurry(String messageId) {
        //执行催促的业务，发出催促的信息
    }
}
