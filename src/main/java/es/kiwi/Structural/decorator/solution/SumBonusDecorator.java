package es.kiwi.Structural.decorator.solution;

import java.util.Date;

/**
 * 装饰器对象，计算累计奖金
 */
public class SumBonusDecorator extends Decorator{
    /**
     * 通过构造方法传入被装饰的对象
     *
     * @param c 被装饰的对象
     */
    public SumBonusDecorator(Component c) {
        super(c);
    }

    @Override
    public double calcBonus(String user, Date begin, Date end) {
        //1.先获取前面运算出来的奖金
        double money = super.calcBonus(user, begin, end);
        //2.然后计算累计奖金，其实应该按照人员去获取类级的业务额，然后再乘以 0.1%
        //简单演示一下，假定大家的累计业务额都是1000000元
        double bonus = 1000000 * 0.001;
        System.out.println(user + "累计奖金" + bonus);
        return money + bonus;
    }
}
