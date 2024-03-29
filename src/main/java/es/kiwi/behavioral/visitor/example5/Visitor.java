package es.kiwi.behavioral.visitor.example5;

/**
 * <p>常见应用：结合组合模式</p>
 * 访问组合对象结构的访问者接口
 */
public interface Visitor {
    /**
     * 访问组合对象，相当于给组合对象添加访问者的功能
     *
     * @param composite 组合对象
     */
    void visitComposite(Composite composite);

    /**
     * 访问叶子对象，相当于给叶子对象添加访问者的功能
     *
     * @param leaf 叶子对象
     */
    void visitLeaf(Leaf leaf);
}
