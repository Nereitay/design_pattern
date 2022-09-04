package es.kiwi.Structural.proxy.pattern.protection_proxy.inherition;

import lombok.ToString;

/**
 * 订单的代理对象
 */
@ToString(callSuper = true)
public class OrderProxy extends Order {
    /**
     * 构造方法，传入构建需要的数据
     *
     * @param productName 订单订购的产品名称
     * @param orderNum    订单订购的数量
     * @param orderUser   创建订单的人员
     */
    public OrderProxy(String productName, int orderNum, String orderUser) {
        super(productName, orderNum, orderUser);
    }

    @Override
    public void setProductName(String productName, String user) {
        if (user != null && user.equals(this.getOrderUser()))
            super.setProductName(productName, user);
        else
            System.out.println("对不起" + user + "，您无权修改订单中的订购数量。");
    }

    @Override
    public void setOrderNum(int orderNum, String user) {
        if (user != null && user.equals(this.getOrderUser())) {
            super.setOrderNum(orderNum, user);
        } else {
            System.out.println("对不起" + user + "，您无权修改订单中的订购数量。");
        }
    }

    @Override
    public void setOrderUser(String orderUser, String user) {
        if (user != null && user.equals(this.getOrderUser())) {
            super.setOrderUser(orderUser, user);
        } else {
            System.out.println("对不起" + user + "，您无权修改订单中的订购人。");
        }
    }
}
