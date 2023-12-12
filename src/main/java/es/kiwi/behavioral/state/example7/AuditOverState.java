package es.kiwi.behavioral.state.example7;

/**
 * 处理审核结束的类
 */
public class AuditOverState implements LeaveRequestState {
    /**
     * 执行状态对应的功能处理
     *
     * @param ctx 上下文的实例对象
     */
    @Override
    public void doWork(StateMachine ctx) {
        //先把业务对象造型回来
        LeaveRequestModel lrm = (LeaveRequestModel) ctx.getBusinessVO();

        System.out.println(lrm.getUser() + "，你的请假申请已经审核结束，结果是：" + lrm.getResult());
    }
}
