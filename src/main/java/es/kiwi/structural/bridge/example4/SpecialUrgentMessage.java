package es.kiwi.structural.bridge.example4;

/**
 * 特急消息的抽象接口
 */
public interface SpecialUrgentMessage extends Message {
	void hurry(String messageId);
}