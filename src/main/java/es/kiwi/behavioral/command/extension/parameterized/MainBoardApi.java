package es.kiwi.behavioral.command.extension.parameterized;

/**
 * 参数化配置：可以使用不同的命令对象，去参数化配置客户的请求
 * 主板的接口
 */
public interface MainBoardApi {
    /**
     * 主板具有能开机的功能
     */
    void open();

    /**
     * 新添加的实现重启机器的功能
     * 主板具有实现重启的功能
     */
    void reset();

}
