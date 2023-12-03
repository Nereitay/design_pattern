package es.kiwi.behavioral.strategy.example6;

/**
 * 容错恢复机制：Fault Tolerance Recovery Mechanism
 *  1. 容错：程序运行时，正常情况下应该按照某种方式来做，如果按照某种方式来做发生错误的话，
 *          程序并不会崩溃，也不会就此不能继续向下运行了，而是有容忍出错的能力
 *  2. 恢复：不但能容忍程序运行出现的错误，还提供出现错误后的备用方案，也就是恢复机制，
 *          来代替正常执行的功能，使程序继续向下运行
 */
public class Client {
    public static void main(String[] args) {
        LogContext log = new LogContext();
        log.log("记录日志");
        /*
        * 第二次调用记录日志的日志消息超长了，运行出错，容错恢复，
        * 所以记录日志到文件中去
        * */
        log.log("再次记录日志");
    }
}
/*
* Fault Tolerance Recovery Mechanism:
* Fault Tolerance: During program execution, it should proceed in a certain way under normal circumstances.
*                  If an error occurs in the process, the program doesn't crash or become unable to continue running.
*                  Instead, it possesses the ability to tolerate errors.
* Recovery: In addition to tolerating errors during program execution,
*           it also provides alternative solutions for handling errors, known as the recovery mechanism.
*           This mechanism replaces the normal execution functionality, allowing the program to continue running smoothly.
* */