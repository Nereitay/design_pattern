package es.kiwi.behavioral.iterator.solution.sample;

/**
 * 具体的聚合对象，实现创建相应迭代器对象的功能
 */
public class ConcreteAggregate extends Aggregate{
    /**
     * 示意，表示聚合对象具体的内容
     */
    private String[] ss;

    /**
     * 构造方法，传入聚合对象具体的内容
     * @param ss 聚合对象具体内容
     */
    public ConcreteAggregate(String[] ss) {
        this.ss = ss;
    }

    @Override
    public Iterator createIterator() {
        //实现创建Iterator的工厂方法
        return new ConcreteIterator(this);
    }

    public Object get(int index) {
        Object retObj = null;
        if (index < ss.length) {
            retObj = ss[index];
        }

        return retObj;
    }

    public int size() {

        return this.ss.length;
    }
}
