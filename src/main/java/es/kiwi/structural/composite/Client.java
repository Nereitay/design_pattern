package es.kiwi.structural.composite;

import es.kiwi.structural.composite.scenario.Composite;
import es.kiwi.structural.composite.scenario.Leaf;
import es.kiwi.structural.composite.solution.sample.Component;

public class Client {
    public static void main(String[] args) {

        /*不用模式的解决方案*/
//        scenario();

        /*组合模式示例代码*/
//        sample();

        /*使用组合模式重写示例*/
//        composite();

        /*安全性的实现方式
         *
         * 对于组合模式而言，在安全性和透明性上，会更看重透明性，
         * 毕竟组合模式的功能就是要让用户对叶子对象和组合对象的使用具有一致性
         *
         * */
//        security();

        /*父组件引用*/
//        parentReference();

        /*环状引用， 要检测并避免出现环状引用，否则容易引起死循环，或是同一个功能被操作多次*/
//        circularReference();
    }

    private static void circularReference() {
        //定义所有的组合对象
        es.kiwi.structural.composite.extension.circular_reference.Component root =
                new es.kiwi.structural.composite.extension.circular_reference.Composite("Ropa");
        es.kiwi.structural.composite.extension.circular_reference.Component c1 =
                new es.kiwi.structural.composite.extension.circular_reference.Composite("Hombre");
        es.kiwi.structural.composite.extension.circular_reference.Component c2 =
                new es.kiwi.structural.composite.extension.circular_reference.Composite("Camisa");
        es.kiwi.structural.composite.extension.circular_reference.Component c3 =
                new es.kiwi.structural.composite.extension.circular_reference.Composite("Hombre");
        //设置一个环状引用
        root.addChild(c1);
        c1.addChild(c2);
        c2.addChild(c3);
        //调用根对象的输出功能来输出整棵树
        root.printStruct("");
    }

    private static void parentReference() {
        //定义所有的组合对象
        es.kiwi.structural.composite.extension.parent_reference.Component root =
                new es.kiwi.structural.composite.extension.parent_reference.Composite("Ropa");
        es.kiwi.structural.composite.extension.parent_reference.Component c1 =
                new es.kiwi.structural.composite.extension.parent_reference.Composite("Hombre");
        es.kiwi.structural.composite.extension.parent_reference.Component c2 =
                new es.kiwi.structural.composite.extension.parent_reference.Composite("Mujer");
        //定义所有的叶子对象
        es.kiwi.structural.composite.extension.parent_reference.Component leaf1 =
                new es.kiwi.structural.composite.extension.parent_reference.Leaf("Camisa");
        es.kiwi.structural.composite.extension.parent_reference.Component leaf2 =
                new es.kiwi.structural.composite.extension.parent_reference.Leaf("Chaqueta");
        es.kiwi.structural.composite.extension.parent_reference.Component leaf3 =
                new es.kiwi.structural.composite.extension.parent_reference.Leaf("Falda");
        es.kiwi.structural.composite.extension.parent_reference.Component leaf4 =
                new es.kiwi.structural.composite.extension.parent_reference.Leaf("Traje");
        //按照树的结构来组合组合对象和叶子对象
        root.addChild(c1);
        root.addChild(c2);
        c1.addChild(leaf1);
        c1.addChild(leaf2);
        c2.addChild(leaf3);
        c2.addChild(leaf4);
        //调用根对象的输出功能来输出整棵树
        root.printStruct("");
        //然后删除一个节点
        root.removeChild(c1);
        System.out.println("---------------------------------------->");
        //重新输出整棵树
        root.printStruct("");
    }

