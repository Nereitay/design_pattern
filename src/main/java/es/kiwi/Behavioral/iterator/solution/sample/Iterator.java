package es.kiwi.Behavioral.iterator.solution.sample;

/**
 * 迭代器接口，定义访问和遍历元素的操作
 */
public interface Iterator {

    void first();

    void next();

    boolean isDone();

    Object currentItem();

}
