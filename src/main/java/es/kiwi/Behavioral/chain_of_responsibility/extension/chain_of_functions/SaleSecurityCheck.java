package es.kiwi.Behavioral.chain_of_responsibility.extension.chain_of_functions;

import es.kiwi.Behavioral.chain_of_responsibility.scenario.SaleModel;

/**
 * 进行权限检查的职责对象
 */
public class SaleSecurityCheck extends SaleHandler{
    @Override
    public boolean sale(String user, String customer, SaleModel saleModel) {
        //进行权限检查，简单点，就Uva能通过
        if ("Uva".equals(user)) {
            return this.successor.sale(user, customer, saleModel);
        } else {
            System.out.println("对不起" + user + "，你没有保存销售信息的权限");
            return false;
        }
    }
}
