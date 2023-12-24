package es.kiwi.behavioral.interpreter.example3;

/**
 * 属性作为终结符对应的解释器
 */
public class PropertyTerminalExpression extends ReadXmlExpression {
    /**
     * 属性的名字
     */
    private String propName;

    public PropertyTerminalExpression(String propName) {
        this.propName = propName;
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
        //直接获取最后的元素的属性的值
        String[] ss = new String[1];
        ss[0] = c.getPreEle().getAttribute(this.propName);
        return ss;
    }
}
