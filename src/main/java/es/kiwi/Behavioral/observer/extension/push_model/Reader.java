package es.kiwi.Behavioral.observer.extension.push_model;

public class Reader implements Observer{
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
    public void update(String content) {
        //这是采用推的方式
        /*变化就在这里，直接接收传入的数据就可以了*/
        System.out.println(name + "收到报纸了，阅读它，内容是 === " + content);

    }
}
