package es.kiwi.behavioral.observer.extension.java_observer;

import java.util.Observable;

/**
 * 报纸对象，具体的目标实现
 */
public class NewsPaper extends Observable {

    /**
     * 报纸的具体内容
     */
    private String content;

    /**
     * 获取报纸的具体内容
     * @return 报纸的具体内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 示意，设置报纸的具体内容，相当于要出版报纸了
     * @param content 报纸的具体内容
     */
    public void setContent(String content) {
        this.content = content;

        //内容有了，说明又出新报纸了，那就通知所有的读者
        /*注意以下实现的改变*/
        /*注意在用java中的Observer模式的时候，下面这句话不可少*/
        this.setChanged();

        //然后注定通知，这里用的是推的方式
        this.notifyObservers(this.content);

        //如果用拉的方式，这么调用
//        this.notifyObservers();
    }
}
