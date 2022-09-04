package es.kiwi.Creational.factory_method.example;

/**
 * 创建器，声明工厂方法，
 *      工厂方法通常会返回一个Product类型的实例对象，而且多是抽象方法。
 *      也可以在Creator里面提供工厂方法的默认实现形式，让工厂方法返回一个缺省的Product类型的实例对象。
 */
public abstract class Creator {
    /**
     * 创建Product的工厂方法
     * @return Product对象
     */
    protected abstract Product factoryMethod();

    /**
     * 示意方法，实现某些功能的方法
     */
    public void someOperation() {
        //通常在这些方法实现中需要调用工厂方法来获取Product对象
        Product product = factoryMethod();
    }
}
