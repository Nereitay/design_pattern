package es.kiwi.behavioral.memento.extension.offline;

import java.io.*;

/**
 * 负责保存模拟运行流程A的对象的备忘录对象
 */
public class FlowAMementoFileCareTaker {

    /**
     * 保存备忘录对象
     *
     * @param memento 被保存的备忘录对象
     */
    public void saveMemento(FlowAMockMemento memento) {
        //写到文件中

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream("FlowAMemento")))) {

            out.writeObject(memento);

        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    /**
     * 获取被保存的备忘录对象
     *
     * @return 被保存的备忘录对象
     */
    public FlowAMockMemento retrieveMemento() {
        FlowAMockMemento memento = null;

        try(ObjectInputStream in =
                    new ObjectInputStream(
                            new BufferedInputStream(
                                    new FileInputStream("FlowAMemento")))) {
            memento = (FlowAMockMemento) in.readObject();
        } catch (Exception err) {
            err.printStackTrace();
        }

        return memento;

    }
}
