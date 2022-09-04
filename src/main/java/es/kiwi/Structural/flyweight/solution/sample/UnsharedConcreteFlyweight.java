package es.kiwi.Structural.flyweight.solution.sample;

/**
 * 不需要共享的flyweight对象
 * 通常是将被共享的享元对象作为子节点组合出来的对象
 */
public class UnsharedConcreteFlyweight implements Flyweight{
    /**
     * 示例，描述对象的状态
     */
    private String allState;

    @Override
    public void operation(String extrinsicState) {
        //具体功能处理
    }
}
