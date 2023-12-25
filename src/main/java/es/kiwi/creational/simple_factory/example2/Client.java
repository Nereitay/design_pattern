package es.kiwi.creational.simple_factory.example2;

/**
 * 客户端，使用Api接口
 */
public class Client {

    public static void main(String[] args) {
        Api api = Factory.createApi(1);
        api.operation("The Simple Factory is being used ... ");
    }
}
