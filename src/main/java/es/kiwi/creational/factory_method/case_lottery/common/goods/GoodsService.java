package es.kiwi.creational.factory_method.case_lottery.common.goods;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 模拟实物商品服务
 */
public class GoodsService {

    public Boolean deliverGoods(DeliverReq req) throws JsonProcessingException {
        System.out.println("模拟发货实物商品一个：" + new ObjectMapper().writeValueAsString(req));
        return true;
    }

}