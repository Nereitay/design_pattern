package es.kiwi.structural.bridge.example6;

public class Client {

    public static void main(String[] args) {
        //创建具体的实现对象
        MessageImplementor impl = new MessageSMS();

        //创建一个普通消息对象
        AbstractMessage m = new CommonMessage(impl);
        m.sendMessage("请喝一杯茶", "小李");

        //创建一个紧急消息对象
        m = new UrgentMessage(impl);
        m.sendMessage("请喝一杯茶", "小李");

        //创建一个特急消息对象
        m = new SpecialUrgentMessage(impl);
        m.sendMessage("请喝一杯茶", "小李");

        //把实现方式切换成手机短消息，然后再实现一遍
        impl = new MessageMobile();

        m = new CommonMessage(impl);
        m.sendMessage("请喝一杯茶", "小李");

        m = new UrgentMessage(impl);
        m.sendMessage("请喝一杯茶", "小李");

        m = new SpecialUrgentMessage(impl);
        m.sendMessage("请喝一杯茶", "小李");
    }
}
