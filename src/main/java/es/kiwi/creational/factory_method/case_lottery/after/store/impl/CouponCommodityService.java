package es.kiwi.creational.factory_method.case_lottery.after.store.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.kiwi.creational.factory_method.case_lottery.after.store.ICommodity;
import es.kiwi.creational.factory_method.case_lottery.common.coupon.CouponResult;
import es.kiwi.creational.factory_method.case_lottery.common.coupon.CouponService;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class CouponCommodityService implements ICommodity {


    private CouponService couponService = new CouponService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        log.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, mapper.writeValueAsString(extMap));
        log.info("测试结果[优惠券]：{}", mapper.writeValueAsString(couponResult));
        if (!"0000".equals(couponResult.getCode())) throw new RuntimeException(couponResult.getInfo());
    }

}