package es.kiwi.structural.bridge.extension.subject.default_implementor;

import es.kiwi.structural.bridge.solution.MessageImplementor;
import es.kiwi.structural.bridge.solution.MessageSMS;

public abstract class AbstractMessage {

    protected MessageImplementor impl;

    /**
     * 构造方法
     */
    public AbstractMessage() {
        //创建一个默认的实现
        this.impl = new MessageSMS();
    }

    public void sendMessage(String message, String toUser) {
        this.impl.send(message, toUser);
    }
}
