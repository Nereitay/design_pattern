package es.kiwi.Behavioral.chain_of_responsibility.extension.multi_request_frame_extended;

import es.kiwi.Behavioral.chain_of_responsibility.extension.multi_request_frame.ProjectManager;
import es.kiwi.Behavioral.chain_of_responsibility.extension.multi_request_frame.RequestModel;

/**
 * 实现项目经理处理聚餐费用申请的对象
 */
public class ProjectManager2 extends ProjectManager {

    /*
    覆盖通用的处理方法，按照业务类型调用自己的处理方法
     */
    @Override
    public Object handleRequest(RequestModel rm) {
        if (PrepaidTravelExpensesRequestModel.FEE_TYPE.equals(rm.getType())) {
            //表示预支差旅费用申请
            return myHandler(rm);
        } else {
            //其他的让父类去处理
            return super.handleRequest(rm);
        }
    }

    /*
    故意定义一个和以前不一样的名称。
    这里可以是任意合法的名称
     */
    private Object myHandler(RequestModel rm) {
        //先把通用的对象造型回来
        PrepaidTravelExpensesRequestModel prm = (PrepaidTravelExpensesRequestModel) rm;
        //项目经理的权限比较小，只能在5000以内
        if (prm.getFee() < 5000) {
            //工作需要嘛，统统同意
            System.out.println("项目经理同意" + prm.getUser() + "预支差旅费用" + prm.getFee() + "元的请求");
            return true;
        } else {
            //超过500， 继续传递给级别更高的人处理
            if (this.successor != null) {
                return successor.handleRequest(rm);
            }
        }

        return false;
    }



}
