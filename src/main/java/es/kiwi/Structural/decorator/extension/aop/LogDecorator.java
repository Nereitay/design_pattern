package es.kiwi.Structural.decorator.extension.aop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 实现日志记录
 */
public class LogDecorator extends Decorator {
    /**
     * 通过构造方法传入被装饰的对象
     *
     * @param ebi 被装饰的对象
     */
    public LogDecorator(GoodsSaleEbi ebi) {
        super(ebi);
    }

    @Override
    public boolean sale(String user, String customer, SaleModel saleModel) {
        //执行业务功能
        boolean f = this.ebi.sale(user, customer, saleModel);

        //执行业务功能后记录日志
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println("日志记录：" + user + "于" + df.format(new Date()) +
                "时保存了一条销售记录，客户是" + customer + "，购买记录是" + saleModel);

        return f;

    }
}
