package es.kiwi.Behavioral.memento.extension.prototype;

import es.kiwi.Behavioral.memento.solution.FlowAMock;
import es.kiwi.Behavioral.memento.solution.FlowAMockMemento;

public class FlowAMockPrototype implements Cloneable{

    private final String flowName;

    private int tempResult;

    private String tempState;

    public FlowAMockPrototype(String flowName) {
        this.flowName = flowName;
    }

    public void runPhraseOne() {
        // 在这个阶段，可能产生了中间结果，示意一下
        tempResult = 3;
        tempState = "PhaseOne";
    }

    public void schema1() {
        //示意，需要使用第一个阶段产生的数据
        this.tempState += ", Schema1";
        System.out.println(this.tempState + " : now run " + tempResult);
        this.tempResult += 11;
    }

    public void schema2() {
        //示意，需要使用第一个阶段产生的数据
        this.tempState += ", Schema2";
        System.out.println(this.tempState + " : now run " + tempResult);
        this.tempResult += 22;
    }

    /**
     * 创建保存原发器对象状态的备忘录对象
     * @return 创建好的备忘录对象
     */
    public FlowAMockMemento createMemento() {
        try {
            return new MementoImplPrototype((FlowAMockPrototype)this.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 重新设置原发器对象的状态,让其回到备忘录对象记录的状态
     * @param memento 记录原有原发器状态的备忘录的对象
     */
    public void setMemento(FlowAMockMemento memento) {
        MementoImplPrototype mementoImpl = (MementoImplPrototype) memento;
        this.tempResult = mementoImpl.getFlowAMock().tempResult;
        this.tempState = mementoImpl.getFlowAMock().tempState;
    }


    /**
     * 真正的备忘录对象，实现备忘录窄接口
     * 实现成私有的内部类，不让外部访问
     */
    private static class MementoImplPrototype implements FlowAMockMemento {

        private final FlowAMockPrototype flowAMock;

        public MementoImplPrototype(FlowAMockPrototype flowAMock) {
            this.flowAMock = flowAMock;
        }

        public FlowAMockPrototype getFlowAMock() {
            return flowAMock;
        }
    }
}
