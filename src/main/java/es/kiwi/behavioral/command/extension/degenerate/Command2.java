package es.kiwi.behavioral.command.extension.degenerate;

/**
 * 再进一步，把单独实现命令接口地类改成用匿名内部类实现，这个时候就只剩下命令的接口，Invoker类，还有客户端了
 */
public interface Command2 {

    void execute();

    /**
     * 设置要输出的内容
     * @param s 要输出的内容
     */
    void setStr(String s);
}
