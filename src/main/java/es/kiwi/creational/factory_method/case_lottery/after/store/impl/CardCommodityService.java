package es.kiwi.creational.factory_method.case_lottery.after.store.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.kiwi.creational.factory_method.case_lottery.after.store.ICommodity;
import es.kiwi.creational.factory_method.case_lottery.common.card.IQiYiCardService;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class CardCommodityService implements ICommodity {

    // 模拟注入
    private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String mobile = queryUserMobile(uId);
        iQiYiCardService.grantToken(mobile, bizId);
        log.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId,
                mapper.writeValueAsString(extMap));
        log.info("测试结果[爱奇艺兑换卡]：success");
    }

    private String queryUserMobile(String uId) {
        return "15200101232";
    }

}