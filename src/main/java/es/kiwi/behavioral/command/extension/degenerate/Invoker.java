package es.kiwi.behavioral.command.extension.degenerate;

public class Invoker {
    /**
     * 持有命令对象
     */
    private Command cmd = null;

    /**
     * 设置命令对象
     * @param cmd 命令对象
     */
    public void setCmd(Command cmd) {
        this.cmd = cmd;
    }

    /**
     * 开始打印
     */
    public void startPrint() {
        //执行命令地功能
        this.cmd.execute();
    }
}
