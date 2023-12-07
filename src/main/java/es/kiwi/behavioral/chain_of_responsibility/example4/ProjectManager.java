package es.kiwi.behavioral.chain_of_responsibility.example4;

public class ProjectManager extends Handler {
    /**
     * 处理聚餐费用的申请
     *
     * @param user 申请人
     * @param fee  申请的钱数
     * @return 成功或失败的具体通知
     */
    @Override
    public String handleFeeRequest(String user, double fee) { // 这个方法的处理没有任何变化
        String str = "";
        //项目经理的权限比较小，只能在500以内
        if (fee < 500) {
            //为了测试，简单点，只同意小李的
            if ("小李".equals(user)) {
                str = "项目经理同意" + user + "聚餐费用" + fee + "元的请求";
            } else {
                //其他人一律不同意
                str = "项目经理不同意" + user + "聚餐费用" + fee + "元的请求";
            }
            return str;
        } else {
            //超过500，继续传递给级别更高的人处理
            if (this.successor != null) {
                return successor.handleFeeRequest(user, fee);
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
        //项目经理的权限比较小，只能在5000以内
        if (requestFee < 5000) {
            //工作需要嘛，统统同意
            System.out.println("项目经理同意" + user + "预支差旅费用" + requestFee + "元的请求");
            return true;
        } else {
            //超过5000，继续传递给级别更高的人处理
            if (this.successor != null) {
                return this.successor.handlePreFeeRequest(user, requestFee);
            }
        }
        return false;
    }
}
