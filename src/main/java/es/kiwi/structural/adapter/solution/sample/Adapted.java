package es.kiwi.structural.adapter.solution.sample;

/**
 * 已经存在的接口，这个接口需要被适配
 */
public class Adapted {
    /**
     * 示意方法，原本已经存在，已经实现的方法
     */
    public void specificRequest() {
        //具体功能实现
        System.out.println("Adapted method: specificRequest()");
    }

    public void method() {
        System.out.println("Adapted method: method()");
    }
}
