package es.kiwi.behavioral.chain_of_responsibility.example6;

/**
 * 真正处理销售的业务功能的职责对象
 */
public class SaleMgr extends SaleHandler {
    /**
     * 处理保存销售信息的请求
     *
     * @param user      操作人员
     * @param customer  客户
     * @param saleModel 销售数据
     * @return 是否处理成功
     */
    @Override
    public boolean sale(String user, String customer, SaleModel saleModel) {
        //进行真正的业务逻辑处理
        System.out.println(user + "保存了" + customer + "购买 " + saleModel + " 的销售数据");
        return true;
    }
}
