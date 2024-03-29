package es.kiwi.behavioral.state.example6;

/**
 * 公共状态接口
 */
public interface State {
    /**
     * 执行状态对应的功能处理
     *
     * @param ctx 上下文的实例对象
     */
    void doWork(StateMachine ctx);
}
