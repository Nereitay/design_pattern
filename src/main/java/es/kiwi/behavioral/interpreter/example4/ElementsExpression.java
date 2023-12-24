package es.kiwi.behavioral.interpreter.example4;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>读取多个元素或属性的值</p>
 * 多个元素做为非终结符的解释处理对象
 */
public class ElementsExpression extends ReadXmlExpression {

    /**
     * 用来记录组合的ReadXmlExpression元素
     */
    private Collection<ReadXmlExpression> eles = new ArrayList<>();

    /**
     * 元素的名称
     */
    private String eleName = "";

    public ElementsExpression(String eleName) {
        this.eleName = eleName;
    }

    public boolean addEle(ReadXmlExpression ele) { // 对子元素的维护
        this.eles.add(ele);
        return true;
    }

    public boolean removeEle(ReadXmlExpression ele) { // 对子元素的维护
        this.eles.remove(ele);
        return true;
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
        //先取出上下文中的父级元素
        List<Element> pEles = c.getPreEles();
        //把当前获取的元素放到上下文里面，这次是获取多个元素
        List<Element> nowEles = new ArrayList<Element>();

        for (Element ele : pEles) {
            nowEles.addAll(c.getNowEles(ele, eleName));
        }
        c.setPreEles(nowEles);

        //循环调用子元素的interpret方法
        String[] ss = null;
        for (ReadXmlExpression ele : eles) {
            ss = ele.interpret(c);
        }
        return ss;
    }
}
