package es.kiwi.creational.builder.example6;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>进一步：把构建器对象和被构建对象合并 - inline class</p>
 * 保险合同的对象
 */
public class InsuranceContract {
    /**
     * 保险合同编号
     */
    private String contractId;
    /**
     * 被保险人员的名称，同一份保险合同，要么跟人员签订，要么跟公司签订，
     * 也就是说，"被保险人员"和"被保险公司"这两个属性，不可能同时有值
     */
    private String personName;
    /**
     * 被保险公司的名称
     */
    private String companyName;
    /**
     * 保险开始生效的日期
     */
    private long beginDate;
    /**
     * 保险失效的日期，一定会大于保险开始生效的日期
     */
    private long endDate;
    /**
     * 示例：其它数据
     */
    private String otherData;

    /**
     * 构造方法，访问级别是私有的👀
     */
    InsuranceContract(ConcreteBuilder builder) {
        this.contractId = builder.contractId;
        this.personName = builder.personName;
        this.companyName = builder.companyName;
        this.beginDate = builder.beginDate;
        this.endDate = builder.endDate;
        this.otherData = builder.otherData;
    }

    /**
     * 👀构造保险合同对象的构建器,作为保险合同的类级内部类
     */
    public static class ConcreteBuilder {
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
            if (StringUtils.isBlank(contractId)) {
                throw new IllegalArgumentException("合同编号不能为空");
            }
            boolean signPerson = StringUtils.isBlank(personName);
            boolean signCompany = StringUtils.isBlank(companyName);
            if (signPerson && signCompany) {
                throw new IllegalArgumentException("一份保险合同不能同时与人和公司签订");
            }
            if (!signPerson && !signCompany) {
                throw new IllegalArgumentException("一份保险合同不能没有签订对象");
            }
            if (beginDate <= 0) {
                throw new IllegalArgumentException("合同必须有保险开始生效的日期");
            }
            if (endDate <= 0) {
                throw new IllegalArgumentException("合同必须有保险失效的日期");
            }
            if (endDate <= beginDate) {
                throw new IllegalArgumentException("保险失效的日期必须大于保险生效日期");
            }
            return new InsuranceContract(this);
        }
    }

    /**
     * 示意：保险合同的某些操作
     */
    public void someOperation() {
        System.out.println("Now in Insurance Contract someOperation==" + this.contractId + ",personName=" + this.personName + " , companyName=" + this.companyName);
    }
}
