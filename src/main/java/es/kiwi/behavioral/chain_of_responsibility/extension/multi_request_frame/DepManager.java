package es.kiwi.behavioral.chain_of_responsibility.extension.multi_request_frame;

/**
 * 实现部门经理处理聚餐费用申请的对象
 */
public class DepManager extends Handler {

    /*
    覆盖通用的处理方法，按照业务类型调用自己的处理方法
     */
    @Override
    public Object handleRequest(RequestModel rm) {
        if (StaffBanquetRequestModel.FEE_TYPE.equals(rm.getType())) {
            //表示聚餐费用申请
            return handleBanquetRequest(rm);
        } else {
            //其他的部门经理暂时不想处理
            return super.handleRequest(rm);
        }
    }

    /*
    除了把方法变私有了，业务参数都给封装在请求对象中外，没有什么大的变化，
    尤其是基本的业务逻辑处理和以前是一样的
     */
    private Object handleBanquetRequest(RequestModel rm) {

        //先把通用的对象造型回来
        StaffBanquetRequestModel frm = (StaffBanquetRequestModel) rm;
        String str = "";
        //部门经理的权限只能在1000以内
        if (frm.getFee() < 1000) {
            //为了测试，简单点，只同意Uva的
            if ("Uva".equals(frm.getUser())) {
                str = "部门经理同意" + frm.getUser() + "聚餐费用" + frm.getFee() + "元的请求";
            } else {
                //其他人一律不同意
                str = "部门经理不同意" + frm.getUser() + "聚餐费用" + frm.getFee() + "元的请求";
            }

            return str;
        } else {
            //超过1000， 继续传递给级别更高的人处理
            if (this.successor != null) {
                return successor.handleRequest(rm);
            }
        }

        return str;

    }
}
