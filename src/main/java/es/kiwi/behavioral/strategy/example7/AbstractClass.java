package es.kiwi.behavioral.strategy.example7;

/**
 * 策略模式结合模板方法模式
 */
public abstract class AbstractClass implements Strategy {

    /**
     * 某个算法的接口，可以有传入参数，也可以有返回值
     */
    @Override
    public final void algorithmInterface() {
        stepOneOpe();
        stepTwoOpe();
        stepThreeOpe();
    }

    private void stepThreeOpe() {}
    protected abstract void stepOneOpe();
    protected abstract void stepTwoOpe();
}
