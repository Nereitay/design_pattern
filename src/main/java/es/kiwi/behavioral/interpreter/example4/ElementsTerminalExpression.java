package es.kiwi.behavioral.interpreter.example4;


import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * 🧠以多个元素作为终结符的解释处理对象
 */
public class ElementsTerminalExpression extends ReadXmlExpression {
    /**
     * 元素的名字
     */
    private String eleName = "";

    public ElementsTerminalExpression(String name) {
        this.eleName = name;
    }

    /**
     * 解释表达式
     *
     * @param c 上下文
     * @return 解析过后的值，为了通用，可能是单个值，也可能是多个值，
     * 因此就返回一个数组
     */
    @Override
    public String[] interpret(Context c) {
        //先取出上下文里的父级元素
        List<Element> pEles = c.getPreEles();
        //获取当前的多个元素
        List<Element> nowEles = new ArrayList<>();

        for (Element ele : pEles) {
            nowEles.addAll(c.getNowEles(ele, eleName));
        }

        //然后需要去获取这些元素的值
        String[] ss = new String[nowEles.size()];
        for (int i = 0; i < ss.length; i++) {
            ss[i] = nowEles.get(i).getFirstChild().getNodeValue();
        }

        return ss;
    }
}
