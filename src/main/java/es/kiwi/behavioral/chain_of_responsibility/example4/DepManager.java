package es.kiwi.behavioral.chain_of_responsibility.example4;

public class DepManager extends Handler {
    /**
     * 处理聚餐费用的申请
     *
     * @param user 申请人
     * @param fee  申请的钱数
     * @return 成功或失败的具体通知
     */
    @Override
    public String handleFeeRequest(String user, double fee) {
        String str = "";
        //部门经理的权限只能在1000以内
        if (fee >= 500 && fee < 1000) {
            //为了测试，简单点，只同意小李申请的
            if ("小李".equals(user)) {
                str = "部门经理同意" + user + "聚餐费用" + fee + "元的请求";
            } else {
                //其他人一律不同意
                str = "部门经理不同意" + user + "聚餐费用" + fee + "元的请求";
            }
            return str;
        } else {
            //超过1000，继续传递给级别更高的人处理
            if (this.successor != null) {
                return this.successor.handleFeeRequest(user, fee);
            }
        }
        return str;
    }

    /**
     * 处理预支差旅费用的申请
     *
     * @param user       申请人
     * @param requestFee 申请的钱数
     * @return 是否同意
     */
    @Override
    public boolean handlePreFeeRequest(String user, double requestFee) {
        //部门经理的权限比较小，只能在20000以内
        if (requestFee < 20000) {
            //工作需要嘛，统统同意
            System.out.println("部门经理同意" + user + "预支差旅费用" + requestFee + "元的请求");
            return true;
        } else {
            //超过20000，继续传递给级别更高的人处理
            if (this.successor != null) {
                return this.successor.handlePreFeeRequest(user, requestFee);
            }
        }
        return false;
    }
}
