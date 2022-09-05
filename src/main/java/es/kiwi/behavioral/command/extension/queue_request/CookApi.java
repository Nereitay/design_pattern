package es.kiwi.behavioral.command.extension.queue_request;
/**
 * 厨师的接口
 */
public interface CookApi {
    /**
     * 示意：做菜的方法
     * @param TableNum 点菜的桌号
     * @param name 菜名
     */
    void cook(int TableNum, String name);
}