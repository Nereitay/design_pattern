package es.kiwi.structural.bridge.example7;

/**
 * 谁来桥接？<br>
 *    - 1.由抽象部分自己来创建相应的Implementor对象<br>
 *       -- 1.2. 不需要外部传入参数<br>
 * 优点：客户使用简单，而且集中控制Implementor对象的创建和切换逻辑<br>
 * 缺点：要求Abstraction知道所有的具体的Implementor，并知道如何选择和创建它们，<br>
 *      如果及后要扩展Implementor的实现，就要求同时修改Abstraction的实现，这会很不灵活，是扩展不方便<br>
 * <p>
 * 抽象的消息对象
 */
public class AbstractMessage2 {

    /**
     * 构造方法，传入选择实现部分的类型
     */
    public AbstractMessage2() {
        // 现在什么都不做了
    }

    /**
     * 发送消息，转调实现部分的方法
     *
     * @param message 要发送的消息内容
     * @param toUser  把消息发送的目的人员
     */
    public void sendMessage(String message, String toUser) {
        this.getImpl(message).send(message, toUser);
    }

    /**
     * 根据消息的长度来选择合适的实现
     *
     * @param message 要发送的消息
     * @return 合适的实现对象
     */
    protected MessageImplementor getImpl(String message) {
        MessageImplementor impl = null;
        if (message == null) {
            //如果没有消息，默认使用站内短消息
            impl = new MessageSMS();
        } else if (message.length() < 100) {
            //如果消息长度在100以内，使用手机短消息
            impl = new MessageMobile();
        } else if (message.length() < 1000) {
            //如果消息长度在100-1000以内，使用站内短消息
            impl = new MessageSMS();
        } else {
            //如果消息长度在1000以上
            impl = new MessageEmail();
        }
        return impl;
    }

}
