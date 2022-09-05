package es.kiwi.creational.simple_factory.solution;

public class ClientConfigurableFactory {
    public static void main(String[] args) {
        Api api = ConfigurableFactory.createApi();
        api.operation("简单工厂使用配置文件创建");
    }
}
