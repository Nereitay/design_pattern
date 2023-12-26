package es.kiwi.structural.adapter.example6;

/**
 * 使用适配器的客户端
 */
public class Client {
    public static void main(String[] args) {
        //创建需被适配的对象
        Adaptee adaptee = new Adaptee();
        //创建客户端需要调用的接口对象
        Target target = new Adapter(adaptee);
        //请求处理
        target.request();

        // 👇模拟实现简单的Decorator的功能
        target.adapterMethod();
    }
}
