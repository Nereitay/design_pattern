package es.kiwi.behavioral.visitor.example4;

/**
 * 具体的访问者，实现客户提出服务请求的功能
 */
public class ServiceRequestVisitor implements Visitor {
    /**
     * 访问企业客户，相当于给企业客户添加访问者的功能
     *
     * @param ec 企业客户的对象
     */
    @Override
    public void visitEnterpriseCustomer(EnterpriseCustomer ec) {
        //企业客户提出的具体服务请求
        System.out.println(ec.getName() + "企业提出服务请求");
    }

    /**
     * 访问个人客户，相当于给个人客户添加访问者的功能
     *
     * @param pc 个人客户的对象
     */
    @Override
    public void visitPersonalCustomer(PersonalCustomer pc) {
        //个人客户提出的具体服务请求
        System.out.println("客户" + pc.getName() + "提出服务请求");
    }
}
