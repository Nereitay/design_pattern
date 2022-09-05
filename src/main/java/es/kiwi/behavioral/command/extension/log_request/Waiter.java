package es.kiwi.behavioral.command.extension.log_request;

import es.kiwi.behavioral.command.extension.queue_request.Command;

/**
 * 服务员，负责组合菜单
 * 还负责执行调用，相当于标准的Command模式的 Client + Invoker
 */
public class Waiter {
    /**
     * 持有一个宏命令对象-菜单
     */
    private MenuCommand menuCommand = new MenuCommand();


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