package es.kiwi.behavioral.command.example8;

public class Invoker {
    /**
     * 持有命令对象
     */
    private Command cmd;

    /**
     * 设置命令对象
     *
     * @param cmd 命令对象
     */
    public void setCommand(Command cmd) {
        this.cmd = cmd;
    }

    /**
     * 开始打印
     */
    public void startPrint() {
        //执行命令的功能
        this.cmd.execute();
    }
}
