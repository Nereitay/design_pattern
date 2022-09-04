package es.kiwi.Behavioral.visitor.solution;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {
    /**
     * 要操作的客户集合
     */
    private List<Customer> list = new ArrayList<>();

    /**
     * 提供给客户端操作的高层接口，具体的功能有客户端传入的访问者决定
     * @param visitor 客户端需要使用的访问者
     */
    public void handleRequest(Visitor visitor) {
        //循环啊对象结构中的元素，接受访问
        list.forEach(cm -> cm.accept(visitor));
    }

    /**
     * 组建对象结构，向对象结构中添加元素
     * 不同的对象结构有不同的构建方式
     * @param ele 加入到对象结构的元素
     */
    public void addElement(Customer ele) {
        this.list.add(ele);
    }
}
