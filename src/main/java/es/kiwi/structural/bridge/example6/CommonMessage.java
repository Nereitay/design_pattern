package es.kiwi.structural.bridge.example6;

public class CommonMessage extends AbstractMessage{
    /**
     * 构造方法，传入实现部分的对象
     *
     * @param impl 实现部分的对象
     */
    public CommonMessage(MessageImplementor impl) {
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
        //对于普通消息，什么都不干，直接调用父类的方法，把消息发送出去就可以了
        super.sendMessage(message, toUser);
    }
}
