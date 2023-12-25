package es.kiwi.creational.simple_factory.example5;

/**
 * 客户端：测试使用Api接口
 */
public class Client {
    public static void main(String[] args) {
        //🧠 不用再传入参数了
        Api api = Factory.createApi();
        api.test1("Don't panic, it's just a test :)");
    }
}


