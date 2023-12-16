package es.kiwi.structural.proxy.example6;

public class Client {
    public static void main(String[] args) {
        //Apple先登录系统创建了一个订单
        Order order = new OrderProxy("Design Pattern", 100, "Apple");
        //Banana想要来修改，那就会报错
        order.setOrderNum(123, "Banana");
        //输出order
        System.out.println("Banana修改后订单记录没有变化：" + order);
        //Apple修改就不会有问题
        order.setOrderNum(123, "Apple");
        //再次输出order
        System.out.println("Apple修改后,订单记录：" + order);
    }
}
