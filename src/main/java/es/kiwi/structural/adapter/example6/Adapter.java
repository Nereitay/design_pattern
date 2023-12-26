package es.kiwi.structural.adapter.example6;

/**
 * <p>Adapter能模拟实现简单的Decorator的功能，也就是为已有功能添加功能</p>
 * 适配器
 */
public class Adapter implements Target {
    /**
     * 持有需要被适配的接口对象
     */
    private Adaptee adaptee;

    /**
     * 构造方法，传入需要被适配的对象
     *
     * @param adaptee 需要被适配的对象
     */
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    /**
     * 👇为已有功能添加功能
     */
    @Override
    public void adapterMethod() {
        System.out.println("在调用Adaptee的方法之前完成一定的工作");
        //调用Adaptee的相关方法
        adaptee.method();
        System.out.println("在调用Adaptee的方法之后完成一定的工作");
    }

    /**
     * 示意方法，客户端请求处理的方法
     */
    @Override
    public void request() {
        //可能转调已经实现了的方法，进行适配
        adaptee.specificRequest();
    }
}
