package es.kiwi.structural.bridge.example7;

/**
 * 谁来桥接？
 *  - 2.在Abstraction中创建默认的Implementor对象，然后子类根据需要，看是直接使用还是覆盖掉
 * 抽象的消息对象
 */
public class AbstractMessage3 {

    protected MessageImplementor impl;

    /**
     * 构造方法
     *
     */
    public AbstractMessage3() {
       // 创建一个默认的实现
        this.impl = new MessageSMS();
    }

    public void sendMessage(String message, String toUser) {
        this.impl.send(message, toUser);
    }

}
