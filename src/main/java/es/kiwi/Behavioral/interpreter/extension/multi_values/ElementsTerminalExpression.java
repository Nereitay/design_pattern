package es.kiwi.Behavioral.interpreter.extension.multi_values;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;


/**
 * 以多个元素作为终结符对应的解释器
 */
public class ElementsTerminalExpression extends ReadXmlExpression {

    /**
     * 元素的名称
     */
    private String eleName = "";

    public ElementsTerminalExpression(String eleName) {
        this.eleName = eleName;
    }

    @Override
    public String[] interpret(Context c) {
        //先取出上下文中的当前元素作为父级元素
        List<Element> pEles = c.getPreEles();

        //获取对当前多个元素
        List<Element> nowEles = new ArrayList<>();

        for (Element ele : pEles) {
            nowEles.addAll(c.getNowEles(ele, eleName));
        }

        //然后来获取这些元素的值
        String[] ss = new String[nowEles.size()];
        for (int i = 0; i < ss.length; i++) {
            ss[i] = nowEles.get(i).getFirstChild().getNodeValue();
        }
        return ss;
    }
}
