package es.kiwi.behavioral.command.extension.macro_command;

/**
 * 命令对象，绿豆排骨煲
 */
public class ChopCommand implements Command{
    /**
     * 持有具体做菜的厨师对象
     */
    private CookApi cookApi;

    /**
     * 设置具体做菜的厨师对象
     * @param cookApi 具体做菜的厨师的对象
     */
    public void setCookApi(CookApi cookApi) {
        this.cookApi = cookApi;
    }

    @Override
    public void execute() {
        this.cookApi.cook("绿豆排骨煲");
    }
}
