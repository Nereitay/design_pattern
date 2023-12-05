package es.kiwi.structural.composite.example7;

/**
 * 叶子对象
 */
public class Leaf extends Component {// 需要继承组件对象

    /**
     * 获取组件的名称
     *
     * @return 组件的名称
     */
    @Override
    public String getName() {
        return this.name;
    }

    /*------------------以下是原有的实现，没有变化-----------------*/
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
