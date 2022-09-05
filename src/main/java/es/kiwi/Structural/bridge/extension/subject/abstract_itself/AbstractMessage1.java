package es.kiwi.Structural.bridge.extension.subject.abstract_itself;

import es.kiwi.Structural.bridge.solution.MessageEmail;
import es.kiwi.Structural.bridge.solution.MessageImplementor;
import es.kiwi.Structural.bridge.solution.MessageMobile;
import es.kiwi.Structural.bridge.solution.MessageSMS;

/**
 * 需要外部传入参数
 * 抽象的消息对象
 */
public abstract class AbstractMessage1 {

    /**
     * 持有一个实现部分的对象
     */
    protected MessageImplementor impl;

    /**
     * 构造方法，传入选择实现部分的对象
     *
     * @param type 传入选择实现部分的对象
     */
    public AbstractMessage1(int type) {
        if (type == 1)
            this.impl = new MessageSMS();
        else if (type == 2)
            this.impl = new MessageEmail();
        else if (type == 3)
            this.impl = new MessageMobile();
    }

    /**
     * 发送消息，转调实现部分的方法
     * @param message 要发送的消息内容
     * @param toUser 消息发送的目的人员
     */
    public void sendMessage(String message, String toUser) {
        this.impl.send(message, toUser);
    }
}
