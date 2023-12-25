package es.kiwi.creational.simple_factory.example4;

/**
 * 客户端：测试使用Api接口
 */
public class Client {
    public static void main(String[] args) {
        //🧠 注意这里传递的参数，修改参数就可以修改行为，试试看吧
        Api api = Factory.createApi(2);
        api.test1("Don't panic, it's just a test :)");
    }
}
/*
* 缺点：客户端选择参数，要求必须在一定程度上，向客户暴露一定的内部实现细节
* */

