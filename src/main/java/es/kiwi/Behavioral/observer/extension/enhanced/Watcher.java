package es.kiwi.Behavioral.observer.extension.enhanced;

/**
 * 具体的观察者实现
 */
public class Watcher implements WatchObserver{
    /**
     * 职务
     */
    private String job;

    /**
     * 收到通知后的处理
     * @param subject 传入被观察者的目标对象
     */
    @Override
    public void update(WaterQualitySubject subject) {
        //这里采用的是拉的方式
        System.out.println(job + "获取到通知，当前污染级别为：" + subject.getPolluteLevel());

    }

    @Override
    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String getJob() {
        return this.job;
    }
}
