package es.kiwi.creational.builder.extension.complex_object;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * 构造保险合同对象的构造器
 */
@Getter
public class ConcreteBuilder {
    private String contractId;

    private String personName;

    private String companyName;

    private long beginDate;

    private long endDate;

    private String otherData;

    /**
     * 构造方法，传入必须要有的参数
     * @param contractId 保险合同编号
     * @param beginDate 保险开始生效的日期
     * @param endDate 保险失效的日期
     */
    public ConcreteBuilder(String contractId, long beginDate, long endDate) {
        this.contractId = contractId;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    /**
     * 选填数据，被保险人员的名称
     * @param personName 被保险人员的名称
     * @return 构建器对象
     */
    public ConcreteBuilder setPersonName(String personName) {
        this.personName = personName;
        return this;
    }

    /**
     * 选填数据，被保险公司的名称
     * @param companyName 被保险公司的名称
     * @return 构建器对象
     */
    public ConcreteBuilder setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    /**
     * 选填数据，其他数据
     * @param otherData 其他数据
     * @return 构建器对象
     */
    public ConcreteBuilder setOtherData(String otherData) {
        this.otherData = otherData;
        return this;
    }

    /**
     * 构建真正的对象并返回
     * @return 构建的包i按合同的对象
     */
    public InsuranceContract build() {
       return new InsuranceContract(this);
    }


}
