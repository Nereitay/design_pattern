package es.kiwi.behavioral.state;

import es.kiwi.behavioral.state.extension.workflow.LeaveRequestContext;
import es.kiwi.behavioral.state.extension.workflow.LeaveRequestModel;
import es.kiwi.behavioral.state.extension.workflow.ProjectManagerState;
import es.kiwi.behavioral.state.scenario.VoteManager;

public class Client {

    public static void main(String[] args) {
//        before();

        // 使用状态模式后
//        after();

        //在状态的处理类中进行状态的维护和状态的转换
//        extension();

        //模拟工作流
        workflow();
    }

    private static void workflow() {
        //创建业务对象，并设置业务数据
        LeaveRequestModel lrm = new LeaveRequestModel();
        lrm.setUser("小李");
        lrm.setBeginDate("2010-02-08");
        lrm.setLeaveDays(5);
        //创建上下文对象
        LeaveRequestContext request = new LeaveRequestContext();
        //为上下文对象设置业务数据对象
        request.setBusisnessVO(lrm);
        //配置上下文，作为开始的状态，以后就不管了
        request.setState(new ProjectManagerState());
        //请求上下文，让上下文开始i处理工作
        request.doWork();
    }

    private static void extension() {
        es.kiwi.behavioral.state.extension.state_maintenance.VoteManager voteManager1 =
                new es.kiwi.behavioral.state.extension.state_maintenance.VoteManager();
        for (int i = 0; i < 10; i++) {
            voteManager1.vote("u1", "A");
        }
    }

    private static void after() {
        es.kiwi.behavioral.state.solution.VoteManager voteManager =
                new es.kiwi.behavioral.state.solution.VoteManager();
        for (int i = 0; i < 8; i++) {
            voteManager.vote("u1", "A");
        }
    }

    private static void before() {
        VoteManager vm = new VoteManager();
        for (int i = 0; i < 8; i++) {
            vm.vote("u1", "A");
        }
    }
}
