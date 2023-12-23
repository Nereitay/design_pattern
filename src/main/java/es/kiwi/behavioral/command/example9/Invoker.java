package es.kiwi.behavioral.command.example9;

/**
 * <p>Invoker也开始智能化 - Java回调机制</p>
 */
public class Invoker {// Invoker退化成一个方法
    public void startPrint(Command cmd) {
        System.out.println("在Invoker中，输出服务前");
        /*回调*/
        cmd.execute();
        System.out.println("输出服务结束");
    }
}
