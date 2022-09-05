package es.kiwi.behavioral.observer.solution;

/**
 * 报纸对象，具体的目标实现
 */

public class NewsPaper extends Subject {
    /**
     * 报纸的具体内容
     */
    private String content;

    public String getContent() {
        return content;
    }

    /**
     * 示意设置报纸的具体内容，相当于要出版报纸了
     * @param content 报纸的具体内容
     *
     * 触发通知的时机 =>> 目标要先修改自己的数据再发出通知
     */
    public void setContent(String content) {
        this.content = content;

        //内容有了，说明又出报纸了，那就通知所有的读者
        notifyObservers();
    }
}
