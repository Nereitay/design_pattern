package es.kiwi.behavioral.strategy.extension.template_method;

/**
 * 日志记录的上下文
 */
public class LogContext {
    /**
     * 记录日志的方法，提供给客户端使用
     * @param msg 需记录的日志信息
     */
    public void log(String msg) {

        //在上下文中，自行实现对具体策略的选择
        //优先选用策略：记录到数据库
        LogStrategy strategy = new DbLog();
        /*
        在这里进行具体策略算法的选择，把try-catch变相当成if-else来用
         */
        try {
            strategy.log(msg);
        } catch (Exception err) {
            //出错了，那就记录到文件中
            strategy = new FileLog();
            strategy.log(msg);
        }
    }
}
