package es.kiwi.Behavioral.command.extension.degenerate;

/**
 * Invoker也开始变得智能化
 */
public class Invoker2 {

    public void startPrint(Command2 cmd) {
        System.out.println("在Invoker中，输出服务前");

        //不叫转调，改称为回调了
        cmd.execute();

        System.out.println("输出服务结束");
    }
}
