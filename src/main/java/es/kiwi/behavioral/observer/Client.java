package es.kiwi.behavioral.observer;

import es.kiwi.behavioral.observer.extension.enhanced.Watcher;
import es.kiwi.behavioral.observer.extension.enhanced.WaterQuality;
import es.kiwi.behavioral.observer.solution.NewsPaper;
import es.kiwi.behavioral.observer.solution.Reader;

public class Client {
    public static void main(String[] args) {
        //使用观察者模式. 拉模型
//        observer();

        //推模型
//        push();

        //Java中的观察者模式
//        javaObserver();

        //简单变形示例 -- 区别对待观察者
        //创建水质主题对象
        enhanced();
    }

    private static void enhanced() {
        WaterQuality subject = new WaterQuality();
        //创建几个观察者
        Watcher watcher1 = new Watcher();
        watcher1.setJob("监测人员");

        Watcher watcher2 = new Watcher();
        watcher2.setJob("预警人员");

        Watcher watcher3 = new Watcher();
        watcher3.setJob("监测部门领导");

        //注册观察者
        subject.attach(watcher1);
        subject.attach(watcher2);
        subject.attach(watcher3);

        //填写水质报告
        System.out.println("当水质为正常的时候-----------------------");
        subject.setPolluteLevel(0);
        System.out.println("当水质为轻度污染的时候--------------------");
        subject.setPolluteLevel(1);
        System.out.println("当水质为中度污染的时候--------------------");
        subject.setPolluteLevel(2);
    }

    private static void javaObserver() {
        //创建一个报纸，作为被观察者
        es.kiwi.behavioral.observer.extension.java_observer.NewsPaper subject =
                new es.kiwi.behavioral.observer.extension.java_observer.NewsPaper();
        //创建阅读者，也就是观察者
        es.kiwi.behavioral.observer.extension.java_observer.Reader reader1 =
                new es.kiwi.behavioral.observer.extension.java_observer.Reader();
        reader1.setName("Leon");

        es.kiwi.behavioral.observer.extension.java_observer.Reader reader2 =
                new es.kiwi.behavioral.observer.extension.java_observer.Reader();
        reader2.setName("Ronan");

        es.kiwi.behavioral.observer.extension.java_observer.Reader reader3 =
                new es.kiwi.behavioral.observer.extension.java_observer.Reader();
        reader3.setName("Gus");


        //注册阅读者
        subject.addObserver(reader1);
        subject.addObserver(reader2);
        subject.addObserver(reader3);

        //要出报纸啦
        subject.setContent("本期内容是观察者模式");
    }

    private static void push() {
        //创建一个报纸，作为被观察者
        es.kiwi.behavioral.observer.extension.push_model.NewsPaper subject =
                new es.kiwi.behavioral.observer.extension.push_model.NewsPaper();
        //创建阅读者，也就是观察者
        es.kiwi.behavioral.observer.extension.push_model.Reader reader1 =
                new es.kiwi.behavioral.observer.extension.push_model.Reader();
        reader1.setName("Leon");

        es.kiwi.behavioral.observer.extension.push_model.Reader reader2 =
                new es.kiwi.behavioral.observer.extension.push_model.Reader();
        reader2.setName("Ronan");

        es.kiwi.behavioral.observer.extension.push_model.Reader reader3 =
                new es.kiwi.behavioral.observer.extension.push_model.Reader();
        reader3.setName("Gus");

        //注册阅读者
        subject.attach(reader1);
        subject.attach(reader2);
        subject.attach(reader3);

        //要出报纸了
        subject.setContent("本期的内容是观察者模式");
    }

    private static void observer() {
        //创建一个报纸，作为被观察者
        NewsPaper subject = new NewsPaper();
        //创建阅读者，也就是观察者
        Reader reader1 = new Reader();
        reader1.setName("Leon");

        Reader reader2 = new Reader();
        reader2.setName("Ronan");

        Reader reader3 = new Reader();
        reader3.setName("Gus");

        //注册阅读者
        subject.attach(reader1);
        subject.attach(reader2);
        subject.attach(reader3);

        //要出报纸了
        subject.setContent("本期的内容是观察者模式");
    }
}
