package es.kiwi.behavioral.mediator.example1;

/**
 * 具体的同事类B
 */
public class ConcreteColleagueB extends Colleague {
    /**
     * 构造方法，传入中介者对象
     *
     * @param mediator 中介者对象
     */
    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }

    /**
     * 示意方法，执行某些业务功能
     */
    public void someOperation() {
        //在需要跟其他同事通信的时候，通知中介者对象
        getMediator().changed(this);
    }
}
