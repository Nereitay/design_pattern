package es.kiwi.Structural.adapter.solution.sample;

/**
 * 适配器
 */
public class Adapter implements Target{

    /**
     * 持有需要被适配的接口对象
     */
    private Adapted adapted;

    /**
     * 构造方法，传入需要被适配的对象
     * @param adapted 需要被适配的对象
     */
    public Adapter(Adapted adapted) {
        this.adapted = adapted;
    }

    @Override
    public void request() {
        //可能转调已经实现的方法，进行适配
        adapted.specificRequest();
    }

    /*适配器模式与装饰模式*/
    public void adapterMethod() {
        System.out.println("在调用Adapted的方法之前完成一定的工作");
        //调用Adapted的相关方法
        adapted.method();
        System.out.println("在调用Adapted的方法之后完成一定的工作");
    }
}
