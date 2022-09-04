package es.kiwi.Behavioral.interpreter.extension.multi_values;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * 上下文，用来包含解释器需要的一些全局信息
 */
public class Context {

    /**
     * 上一个被处理的多个元素
     */
    private List<Element> preEles = new ArrayList<>();

    /**
     * Dom解析xml的Document对象
     */
    private Document document;

    /**
     * 构造方法
     * @param filePathName 需要读取的xml的路径和名字
     * @throws Exception
     */
    public Context(String filePathName) throws Exception{
        //通过辅助的xml工具类来获取被解析的xml对应的Document对象
        this.document = XmlUtil.getRoot(filePathName);
    }

    public List<Element> getPreEles() {
        return preEles;
    }

    public void setPreEles(List<Element> preEles) {
        this.preEles = preEles;
    }

    public Document getDocument() {
        return document;
    }

    /**
     * 重新初始化上下文
     */
    public void reInit() {
        preEles = new ArrayList<>();
    }

    /**
     * 各个Expression公共使用的方法
     * 根据父元素和当前元素的名称来获取当前的多个元素的集合
     * @param pEle 父元素
     * @param eleName 当前元素的名称
     * @return 当前的多个元素集合
     */
    public List<Element> getNowEles(Element pEle, String eleName) {
        List<Element> elements = new ArrayList<>();

        NodeList tempNodeList = pEle.getChildNodes();
        for (int i = 0; i < tempNodeList.getLength(); i++) {
            if (tempNodeList.item(i) instanceof Element) {
                Element nowEle = (Element) tempNodeList.item(i);
                if (nowEle.getTagName().equals(eleName)) {
                    elements.add(nowEle);
                }
            }
        }

        return elements;
    }
}
