package es.kiwi.behavioral.chain_of_responsibility.example6;

/**
 * 进行数据逻辑检查的职责对象
 */
public class SaleLoginCheck extends SaleHandler {
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
        //进行数据的逻辑检查，比如检查ID的唯一性，主外键的对应关系等等
        //这里应该检查这种主外键的对应关系，比如销售商品是否存在
        //为了演示简单，直接通过吧

        //如果通过了上面的检测，那就向下继续执行
        return this.successor.sale(user, customer, saleModel);
    }
}
