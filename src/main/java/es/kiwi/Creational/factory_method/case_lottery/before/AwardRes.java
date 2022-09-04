package es.kiwi.Creational.factory_method.case_lottery.before;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 发奖结果反馈对象
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AwardRes {

    private String code; // 编码
    private String info; // 描述
}