package es.kiwi.Behavioral.iterator.solution;

public interface Iterator {
    void first();
    void next();
    boolean isDone();
    Object currentItem();
}
