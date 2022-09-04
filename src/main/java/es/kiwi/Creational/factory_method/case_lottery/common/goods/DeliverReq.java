package es.kiwi.Creational.factory_method.case_lottery.common.goods;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliverReq {

    private String userName;              // 用户姓名
    private String userPhone;             // 用户手机
    private String sku;                   // 商品SKU
    private String orderId;               // 订单ID
    private String consigneeUserName;     // 收货人姓名
    private String consigneeUserPhone;    // 收货人手机
    private String consigneeUserAddress;  // 收获人地址
}