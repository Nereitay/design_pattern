package es.kiwi.behavioral.chain_of_responsibility.scenario;

/**
 * 商品销售管理模块的业务处理
 */
public class GoodsSaleEbo {
    /**
     * 保存销售信息，本来销售数据应该是多条，太麻烦了，为了演示，简单点
     * @param user 操作人员
     * @param customer 客户
     * @param saleModel 销售数据
     * @return 是否保存成功
     */
    public boolean sale(String user, String customer, SaleModel saleModel) {
        //如果全部在这里处理，基本的顺序是：
        //1：权限检查
        //2：通用数据检查（这个也可能在表现层已经做过了）
        //3：数据逻辑校验

        //4：真正的业务处理

        //但是现在通过功能链来做，这里就主要负责构建链
        //暂时还没有功能链，等实现好了各个处理对象再回来添加

        return true;
    }
}