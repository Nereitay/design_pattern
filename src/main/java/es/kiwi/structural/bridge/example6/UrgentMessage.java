package es.kiwi.structural.bridge.example6;
/**
 * 加急消息
 */
public class UrgentMessage extends AbstractMessage{
    /**
     * 构造方法，传入实现部分的对象
     *
     * @param impl 实现部分的对象
     */
    public UrgentMessage(MessageImplementor impl) {
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
        message = "加急："+message;
        super.sendMessage(message, toUser);
    }

    /**
     * 扩展自己的新功能，监控某消息的处理过程
     * @param messageId 被监控的消息的编号
     * @return 包含监控到的数据对象，这里示意一下，所以用了Object
     */
    public Object watch(String messageId) {
        //获取相应的数据，组织成监控的数据对象，然后返回
        return null;
    }
}
