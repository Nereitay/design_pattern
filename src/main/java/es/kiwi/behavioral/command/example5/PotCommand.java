package es.kiwi.behavioral.command.example5;

/**
 * 命令对象，绿豆排骨煲
 */
public class PotCommand implements Command {
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
    public void setCookApi(CookApi cookApi) {
        this.cookApi = cookApi;
    }

    /**
     * 执行命令对应的操作
     */
    @Override
    public void execute() {
        this.cookApi.cook("绿豆排骨煲");
    }
}
