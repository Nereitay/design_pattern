package es.kiwi.creational.prototype.pattern.prototype_manager;

public interface Prototype {
    Prototype clone();

    String getName();

    void setName(String name);
}
