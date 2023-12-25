package es.kiwi.creational.simple_factory.example2;

/**
 * 接口的具体实现对象A
 */
public class ImplA implements Api {
    /**
     * 示意，具体的功能方法的定义
     *
     * @param s 示意，需要的参数
     */
    @Override
    public void operation(String s) {
        //实现功能的代码，示意一下
        System.out.println("ImplA s == " + s);
    }
}
