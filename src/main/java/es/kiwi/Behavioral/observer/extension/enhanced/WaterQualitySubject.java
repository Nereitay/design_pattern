package es.kiwi.Behavioral.observer.extension.enhanced;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义水质检测的目标对象
 */
public abstract class WaterQualitySubject {
    /**
     * 用来保存注册的观察者对象
     */
    protected List<WatchObserver> observers = new ArrayList<>();

    /**
     * 通知相应的观察者对象
     *
     * 注意这个方法不再是通知所有的观察者了，现在要按照业务要求去通知
     */
    public abstract void notifyWatchers();

    /**
     * 获取水质污染的级别
     * @return 水质污染的级别
     */
    public abstract int getPolluteLevel();

    /**
     * 注册观察者对象
     * @param observer 观察者对象
     *
     */
    public boolean attach(WatchObserver observer) {
        return observers.add(observer);
    }

    /**
     * 删除观察者对象
     * @param observer 观察者对象
     */
    public boolean detach(WatchObserver observer) {
        return observers.remove(observer);
    }
}
