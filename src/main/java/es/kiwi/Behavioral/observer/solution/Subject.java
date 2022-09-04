package es.kiwi.Behavioral.observer.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标对象，作为被观察者
 */
public class Subject {
    /**
     * 用来保存注册的观察者对象，也就是报纸的订阅者
     */
    private final List<Observer> readers = new ArrayList<>();

    /**
     * 报纸的读者需要向报社订阅，先要注册
     * @param reader 报纸的读者
     * @return 是否注册成功
     */
    public boolean attach(Observer reader) {
       return readers.add(reader);
    }

    /**
     * 报纸的读者可以取消订阅
     * @param reader 报纸的读者
     * @return 是否取消成功
     */
    public boolean detach(Observer reader) {
       return readers.remove(reader);
    }

    /**
     * 当每期报纸印刷出来后，就要迅速主动地被送到读者的手中
     * 相当于通知读者，让他们知道
     */
    protected void notifyObservers() {
        for (Observer reader : readers) {
            reader.update(this);
        }
    }
}
