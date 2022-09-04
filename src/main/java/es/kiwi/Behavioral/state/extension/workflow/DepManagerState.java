package es.kiwi.Behavioral.state.extension.workflow;

import java.util.Scanner;

public class DepManagerState implements LeaveRequestState {
    @Override
    public void doWork(StateMachine request) {
        //先拿到业务对象
        LeaveRequestModel lrm = (LeaveRequestModel) request.getBusisnessVO();
        /*//业务处理，把审核结果保存到数据库中

        //部门尽力审核以后，直接转向审核结束状态了
        request.setState(new AuditOverState());
        //给申请人增加一个工作，让他查看审核结果*/

        System.out.println("部门经理审核中，请稍候.....");
        //模拟用户处理界面，通过控制台来读取数据
        System.out.println(lrm.getUser() + "申请从" + lrm.getBeginDate() + "开始请假" + lrm.getLeaveDays() + "天， 请部门经理审核（1" +
                "为同意， 2 为不同意）；");
        //读取从控制台输入的数据
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int a = scanner.nextInt();
            //设置回到上下文中
            String result = "不同意";
            if (a == 1)
                result = "同意";
            lrm.setResult("部门经理审核结果：" + result);
            //部门经理审核以后，直接转向审核结束状态了
            request.setState(new AuditOverState());
            //继续执行下一步工作
            request.doWork();
        }
    }
}

