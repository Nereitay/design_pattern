package es.kiwi.behavioral.command.example6;

/**
 * 命令对象，北京烤鸭
 */
public class DuckCommand implements Command {
    /**
     * 持有具体做菜的厨师的对象
     */
    private CookApi cookApi;

    /**
     * 👀👀 使用setter代替constructor， 可以动态切换接受者对象
     * 设置具体做菜的厨师的对象
     *
     * @param cookApi 具体做菜的厨师的对象
     */
    @Override
    public void setCookApi(CookApi cookApi) {
        this.cookApi = cookApi;
    }

    /**
     * 点菜的桌号
     */
    private int tableNum;

    /**
     * 构造方法，传入点菜的桌号
     *
     * @param tableNum 点菜的桌号
     */
    public DuckCommand(int tableNum) {
        this.tableNum = tableNum;
    }

    /**
     * 返回发起请求的桌号，就是点菜的桌号
     *
     * @return 发起请求的桌号
     */
    @Override
    public int getTableNum() {
        return this.tableNum;
    }

    /**
     * 执行命令对应的操作
     */
    @Override
    public void execute() {
        this.cookApi.cook(tableNum, "北京烤鸭");
    }
}
