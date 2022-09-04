package es.kiwi.Structural.decorator;

import es.kiwi.Structural.decorator.extension.aop.*;
import es.kiwi.Structural.decorator.extension.javaIO.EncryptOutputStream;
import es.kiwi.Structural.decorator.extension.javaIO.EncryptOutputStream2;
import es.kiwi.Structural.decorator.scenario.Bonus;
import es.kiwi.Structural.decorator.solution.*;
import es.kiwi.Structural.decorator.solution.Decorator;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Client {

    public static void main(String[] args) throws Exception{
        /*奖金计算场景*/
//        scenario();

        /*使用装饰模式*/
//        decorator();

        /*自己实现的I/O流的装饰器 ---- 第一版*/
//        io1();
        /*第一版的问题*/
//        io0();

        /*自己实现的I/O流的装饰器 ---- 第二版*/
//        io2();

        /*装饰模式和AOP*/
        //得到业务接口，组合装饰器
        GoodsSaleEbi ebi = new CheckDecorator(new LogDecorator(new GoodsSaleEbo()));
        //准备测试数据
        SaleModel saleModel = new SaleModel();
        saleModel.setGoods("Moto手机");
        saleModel.setSaleNum(2);
        //调用业务功能
        ebi.sale("Mango", "Uva", saleModel);
        ebi.sale("Papaya", "Uva", saleModel);
    }

    private static void io2() throws IOException {
        //流式输出文件
        DataOutputStream dout = new DataOutputStream(
                new EncryptOutputStream2(
                        new BufferedOutputStream(
                                new FileOutputStream(
                                        "MyEncrypt.txt"))));
        //然后就可以输出内容了
        dout.write("abcdxyz".getBytes());
        dout.close();
    }

    private static void io0() throws IOException {
        //流式输出文件
        // 换了个位置，输出文件内容为空，EncryptOutputStream继承OutputStream的close方法，是个空，没有flush()方法
        DataOutputStream dout = new DataOutputStream(
                new EncryptOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(
                                        "MyEncrypt.txt"))));
        //然后就可以输出内容了
        dout.write("abcdxyz".getBytes());
        dout.close();
    }

    private static void io1() throws IOException {
        //流式输出文件
        DataOutputStream dout = new DataOutputStream(
                new BufferedOutputStream(
                        new EncryptOutputStream(//这是我们自己加的装饰器
                                new FileOutputStream(
                                        "MyEncrypt.txt"))));
        //然后就可以输出内容了
        dout.write("abcdxyz".getBytes());
        dout.close();
    }

    private static void decorator() {
        //先创建基本奖金的类，这也是被装饰的对象
        Component c1 = new ConcreteComponent();

        //然后对计算的基本奖金进行装饰，这里要组合各个装饰
        //说明，各个装饰者之间最好时不要有先后顺序的限制
        //也就是先装饰谁和后装饰谁都应该一样

        //先组合普通业务人员的奖金计算
        Decorator d1 = new MonthBonusDecorator(c1);
        Decorator d2 = new SumBonusDecorator(d1);

        //注意：这里只需使用最后组合好的对象调用业务方法即可，会依次调用回去
        //日期对象都没有用上，所以传null就可以了
        double m = d2.calcBonus("Mango", null, null);
        System.out.println("============Mango应得奖金：" + m);
        double h = d2.calcBonus("Higos", null, null);
        System.out.println("============Piña应得奖金：" + h);

        //如果是业务经理，还需要一个计算段对的奖金计算
        Decorator d3 = new GroupBonusDecorator(d2);
        double p = d3.calcBonus("Papaya", null, null);
        System.out.println("============Papaya应得奖金：" + p);
    }

    private static void scenario() {
        //先创建奖金计算的对象
        Bonus bonus = new Bonus();

        //日期对象都没用上，所有传null就可以了
        double m = bonus.calcBonus("Mango", null, null);
        System.out.println("============Mango应得奖金：" + m);
        double h = bonus.calcBonus("Higos", null, null);
        System.out.println("============Piña应得奖金：" + h);
        double p = bonus.calcBonus("Papaya", null, null);
        System.out.println("============Papaya应得奖金：" + p);
    }
}
