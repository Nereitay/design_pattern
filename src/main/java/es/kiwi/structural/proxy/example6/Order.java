package es.kiwi.structural.proxy.example6;


import lombok.ToString;

/**
 * <p>采用对象继承的方式来实现代理</p>
 * 订单对象
 */
@ToString
public class Order {
    /**
     * 订单订购的产品名称
     */
    private String productName;
    /**
     * 订单订购的数量
     */
    private int orderNum;
    /**
     * 创建订单的人员
     */
    private String orderUser;

    /**
     * 构造方法，传入构建需要的数据
     *
     * @param productName 订单订购的产品名称
     * @param orderNum    订单订购的数量
     * @param orderUser   创建订单的人员
     */
    public Order(String productName, int orderNum, String orderUser) {
        this.productName = productName;
        this.orderNum = orderNum;
        this.orderUser = orderUser;
    }

    /**
     * 获取订单订购的产品名称
     *
     * @return 订单订购的产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置订单订购的产品名称
     *
     * @param productName 订单订购的产品名称
     * @param user        操作人员
     */
    public void setProductName(String productName, String user) {
        this.productName = productName;
    }

    /**
     * 获取订单订购的数量
     *
     * @return 订单订购的数量
     */
    public int getOrderNum() {
        return orderNum;
    }

    /**
     * 设置订单订购的数量
     *
     * @param orderNum 订单订购的数量
     * @param user     操作人员
     */
    public void setOrderNum(int orderNum, String user) {
        this.orderNum = orderNum;
    }

    /**
     * 获取创建订单的人员
     *
     * @return 创建订单的人员
     */
    public String getOrderUser() {
        return orderUser;
    }

    /**
     * 设置创建订单的人员
     *
     * @param orderUser 创建订单的人员
     * @param user      操作人员
     */
    public void setOrderUser(String orderUser, String user) {
        this.orderUser = orderUser;
    }
}
