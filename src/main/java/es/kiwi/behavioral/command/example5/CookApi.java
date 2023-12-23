package es.kiwi.behavioral.command.example5;

/**
 * Receiver
 * 厨师的接口
 */
public interface CookApi {
    /**
     * 示意，做菜的方法
     * @param name 菜名
     */
    void cook(String name);
}
