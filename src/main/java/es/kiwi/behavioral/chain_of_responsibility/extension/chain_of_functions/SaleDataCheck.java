package es.kiwi.behavioral.chain_of_responsibility.extension.chain_of_functions;

import es.kiwi.behavioral.chain_of_responsibility.scenario.SaleModel;
import org.apache.commons.lang3.StringUtils;

/**
 * 进行数据通用检查的职责对象
 */
public class SaleDataCheck extends SaleHandler{
    @Override
    public boolean sale(String user, String customer, SaleModel saleModel) {
        //进行数据通用检查，稍麻烦点，每个数据都要检测
        if (StringUtils.isBlank(user)) {
            System.out.println("申请人不能为空");
            return false;
        }
        if (StringUtils.isBlank(customer)) {
            System.out.println("客户不能为空");
            return false;
        }
        if (saleModel == null) {
            System.out.println("销售商品的数据不能为空");
            return false;
        }
        if (StringUtils.isBlank(saleModel.getGoods())) {
            System.out.println("销售的商品不能为空");
            return false;
        }
        if (saleModel.getSaleNum() == 0) {
            System.out.println("销售的商品数量不能为0");
            return false;
        }

        //如果通过了上面的检测，那就向下继续执行
        return this.successor.sale(user, customer, saleModel);



    }
}
