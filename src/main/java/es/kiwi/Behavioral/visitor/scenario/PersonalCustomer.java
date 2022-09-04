package es.kiwi.Behavioral.visitor.scenario;

/**
 * 个人客户
 */
public class PersonalCustomer extends Customer{
    /**
     * 联系电话
     */
    private String telephone;
    /**
     * 年龄
     */
    private int age;


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    /**
     * 个人客户提出服务请求的方法，示意一下
     */
    @Override
    public void serviceRequest() {
        //个人客户提出的具体服务请求
        System.out.println("客户" + this.getName() + "提出服务请求");
    }

    /**
     * 个人客户对公司产品的偏好分析，示意一下
     */
    @Override
    public void preferenceAnalysis() {
        //根据以往购买的历史、潜在购买意向
        //以及客户所在行业的发展趋势，客户的发展预期等的分析
        System.out.println("现在对个人客户" + this.getName() + "进行产品偏好分析");
    }

    /**
     * 个人客户价值分析，示意一下
     */
    @Override
    public void valueAnalysis() {
        //根据购买的金额大小、购买的产品和服务的多少、购买的频率等进行分析
        //企业客户的标准会比个人客户的高
        System.out.println("现在对个人客户" + this.getName() + "进行价值分析");
    }
}
