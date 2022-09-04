package es.kiwi.Behavioral.interpreter.extension.multi_values;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * 单个元素作为非终结符对应的解释器
 */
public class ElementExpression extends ReadXmlExpression {

    /**
     * 用来记录组合的ReadXmlExpression元素
     */
    private List<ReadXmlExpression> eles = new ArrayList<>();

    /**
     * 元素的名称
     */
    private String eleName = "";

    public ElementExpression(String eleName) {
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
        //先取出上下文中的当前元素作为父级元素
        //查找到当前元素名称所对应的xml元素，并设置回到上下文
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
                    //找到一个就停止
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
