package es.kiwi.behavioral.command.extension.log_request;

import es.kiwi.behavioral.command.extension.queue_request.Command;
import es.kiwi.behavioral.command.extension.queue_request.CookApi;

import java.io.Serializable;

/**
 * 命令对象，绿豆排骨煲
 */
public class ChopCommand implements Command, Serializable {
    private static final long serialVersionUID = 3359036603850540829L;
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