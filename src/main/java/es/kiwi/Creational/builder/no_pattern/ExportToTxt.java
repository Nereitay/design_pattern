package es.kiwi.Creational.builder.no_pattern;


import es.kiwi.Creational.builder.common.ExportDataModel;
import es.kiwi.Creational.builder.common.ExportFooterModel;
import es.kiwi.Creational.builder.common.ExportHeaderModel;

import java.util.Collection;
import java.util.Map;

/**
 * 导出数据到文本文件的对象
 */
public class ExportToTxt {

    private static final String SEPARATOR = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    /**
     * 导出数据到文本文件
     *
     * @param ehm     文件头的内容
     * @param mapData 数据的内容
     * @param efm     文件尾的内容
     */
    public void export(ExportHeaderModel ehm,
                       Map<String, Collection<ExportDataModel>> mapData,
                       ExportFooterModel efm) {
        //用来记录最终输出的文件内容
        StringBuffer sb = new StringBuffer();
        //1. 先来拼接文件头内容
        sb.append(ehm.getDepId()).append(SEPARATOR).append(ehm.getExportDate()).append(LINE_SEPARATOR);
        //2. 接着来拼接文件体的内容
        for (String tb1Name : mapData.keySet()) {
            //先拼接表名称
            sb.append(tb1Name).append("\n");
            //然后循环拼接具体数据
            for (ExportDataModel edm : mapData.get(tb1Name)) {
                sb.append(edm.getProductId()).append(SEPARATOR)
                        .append(edm.getPrice()).append(SEPARATOR)
                        .append(edm.getAmount()).append(LINE_SEPARATOR);
            }
        }
        //3. 接着来拼接文件尾的内容
        sb.append(efm.getExportUser());

        //为了演示的简洁性，这里就不再写输出文件的代码了
        //把要输出的内容输出到控制台看看
        System.out.println("输出到文本文件的内容：\n" + sb);

    }
}
