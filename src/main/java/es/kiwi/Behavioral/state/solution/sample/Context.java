package es.kiwi.Behavioral.state.solution.sample;

/**
 * 定义客户感兴趣的接口，通常会维护一个State类型的对象实例
 */
public class Context {
    /**
     * 持有一个State类型的对象实例
     */
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void request (String sampleParameter) {
        //处理中，会转调state来处理
        state.handle(sampleParameter);
    }
}
