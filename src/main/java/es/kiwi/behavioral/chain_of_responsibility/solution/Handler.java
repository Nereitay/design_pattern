package es.kiwi.behavioral.chain_of_responsibility.solution;

/**
 * 定义职责对象的接口
 */
public abstract class Handler {
    /**
     * 持有下一个处理请求的对象
     */
    protected Handler successor;

    /**
     * 设置下一个处理请求的对象
     * @param successor 下一个处理请求的对象
     */
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    /**
     * 这是个业务方法
     *
     * 处理聚餐费用的申请
     * @param user 申请人
     * @param fee 申请的钱数
     * @return 成功或失败的具体通知
     */
    public abstract String handleStaffBanquetRequest(String user, double fee);

    /**
     * 新加的业务处理方法
     *
     * 处理预支差旅费用的申请
     * @param user 申请人
     * @param expenses 申请的钱数
     * @return 成功或失败的具体通知
     */
    public abstract boolean handlePrepaidTravelExpensesRequest(String user, double expenses);
}
