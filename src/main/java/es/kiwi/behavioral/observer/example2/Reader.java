package es.kiwi.behavioral.observer.example2;

/**
 * 真正的读者，为了简单就描述一下姓名
 */
public class Reader implements Observer {
    /**
     * 读者的姓名
     */
    private String name;

    /**
     * 被通知的方法
     *
     * @param subject 具体的目标对象，可以获取报纸的内容
     */
    @Override
    public void update(Subject subject) {
        //这是采用拉的方式, 最简单的处理，输出了接收到的内容
        System.out.println(name + "收到报纸了，阅读它。内容是===" + ((Newspaper) subject).getContent());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
