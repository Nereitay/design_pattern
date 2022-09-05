package es.kiwi.behavioral.iterator.solution;

/**
 * 用来实现访问数组的迭代接口
 */
public class ArrayIteratorImpl implements Iterator{
    private SalaryManager aggregate;

    private int index = -1;

    public ArrayIteratorImpl(SalaryManager aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void next() {
        if (index < this.aggregate.size())
            index ++;
    }

    @Override
    public boolean isDone() {

        return (index == this.aggregate.size());
    }

    @Override
    public Object currentItem() {
        return this.aggregate.get(index);
    }
}
