package es.kiwi.behavioral.interpreter.example5;


import org.w3c.dom.Element;

import java.util.List;

/**
 * 元素作为终结符对应的解释器
 */
public class ElementTerminalExpression extends ReadXmlExpression {
    /**
     * 元素的名字
     */
    private String eleName = "";

    public ElementTerminalExpression(String name) {
        this.eleName = name;
    }

    /**
     * 🧠解释表达式
     *
     * @param c 上下文
     * @return 解析过后的值，为了通用，可能是单个值，也可能是多个值，
     * 因此就返回一个数组
     */
    @Override
    public String[] interpret(Context c) {
        //先取出上下文里的当前元素作为父级元素
        List<Element> pEles = c.getPreEles();
        //查找到当前元素名称所对应的xml元素
        Element ele = null;
        if (pEles.size() == 0) {
            //说明现在获取的是根元素
            ele = c.getDocument().getDocumentElement();
        } else {
            //获取当前的元素
            ele = c.getNowEles(pEles.get(0), eleName).get(0);
        }

        //然后需要去获取这个元素的值
        String[] ss = new String[1];
        ss[0] = ele.getFirstChild().getNodeValue();

        return ss;
    }
}
