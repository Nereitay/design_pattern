package es.kiwi.Creational.builder.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 描述输出到文件头的内容对象
 */
@Getter
@Setter
public class ExportHeaderModel {
    /**
     * 分公司或门市点编号
     */
    private String depId;
    /**
     * 导出数据的日期
     */
    private String exportDate;


}
