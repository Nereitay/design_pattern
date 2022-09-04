package es.kiwi.Behavioral.chain_of_responsibility.extension.chain_of_functions;

import es.kiwi.Behavioral.chain_of_responsibility.scenario.SaleModel;

/**
 * 定义职责对象的接口
 */
public abstract class SaleHandler {

    /**
     * 持有下一个处理请求的对象
     */
    protected SaleHandler successor;

    /**
     * 设置下一个处理请求的对象
     * @param successor
     */
    public void setSuccessor(SaleHandler successor) {
        this.successor = successor;
    }

    /**
     * 处理保存销售信息的请求
     * @param user 操作人员
     * @param customer 客户
     * @param saleModel 销售数据
     * @return 是否处理成功
     */
    public abstract boolean sale (String user, String customer, SaleModel saleModel);
}
