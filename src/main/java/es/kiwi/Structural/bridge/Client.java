package es.kiwi.Structural.bridge;

import es.kiwi.Structural.bridge.solution.*;

public class Client {

    public static void main(String[] args) {
        /*使用桥接模式重写示例*/
//        bridge();

        /*谁来桥接 -> 谁来负责创建Implementor对象*/
        /*
        * 1. 由客户端负责创建Implementor对象
        * 2. 由抽象部分的对象自己来创建相应的Implementor对象
        * 2.1 一种是需要外部传入参数
        * 2.2 一种是不需要外部传入参数
        * 3. 在Abstraction中创建默认的Implementor对象，然后子类根据需要，看是直接使用覆盖掉
        * 4. 使用抽象工厂或者是简单工厂
        * 5. 使用IoC/DI的方式
        * */



    }

    private static void bridge() {
        //创建具体的实现对象
        MessageImplementor impl = new MessageSMS();
        //创建一个普通的消息对象
        AbstractMessage m = new CommonMessage(impl);
        m.sendMessage("Please have a look and let me know", "Uva");
        //创建一个加急的消息对象
        m = new UrgencyMessage(impl);
        m.sendMessage("Please have a look and let me know", "Uva");
        //创建一个特急的消息对象
        m = new ExtremelyUrgentMessage(impl);
        m.sendMessage("Please have a look and let me know", "Uva");

        //把实现方式切换成手机短消息，然后再实现一遍
        impl = new MessageMobile();

        m = new CommonMessage(impl);
        m.sendMessage("Please have a look and let me know", "Uva");

        m = new UrgencyMessage(impl);
        m.sendMessage("Please have a look and let me know", "Uva");

        m = new ExtremelyUrgentMessage(impl);
        m.sendMessage("Please have a look and let me know", "Uva");
    }
}
