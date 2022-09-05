package es.kiwi.creational.simple_factory.solution;

/**
 * 客户端，使用api接口
 */
public class Client {
    public static void main(String[] args) {
        //通过简单工厂来获取接口对象
        Api api = Factory.createApi(1);
        api.operation("Simple Factory dp");
    }
}
