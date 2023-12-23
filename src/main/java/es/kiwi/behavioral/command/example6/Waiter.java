package es.kiwi.behavioral.command.example6;

import es.kiwi.behavioral.command.example5.ColdCook;
import es.kiwi.behavioral.command.example5.PorkCommand;

/**
 * 服务员，负责组合菜单，还负责执行调用
 */
public class Waiter {
    /**
     * 持有一个宏命令对象——菜单
     */
    private MenuCommand menuCommand = new MenuCommand();

    /**
     * 👀👀👀客户点菜
     *
     * @param cmd 客户点的菜，每道菜是一个命令对象
     */
    public void orderDish(Command cmd) {
        //添加到菜单中
        menuCommand.addCommand(cmd);
    }

    /**
     * 客户点菜完毕，表示要执行命令了，这里就是执行菜单这个组合命令
     */
    public void orderOver() {
        this.menuCommand.execute();
    }
}
