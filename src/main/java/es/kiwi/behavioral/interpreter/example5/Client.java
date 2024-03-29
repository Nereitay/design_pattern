package es.kiwi.behavioral.interpreter.example5;

import java.util.Objects;

public class Client {
    public static void main(String[] args) throws Exception {
        //准备上下文
        String path = Objects.requireNonNull(Client.class.getClassLoader().getResource("InterpreterTest.xml")).getPath();
        Context c = new Context(path);

        //通过解析器获取抽象语法树
        ReadXmlExpression re = Parser.parse("root/a/b/d$.id$");

        //请求解析，获取返回值
        String[] ss = re.interpret(c);
        for (String s : ss) {
            System.out.println("d的属性id值是=" + s);
        }

        //如果要使用同一个上下文，连续进行解析，需要重新初始化上下文对象
        c.reInit();
        ReadXmlExpression re2 = Parser.parse("root/a/b/d$");
        //请求解析，获取返回值
        String[] ss2 = re2.interpret(c);
        for (String s : ss2) {
            System.out.println("d的值是=" + s);
        }
    }
}
