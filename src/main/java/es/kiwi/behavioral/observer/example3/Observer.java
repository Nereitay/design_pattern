package es.kiwi.behavioral.observer.example3;

/**
 * <p>推模型</p>
 * 观察者，比如报纸的读者
 */
public interface Observer {
    /**
     * 被通知的方法，直接把报纸的内容推送过来
     *
     * @param content 报纸的内容
     */
    void update(String content);
}
