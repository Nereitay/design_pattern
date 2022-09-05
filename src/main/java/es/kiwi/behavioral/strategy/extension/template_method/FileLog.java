package es.kiwi.behavioral.strategy.extension.template_method;

/**
 * 把日志记录到文件中
 */
public class FileLog extends LogStrategyTemplate{
    /*
    除了定义上发生变化外，具体的实现没变
     */
    @Override
    protected void doLog(String msg) {
        System.out.println("现在把 '" + msg + "' 记录到文件中");
    }
}
