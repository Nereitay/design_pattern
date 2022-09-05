package es.kiwi.behavioral.mediator.solution.sample;

/**
 * 同事类的抽象父类
 *
 * 示例中的抽象类是没有定义抽象方法的，主要是用来约束所有同事类的类型
 */
public abstract class Colleague {
    /**
     * 持有中介者对象，每一个同事类都知道他的中介者对象
     */
    private Mediator mediator;

    /**
     * 构造方法，传入中介者对象
     * @param mediator 中介者对象
     */
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 获取当前同事类对应的中介者对象
     * @return 对应的中介者对象
     */
    public Mediator getMediator() {
        return mediator;
    }
}
