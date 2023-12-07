package es.kiwi.behavioral.chain_of_responsibility.example6;
/**
 * 进行权限检查的职责对象
 */
public class SaleSecurityCheck extends SaleHandler {
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
        //进行权限检查，简单点，就小李能通过
        if ("小李".equals(user)) {
            return this.successor.sale(user, customer, saleModel);
        } else {
            System.out.println("对不起" + user + "，你没有保存销售信息的权限");
            return false;
        }
    }
}
