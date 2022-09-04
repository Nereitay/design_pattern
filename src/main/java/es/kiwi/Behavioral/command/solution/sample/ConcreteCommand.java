package es.kiwi.Behavioral.command.solution.sample;

/**
 * 具体的命令实现对象
 */
public class ConcreteCommand implements Command{
    /**
     * 持有相应的接收者对象
     */
    private Receiver receiver;

    /**
     * 示意：命令对象可以有自己的状态
     */
    private String state;

    /**
     * 构造方法，传入相应的接收者对象
     * @param receiver 相应的接收者对象
     */
    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //通常会转调接收者对象的相应方法，让接收者来真正执行功能
        receiver.action();
    }
}
