package es.kiwi.Creational.abstract_factory.pattern.example;

/**
 * 抽象工厂接口，声明创建抽象产品对象的操作
 */
public interface AbstractFactory {
    /**
     * 示例方法，创建抽象产品A的对象
     * @return 抽象产品A的对象
     */
    AbstractProductA createProductA();

    /**
     * 示例方法，创建抽象产品B的对象
     * @return 抽象产品B的对象
     */
    AbstractProductB createProductB();
}
