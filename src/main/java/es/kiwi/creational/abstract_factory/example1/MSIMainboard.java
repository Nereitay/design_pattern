package es.kiwi.creational.abstract_factory.example1;

/**
 * 微星的主板
 */
public class MSIMainboard implements MainboardApi {
    /**
     * CPU插槽的孔数
     */
    private int cpuHoles = 0;

    /**
     * 构造方法，传入CPU插槽的孔数
     *
     * @param cpuHoles CPU插槽的孔数
     */
    public MSIMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    /**
     * 示意方法，主板都具有安装CPU的功能
     */
    @Override
    public void installCPU() {
        System.out.println("now in MSI Main-board,cpuHoles=" + cpuHoles);
    }
}