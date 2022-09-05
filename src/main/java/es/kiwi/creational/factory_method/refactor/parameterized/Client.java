package es.kiwi.creational.factory_method.refactor.parameterized;

public class Client {

    public static void main(String[] args) {
        //创建需要使用的Creator对象
        ExportOperate operate = new ExportOperate();

        //调用输出数据的功能方法
        operate.export(1, "测试数据");


        //使用参数化工厂方法，扩展起来会非常容易
        ExportOperate operate2 = new ExportOperate2();
        operate2.export(1, "Test1");
        operate2.export(2, "Test2");
        operate2.export(3, "Test3");

    }
}
