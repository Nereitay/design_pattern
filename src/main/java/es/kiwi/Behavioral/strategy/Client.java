package es.kiwi.Behavioral.strategy;

import es.kiwi.Behavioral.strategy.extension.context_strategy.*;
import es.kiwi.Behavioral.strategy.extension.faultTolerance_recovery.LogContext;
import es.kiwi.Behavioral.strategy.solution.CooperateCustomerStrategy;
import es.kiwi.Behavioral.strategy.solution.LargeCustomerStrategy;
import es.kiwi.Behavioral.strategy.solution.Price;
import es.kiwi.Behavioral.strategy.solution.Strategy;

public class Client {

    public static void main(String[] args) {
        //使用策略模式
//        strategyPattern();

        //Context和Strategy的关系，策略实现对象也可以从上下文中获取所需要的数据
//        contextStrategy();

        //扩展示例，实现方式二
//        contextStrategy2();

        //容错恢复机制
//        faultTolerance();

        //策略模式结合模板方法模式
        template();
    }

    private static void template() {
        es.kiwi.Behavioral.strategy.extension.template_method.LogContext log =
                new es.kiwi.Behavioral.strategy.extension.template_method.LogContext();
        log.log("记录日志");
        log.log("再次记录日志");
    }

    private static void faultTolerance() {
        LogContext log = new LogContext();
        log.log("记录日志");
        log.log("再次记录日志");
    }

    /**
     * 	现在有这么两种扩展的实现方式，到底使用哪一种呢？或者是哪种实现更好呢？下面来比较一下。
     *
     * 	- 对于扩展上下文的方式：
     * 	    这样实现，所有策略的实现风格更统一，策略需要的数据都统一从上下文来获取，这样在使用方法上也很统一：
     * 	    另外，在上下文中添加新的数据，别的相应算法也可以用得上，可以视为公共的数据。
     *
     * 		但缺点也很明显，如果这些数据只有一个特定的算法来使用，那么这些数据有些浪费；
     * 		另外每次添加新的算法都去扩展上下文，容易形成复杂的上下文对象层次，也未见得有必要。
     *
     * 	- 对于在策略算法的实现上添加自己需要的数据的方式：
     * 	    这样实现，比较好想，实现起来简单。
     *
     * 	    但是缺点也很明显，跟其他策略实现的风格不一致，其他策略都是从上下文中来获取数据，而这个策略的实现一部分数据来自上下文，一部分数据
     * 		来自自己，有些不统一；
     * 		另外，这样一来，外部使用这些策略算法的时候也不一样了，难于以一个统一的方式来动态切换策略算法。
     *
     * 	两种实现各有优劣，至于如何选择，那就具体问题具体分析了。
     */
    private static void contextStrategy2() {
        //测试新添加的支付方式
        PaymentStrategy strategyCard2 = new Card2("010998877656");
        PaymentContext ctx4 = new PaymentContext("Picota", 9000, strategyCard2);
        ctx4.payNow();
    }

    private static void contextStrategy() {
        //创建相应的支付策略
        PaymentStrategy strategyRMB = new RMBCash();
        PaymentStrategy strategyDollar = new DollarCash();

        //准备小李的支付工资上下文
        PaymentContext ctx1 = new PaymentContext("Ciruela", 5000, strategyRMB);
        //向小李支付工资
        ctx1.payNow();

        //切换一个人， 给Pera支付工资
        PaymentContext ctx2 = new PaymentContext("Pera", 8000, strategyDollar);
        ctx2.payNow();

        //创建新添加的支付方式
        PaymentStrategy strategyCard = new Card();
        PaymentContext ctx3 = new PaymentContext2("Uva", 9000, "010998877656", strategyCard);
        ctx3.payNow();
    }

    private static void strategyPattern() {
        //1. 选择并创建需要使用的策略对象
        Strategy strategy = new LargeCustomerStrategy();
        //2. 创建上下文
        Price ctx = new Price(strategy);
        //3. 计算报价
        double quote = ctx.quote(1000);
        System.out.println("向客户报价：" + quote);

        // 增加新的策略
        Strategy strategy2 = new CooperateCustomerStrategy();
        Price ctx2 = new Price(strategy2);
        double quote2 = ctx2.quote(1000);
        System.out.println("向客户报价：" + quote2);
    }
}
