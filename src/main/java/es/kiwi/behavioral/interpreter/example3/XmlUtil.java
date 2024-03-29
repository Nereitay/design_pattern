package es.kiwi.behavioral.interpreter.example3;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * 工具类：获取Document对象，就是Dom解析xml,获取相应的Document对象
 */
public class XmlUtil {
    public static Document getRoot(String filePathName) throws Exception {
        Document doc = null;
        //建立一个解析器工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //获得一个DocumentBuilder对象，这个对象代表了具体的DOM解析器
        DocumentBuilder builder = factory.newDocumentBuilder();
        //得到一个表示XML文档的Document对象
        doc = builder.parse(filePathName);
        //去掉XML文档中作为格式化内容的空白而映射在DOM树中的不必要的Text Node对象
        doc.normalize();
        return doc;
    }
}