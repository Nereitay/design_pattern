package es.kiwi.behavioral.iterator.solution;

/**
 * 被客户收购的那个公司的工资管理类
 */
public class SalaryManager extends Aggregate {
    /**
     * 用数组管理
     */
    private PayModel[] pms;

    /**
     * 获取工资列表
     * @return 工资列表
     */
    public PayModel[] getPays() {
        return pms;
    }

    /**
     * 计算工资，其实应该有很多参数，为了演示从简
     */
    public void calcSalary() {
        //计算工资，并把工资信息填充到工资列表中
        //为了测试，输入写数据进去
        PayModel pm1 = new PayModel();
        pm1.setUsername("Apple");
        pm1.setPay(2200);

        PayModel pm2 = new PayModel();
        pm2.setUsername("Orange");
        pm2.setPay(3600);

        pms = new PayModel[2];
        pms[0] = pm1;
        pms[1] = pm2;
    }

    @Override
    public Iterator createIterator() {
        return new ArrayIteratorImpl(this);
    }

    public Object get(int index) {
        Object retObj = null;

        if (index < this.pms.length)
            retObj = this.pms[index];

        return retObj;
    }

    public int size() {
        return this.pms.length;
    }

}
