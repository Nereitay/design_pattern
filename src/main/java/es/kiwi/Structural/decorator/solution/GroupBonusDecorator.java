package es.kiwi.Structural.decorator.solution;

import es.kiwi.Structural.decorator.scenario.TempDB;

import java.util.Date;

/**
 * 装饰器对象，计算当月团队业务奖金
 */
public class GroupBonusDecorator extends Decorator {
    /**
     * 通过构造方法传入被装饰的对象
     *
     * @param c 被装饰的对象
     */
    public GroupBonusDecorator(Component c) {
        super(c);
    }

    @Override
    public double calcBonus(String user, Date begin, Date end) {
        //1.先获取前面运算出来的奖金
        double money = super.calcBonus(user, begin, end);
        //2.计算当月团队业务奖金，先计算出团队总的业务额，然后再乘以1%
        //假设都是一个团队的
        double group = 0.0;
        for (double d : TempDB.mapMonthSaleMoney.values()) {
            group += d;
        }
        double bonus = group * 0.01;
        System.out.println(user + "当月团队业务奖金" + bonus);
        return money + bonus;
    }
}
