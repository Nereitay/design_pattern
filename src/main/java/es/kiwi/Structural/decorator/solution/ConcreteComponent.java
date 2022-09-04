package es.kiwi.Structural.decorator.solution;

import java.util.Date;

/**
 * 基本的实现计算奖金的类，也是被装饰器装饰的对象
 */
public class ConcreteComponent extends Component{

    @Override
    public double calcBonus(String user, Date begin, Date end) {
        //只是一个默认的实现，默认没有奖金
        return 0;
    }
}
