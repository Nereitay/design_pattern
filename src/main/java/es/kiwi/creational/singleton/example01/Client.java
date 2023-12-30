package es.kiwi.creational.singleton.example01;

public class Client {
    public static void main(String[] args) {
        //创建读取应用配置的对象
        AppConfig config = new AppConfig();

        String paramA = config.getParameterA();
        String paramB = config.getParameterB();

        System.out.println("paramA=" + paramA + ",paramB=" + paramB);
    }
}

/*
* 对于AppConfig这种类，在运行期间，只需要一个实例对象就够了
* 问题：在一个系统运行期间，某个类只需要一个类实例就可以了，那么应该怎样实现呢？
* */
