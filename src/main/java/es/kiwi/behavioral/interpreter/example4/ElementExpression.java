package es.kiwi.behavioral.interpreter.example4;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>读取多个元素或属性的值</p>
 * 单个元素作为非终结符的解释器
 */
public class ElementExpression extends ReadXmlExpression {

    /**
     * 用来记录组合的ReadXmlExpression元素
     */
    private Collection<ReadXmlExpression> eles = new ArrayList<>();

    /**
     * 元素的名称
     */
    private String eleName = "";

    public ElementExpression(String eleName) {
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
     * 🧠解释表达式
     *
     * @param c 上下文
     * @return 解析过后的值，为了通用，可能是单个值，也可能是多个值，
     * 因此就返回一个数组
     */
    @Override
    public String[] interpret(Context c) {
        //先取出上下文中的父级元素
        List<Element> pEles = c.getPreEles();
        Element ele = null;
        //把当前获取的元素放到上下文中
        List<Element> nowEles = new ArrayList<>();
        if (pEles.size() == 0) {
            //说明现在获取的是根元素
           ele = c.getDocument().getDocumentElement();
           pEles.add(ele);
           c.setPreEles(pEles);
        } else {
            for (Element tempEle : pEles) {
                nowEles.addAll(c.getNowEles(tempEle, eleName));
                if (nowEles.size() > 0) {
                    // 找到一个就停止
                    break;
                }
            }
            List<Element> tempList = new ArrayList<>();
            tempList.add(nowEles.get(0));
            c.setPreEles(tempList);
        }

        //循环调用子元素的interpret方法
        String[] ss = null;
        for (ReadXmlExpression tempEle : eles) {
            ss = tempEle.interpret(c);
        }
        return ss;
    }
}
