package es.kiwi.creational.prototype.example2;
/**
 * 克隆的具体实现对象
 */
public class ConcretePrototype2 implements Prototype{
    /**
     * 克隆自身的方法
     *
     * @return 一个从自身克隆出来的对象
     */
    @Override
    public Prototype clone() {
        //最简单的克隆，新建一个自身对象，由于没有属性，就不去复制值了
        return new ConcretePrototype2();
    }
}
