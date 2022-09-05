package es.kiwi.behavioral.interpreter.scenario;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * 读取配置文件
 */
public class ReadAppXml {
    /**
     * 读取配置文件内容
     *
     * @param filePathName 配置文件的路径和文件名
     * @throws Exception
     */
    public void read(String filePathName) throws Exception {
        Document doc = null;
        //建立一个解析器工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //获取一个DocumentBuilder对象，这个对象代表了具体的Dom解析器
        DocumentBuilder builder = factory.newDocumentBuilder();
        //得到一个表示xml文档的Document对象
        doc = builder.parse(filePathName);
        //去掉xml中作为格式化内容的空白而映射在Dom树中的Text Node对象
        doc.normalize();

        //获取jdbc的配置值
        NodeList jdbc = doc.getElementsByTagName("jdbc");

        //只有一个jdbc，获取jdbc中的驱动类的名称
        Element itemJdbc = (Element) jdbc.item(0);

        NodeList driverClassNode = itemJdbc.getElementsByTagName("driver-class");
        String driverClass = driverClassNode.item(0).getFirstChild().getNodeValue();
        System.out.println("driverClass==" + driverClass);

        //同理获取url,user,password等的值
        NodeList urlNode = itemJdbc.getElementsByTagName("url");
        String url = urlNode.item(0).getFirstChild().getNodeValue();
        System.out.println("url==" + url);

        NodeList userNode = itemJdbc.getElementsByTagName("user");
        String user = userNode.item(0).getFirstChild().getNodeValue();
        System.out.println("user==" + user);

        NodeList passwordNode = itemJdbc.getElementsByTagName("password");
        String password = passwordNode.item(0).getFirstChild().getNodeValue();
        System.out.println("password==" + password);

        //获取application-xml
       /* NodeList applicationXmlNode = itemJdbc.getElementsByTagName("application-xml");
        String applicationXml = applicationXmlNode.item(0).getFirstChild().getNodeValue();
        System.out.println("applicationXml==" + applicationXml);*/

        /*配置文件结构修改后*/
        //先要获取spring-default,再获取application-xmls,然后才能获取application-xml
        NodeList springDefaultNode = doc.getElementsByTagName("spring-default");
        NodeList appXmlsNode = ((Element) springDefaultNode.item(0)).getElementsByTagName("application-xmls");
        NodeList appXmlNode = ((Element) appXmlsNode.item(0)).getElementsByTagName("application-xml");
        //循环获取每个application-xml元素
        for (int i = 0; i < appXmlNode.getLength(); i++) {
            String applicationXml = appXmlNode.item(i).getFirstChild().getNodeValue();
            System.out.println("applicationXml==" + applicationXml);
        }
    }
}
/*
* 待解决问题：
*   当xml的结构发生变化后，能够很方便地获取相应元素或者是属性的值，而不用去修改解析xml的程序
* */