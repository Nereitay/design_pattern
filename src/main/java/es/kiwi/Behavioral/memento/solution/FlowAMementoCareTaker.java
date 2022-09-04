package es.kiwi.Behavioral.memento.solution;

/**
 * 负责保存模拟运行流程A的对象的备忘录对象
 */
public class FlowAMementoCareTaker {
    /**
     * 记录被保存的备忘录对象
     */
    private FlowAMockMemento memento;

    /**
     * 保存备忘录对象
     * @param memento 被保存的备忘录对象
     */
    public void saveMemento(FlowAMockMemento memento) {
        this.memento = memento;
    }

    /**
     * 获取被保存的备忘录对象
     * @return 被保存的备忘录对象
     */
    public FlowAMockMemento retrieveMemento() {
        return this.memento;
    }
}
