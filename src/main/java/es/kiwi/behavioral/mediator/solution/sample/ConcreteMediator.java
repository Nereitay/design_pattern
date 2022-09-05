package es.kiwi.behavioral.mediator.solution.sample;

/**
 * 具体中介者实现
 */
public class ConcreteMediator implements Mediator{
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
     * @param colleague 同事A对象
     */
    public void setColleagueA(ConcreteColleagueA colleague) {
        this.colleagueA = colleague;
    }
    /**
     * 设置中介者需要了解并维护的同事B对象
     * @param colleague 同事B对象
     */
    public void setColleagueB(ConcreteColleagueB colleague) {
        this.colleagueB = colleague;
    }

    @Override
    public void changed(Colleague colleague) {
        //某个同事类发生变化，通常需要与其他同事交互
        //具体协调相应的同时对象来实现协作行为
    }
}
