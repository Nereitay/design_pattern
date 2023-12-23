package es.kiwi.behavioral.command.example4;

/**
 * <p>基本实现</p>
 * 计算器类，计算器上有加法按钮、减法按钮
 */
public class Calculator0 {
    /**
     * 持有执行加法的命令对象
     */
    private Command addCmd;
    /**
     * 持有执行减法的命令对象
     */
    private Command subtractCmd;

    /**
     * 设置执行加法的命令对象
     *
     * @param addCmd 执行加法的命令对象
     */
    public void setAddCmd(Command addCmd) {
        this.addCmd = addCmd;
    }

    /**
     * 设置执行减法的命令对象
     *
     * @param subtractCmd 执行减法的命令对象
     */
    public void setSubtractCmd(Command subtractCmd) {
        this.subtractCmd = subtractCmd;
    }

    /**
     * 提供给客户使用，执行加法功能
     */
    public void addPressed() {
        this.addCmd.execute();
    }

    /**
     * 提供给客户使用，执行减法功能
     */
    public void subtractPressed() {
        this.subtractCmd.execute();
    }
}
