package es.kiwi.creational.builder.example4;

import lombok.Getter;

/**
 * <p>没有接口，直接提供一个具体的构建器类</p>
 * 构造保险合同对象的构建器
 */
@Getter // 提供getter方法供外部访问。请注意是没有提供setter方法的
public class ConcreteBuilder {
    private String contractId;
    private String personName;
    private String companyName;
    private long beginDate;
    private long endDate;
    private String otherData;

    /**
     * 构造方法，传入必须要有的参数
     *
     * @param contractId 保险合同编号
     * @param beginDate  保险开始生效的日期
     * @param endDate    保险失效的日期
     */
    public ConcreteBuilder(String contractId, long beginDate, long endDate) {
        this.contractId = contractId;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    /**
     * 选填数据，被保险人员的名称
     *
     * @param personName 被保险人员的名称
     * @return 构建器对象
     */
    public ConcreteBuilder setPersonName(String personName) {
        this.personName = personName;
        return this;
    }

    /**
     * 选填数据，被保险公司的名称
     *
     * @param companyName 被保险公司的名称
     * @return 构建器对象
     */
    public ConcreteBuilder setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    /**
     * 选填数据，其它数据
     *
     * @param otherData 其它数据
     * @return 构建器对象
     */
    public ConcreteBuilder setOtherData(String otherData) {
        this.otherData = otherData;
        return this;
    }

    /**
     * 构建真正的对象并返回
     *
     * @return 构建的保险合同的对象
     */
    public InsuranceContract build() {
        return new InsuranceContract(this);
    }
}
