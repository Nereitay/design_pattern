package es.kiwi.structural.flyweight.example1;

import lombok.Getter;
import lombok.Setter;

/**
 * 描述授权数据的数据model
 */
@Getter
@Setter
public class AuthorizationModel {
    /**
     * 人员
     */
    private String user;
    /**
     * 安全实体
     */
    private String securityEntity;
    /**
     * 权限
     */
    private String permit;
}
