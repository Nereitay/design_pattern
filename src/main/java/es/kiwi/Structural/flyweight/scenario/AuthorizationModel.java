package es.kiwi.Structural.flyweight.scenario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 描述授权数据的数据Model
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
