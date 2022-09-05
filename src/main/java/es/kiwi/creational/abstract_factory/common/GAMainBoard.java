package es.kiwi.creational.abstract_factory.common;

/**
 * 技嘉的主板
 */
public class GAMainBoard implements MainBoardApi{
    /**
     * CPU插槽的孔数
     */
    private int cpuHoles = 0;

    /**
     * 构造方法，传入CPU的插槽的孔数
     * @param cpuHoles CPU插槽的孔数
     */
    public GAMainBoard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("now in GAMainBoard, cpu holes = " + cpuHoles);
    }
}
