package es.kiwi.behavioral.visitor.example5;

/**
 * 具体的访问者，实现：输出对象的名称，在组合对象的名称前面添加"节点："，
 * 在叶子对象的名称前面添加"叶子："
 */
public class PrintNameVisitor implements Visitor {
    /**
     * 访问组合对象，相当于给组合对象添加访问者的功能
     *
     * @param composite 组合对象
     */
    @Override
    public void visitComposite(Composite composite) {
        //访问到组合对象的数据
        System.out.println("节点1：" + composite.getName());
    }

    /**
     * 访问叶子对象，相当于给叶子对象添加访问者的功能
     *
     * @param leaf 叶子对象
     */
    @Override
    public void visitLeaf(Leaf leaf) {
        //访问到叶子对象的数据
        System.out.println("叶子2：" + leaf.getName());
    }
}
