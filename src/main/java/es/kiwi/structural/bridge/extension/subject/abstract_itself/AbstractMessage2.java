package es.kiwi.structural.bridge.extension.subject.abstract_itself;

import es.kiwi.structural.bridge.solution.MessageEmail;
import es.kiwi.structural.bridge.solution.MessageImplementor;
import es.kiwi.structural.bridge.solution.MessageMobile;
import es.kiwi.structural.bridge.solution.MessageSMS;

/**
 * 不需要外部传入参数
 * 抽象的消息对象
 */
public abstract class AbstractMessage2 {
    /**
     * 构造方法
     */
    public AbstractMessage2() {
        //现在什么都不做了
    }

    /**
     * 发送消息，转调实现部分的方法
     * @param message 要发送的消息内容
     * @param toUser 消息发送的目的人员
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
        if (message == null)
            //如果没有消息，默认使用站内短消息
            impl = new MessageSMS();
        else if (message.length() < 100)
            //如果消息长度在100以内，使用手机短消息
            impl = new MessageMobile();
        else if (message.length() < 1000)
            //如果消息长度在1000以内，使用站内短消息
            impl = new MessageSMS();
        else
            //如果消息长度在1000以上，使用邮件
            impl = new MessageEmail();

        return impl;
    }
}
