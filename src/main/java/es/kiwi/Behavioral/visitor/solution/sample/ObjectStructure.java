package es.kiwi.Behavioral.visitor.solution.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象结构，通常在这里对元素进行遍历，让访问者能访问到所有的元素
 */
public class ObjectStructure {
    /**
     * 示意，表示对象结构，可以是一个组合结构或是集合
     */
    private List<Element> list = new ArrayList<>();

    /**
     * 示意方法，提供给客户端操作的高层接口
     * @param visitor 客户端需要使用的访问者
     */
    public void handleRequest(Visitor visitor) {
        //循环对象结构中的元素，接受访问
        for (Element ele : list) {
            ele.accept(visitor);
        }
    }

    /**
     * 示意方法，组件对象结构，向对象结构中添加元素
     * 不同的对象结构有不同的构建方式
     * @param ele 加入到对象结构的元素
     */
    public void addElement(Element ele) {
        this.list.add(ele);
    }
}
