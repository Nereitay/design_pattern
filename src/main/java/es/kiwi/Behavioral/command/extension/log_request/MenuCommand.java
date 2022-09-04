package es.kiwi.Behavioral.command.extension.log_request;

import es.kiwi.Behavioral.command.extension.queue_request.Command;
import es.kiwi.Behavioral.command.extension.queue_request.CookApi;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单对象，是个宏命令
 */
public class MenuCommand implements Command {
    /**
     * 用来记录组合本菜单的多道菜品，也就是多个命令对象
     */
    private List<Command> list = new ArrayList<>();

    /**
     * 点菜，把菜品加入到菜单中
     *
     * @param cmd 客户点的菜
     */
    public void addCommand(Command cmd) {
        list.add(cmd);
    }

    /**
     * 这里发生了变化，以前是循环执行每个命令
     */
    @Override
    public void execute() {
        //执行菜单就是把菜单传递给后面
        CommandQueue.addMenu(this);
    }

    /**
     * 获取菜单中的多个命令对象
     *
     * @return 菜单中的多个命令对象
     */
    public List<Command> getCommands() {
        return this.list;
    }

    /*
        下面两个方法对子和命令的菜单没有实际意义
         */
    @Override
    public void setCookApi(CookApi cookApi) {
        //什么都不用做
    }

    @Override
    public int getTableNum() {
        //什么都不用做
        return 0;
    }
}