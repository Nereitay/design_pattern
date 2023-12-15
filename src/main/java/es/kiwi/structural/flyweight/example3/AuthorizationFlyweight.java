package es.kiwi.structural.flyweight.example3;

import lombok.Getter;

/**
 * 封装授权数据中重复出现部分的享元对象
 */
@Getter // 不提供Setter - 也就是这些数据不会让外部来修改
public class AuthorizationFlyweight implements Flyweight {

    /**
     * 内部状态，安全实体
     */
    private String securityEntity;
    /**
     * 内部状态，权限
     */
    private String permit;

    public AuthorizationFlyweight(String state) {
        String[] ss = state.split(",");
        securityEntity = ss[0];
        permit = ss[1];
    }

    /**
     * 判断传入的安全实体和权限，是否和享元对象内部状态匹配
     *
     * @param securityEntity 安全实体
     * @param permit         权限
     * @return true表示匹配，false表示不匹配
     */
    @Override
    public boolean match(String securityEntity, String permit) {
        return this.securityEntity.equals(securityEntity) && this.permit.equals(permit);
    }
}
