package es.kiwi.structural.bridge.solution;

public class ExtremelyUrgentMessage extends AbstractMessage {
    /**
     * 构造方法，传入实现部分的对象
     *
     * @param impl 实现部分的对象
     */
    public ExtremelyUrgentMessage(MessageImplementor impl) {
        super(impl);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "特急：" + message;
        super.sendMessage(message, toUser);
        //还需要增加一条带催促的信息
    }

    public void urge(String messageId) {
        //执行催促的业务，发出催促的信息
    }
}
