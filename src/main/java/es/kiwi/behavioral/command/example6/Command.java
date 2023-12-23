package es.kiwi.behavioral.command.example6;

/**
 * <p>队列请求</p>
 * 命令接口，声明执行的操作
 */
public interface Command {
    /**
     * 执行命令对应的操作
     */
    void execute();

    /**
     * 设置命令的接收者
     *
     * @param cookApi 命令的接收者
     */
    void setCookApi(CookApi cookApi); //为了后面多线程处理的时候方便使用

    /**
     * 返回发起请求的桌号，就是点菜的桌号
     *
     * @return 发起请求的桌号
     */
    int getTableNum();
}
