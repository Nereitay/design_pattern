package es.kiwi.behavioral.mediator.example1;

/**
 * 具体的中介者实现
 */
public class ConcreteMediator implements Mediator {
    /**
     * 持有并维护同事A
     */
    private ConcreteColleagueA colleagueA;
    /**
     * 持有并维护同事B
     */
    private ConcreteColleagueB colleagueB;

    /**
     * 设置中介者需要了解并维护的同事A对象
     *
     * @param colleagueA 同事A对象
     */
    public void setColleagueA(ConcreteColleagueA colleagueA) {
        this.colleagueA = colleagueA;
    }

    /**
     * 设置中介者需要了解并维护的同事B对象
     *
     * @param colleagueB 同事B对象
     */
    public void setColleagueB(ConcreteColleagueB colleagueB) {
        this.colleagueB = colleagueB;
    }

    /**
     * 同事对象在自身改变的时候来通知中介者的方法，
     * 让中介者去负责相应的与其他同事对象的交互
     *
     * @param colleague 同事对象自身，好让中介者对象通过对象实例
     *                  去获取同事对象的状态
     */
    @Override
    public void changed(Colleague colleague) {
        //某个同事类发生了变化，通常需要与其他同事交互
        //具体协调相应的同事对象来实现协作行为
    }
}
