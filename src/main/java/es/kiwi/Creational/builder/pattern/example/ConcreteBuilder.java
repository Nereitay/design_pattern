package es.kiwi.Creational.builder.pattern.example;

/**
 * 具体生成器实现对象
 */
public class ConcreteBuilder implements Builder{
    /**
     * 生成器最终构建的产品对象
     */
    private Product resultProduct;

    /**
     * 获取生成器最终构建的产品对象
     * @return 生成器最终构建的产品对象
     */
    public Product getResult() {
        return resultProduct;
    }

    @Override
    public void buildPart() {
        //构造某个部件的功能处理
    }
}
