package es.kiwi.behavioral.strategy.example8;
/**
 * 日志记录策略的接口
 */
public interface LogStrategy {
    /**
     * 记录日志
     * @param msg 需记录的日志信息
     */
    void log(String msg);
}
