package es.kiwi.creational.builder;

import es.kiwi.creational.builder.extension.complex_object.*;
import es.kiwi.creational.builder.mosh.PdfDocument;
import es.kiwi.creational.builder.mosh.PdfDocumentBuilder;
import es.kiwi.creational.builder.mosh.Presentation1;
import es.kiwi.creational.builder.mosh.Slide;
import es.kiwi.creational.builder.scenario.*;
import es.kiwi.creational.builder.solution.Director;
import es.kiwi.creational.builder.solution.TxtBuilder;
import es.kiwi.creational.builder.solution.XmlBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BuilderTest {

    /*To separate the construction of an object from its representation*/
    @Test
    public void mainMosh() {
        Presentation1 presentation = new Presentation1();
        presentation.addSlide(new Slide("Slide 1"));
        presentation.addSlide(new Slide("Slide 2"));

        PdfDocumentBuilder builder = new PdfDocumentBuilder();
        presentation.export(builder);
        PdfDocument pdf = builder.getPdfDocument();
    }

    @Test
    public void scenario() {
        //准备测试数据
        ExportHeaderModel ehm = new ExportHeaderModel();
        ehm.setDepId("一分公司");
        ehm.setExportDate("2021-11-11");

        Map<String, Collection<ExportDataModel>> mapData = new HashMap<>();
        Collection<ExportDataModel> col = new ArrayList<>();

        ExportDataModel edm1 = new ExportDataModel();
        edm1.setProductId("产品001号");
        edm1.setPrice(100);
        edm1.setAmount(80);

        ExportDataModel edm2 = new ExportDataModel();
        edm2.setProductId("产品002号");
        edm2.setPrice(99);
        edm2.setAmount(55);
        //把数据组装起来
        col.add(edm1);
        col.add(edm2);
        mapData.put("销售记录表", col);

        ExportFooterModel efm = new ExportFooterModel();
        efm.setExportUser("张三");

        //测试输出到文本文件
        ExportToTxt toTxt = new ExportToTxt();
        toTxt.export(ehm, mapData, efm);
        //测试输出到xml文件
        ExportToXml toXml = new ExportToXml();
        toXml.export(ehm, mapData, efm);
    }

    @Test
    public void builder() {
        //准备测试数据
        ExportHeaderModel ehm = new ExportHeaderModel();
        ehm.setDepId("一分公司");
        ehm.setExportDate("2021-11-11");

        Map<String, Collection<ExportDataModel>> mapData = new HashMap<>();
        Collection<ExportDataModel> col = new ArrayList<>();

        ExportDataModel edm1 = new ExportDataModel();
        edm1.setProductId("产品001号");
        edm1.setPrice(100);
        edm1.setAmount(80);

        ExportDataModel edm2 = new ExportDataModel();
        edm2.setProductId("产品002号");
        edm2.setPrice(99);
        edm2.setAmount(55);
        //把数据组装起来
        col.add(edm1);
        col.add(edm2);
        mapData.put("销售记录表", col);

        ExportFooterModel efm = new ExportFooterModel();
        efm.setExportUser("张三");

        //测试输出到文本文件
        TxtBuilder txtBuilder = new TxtBuilder();
        //创建指导者对象
        Director director = new Director(txtBuilder);
        director.construct(ehm, mapData, efm);
        //把要输出的内容输出到控制台看看
        System.out.println("输出到文本文件的内容：\n" + txtBuilder.getResult());

        //测试输出到xml文件
        XmlBuilder xmlBuilder = new XmlBuilder();
        //创建指导者对象
        Director director2 = new Director(xmlBuilder);
        director2.construct(ehm, mapData, efm);
        //把要输出的内容输出到控制台看看
        System.out.println("输出到XML文件的内容：\n" + xmlBuilder.getResult());
    }

    /**
     * 使用生成器模式构造复杂对象
     */
    @Test
    public void complexObject() {
        //构建构建器
        ConcreteBuilder builder = new ConcreteBuilder("001", 12345L, 67890L);
        //设置需要的数据，然后构建保险合同的对象
        InsuranceContract contract = builder.setPersonName("张三").setOtherData("test").build();
        //操作保险合同对象的方法
        contract.someOperation();

    }

    /**
     * 使用Builder模式来构建复杂对象，考虑带约束规则
     */
    @Test
    public void complexObject1() {
        //构建构建器
        ConcreteBuilder1 builder = new ConcreteBuilder1("001", 12345L, 67890L);
        //设置需要的数据，然后构建保险合同的对象
        InsuranceContract1 contract = builder.setPersonName("张三").setCompanyName("ABC").build();
        //操作保险合同对象的方法
        contract.someOperation();
    }

    /** 进一步：把构建器对象和被构建对象合并
    * 重构手法：将类内联化 (Inline Class)*/
    @Test
    public void complexObject2() {
        //构建构建器
        InsuranceContract2.ConcreteBuilder2 builder =
                new InsuranceContract2.ConcreteBuilder2("001", 12345L, 67890L);

        //设置需要的数据，然后构建保险合同的对象
        InsuranceContract2 contract = builder.setCompanyName("李四").setOtherData("test2").build();

        //操作保险合同对象的方法
        contract.someOperation();
    }
}
