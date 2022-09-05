package es.kiwi.behavioral.iterator.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户方已有的工资管理对象
 */
public class PayManager extends Aggregate{
    /**
     * 聚合对象，这里是Java的聚合对象
     */
    private List list = new ArrayList<>();

    public List getPayList() {
        return list;
    }

    public void calcPay() {
        //计算工资，并把工资信息填充到工资列表中
        //为了测试，输入些数据进去
        PayModel pm1 = new PayModel();
        pm1.setPay(3800);
        pm1.setUsername("Uva");

        PayModel pm2 = new PayModel();
        pm2.setPay(5800);
        pm2.setUsername("Piña");

        list.add(pm1);
        list.add(pm2);
    }

    @Override
    public Iterator createIterator() {
        return new CollectionIteratorImpl(this);
    }

    public Object get(int index) {
        Object retObj = null;

        if (index < this.list.size())
            retObj = this.list.get(index);

        return retObj;
    }

    public int size() {
        return this.list.size();
    }
}
