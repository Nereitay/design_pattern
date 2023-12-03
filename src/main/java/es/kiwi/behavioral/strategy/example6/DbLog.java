package es.kiwi.behavioral.strategy.example6;

/**
 * 把日志记录到数据库
 */
public class DbLog implements LogStrategy {
    /**
     * 记录日志
     *
     * @param msg 需记录的日志信息
     */
    @Override
    public void log(String msg) {
        //制造错误
        if (msg != null && msg.trim().length() > 5) {
            int a = 5 / 0;
        }
        System.out.println("现在把 '" + msg + "' 记录到数据库中");
    }
}
