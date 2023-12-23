package es.kiwi.behavioral.command.example7;

/**
 * <p>队列请求</p>
 * Receiver
 * 厨师的接口
 */
public interface CookApi {
    /**
     * 示意，做菜的方法
     *
     * @param tableNum 点菜的桌号
     * @param name     菜名
     */
    void cook(int tableNum, String name); // 添加发出命令的桌号，这样在多线程输出信息的时候，才知道到底是在给哪个桌做菜
}
