package es.kiwi.Behavioral.command.extension.queue_request;

/**
 * 命令对象，绿豆排骨煲
 */
public class ChopCommand implements Command{
    /**
     * 持有具体做菜的厨师对象
     */
    private CookApi cookApi;
    /**
     * 点菜的桌号
     */
    private int tableNum;

    /**
     * 构造方法，传入点菜的桌号
     * @param tableNum 点菜的桌号
     */
    public ChopCommand(int tableNum) {
        this.tableNum = tableNum;
    }

    /**
     * 设置具体做菜的厨师对象
     * @param cookApi 具体做菜的厨师的对象
     */
    public void setCookApi(CookApi cookApi) {
        this.cookApi = cookApi;
    }

    @Override
    public void execute() {
        this.cookApi.cook(tableNum, "绿豆排骨煲");
    }

    @Override
    public int getTableNum() {
        return this.tableNum;
    }
}