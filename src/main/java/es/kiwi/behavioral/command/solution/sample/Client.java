package es.kiwi.behavioral.command.solution.sample;

/**
 * 注意这个不是我们通常意义上的测试客户端，
 * 主要功能是要创建命令对象并设定它的接收者，因此这里并没有调用执行的代码
 */
public class Client {
    /**
     * 示意，负责创建命令对象，并设定它的接收者
     */
    public void assemble() {
        //创建接收者
        Receiver receiver = new Receiver();
        //创建命令对象，设定他的接收者
        ConcreteCommand command = new ConcreteCommand(receiver);

        //创建Invoke,把命令对象设置进去
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
    }
}
