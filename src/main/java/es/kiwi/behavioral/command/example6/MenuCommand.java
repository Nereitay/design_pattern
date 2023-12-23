package es.kiwi.behavioral.command.example6;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>命令队列</p>
 * 菜单对象，是个宏命令对象
 */
public class MenuCommand implements Command {
    /**
     * 用来记录组合本菜单的多道菜品，也就是多个命令对象
     */
    private Collection<Command> col = new ArrayList<>();

    /**
     * 点菜，把菜品加入到菜单中
     * @param cmd 客户点的菜
     */
    public void addCommand(Command cmd) {
        col.add(cmd);
    }
    /**
     * 👀👀👀这里发生了变化，以前是循环执行每个命令
     * 执行命令对应的操作
     */
    @Override
    public void execute() {
        //执行菜单就是把菜单传递给后厨
        CommandQueue.addMenu(this);
    }


    /*👇这两个方法对组合命令对象的菜单没有实际意义*/
    /**
     * 设置命令的接收者
     *
     * @param cookApi 命令的接收者
     */
    @Override
    public void setCookApi(CookApi cookApi) {
        // 什么都不做
    }

    /**
     * 返回发起请求的桌号，就是点菜的桌号
     *
     * @return 发起请求的桌号
     */
    @Override
    public int getTableNum() {
        // 什么都不做
        return 0;
    }

    /**
     * 获取菜单中的多个命令对象
     * @return 菜单中的多个命令对象
     */
    public Collection<Command> getCommands() {
        return this.col;
    }
}
