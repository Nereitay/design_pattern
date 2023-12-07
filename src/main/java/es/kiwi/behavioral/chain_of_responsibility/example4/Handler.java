package es.kiwi.behavioral.chain_of_responsibility.example4;

/**
 * <p>处理多种请求</p>
 * 定义职责对象的接口
 */
public abstract class Handler {
    /**
     * 持有下一个处理请求的对象
     */
    protected Handler successor;

    /**
     * 设置下一个处理请求的对象
     *
     * @param successor 下一个处理请求的对象
     */
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    /**
     * 处理聚餐费用的申请
     *
     * @param user 申请人
     * @param fee  申请的钱数
     * @return 成功或失败的具体通知
     */
    public abstract String handleFeeRequest(String user, double fee); // 这是个业务方法

    /*新加的业务处理方法*/
    /**
     * 处理预支差旅费用的申请
     *
     * @param user       申请人
     * @param requestFee 申请的钱数
     * @return 是否同意
     */
    public abstract boolean handlePreFeeRequest(String user, double requestFee);
}
