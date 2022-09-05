package es.kiwi.behavioral.state.extension.workflow;

public class AuditOverState implements LeaveRequestState{
    @Override
    public void doWork(StateMachine request) {
        //先拿到业务对象
        LeaveRequestModel lrm = (LeaveRequestModel) request.getBusisnessVO();
        //业务处理，在数据中记录整个流程结束


        System.out.println(lrm.getUser() + "，你的请假申请已经审核结束，结果是：" +
         lrm.getResult());
    }
}
