package es.kiwi.creational.abstract_factory.scenario;

/**
 * 微星的主板
 */
public class MSIMainBoard implements MainBoardApi{
    /**
     * CPU插槽的孔数
     */
    private int cpuHoles = 0;

    /**
     * 构造方法，传入CPU的插槽的孔数
     * @param cpuHoles CPU插槽的孔数
     */
    public MSIMainBoard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("now in MSIMainBoard, cpu holes = " + cpuHoles);
    }
}
