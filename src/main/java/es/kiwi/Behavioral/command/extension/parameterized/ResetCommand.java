package es.kiwi.Behavioral.command.extension.parameterized;


import es.kiwi.Behavioral.command.solution.Command;

/**
 * 重启机器命令的实现，实现Command接口
 * 持有重启机器命令的真正实现，通过调用接收者的方法来实现命令
 */
public class ResetCommand implements Command {
    /**
     * 持有真正实现命令的接收者-主板对象
     */
    MainBoardApi mainBoard;

    /**
     * 构造方法，传入主板对象
     * @param mainBoard 主板对象
     */
    public ResetCommand(MainBoardApi mainBoard) {
        this.mainBoard = mainBoard;
    }

    @Override
    public void execute() {
        //对于命令对象，根本不知道如何重启机器，会转调主板对象
        //让主板去完成重启机器的功能
        this.mainBoard.reset();
    }
}
