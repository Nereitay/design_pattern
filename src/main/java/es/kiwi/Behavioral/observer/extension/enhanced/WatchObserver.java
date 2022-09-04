package es.kiwi.Behavioral.observer.extension.enhanced;

/**
 * 水质观察者接口定义
 */
public interface WatchObserver {
    /**
     * 被通知的方法
     * @param subject 传入被观察者的目标对象
     */
    void update(WaterQualitySubject subject);

    /**
     * 设置观察人员的职务
     * @param job 观察人员的职务
     */
    void setJob(String job);

    /**
     * 获取观察任务的职务
     * @return 观察人员的职务
     */
    String getJob();
}
