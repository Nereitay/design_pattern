package es.kiwi.behavioral.interpreter.example4;

import java.util.Objects;

/**
 * 获取多个属性值
 */
public class Client2 {
    public static void main(String[] args) throws Exception {
        //准备上下文
        String path = Objects.requireNonNull(Client2.class.getClassLoader().getResource("InterpreterTest.xml")).getPath();
        Context c = new Context(path);

        //想要获取多个d元素的值，也就是如下表达式的值："root/a/b/d$"
        //首先要构建解释器的抽象语法树
        ElementExpression root = new ElementExpression("root");
        ElementExpression aEle = new ElementExpression("a");
        ElementExpression bEle = new ElementExpression("b");
        ElementsExpression dEle = new ElementsExpression("d");
        PropertiesTerminalExpression prop = new PropertiesTerminalExpression("id");

        //组合起来
        root.addEle(aEle);
        aEle.addEle(bEle);
        bEle.addEle(dEle);
        dEle.addEle(prop);

        //调用
        String[] ss = root.interpret(c);
        for (String s : ss) {
            System.out.println("d的属性id值是=" + s);
        }
    }
}
