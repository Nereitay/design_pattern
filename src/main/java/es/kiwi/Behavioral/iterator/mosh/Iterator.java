package es.kiwi.Behavioral.iterator.mosh;

public interface Iterator<T> {

    boolean hasNext();

    T current();

    void next();
}

//implements Iterator<String>
