package es.kiwi.behavioral.observer.solution;

/**
 * 观察者，比如报纸的读者
 */
public interface Observer {
    /**
     * 被通知的方法
     * @param subject 具体的目标对象们可以获取报纸的内容
     */
    void update(Subject subject);
}
