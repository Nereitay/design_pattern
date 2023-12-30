package es.kiwi.creational.factory_method.example2;

/**
 * 具体的创建器实现对象
 */
public class ConcreteCreator extends Creator {
    /**
     * 创建Product的工厂方法
     *
     * @return Product对象
     */
    @Override
    protected Product factoryMethod() {
        //重定义工厂方法，返回一个具体的Product对象
        return new ConcreteProduct();
    }
}
