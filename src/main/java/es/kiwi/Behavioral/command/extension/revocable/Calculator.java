package es.kiwi.Behavioral.command.extension.revocable;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算器类，计算器上有加法按钮，减法按钮 -> Invoker
 */
public class Calculator {
    /**
     * 持有执行加法的命令对象
     */
    private Command addCmd;
    /**
     * 持有执行减法的命令对象
     */
    private Command subtractCmd;
    /**
     * 命令操作的历史记录，在撤销时使用
     */
    private List<Command> undoCmds = new ArrayList<>();
    /**
     * 命令操作的历史记录，在恢复时使用
     */
    private List<Command> redoCmds = new ArrayList<>();

    public void setAddCmd(Command addCmd) {
        this.addCmd = addCmd;
    }

    public void setSubtractCmd(Command subtractCmd) {
        this.subtractCmd = subtractCmd;
    }

    /**
     * 提供给客户使用，执行加法功能
     */
    public void addPressed() {
        this.addCmd.execute();
        //把操作记录到历史记录里面
        undoCmds.add(this.addCmd);
    }

    /**
     * 提供给客户使用，执行减法功能
     */
    public void subtractPressed() {
        this.subtractCmd.execute();
        //把操作记录到历史记录里面
        undoCmds.add(this.subtractCmd);
    }

    public void undoPressed() {
        if (this.undoCmds.size() > 0) {
            //取出最后一个命令来撤销
            Command cmd = this.undoCmds.get(this.undoCmds.size() - 1);
            cmd.undo();
            //如果还有恢复功能，那就把这个命令记录到恢复的历史记录里面
            this.redoCmds.add(cmd);
            //然后把最后一个命令删除掉
            this.undoCmds.remove(cmd);

        } else {
            System.out.println("很抱歉，没有可撤销的命令");
        }
    }

    public void redoPressed() {
        if (this.redoCmds.size() > 0) {
            //取出最后一个命令来重做
            Command cmd = redoCmds.get(this.redoCmds.size() - 1);
            cmd.execute();
            //把这个命令记录到可撤销的历史记录里面
            this.undoCmds.add(cmd);
            //然后把最后一个命令删除掉
            this.redoCmds.remove(cmd);
        } else
            System.out.println("很抱歉，没有可恢复的命令");
    }
}
