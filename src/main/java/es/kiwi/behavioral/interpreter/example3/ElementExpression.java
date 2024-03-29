package es.kiwi.behavioral.interpreter.example3;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 元素作为非终结符对应的解释器，解释并执行中间元素
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
     * 解释表达式
     *
     * @param c 上下文
     * @return 解析过后的值，为了通用，可能是单个值，也可能是多个值，
     * 因此就返回一个数组
     */
    @Override
    public String[] interpret(Context c) {
        //先取出上下文里的当前元素作为父级元素
        //查找到当前元素名称所对应的xml元素，并设置回到上下文中
        Element pEle = c.getPreEle();
        if (pEle == null) {
            //说明现在获取的是根元素
            c.setPreEle(c.getDocument().getDocumentElement());
        } else {
            //根据父级元素和要查找的元素的名称来获取当前的元素
            Element nowEle = c.getNowEle(pEle, eleName);
            c.setPreEle(nowEle);
        }

        //循环调用子元素的interpret方法
        String[] ss = null;
        for (ReadXmlExpression ele : eles) {
            ss = ele.interpret(c);
        }
        return ss;
    }
}
