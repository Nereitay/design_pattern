package es.kiwi.behavioral.memento.example2;

/**
 * 负责保存备忘录的对象
 */
public class Caretaker {
    /**
     * 记录被保存的备忘录对象
     */
    private Memento memento;

    /**
     * 保存备忘录对象
     *
     * @param memento 被保存的备忘录对象
     */
    public void saveMemento(Memento memento) {
        this.memento = memento;
    }

    /**
     * 获取被保存的备忘录对象
     *
     * @return 被保存的备忘录对象
     */
    public Memento retrieveMemento() {
        return this.memento;
    }

}
