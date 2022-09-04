package es.kiwi.Behavioral.state.extension.workflow;

/**
 * 公共状态接口
 */
public interface State {
    /**
     * 执行状态对应的功能处理
     * @param ctx
     */
    void doWork (StateMachine ctx);
}
