package es.kiwi.behavioral.strategy.example8;

/**
 * 日志记录的上下文
 */
public class LogContext {

    public void log(String msg) {
        //在上下文里面，自行实现对具体策略的选择
        //优先选用策略：记录到数据库
        LogStrategy strategy = new DbLog();
        try {
            strategy.log(msg);
        } catch (Exception err) {
            //出错了，那就记录到文件中
            strategy = new FileLog();
            strategy.log(msg);
        }
    }
}
