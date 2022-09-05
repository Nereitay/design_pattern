package es.kiwi.behavioral.interpreter;

import es.kiwi.behavioral.interpreter.extension.multi_values.ElementsExpression;
import es.kiwi.behavioral.interpreter.extension.multi_values.ElementsTerminalExpression;
import es.kiwi.behavioral.interpreter.extension.multi_values.PropertiesTerminalExpression;
import es.kiwi.behavioral.interpreter.extension.multi_values.ReadXmlExpression;
import es.kiwi.behavioral.interpreter.extension.parser.Parser;
import es.kiwi.behavioral.interpreter.solution.Context;
import es.kiwi.behavioral.interpreter.solution.ElementExpression;
import es.kiwi.behavioral.interpreter.solution.ElementTerminalExpression;
import es.kiwi.behavioral.interpreter.solution.PropertyTerminalExpression;

public class Client {

    public static void main(String[] args) throws Exception {
        /*使用解释器模式*/
//        interpreter1();
//        interpreter2();

        /*读取多个元素或属性的值*/
//        interpreter3();
//        interpreter4();

        /*解析器*/
//        parser();

    }

    private static void parser() throws Exception {
        //准备上下文
        es.kiwi.behavioral.interpreter.extension.multi_values.Context ctx =
                new es.kiwi.behavioral.interpreter.extension.multi_values.Context("InterpreterTest.xml");
        //通过解析器获取抽象语法树
        ReadXmlExpression re = Parser.parse("root/a/b/d$.id$");
        //请求解析，获取返回值
        String[] ss = re.interpret(ctx);
        for (String s : ss) {
            System.out.println("d的属性id的值是=" + s);
        }
    }

    private static void interpreter4() throws Exception {
        //准备上下文
        es.kiwi.behavioral.interpreter.extension.multi_values.Context ctx =
                new es.kiwi.behavioral.interpreter.extension.multi_values.Context("InterpreterTest.xml");
        //想要获取多个d元素的id属性，也就是如下表达式的值："root/a/b/c/d&.id&"
        //首先要构建解释器的抽象语法树
        es.kiwi.behavioral.interpreter.extension.multi_values.ElementExpression root =
                new es.kiwi.behavioral.interpreter.extension.multi_values.ElementExpression("root");
        es.kiwi.behavioral.interpreter.extension.multi_values.ElementExpression aEle =
                new es.kiwi.behavioral.interpreter.extension.multi_values.ElementExpression("a");
        es.kiwi.behavioral.interpreter.extension.multi_values.ElementExpression bEle =
                new es.kiwi.behavioral.interpreter.extension.multi_values.ElementExpression("b");

        ElementsExpression dEle = new ElementsExpression("d");

        PropertiesTerminalExpression prop = new PropertiesTerminalExpression("id");

        //组合起来
        root.addEle(aEle);
        aEle.addEle(bEle);
        bEle.addEle(dEle);
        dEle.addEle(prop);

        //调用
        String[] ss = root.interpret(ctx);
        for (String s : ss) {
            System.out.println("d的属性id的值是=" + s);
        }
    }

    private static void interpreter3() throws Exception {
        //准备上下文
        es.kiwi.behavioral.interpreter.extension.multi_values.Context ctx =
                new es.kiwi.behavioral.interpreter.extension.multi_values.Context("InterpreterTest.xml");
        //想要获取多个d元素的值，也就是如下表达式的值："root/a/b/c/d&"
        //首先要构建解释器的抽象语法树
        es.kiwi.behavioral.interpreter.extension.multi_values.ElementExpression root =
                new es.kiwi.behavioral.interpreter.extension.multi_values.ElementExpression("root");
        es.kiwi.behavioral.interpreter.extension.multi_values.ElementExpression aEle =
                new es.kiwi.behavioral.interpreter.extension.multi_values.ElementExpression("a");
        es.kiwi.behavioral.interpreter.extension.multi_values.ElementExpression bEle =
                new es.kiwi.behavioral.interpreter.extension.multi_values.ElementExpression("b");
        ElementsTerminalExpression dEle = new ElementsTerminalExpression("d");

        //组合起来
        root.addEle(aEle);
        aEle.addEle(bEle);
        bEle.addEle(dEle);

        //调用
        String[] ss = root.interpret(ctx);
        for (String s : ss) {
            System.out.println("d的值是=" + s);
        }
    }

    private static void interpreter2() throws Exception {
        //准备上下文
        Context ctx = new Context("InterpreterTest.xml");

        //想要获取c元素的name属性值，也就是如下表达式：“root/a/b/c.name”
        //这个时候c不是终结了，需要把c修改成ElementExpression
        ElementExpression root = new ElementExpression("root");
        ElementExpression aEle = new ElementExpression("a");
        ElementExpression bEle = new ElementExpression("b");
        ElementExpression cEle = new ElementExpression("c");
        PropertyTerminalExpression prop = new PropertyTerminalExpression("name");

        //组合
        root.addEle(aEle);
        aEle.addEle(bEle);
        bEle.addEle(cEle);
        cEle.addEle(prop);

        //调用
        String[] ss = root.interpret(ctx);
        System.out.println("c的值是=" + ss[0]);

        //如果要使用同一个上下文，连续进行解析，需要重新初始化上下文对象
        //比如，要连续的重新再获取一次属性的name值，当然你可以重新组合元素
        //重新解析，只要是在使用同一个上下文，就需要重新初始化上下文对象
        ctx.reInit();
        String[] ss2 = root.interpret(ctx);
        System.out.println("重新获取c的属性name的值是=" + ss2[0]);
    }

    private static void interpreter1() throws Exception {
        //准备上下文
        Context ctx = new Context("InterpreterTest.xml");

        //想要获取c元素的值，也就是如下表达式：“root/a/b/c”
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
        String[] ss = root.interpret(ctx);
        System.out.println("c的值是=" + ss[0]);
    }
}