    private static void security() {
        //定义所有的组合对象
        es.kiwi.structural.composite.extension.security.Composite root =
                new es.kiwi.structural.composite.extension.security.Composite("Ropa");
        es.kiwi.structural.composite.extension.security.Composite c1 =
                new es.kiwi.structural.composite.extension.security.Composite("Hombre");
        es.kiwi.structural.composite.extension.security.Composite c2 =
                new es.kiwi.structural.composite.extension.security.Composite("Mujer");
        //定义所有的叶子对象
        es.kiwi.structural.composite.extension.security.Leaf leaf1 =
                new es.kiwi.structural.composite.extension.security.Leaf("Camisa");
        es.kiwi.structural.composite.extension.security.Leaf leaf2 =
                new es.kiwi.structural.composite.extension.security.Leaf("Chaqueta");
        es.kiwi.structural.composite.extension.security.Leaf leaf3 =
                new es.kiwi.structural.composite.extension.security.Leaf("Falda");
        es.kiwi.structural.composite.extension.security.Leaf leaf4 =
                new es.kiwi.structural.composite.extension.security.Leaf("Traje");
        //按照树的结构来组合组合对象和叶子对象
        root.addChild(c1);
        root.addChild(c2);
        c1.addChild(leaf1);
        c1.addChild(leaf2);
        c2.addChild(leaf3);
        c2.addChild(leaf4);
        //调用根对象的输出功能来输出整棵树
        root.printStruct("");
    }

    private static void composite() {
        //定义所有的组合对象
        es.kiwi.structural.composite.solution.Component root = new es.kiwi.structural.composite.solution.Composite(
                "Ropa");
        es.kiwi.structural.composite.solution.Component c1 = new es.kiwi.structural.composite.solution.Composite(
                "Hombre");
        es.kiwi.structural.composite.solution.Component c2 = new es.kiwi.structural.composite.solution.Composite(
                "Mujer");

        //定义所有的叶子对象
        es.kiwi.structural.composite.solution.Component leaf1 = new es.kiwi.structural.composite.solution.Leaf(
                "Camisa");
        es.kiwi.structural.composite.solution.Component leaf2 = new es.kiwi.structural.composite.solution.Leaf(
                "Chaqueta");
        es.kiwi.structural.composite.solution.Component leaf3 = new es.kiwi.structural.composite.solution.Leaf(
                "Falda");
        es.kiwi.structural.composite.solution.Component leaf4 = new es.kiwi.structural.composite.solution.Leaf(
                "Traje");

        //按照树的结构来组合组合对象和叶子对象
        root.addChild(c1);
        root.addChild(c2);
        c1.addChild(leaf1);
        c1.addChild(leaf2);
        c2.addChild(leaf3);
        c2.addChild(leaf4);

        //调用根对象的输出功能来输出整棵树
        root.printStruct("");
    }

    private static void sample() {
        //定义多个Composite对象，全部都是Component类型
        Component root = new es.kiwi.structural.composite.solution.sample.Composite();
        Component c1 = new es.kiwi.structural.composite.solution.sample.Composite();
        Component c2 = new es.kiwi.structural.composite.solution.sample.Composite();
        //定义多个叶子对象
        Component leaf1 = new es.kiwi.structural.composite.solution.sample.Leaf();
        Component leaf2 = new es.kiwi.structural.composite.solution.sample.Leaf();
        Component leaf3 = new es.kiwi.structural.composite.solution.sample.Leaf();

        /*组合成为树形的对象结构，并不是每次操作组件对象都需要组装树形的对象结构，如果对象结构已经存在，直接操作就可以了*/
        root.addChild(c1);
        root.addChild(c2);
        root.addChild(leaf1);
        c1.addChild(leaf2);
        c2.addChild(leaf3);

        //操作Component对象
        Component o = root.getChildren(1);
        System.out.println(o);
    }

    private static void scenario() {
        //定义所有的组合对象
        Composite root = new Composite("Ropa");
        Composite c1 = new Composite("Hombre");
        Composite c2 = new Composite("Mujer");

        //定义所有的叶子对象
        Leaf leaf1 = new Leaf("Camisa");
        Leaf leaf2 = new Leaf("Chaqueta");
        Leaf leaf3 = new Leaf("Falda");
        Leaf leaf4 = new Leaf("Traje");

        //按照树的结构来组合组合对象和叶子对象
        root.addComposite(c1);
        root.addComposite(c2);
        c1.addLeaf(leaf1);
        c1.addLeaf(leaf2);
        c2.addLeaf(leaf3);
        c2.addLeaf(leaf4);

        //调用根对象的输出功能来输出整棵树
        root.printStruct("");
    }
}
