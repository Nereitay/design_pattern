package es.kiwi.structural.bridge.example4;

/**
 * 加急消息的抽象接口
 */
public interface UrgentMessage extends Message {
    /**
     * 监控某消息的处理过程
     * @param messageId 被监控的消息的编号
     * @return 包含监控到的数据对象，这里示意一下，所以用了Object
     */
    Object watch(String messageId);
}
