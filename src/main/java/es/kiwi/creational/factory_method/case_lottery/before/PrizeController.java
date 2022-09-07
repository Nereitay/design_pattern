package es.kiwi.creational.factory_method.case_lottery.before;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.kiwi.creational.factory_method.case_lottery.common.coupon.CouponResult;
import es.kiwi.creational.factory_method.case_lottery.common.coupon.CouponService;
import es.kiwi.creational.factory_method.case_lottery.common.goods.DeliverReq;
import es.kiwi.creational.factory_method.case_lottery.common.goods.GoodsService;
import es.kiwi.creational.factory_method.case_lottery.common.card.IQiYiCardService;
import lombok.extern.slf4j.Slf4j;

/**
 * 模拟发奖服务
 */
@Slf4j
public class PrizeController {

    public AwardRes awardToUser(AwardReq req) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String reqJson = mapper.writeValueAsString(req);
        AwardRes awardRes = null;

        try {
            log.info("奖品发放开始{}, req:{}", req.getUId(), reqJson);
            // 按照不同类型方法商品[1优惠券、2实物商品、3第三方兑换卡(爱奇艺)]
            if (req.getAwardType() == 1) {
                CouponService couponService = new CouponService();
                CouponResult couponResult = couponService.sendCoupon(req.getUId(), req.getAwardNumber(), req.getBizId());
                if ("0000".equals(couponResult.getCode())) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", couponResult.getInfo());
                }
            }else if (req.getAwardType() == 2) {
                GoodsService goodsService = new GoodsService();
                DeliverReq deliverReq = new DeliverReq();
                deliverReq.setUserName(queryUserName(req.getUId()));
                deliverReq.setUserPhone(queryUserPhoneNumber(req.getUId()));
                deliverReq.setSku(req.getAwardNumber());
                deliverReq.setOrderId(req.getBizId());
                deliverReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
                deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
                deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));
                Boolean isSuccess = goodsService.deliverGoods(deliverReq);
                if (isSuccess) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", "发放失败");
                }
            } else if (req.getAwardType() == 3) {
                String bindMobileNumber = queryUserPhoneNumber(req.getUId());
                IQiYiCardService iQiYiCardService = new IQiYiCardService();
                iQiYiCardService.grantToken(bindMobileNumber, req.getAwardNumber());
                awardRes = new AwardRes("0000", "发放成功");
            }
            log.info("奖品发放完成{}。", req.getUId());

        } catch (Exception e) {
            log.error("奖品发放失败{}, req:{}", req.getUId(), reqJson, e);
            awardRes = new AwardRes("001", e.getMessage());
        }
        return awardRes;
    }

    private String queryUserName(String uId) {
        return "Kiwi";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }


}
