package es.kiwi.structural.facade.example2;

public class Client {

    public static void main(String[] args) {
        //使用Facade
        new Facade().test();

        /*有外观但可以不使用*/
        AModuleApi a = new AModuleImpl();
        a.testA(); // 直接调用
    }
}
