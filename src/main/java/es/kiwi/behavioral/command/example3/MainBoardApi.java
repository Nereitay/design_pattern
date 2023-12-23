package es.kiwi.behavioral.command.example3;

/**
 * <p>参数化配置</p>
 * Receiver
 * 主板的接口
 */
public interface MainBoardApi {
    /**
     * 主板具有能开机的功能
     */
    void open();

    /*新添加的实现重启机器的功能*/
    /**
     * 主板具有实现重启的功能
     */
    void reset();
}
