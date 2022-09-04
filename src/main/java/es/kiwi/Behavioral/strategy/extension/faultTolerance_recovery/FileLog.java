package es.kiwi.Behavioral.strategy.extension.faultTolerance_recovery;

/**
 * 把日志记录到文件
 */
public class FileLog implements LogStrategy{
    @Override
    public void log(String msg) {
        System.out.println("现在把 '" + msg + "' 记录到文件中");
    }
}
