package es.kiwi.behavioral.command.extension.queue_request;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 命令队列的类
 */
public class CommandQueue {
    /**
     * 用来存储命令对象的队列
     */
    private static Queue<Command> cmds = new LinkedList<>();

    /**
     * 服务员传过来一个新的菜品需要同步
     * 因为同时会有很多的服务员传日菜单，而同时又有很多厨师在从队列里取值
     *
     * @param menu 传入的菜单
     */
    public synchronized static void addMenu(MenuCommand menu) {
        //一个菜单对象包含很多命令对象
        cmds.addAll(menu.getCommands());
    }

    /**
     * 厨师从命令队列里面获取命令对象进行处理，也是需要同步的
     * @return
     */
    public synchronized static Command getOneCommand() {
        Command cmd = null;
        if (cmds.size() > 0) {
            //取出队列的第一个，因为是约定的按照加入的先后来处理
            //同时从队列里面取掉这个命令对象
            cmd = cmds.poll();
        }

        return cmd;
    }
    /*
        如果命令队列里面没有命令，而厨师又来获取命令，需要使用wait/notify来进行线程调度
     */
}
