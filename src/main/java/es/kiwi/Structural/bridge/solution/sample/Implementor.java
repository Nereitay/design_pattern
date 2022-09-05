package es.kiwi.Structural.bridge.solution.sample;

/**
 * 定义实现部分的接口，可以与抽象部分接口的方法不一样
 */
public interface Implementor {

    /**
     * 示例方法，实现抽象部分需要的默写具体功能
     */
    void operationImpl();
}
