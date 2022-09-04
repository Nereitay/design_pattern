package es.kiwi.Creational.prototype.pattern.example;

/**
 * 克隆的具体实现对象
 */
public class ConcretePrototype2 implements Prototype{
    @Override
    public Prototype clone() {
        //最简单的克隆，新建一个自身的对象，由于没有属性，就不再复制值了
        Prototype prototype = new ConcretePrototype2();
        return prototype;
    }
}
