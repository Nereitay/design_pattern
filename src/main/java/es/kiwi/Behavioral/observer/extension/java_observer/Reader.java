package es.kiwi.Behavioral.observer.extension.java_observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 真正的读者，为了简单就描述一下姓名
 */
public class Reader implements Observer {

    /**
     * 读者的姓名
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        //这里采用推的方式
        /*对于要获取推的数据，在目标实现里面调用的时候必须用推的方式，就是带参数的哪个，否则这里会是null*/
        System.out.println(name + "收到报纸了，阅读它。目标推过来的内容是===" + arg);

        /*
        对于要用拉的方式获取数据，在目标实现里面怎么调用都行，有参无参都行， Java默认会传递目标的实现对象本身。
        也就是说，Java实现观察者模式时，默认是拉模型，如果你用推模型调用，那么两种方式都可以获取到值，也就是两种方式可以同时使用
         */
        //这是获取拉的数据
        System.out.println(name + "收到报纸了，阅读它。主动到目标对象去拉的内容是==="
                + ((NewsPaper)o).getContent());

    }
}
