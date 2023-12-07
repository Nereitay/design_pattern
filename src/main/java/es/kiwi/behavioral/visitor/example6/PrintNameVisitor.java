package es.kiwi.behavioral.visitor.example6;

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

        System.out.println("节点："+composite.getName());

        //如果还包含有子组件，那么就输出这些子组件对象
        if (composite.getChildComponents() != null) {
            //输出当前对象的子对象了
            for (Component c : composite.getChildComponents()) {
                //递归输出每个子对象
                c.accept(this);
            }
        }
    }

    /**
     * 访问叶子对象，相当于给叶子对象添加访问者的功能
     *
     * @param leaf 叶子对象
     */
    @Override
    public void visitLeaf(Leaf leaf) {
        //访问到叶子对象的数据
        System.out.println("叶子：" + leaf.getName());
    }
}
