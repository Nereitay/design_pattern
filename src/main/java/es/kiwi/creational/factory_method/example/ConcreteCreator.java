package es.kiwi.creational.factory_method.example;

/**
 * 具体的创建器实现对象， 覆盖实现Creator定义的工厂方法，返回具体的Product实例。
 */
public class ConcreteCreator extends Creator{
    @Override
    protected Product factoryMethod() {
        //重定义工厂方法，返回一个具体的Product对象
        return new ConcreteProduct();
    }
}
