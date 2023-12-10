package es.kiwi.behavioral.memento.example3;

/**
 * <p>结合原型模式</p>
 */
public class FlowAMockPrototype implements Cloneable {
    private String flowName;
    private int tempResult;
    private String tempState;

    public FlowAMockPrototype(String flowName) {
        this.flowName = flowName;
    }

    public void runPhaseOne() {
        //在这个阶段，可能产生了中间结果，示意一下
        tempResult = 3;
        tempState = "PhaseOne";
    }

    /**
     * 示意，按照方案一来运行流程后半部分
     */
    public void schema1() {
        //示意，需要使用第一个阶段产生的数据
        this.tempState += ",Schema1";
        System.out.println(this.tempState + " : now run " + tempResult);
        this.tempResult += 11;
    }

    /**
     * 示意，按照方案二来运行流程后半部分
     */
    public void schema2() {
        //示意，需要使用第一个阶段产生的数据
        this.tempState += ",Schema2";
        System.out.println(this.tempState + " : now run " + tempResult);
        this.tempResult += 22;
    }

    /*以上都没有改变*/

    /**
     * 创建保存原发器对象的状态的备忘录对象
     *
     * @return 创建好的备忘录对象
     */
    public FlowAMockMemento createMemento() {
        /*
        * 不过要注意一点，就是如果克隆对象非常复杂，或者需要很多层次的深度克隆，
        * 实现克隆的时候会比较麻烦。
        * */
        try {
            return new MementoImplPrototype((FlowAMockPrototype) this.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 重新设置原发器对象的状态，让其回到备忘录对象记录的状态
     *
     * @param memento 记录有原发器状态的备忘录对象
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
        private FlowAMockPrototype flowAMock;

        public MementoImplPrototype(FlowAMockPrototype f) {
            this.flowAMock = f;
        }

        public FlowAMockPrototype getFlowAMock() {
            return flowAMock;
        }
    }
}
