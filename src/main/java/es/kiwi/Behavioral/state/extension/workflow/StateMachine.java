package es.kiwi.Behavioral.state.extension.workflow;

/**
 * 公共状态处理机。相当于状态模式的Context,在其中提供基本的、公共的功能
 * 包含所有流程使用状态模式时的公共功能
 */
public class StateMachine {
    /**
     * 持有一个状态对象
     */
    private State state = null;
    /**
     * 包含流程处理需要的业务数据对象没不知道具体类型，为了简单，不使用泛型用Object。反正只是传递到具体的状态对象中
     */
    private Object busisnessVO = null;

    public State getState() {
        return state;

    }

    public void setState(State state) {
        this.state = state;
    }

    public Object getBusisnessVO() {
        return busisnessVO;
    }

    public void setBusisnessVO(Object busisnessVO) {
        this.busisnessVO = busisnessVO;
    }

    /**
     * 执行工作，客户端处理流程的接口方法
     * 在客户完成自己的工作后调用
     */
    public void doWork() {
        //转调相应的状态对象真正完成功能处理
        this.state.doWork(this);
    }
}
