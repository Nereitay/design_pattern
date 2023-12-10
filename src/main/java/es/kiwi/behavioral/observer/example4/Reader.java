package es.kiwi.behavioral.observer.example4;

import java.util.Observable;
import java.util.Observer;

/**
 * 真正的读者，为了简单就描述一下姓名
 */
public class Reader implements Observer { // 注意这里实现的接口是Java提供的
    /**
     * 读者的姓名
     */
    private String name;

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     *            method.
     */
    @Override
    public void update(Observable o, Object arg) {
        //这是采用推的方式
        System.out.println(name + "收到报纸了，阅读它。目标推过来的内容是===" + arg);// 目标实现里面调用的时候必须用推的方式，就是带参数哪个，否则这里会是null

        //这是获取拉的数据
        System.out.println(name + "收到报纸了，阅读它。主动到目标对象去拉的内容是==="
                + ((Newspaper) o).getContent());// 对于拉的方式获取数据，目标实现中怎么调用都行；java默认会传递目标的实现对象本身
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
