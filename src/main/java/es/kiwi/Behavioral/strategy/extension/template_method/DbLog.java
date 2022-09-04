package es.kiwi.Behavioral.strategy.extension.template_method;

/**
 * 把日志记录到数据库
 */
public class DbLog extends LogStrategyTemplate{
    /*
    除了定义上发生变化外，具体的实现没变
     */
    @Override
    protected void doLog(String msg) {
        //制造错误
        if(msg != null && msg.trim().length() > 5) {
            int a = 5/0;
        }

        System.out.println("现在把 '" + msg + "' 记录到数据库中");
    }
}
