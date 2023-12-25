package es.kiwi.creational.simple_factory.example1;
/**
 * 客户端：测试使用Api接口
 */
public class Client {
    public static void main(String[] args) {
        Api api = new Impl();
        api.test1("Don't panic, it's just a test :)");
    }
}
/*
* 问题：只是用到了接口的多态部分，违背了接口的思想 - 封装隔离
* 客户端不但知道了接口Api，同时还知道了具体的实现Impl,
* 而实现类应该是被接口封装并同客户端隔离开的，如果把impl从客户端拿掉，出现新问题：
*
* 在java编程中，出现只知接口而不知实现该怎么办？
* */