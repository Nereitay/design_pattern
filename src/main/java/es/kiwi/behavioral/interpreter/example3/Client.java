package es.kiwi.behavioral.interpreter.example3;

import java.util.Objects;

/**
 * 获取单个元素的值
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //准备上下文
        String path = Objects.requireNonNull(Client.class.getClassLoader().getResource("InterpreterTest.xml")).getPath();
        Context c = new Context(path);

        //想要获取c元素的值，也就是如下表达式的值："root/a/b/c"
        //首先要构建解释器的抽象语法树
        ElementExpression root = new ElementExpression("root");
        ElementExpression aEle = new ElementExpression("a");
        ElementExpression bEle = new ElementExpression("b");
        ElementTerminalExpression cEle = new ElementTerminalExpression("c");

        //组合起来
        root.addEle(aEle);
        aEle.addEle(bEle);
        bEle.addEle(cEle);

        //调用
        String[] ss = root.interpret(c);
        System.out.println("c的值是=" + ss[0]);
    }
}
