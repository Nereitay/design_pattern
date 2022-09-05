package es.kiwi.structural.decorator.solution;

import es.kiwi.structural.decorator.scenario.TempDB;

import java.util.Date;

/**
 * 装饰器对象，计算当月业务奖金
 */
public class MonthBonusDecorator extends Decorator{
    /**
     * 通过构造方法传入被装饰的对象
     *
     * @param c 被装饰的对象
     */
    public MonthBonusDecorator(Component c) {
        super(c);
    }

    @Override
    public double calcBonus(String user, Date begin, Date end) {
        //1.先获取前面运算出来的奖金
        double money = super.calcBonus(user, begin, end);
        //2.然后计算当月业务奖金，按人员和时间去获取当月业务额，然后再乘以 3%
        double bonus = TempDB.mapMonthSaleMoney.get(user) * 0.03;
        System.out.println(user + "当月业务奖金" + bonus);
        return money + bonus;
    }
}
