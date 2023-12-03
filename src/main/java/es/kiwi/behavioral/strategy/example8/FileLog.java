package es.kiwi.behavioral.strategy.example8;

/**
 * 把日志记录到文件
 */
public class FileLog extends LogStrategyTemplate {
    /**
     * 真正执行日志记录，让子类去具体实现
     *
     * @param msg 需记录的日志信息
     */
    @Override
    public void doLog(String msg) {
        System.out.println("现在把 '" + msg + "' 记录到文件中");
    }
}
