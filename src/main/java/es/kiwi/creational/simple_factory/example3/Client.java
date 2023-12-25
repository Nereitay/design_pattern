package es.kiwi.creational.simple_factory.example3;

/**
 * 客户端：测试使用Api接口
 */
public class Client {
    public static void main(String[] args) {
        //🧠重要改变，没有new Impl()了，取而代之Factory.createApi()
        Api api = Factory.createApi();
        api.test1("Don't panic, it's just a test :)");
    }
}

