package es.kiwi.creational.prototype.example8;

/**
 * <p>原型管理器</p>
 */
public interface Prototype {
    Prototype clone();

    String getName();

    void setName(String name);
}
