package es.kiwi.Creational.factory_method.case_lottery.before;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 发奖请求对象
 */
@Getter
@Setter
public class AwardReq {
    private String uId;                 // 用户唯一ID
    private Integer awardType;          // 奖品类型(可以用枚举定义)；1优惠券、2实物商品、3第三方兑换卡(爱奇艺)
    private String awardNumber;         // 奖品编号；sku、couponNumber、cardId
    private String bizId;               // 业务ID，防重复
    private Map<String, String> extMap; // 扩展信息
}
