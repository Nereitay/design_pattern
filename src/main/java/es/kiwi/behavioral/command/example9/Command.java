package es.kiwi.behavioral.command.example9;

/**
 * <p>退化的命令模式 - 继续变化 -> Invoker也开始智能化</p>
 */
public interface Command {
    void execute();

    /**
     * 🧠设置要输出的内容
     * @param s 要输出的内容
     */
    void setStr(String s);
}
