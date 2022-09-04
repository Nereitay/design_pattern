package es.kiwi.Behavioral.memento.solution.sample;

/**
 * 负责保存备忘录的对象
 */
public class CareTaker {
    /**
     * 记录被保存的备忘录对象
     */
    private Memento memento = null;

    /**
     * 保存备忘录对象
     * @param memento 被保存的备忘录对象
     */
    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    /**
     * 获取被保存的备忘录对象
     * @return 被保存的备忘录对象
     */
    public Memento retrieveMemento() {
        return this.memento;
    }
}
