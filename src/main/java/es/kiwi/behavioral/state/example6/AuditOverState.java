package es.kiwi.behavioral.state.example6;
/**
 * 处理审核结束的类
 */
public class AuditOverState implements LeaveRequestState{
    /**
     * 执行状态对应的功能处理
     *
     * @param ctx 上下文的实例对象
     */
    @Override
    public void doWork(StateMachine ctx) {
        //先把业务对象造型回来
        LeaveRequestModel lrm = (LeaveRequestModel)ctx.getBusinessVO();

        //业务处理，在数据里面记录整个流程结束
    }
}
