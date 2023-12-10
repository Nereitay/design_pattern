package es.kiwi.behavioral.observer.example5;

/**
 * 具体的观察者实现
 */
public class Watcher implements WatcherObserver {
    /**
     * 职务
     */
    private String job;

    /**
     * 被通知的方法
     *
     * @param subject 传入被观察的目标对象
     */
    @Override
    public void update(WaterQualitySubject subject) { //收到通知后的处理
        //这里采用的是拉的方式
        System.out.println(job + "获取到通知，当前污染级别为：" + subject.getPolluteLevel());
    }

    /**
     * 设置观察人员的职务
     *
     * @param job 观察人员的职务
     */
    @Override
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * 获取观察人员的职务
     *
     * @return 观察人员的职务
     */
    @Override
    public String getJob() {
        return this.job;
    }
}
