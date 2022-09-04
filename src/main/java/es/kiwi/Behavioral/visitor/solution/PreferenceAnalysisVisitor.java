package es.kiwi.Behavioral.visitor.solution;

/**
 * 具体的访问者，实现对公司产品的偏好分析
 */
public class PreferenceAnalysisVisitor implements Visitor {
    @Override
    public void visitEnterpriseCustomer(EnterpriseCustomer ec) {
        //根据以往购买的历史、潜在购买意向
        //以及客户所在行业的发展趋势，客户的发展预期等的分析
        System.out.println("现在对企业客户" + ec.getName() + "进行产品偏好分析");

    }

    @Override
    public void visitPersonalCustomer(PersonalCustomer pc) {
        //根据以往购买的历史、潜在购买意向
        //以及客户所在行业的发展趋势，客户的发展预期等的分析
        System.out.println("现在对个人客户" + pc.getName() + "进行产品偏好分析");
    }
}
