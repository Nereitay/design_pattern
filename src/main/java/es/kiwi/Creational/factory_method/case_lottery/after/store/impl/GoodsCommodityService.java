package es.kiwi.Creational.factory_method.case_lottery.after.store.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.kiwi.Creational.factory_method.case_lottery.after.store.ICommodity;
import es.kiwi.Creational.factory_method.case_lottery.common.goods.DeliverReq;
import es.kiwi.Creational.factory_method.case_lottery.common.goods.GoodsService;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
@Slf4j
public class GoodsCommodityService implements ICommodity {


    private GoodsService goodsService = new GoodsService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName(queryUserName(uId));
        deliverReq.setUserPhone(queryUserPhoneNumber(uId));
        deliverReq.setSku(commodityId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));

        Boolean isSuccess = goodsService.deliverGoods(deliverReq);

        log.info("请求参数[实物商品] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, mapper.writeValueAsString(extMap));
        log.info("测试结果[实物商品]：{}", isSuccess);

        if (!isSuccess) throw new RuntimeException("实物商品发放失败");
    }

    private String queryUserName(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }

}