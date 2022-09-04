package es.kiwi.Behavioral.interpreter.solution;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;

/**
 * Dom解析xml, 获取相应的Document对象
 */
public class XmlUtil {

    public static Document getRoot(String filePathName) throws Exception {

        Document doc = null;

        //建立一个解析器工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //获取一个DocumentBuilder对象，这个对象代表了具体的Dom解析器
        DocumentBuilder builder = factory.newDocumentBuilder();
        URL resource = XmlUtil.class.getClassLoader().getResource(filePathName);
        //得到一个表示xml文档的Document对象
        doc = builder.parse(resource.getPath());
        //去掉xml中作为格式化内容的空白而映射在Dom树中的Text Node对象
        doc.normalize();

        return doc;
    }
}
