package es.kiwi.creational.abstract_factory.example1;

/**
 * Intel的CPU实现
 */
public class IntelCPU implements CPUApi {
    /**
     * CPU的针脚数目
     */
    private int pins = 0;

    /**
     * 构造方法，传入CPU的针脚数目
     *
     * @param pins CPU的针脚数目
     */
    public IntelCPU(int pins) {
        this.pins = pins;
    }

    /**
     * 示意方法，CPU具有运算的功能
     */
    @Override
    public void calculate() {
        System.out.println("now in Intel CPU,pins=" + pins);
    }
}
