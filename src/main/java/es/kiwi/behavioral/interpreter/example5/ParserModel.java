package es.kiwi.behavioral.interpreter.example5;

import lombok.Getter;
import lombok.Setter;

/**
 * 用来封装每一个解析出来的元素对应的属性
 */
@Getter
@Setter
public class ParserModel {
    /**
     * 是否单个值
     */
    private boolean singleValue;
    /**
     * 是否属性，不是属性就是元素
     */
    private boolean propertyValue;
    /**
     * 是否终结符
     */
    private boolean end;

}
