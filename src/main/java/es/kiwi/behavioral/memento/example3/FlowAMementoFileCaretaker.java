package es.kiwi.behavioral.memento.example3;

import java.io.*;

/**
 * <p>离线存储</p>
 * <p>
 * 负责在文件中保存模拟运行流程A的对象的备忘录对象
 */
public class FlowAMementoFileCaretaker {
    /**
     * 保存备忘录对象
     *
     * @param memento 被保存的备忘录对象
     */
    public void saveMemento(FlowAMockMemento memento) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("FlowAMemento")))) {
            out.writeObject(memento);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public FlowAMockMemento retrieveMemento() {
        FlowAMockMemento memento = null;
        try(ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("FlowAMemento")))) {
            memento = (FlowAMockMemento) in.readObject();
        }catch (Exception err) {
            err.printStackTrace();
        }

        return memento;
    }


}
