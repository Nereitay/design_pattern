package es.kiwi.behavioral.observer.example3;

/**
 * 真正的读者，为了简单就描述一下姓名
 */
public class Reader implements Observer {
    /**
     * 读者的姓名
     */
    private String name;


    /**
     * 被通知的方法，直接把报纸的内容推送过来
     *
     * @param content 报纸的内容
     */
    @Override
    public void update(String content) {
        //这是采用推的方式
        System.out.println(name + "收到报纸了，阅读它。推模型 内容是===" + content); // 变化就在这里，直接接受传入的数据就可以了
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
