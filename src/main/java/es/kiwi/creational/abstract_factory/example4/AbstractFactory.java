package es.kiwi.creational.abstract_factory.example4;

/**
 * 可扩展的抽象工厂的接口
 */
public interface AbstractFactory {
    /**
     * 一个通用的创建产品对象的方法，为了简单，直接返回Object
     * 也可以为所有被创建的产品定义一个公共的接口
     *
     * @param type 具体创建的产品类型标识
     * @return 创建出的产品对象
     */
    Object createProduct(int type); // 这个参数只是用来标识现在是在创建什么类型的产品，不再进一步表示具体是什么样的
}
