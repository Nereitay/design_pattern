package es.kiwi.creational.simple_factory.solution.sample;

/**
 * 接口的具体实现对象A
 */
public class ImplA implements Api{

    @Override
    public void operation(String s) {
        //实现功能的代码，示意一下
        System.out.println("ImplA s == " + s);
    }
}
