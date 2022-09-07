package es.kiwi.creational.builder.extension.complex_object;


import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * 保险合同的对象
 *
 * 进一步：把构建器对象和被构建对象合并
 * 重构手法：将类内联化 (Inline Class)
 */
public class InsuranceContract2 {

    private String contractId;

    private String personName;

    private String companyName;

    private long beginDate;

    private long endDate;

    private String otherData;

    /**
     * 构造方法：访问级别是私有的
     */
    private InsuranceContract2(ConcreteBuilder2 builder) {
        this.contractId = builder.getContractId();
        this.personName = builder.getPersonName();
        this.companyName = builder.getCompanyName();
        this.beginDate = builder.getBeginDate();
        this.endDate = builder.getEndDate();
        this.otherData = builder.getOtherData();
    }

    @Getter
    public static class ConcreteBuilder2 {
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
        public ConcreteBuilder2(String contractId, long beginDate, long endDate) {
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
        public ConcreteBuilder2 setPersonName(String personName) {
            this.personName = personName;
            return this;
        }

        /**
         * 选填数据，被保险公司的名称
         *
         * @param companyName 被保险公司的名称
         * @return 构建器对象
         */
        public ConcreteBuilder2 setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        /**
         * 选填数据，其他数据
         *
         * @param otherData 其他数据
         * @return 构建器对象
         */
        public ConcreteBuilder2 setOtherData(String otherData) {
            this.otherData = otherData;
            return this;
        }

        /**
         * 构建真正的对象并返回
         *
         * @return 构建的保险合同的对象
         */
        public InsuranceContract2 build() {
            if (StringUtils.isBlank(contractId)) {
                throw new IllegalArgumentException("合同编号不能为空");
            }
            boolean signPerson = StringUtils.isNotBlank(personName);
            boolean signCompany = StringUtils.isNotBlank(companyName);
            if (signPerson && signCompany) {
                throw new IllegalArgumentException("一份保险合同不能同时与个人和公司签订");
            }
            if (!signPerson && !signCompany) {
                throw new IllegalArgumentException("一份合同不能没有签订对象");
            }
            if (beginDate <= 0) {
                throw new IllegalArgumentException("合同必须有保险开始生效的日期");
            }
            if (endDate <= 0) {
                throw new IllegalArgumentException("合同必须有保险失效的日期");
            }
            if (endDate <= beginDate) {
                throw new IllegalArgumentException("保险失效日期必须大于保险生效日期");
            }
            return new InsuranceContract2(this);
        }
    }

    /**
     * 示例：保险合同的某些操作
     */
    public void someOperation() {
        System.out.println("Now in Insurance Contract someOperation == " + this.contractId);
    }
}
