package es.kiwi.behavioral.interpreter.extension.multi_values;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * 多个元素作为非终结符的解释处理对象
 */
public class ElementsExpression extends ReadXmlExpression {

    /**
     * 用来记录组合的ReadXmlExpression元素
     */
    private List<ReadXmlExpression> eles = new ArrayList<>();

    /**
     * 元素的名称
     */
    private String eleName = "";

    public ElementsExpression(String eleName) {
        this.eleName = eleName;
    }

    /*对子元素的维护*/
    public boolean addEle(ReadXmlExpression ele) {
        return this.eles.add(ele);
    }

    public boolean removeEle(ReadXmlExpression ele) {
        return this.eles.remove(ele);
    }

    @Override
    public String[] interpret(Context c) {
        //先取出上下文中的父级元素
        List<Element> pEles = c.getPreEles();

        //把当前获取的元素放到上下文中，这次是获取多个元素
        List<Element> nowEles = new ArrayList<>();

        for (Element ele : pEles) {
            nowEles.addAll(c.getNowEles(ele, eleName));
        }
        c.setPreEles(nowEles);

        //循环调用子元素的interpret方法
        String[] ss = null;
        for (ReadXmlExpression tempEle : eles) {
            ss = tempEle.interpret(c);
        }

        return ss;
    }
}
