package es.kiwi.Structural.proxy.pattern.protection_proxy.inherition;

public class Client {
    public static void main(String[] args) {
        Order order = new OrderProxy("设计模式", 100, "张三");

        order.setOrderNum(123, "李四");
        System.out.println("李四修改后订单记录没有变化：" + order);

        order.setOrderNum(123, "张三");
        System.out.println("张三修改后，订单记录：" + order);

    }
}
