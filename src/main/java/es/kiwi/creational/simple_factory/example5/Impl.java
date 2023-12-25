package es.kiwi.creational.simple_factory.example5;

/**
 * 对接口的实现
 */
public class Impl implements Api {
    /**
     * 某个具体的功能方法的定义，用test1来演示一下。
     * 这里的功能很简单，把传入的s打印输出即可
     *
     * @param s 任意想要打印输出的字符串
     */
    @Override
    public void test1(String s) {
        System.out.println("Now In Impl. The input s == " + s);
    }
}
