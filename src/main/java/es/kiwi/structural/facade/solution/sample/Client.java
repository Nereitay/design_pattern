package es.kiwi.structural.facade.solution.sample;

public class Client {
    public static void main(String[] args) {
        //使用Facade
//        new Facade().test();
        Facade.test();

        //直接调用, facade了以实现兼顾组合功能和细节功能
        /*AModuleApi a = new AModuleImpl();
        a.testA();*/
    }
}
