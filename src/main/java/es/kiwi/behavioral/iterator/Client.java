package es.kiwi.behavioral.iterator;

import es.kiwi.behavioral.iterator.scenario.PayManager;
import es.kiwi.behavioral.iterator.scenario.PayModel;
import es.kiwi.behavioral.iterator.scenario.SalaryManager;
import es.kiwi.behavioral.iterator.solution.sample.Aggregate;
import es.kiwi.behavioral.iterator.solution.sample.ConcreteAggregate;
import es.kiwi.behavioral.iterator.solution.sample.Iterator;


import java.util.List;

public class Client {

    public static void main(String[] args) {
//        someOperation();

//        before();

        //使用迭代器模式
//        after();

        //Java中最简单统一访问聚合的方式
        javaIterator();

    }

    private static void javaIterator() {
        es.kiwi.behavioral.iterator.extension.java_iterator.PayManager payManager =
                new es.kiwi.behavioral.iterator.extension.java_iterator.PayManager();
        payManager.calcPay();
        List<PayModel> payList = payManager.getPayList();
        System.out.println("集团工资列表： ");
        for (PayModel payModel : payList) {
            System.out.println(payManager);
        }

        SalaryManager salaryManager = new SalaryManager();
        salaryManager.calcSalary();
        PayModel[] pays = salaryManager.getPays();
        System.out.println("新收购公司的公司工资列表：");
        for (PayModel pm : pays) {
            System.out.println(pm);
        }
    }

    private static void after() {
        //访问集团的工资列表
        es.kiwi.behavioral.iterator.solution.PayManager payManager =
                new es.kiwi.behavioral.iterator.solution.PayManager();
        //先计算再获取
        payManager.calcPay();
        System.out.println("集团工资列表： ");
        test(payManager.createIterator());
        //访问新收购公司的工资列表
        es.kiwi.behavioral.iterator.solution.SalaryManager salaryManager =
                new es.kiwi.behavioral.iterator.solution.SalaryManager();
        //先计算再获取
        salaryManager.calcSalary();
        System.out.println("新收购公司的公司工资列表：");
        test(salaryManager.createIterator());
    }

    /**
     * 测试通过访问聚合对象的迭代器，是否能正常访问聚合对象
     *
     * @param iterator 聚合对象的迭代器
     */
    private static void test(es.kiwi.behavioral.iterator.solution.Iterator iterator) {
        iterator.first();
        while (!iterator.isDone()) {
            Object o = iterator.currentItem();
            System.out.println("the obj == " + o);
            iterator.next();
        }
    }

    private static void before() {
        //访问集团的工资列表
        PayManager payManager = new PayManager();
        //先计算再获取
        payManager.calcPay();
        List payList = payManager.getPayList();
        java.util.Iterator iterator = payList.iterator();
        System.out.println("集团工资列表： ");
        while (iterator.hasNext()) {
            PayModel pm = (PayModel) iterator.next();
            System.out.println(pm);
        }

        //访问新收购公司的工资列表
        SalaryManager salaryManager = new SalaryManager();
        //先计算再获取
        salaryManager.calcSalary();
        PayModel[] pays = salaryManager.getPays();
        System.out.println("新收购公司的公司工资列表：");
        for (int i = 0; i < pays.length; i++) {
            System.out.println(pays[i]);
        }
    }

    /**
     * 示意方法，使用迭代器的功能
     * 这里示意使用迭代器来迭代聚合对象
     */
    private static void someOperation() {
        String[] names = {"张三", "李四", "王五"};
        //创建聚合对象
        Aggregate aggregate = new ConcreteAggregate(names);
        //循环输出聚合对象中的值
        Iterator iterator = aggregate.createIterator();
        //首先设置迭代器到第一个元素
        iterator.first();
        while (!iterator.isDone()) {
            //取出当前的元素来
            Object obj = iterator.currentItem();
            System.out.println("the obj == " + obj);
            //如果还没有迭代到最后，那么就向下迭代一个
            iterator.next();
        }
    }
}
