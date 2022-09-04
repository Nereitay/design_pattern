package es.kiwi.Creational.factory_method;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.kiwi.Creational.factory_method.case_lottery.after.StoreFactory;
import es.kiwi.Creational.factory_method.case_lottery.after.store.ICommodity;
import es.kiwi.Creational.factory_method.case_lottery.before.AwardReq;
import es.kiwi.Creational.factory_method.case_lottery.before.AwardRes;
import es.kiwi.Creational.factory_method.case_lottery.before.PrizeController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ApiTest {

    @Test
    public void test_awardToUser() throws Exception {

        PrizeController prizeController = new PrizeController();
        ObjectMapper mapper = new ObjectMapper();

        System.out.println("\r\n模拟发放优惠券测试\r\n");
        // 模拟发放优惠券测试
        AwardReq req01 = new AwardReq();
        req01.setUId("10001");
        req01.setAwardType(1);
        req01.setAwardNumber("EGM1023938910232121323432");
        req01.setBizId("791098764902132");
        AwardRes awardRes01 = prizeController.awardToUser(req01);

        log.info("请求参数：{}", mapper.writeValueAsString(req01));
        log.info("测试结果：{}", mapper.writeValueAsString(awardRes01));

        System.out.println("\r\n模拟方法实物商品\r\n");
        // 模拟方法实物商品
        AwardReq req02 = new AwardReq();
        req02.setUId("10001");
        req02.setAwardType(2);
        req02.setAwardNumber("9820198721311");
        req02.setBizId("1023000020112221113");
        req02.setExtMap(new HashMap<String, String>() {{
            put("consigneeUserName", "谢飞机");
            put("consigneeUserPhone", "15200292123");
            put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");
        }});

        AwardRes awardRes02 = prizeController.awardToUser(req02);
        log.info("请求参数：{}", mapper.writeValueAsString(req02));
        log.info("测试结果：{}", mapper.writeValueAsString(awardRes02));

        System.out.println("\r\n第三方兑换卡(爱奇艺)\r\n");
        AwardReq req03 = new AwardReq();
        req03.setUId("10001");
        req03.setAwardType(3);
        req03.setAwardNumber("AQY1xjkUodl8LO975GdfrYUio");

        AwardRes awardRes03 = prizeController.awardToUser(req03);
        log.info("请求参数：{}", mapper.writeValueAsString(req03));
        log.info("测试结果：{}", mapper.writeValueAsString(awardRes03));

    }

    @Test
    public void test_commodity() throws Exception {
        StoreFactory storeFactory = new StoreFactory();
        // 1. 优惠券
        ICommodity commodityService_1 = storeFactory.getCommodityService(1);
        commodityService_1.sendCommodity("10001", "EGM1023938910232121323432", "791098764902132", null);
        // 2. 实物商品
        ICommodity commodityService_2 = storeFactory.getCommodityService(2);

        Map<String,String> extMap = new HashMap<String,String>();
        extMap.put("consigneeUserName", "谢飞机");
        extMap.put("consigneeUserPhone", "15200292123");
        extMap.put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");

        commodityService_2.sendCommodity("10001","9820198721311","1023000020112221113", extMap);
        // 3. 第三方兑换卡(爱奇艺)
        ICommodity commodityService_3 = storeFactory.getCommodityService(3);
        commodityService_3.sendCommodity("10001","AQY1xjkUodl8LO975GdfrYUio",null,null);
    }
}
