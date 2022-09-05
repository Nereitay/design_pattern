package es.kiwi.creational.prototype.extension.prototype_manager;

public interface Prototype {
    Prototype clone();

    String getName();

    void setName(String name);
}
