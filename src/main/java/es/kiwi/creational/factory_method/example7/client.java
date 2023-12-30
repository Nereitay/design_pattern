package es.kiwi.creational.factory_method.example7;

public class client {
    public static void main(String[] args) {
        //创建需要使用的Creator对象
        ExportOperate operate = new ExportOperate();
        //🦉调用输出数据的功能方法，传入选择导出类型的参数
        operate.export(1,"测试数据");
    }
}
