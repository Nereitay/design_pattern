package es.kiwi.behavioral.interpreter.example3;

import java.util.Objects;

/**
 * 获取单个元素的属性的值
 */
public class Client2 {
    public static void main(String[] args) throws Exception {
        //准备上下文
        String path = Objects.requireNonNull(Client2.class.getClassLoader().getResource("InterpreterTest.xml")).getPath();
        Context c = new Context(path);

        //想要获取c元素的name属性，也就是如下表达式的值："root/a/b/c.name"
        //这个时候c不是终结了，需要把c修改成ElementExpression
        ElementExpression root = new ElementExpression("root");
        ElementExpression aEle = new ElementExpression("a");
        ElementExpression bEle = new ElementExpression("b");
        ElementExpression cEle = new ElementExpression("c");
        PropertyTerminalExpression prop = new PropertyTerminalExpression("name");

        //组合起来
        root.addEle(aEle);
        aEle.addEle(bEle);
        bEle.addEle(cEle);
        cEle.addEle(prop);

        //调用
        String[] ss = root.interpret(c);
        System.out.println("c的属性name的值是=" + ss[0]);

        //如果要使用同一个上下文，连续进行解析，需要重新初始化上下文对象
        //比如要连续的重新再获取一次属性name的值，当然你可以重新组合元素，
        //重新解析，只要是在使用同一个上下文，就需要重新初始化上下文对象
        c.reInit();
        String[] ss2 = root.interpret(c);
        System.out.println("重新获取c的属性name的值是=" + ss2[0]);
    }
}
