package es.kiwi.creational.builder.pattern.complex_object;

public class Client {

    public static void main(String[] args) {
        //构建构建器
        ConcreteBuilder builder = new ConcreteBuilder("001", 12345L, 67890L);
        InsuranceContractBuilder.ConcreteBuilderInline builder2 =
                new InsuranceContractBuilder.ConcreteBuilderInline("002", 12345L, 67890L);

        //设置需要的数据，然后构建保险合同的对象
        InsuranceContract contract = builder.setPersonName("张三").setOtherData("test").build();
        InsuranceContractBuilder contract2 = builder2.setCompanyName("李四").setOtherData("test2").build();

        //操作保险合同对象的方法
        contract.someOperation();
        contract2.someOperation();
    }
}
