package es.kiwi.Behavioral.command.extension.parameterized;


import es.kiwi.Behavioral.command.solution.Command;

/**
 * 机箱对象，本身有按钮，持有按钮对应的命令对象
 */
public class Box {

    private Command openCommand;
    /**
     * 重启机器命令对象
     */
    private Command resetCommand;

    /**
     * 设置开机命令对象
     *
     * @param openCommand 开机命令对象
     */
    public void setOpenCommand(Command openCommand) {
        this.openCommand = openCommand;
    }

    /**
     * 设置重启机器命令对象
     *
     * @param resetCommand 重启机器命令对象
     */
    public void setResetCommand(Command resetCommand) {
        this.resetCommand = resetCommand;
    }

    /*原有的开机命令*/
    public void openButtonPressed() {
        //按下按钮，执行命令
        openCommand.execute();
    }

    /**
     * 提供给客户使用，接收并响应用户请求，相当于重启按钮被按下触发的方法
     */
    public void resetButtonPressed() {
        //按下按钮，执行命令
        resetCommand.execute();
    }
}
