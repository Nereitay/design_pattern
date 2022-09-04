package es.kiwi.Structural.flyweight.solution;

/**
 * 封装授权数据中重复出现部分的享元对象
 */
public class AuthorizationFlyweight implements Flyweight{
    /**
     * 内部状态，安全实体
     */
    private String securityEntity;

    /**
     * 内部状态，权限
     */
    private String permit;

    /**
     * 构造方法，传入状态数据
     * @param state 状态数据，包含安全实体和权限的数据，用“,”分割
     */
    public AuthorizationFlyweight(String state) {
        String[] ss = state.split(",");
        securityEntity = ss[0];
        permit = ss[1];
    }

    /*根据需要，可以提供外部访问内部数据的getter方法，但是不会提供setter方法，
    也就是这些数据不会让外部来修改*/
    public String getSecurityEntity() {
        return securityEntity;
    }

    public String getPermit() {
        return permit;
    }

    @Override
    public boolean match(String securityEntity, String permit) {
        return this.securityEntity.equals(securityEntity) && this.permit.equals(permit);
    }
}
