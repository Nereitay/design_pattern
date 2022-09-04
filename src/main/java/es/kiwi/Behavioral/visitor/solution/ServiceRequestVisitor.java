package es.kiwi.Behavioral.visitor.solution;

/**
 * 具体的访问者，实现客户提出服务请求的功能
 */
public class ServiceRequestVisitor implements Visitor {
    @Override
    public void visitEnterpriseCustomer(EnterpriseCustomer ec) {
        //企业客户提出的具体服务请求
        System.out.println(ec.getName() + "企业提出的服务请求");
    }

    @Override
    public void visitPersonalCustomer(PersonalCustomer pc) {
        //个人客户提出的具体服务请求
        System.out.println("客户" + pc.getName() + "提出服务请求");
    }
}
