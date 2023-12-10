package es.kiwi.behavioral.observer.example5;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义水质监测的目标对象
 */
public abstract class WaterQualitySubject {
    /**
     * 用来保存注册的观察者对象
     */
    protected List<WatcherObserver> observers = new ArrayList<>();

    /**
     * 注册观察者对象
     *
     * @param observer 观察者对象
     */
    public void attach(WatcherObserver observer) {
        observers.add(observer);
    }

    /**
     * 删除观察者对象
     *
     * @param observer 观察者对象
     */
    public void detach(WatcherObserver observer) {
        observers.remove(observer);
    }

    /**
     * 通知相应的观察者对象
     */
    public abstract void notifyWatchers(); // 注意这个方法不再是通知所有的观察者了，现在要按照业务要求去通知

    /**
     * 获取水质污染的级别
     *
     * @return 水质污染的级别
     */
    public abstract int getPolluteLevel();
}
