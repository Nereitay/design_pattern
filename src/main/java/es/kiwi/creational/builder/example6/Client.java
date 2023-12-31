package es.kiwi.creational.builder.example6;

public class Client {
    public static void main(String[] args) {
        // 👀创建构建器
        InsuranceContract.ConcreteBuilder builder = new InsuranceContract.ConcreteBuilder("001", 12345L, 67890L);
        // 设置需要的数据，然后构建保险合同对象
        InsuranceContract contract = builder.setPersonName("Apple").setOtherData("test").build();
        // 操作保险合同对象的方法
        contract.someOperation();
    }
}
