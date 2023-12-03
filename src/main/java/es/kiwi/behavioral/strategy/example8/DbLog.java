package es.kiwi.behavioral.strategy.example8;
/**
 * 把日志记录到数据库
 */
public class DbLog extends LogStrategyTemplate {
    /**
     * 真正执行日志记录，让子类去具体实现
     *
     * @param msg 需记录的日志信息
     */
    @Override
    public void doLog(String msg) { // 除了定义上发生了改变外，具体的实现没变
        //制造错误
        if (msg != null && msg.trim().length() > 5) {
            int a = 5 / 0;
        }
        System.out.println("现在把 '" + msg + "' 记录到数据库中");
    }
}
