package es.kiwi.behavioral.command.extension.macro_command;

/**
 * 厨师的接口 -> Receiver
 */
public interface CookApi {
    /**
     * 示意：做菜的方法
     * @param name 菜名
     */
    void cook(String name);
}
