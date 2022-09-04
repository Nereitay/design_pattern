package es.kiwi.Behavioral.command.extension.log_request;

import es.kiwi.Behavioral.command.extension.queue_request.Command;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 命令队列的类
 */
public class CommandQueue {
    /**
     * 新添加的，文件名称
     */
    private final static String FILE_NAME = "CmdQueue.txt";
    /**
     * 用来存储命令对象的队列
     */
    private static Queue<Command> cmds;

    //从日志中获取上一次还没有做完的命令，如果有，就新建一个队列
    static {
        //获取上次没有做完的命令队列
        cmds = FileOpeUtil.readFile(FILE_NAME);
        if (cmds == null) {
            cmds = new LinkedList<>();
        }
    }

    /**
     * 服务员传过来一个新的菜品需要同步
     * 因为同时会有很多的服务员传日菜单，而同时又有很多厨师在从队列里取值
     *
     * @param menu 传入的菜单
     */
    public synchronized static void addMenu(MenuCommand menu) {
        //一个菜单对象包含很多命令对象
        cmds.addAll(menu.getCommands());

        //记录请求日志
        FileOpeUtil.writeFile(FILE_NAME, cmds);
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

            //记录请求日志
            FileOpeUtil.writeFile(FILE_NAME, cmds);
        }

        return cmd;
    }
}