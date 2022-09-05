package es.kiwi.creational.factory_method.case_lottery.common.coupon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 优惠券返回结果类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CouponResult {

    private String code; // 编码
    private String info; // 描述
}