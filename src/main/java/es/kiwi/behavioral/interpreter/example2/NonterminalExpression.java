package es.kiwi.behavioral.interpreter.example2;

import java.util.ArrayList;
import java.util.List;

/**
 * 非终结符表达式===相当于组合对象
 */
public class NonterminalExpression extends AbstractExpression {

    private List<AbstractExpression> list = new ArrayList<>();

    public void addAbstractExpression(AbstractExpression ae) {
        list.add(ae);
    }

    /**
     * 解释的操作
     *
     * @param ctx 上下文对象
     */
    @Override
    public void interpret(Context ctx) {
        //实现与语法规则中的非终结符相关联的解释操作
    }
}
