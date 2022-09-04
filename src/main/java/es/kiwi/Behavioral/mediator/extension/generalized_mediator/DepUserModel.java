package es.kiwi.Behavioral.mediator.extension.generalized_mediator;

import lombok.Getter;
import lombok.Setter;

/**
 * 描述部门和人员关系的类
 */
@Getter
@Setter
public class DepUserModel {
    /**
     * 用于部门和人员关系的编号，用作主键
     */
    private String depUserId;
    /**
     * 部门的编号
     */
    private String depId;
    /**
     * 人员的编号
     */
    private String userId;
}
