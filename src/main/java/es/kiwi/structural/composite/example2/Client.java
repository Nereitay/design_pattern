package es.kiwi.structural.composite.example2;

public class Client {
    public static void main(String[] args) {
        /*全部都是Component类型*/
        //定义多个Composite对象
        Component root = new Composite();
        Component c1 = new Composite();
        Component c2 = new Composite();
        //定义多个叶子对象
        Component leaf1 = new Leaf();
        Component leaf2 = new Leaf();
        Component leaf3 = new Leaf();

        /*
         * 并不是每次操作组件对象都需要组装成树形的对象结构，
         * 如果对象结构已经存在，直接操作就可以了
         * */
        //组合成为树形的对象结构
        root.addChild(c1);
        root.addChild(c2);
        root.addChild(leaf1);

        c1.addChild(leaf2);
        c2.addChild(leaf3);

        //操作Component对象
        Component o = root.getChildren(1);
        System.out.println(o);
    }
}