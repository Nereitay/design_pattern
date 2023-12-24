package es.kiwi.behavioral.interpreter.example5;

import org.w3c.dom.Element;

import java.util.List;

/**
 * 🧠以多个元素的属性做为终结符的解释处理对象
 *
 */
public class PropertiesTerminalExpression extends ReadXmlExpression {
    /**
     * 属性的名字
     */
    private String propName;

    public PropertiesTerminalExpression(String propName) {
        this.propName = propName;
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
        //获取最后的多个元素
        List<Element> eles = c.getPreEles();
        String[] ss = new String[eles.size()];
        //循环多个元素，获取每个的属性的值
        for (int i = 0; i < ss.length; i++) {
            ss[i] = eles.get(i).getAttribute(this.propName);
        }
        return ss;
    }
}
