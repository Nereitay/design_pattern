package es.kiwi.creational.factory_method.example7;

public class client2 {
    public static void main(String[] args) {
        //创建需要使用的Creator对象
        ExportOperate operate = new ExportOperate2();
        //🦉下面变换传入的参数来测试参数化工厂方法
        operate.export(1,"测试数据");
        operate.export(2,"测试数据");
        operate.export(3,"测试数据");
    }
}
