package es.kiwi.Behavioral.visitor.solution;

/**
 * 访问者接口
 */
public interface Visitor {

    /**
     * 访问企业客户，相当于给企业客户添加访问者的对象
     * @param ec 企业客户的对象
     */
    void visitEnterpriseCustomer(EnterpriseCustomer ec);

    /**
     * 访问个人客户，相当于给企业客户添加访问者的对象
     * @param pc 个人客户的对象
     */
    void visitPersonalCustomer(PersonalCustomer pc);
}
