package es.kiwi.structural.composite.example5;

/**
 * 叶子对象
 */
public class Leaf extends Component {// 需要继承组件对象
    private String name = "";

    public Leaf(String name) {
        this.name = name;
    }

    /**
     * 输出叶子对象的结构，叶子对象没有子对象，也就是输出叶子对象的名字
     *
     * @param preStr 前缀，主要是按照层级拼接的空格，实现向后缩进
     */
    @Override
    public void printStruct(String preStr) {
        System.out.println(preStr + "-" + name);
    }
}
