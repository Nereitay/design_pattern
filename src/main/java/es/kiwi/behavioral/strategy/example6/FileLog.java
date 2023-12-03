package es.kiwi.behavioral.strategy.example6;

/**
 * 把日志记录到文件
 */
public class FileLog implements LogStrategy {
    /**
     * 记录日志
     *
     * @param msg 需记录的日志信息
     */
    @Override
    public void log(String msg) {
        System.out.println("现在把 '" + msg + "' 记录到文件中");
    }
}
