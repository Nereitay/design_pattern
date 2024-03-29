package es.kiwi.structural.flyweight.example2;

/**
 * 不需要共享的Flyweight对象，
 * 通常是将被共享的享元对象作为子节点，组合出来的对象
 */
public class UnsharedConcreteFlyweight implements Flyweight {
    /**
     * 示例，描述对象的状态
     */
    private String allState;


    /**
     * 示例操作，传入外部状态
     *
     * @param extrinsicState 示例参数，外部状态
     */
    @Override
    public void operation(String extrinsicState) {
        //具体的功能处理
    }
}
