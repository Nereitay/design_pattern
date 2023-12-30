package es.kiwi.creational.abstract_factory.example2;
/**
 * 具体的工厂实现对象，实现创建具体的产品对象的操作
 */
public class ConcreteFactory1 implements AbstractFactory{
    /**
     * 示例方法，创建抽象产品A的对象
     *
     * @return 抽象产品A的对象
     */
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    /**
     * 示例方法，创建抽象产品B的对象
     *
     * @return 抽象产品B的对象
     */
    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
