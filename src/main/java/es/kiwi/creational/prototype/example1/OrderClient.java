package es.kiwi.creational.prototype.example1;

public class OrderClient {

    public static void main(String[] args) {
        //创建订单对象，这里为了演示简单，直接new了
        PersonalOrder op = new PersonalOrder();
        //设置订单数据
        op.setOrderProductNum(2925);
        op.setCustomerName("Apple");
        op.setProductId("P0001");

        //这里获取业务处理的类，也直接new了，为了简单，连业务接口都没有做
        OrderBusiness ob = new OrderBusiness();
        //调用业务来保存订单对象
        ob.saveOrder(op);
    }
}

/*
* 问题： instanceof
*
* 1 - 实现订单的通用的处理，是不应该知道订单的具体实现的，更不应该依赖订单的具体实现
* 2 - 难以扩展新的订单类型
*
* 已经有了某个对象实例后，如何能够快速简单地创建出更多的这种对象
* */
