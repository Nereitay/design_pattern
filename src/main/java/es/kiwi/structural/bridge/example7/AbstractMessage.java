package es.kiwi.structural.bridge.example7;

/**
 * 谁来桥接？
 *  - 1.由抽象部分自己来创建相应的Implementor对象
 *      -- 1.1. 需要外部传入参数
 *  优点：客户使用简单，而且集中控制Implementor对象的创建和切换逻辑
 *  缺点：要求Abstraction知道所有的具体的Implementor，并知道如何选择和创建它们，
 *       如果及后要扩展Implementor的实现，就要求同时修改Abstraction的实现，这会很不灵活，是扩展不方便
 *
 * 抽象的消息对象
 */
public class AbstractMessage {
    /**
     * 持有一个实现部分的对象
     */
    protected MessageImplementor impl;

    /**
     * 构造方法，传入选择实现部分的类型
     *
     * @param type 传入选择实现部分的类型
     */
    public AbstractMessage(int type) {
        if (type == 1) {
            this.impl = new MessageSMS();
        } else if (type == 2) {
            this.impl = new MessageEmail();
        } else if (type == 3) {
            this.impl = new MessageMobile();
        }
    }

    /**
     * 发送消息，转调实现部分的方法
     *
     * @param message 要发送的消息内容
     * @param toUser  把消息发送的目的人员
     */
    public void sendMessage(String message, String toUser) {
        this.impl.send(message, toUser);
    }

}
