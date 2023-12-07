package es.kiwi.behavioral.chain_of_responsibility.example6;

/**
 * 进行数据通用检查的职责对象
 */
public class SaleDataCheck extends SaleHandler {
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
        //进行数据通用检查，稍麻烦点，每个数据都要检测
        if (user == null || user.trim().length() == 0) {
            System.out.println("申请人不能为空");
            return false;
        }
        if (customer == null || customer.trim().length() == 0) {
            System.out.println("客户不能为空");
            return false;
        }
        if (saleModel == null) {
            System.out.println("销售商品的数据不能为空");
            return false;
        }
        if (saleModel.getGoods() == null || saleModel.getGoods().trim().length() == 0) {
            System.out.println("销售的商品不能为空");
            return false;
        }
        if (saleModel.getSaleNum() == 0) {
            System.out.println("销售商品的数量不能为0");
            return false;
        }
        //如果通过了上面的检测，那就向下继续执行
        return this.successor.sale(user, customer, saleModel);
    }
}
