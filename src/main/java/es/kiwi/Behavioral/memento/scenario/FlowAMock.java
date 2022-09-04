package es.kiwi.Behavioral.memento.scenario;

/**
 * 模拟运行流程A，只是一个示意，代指某个具体流程
 *
 * 问题：
 * 1. 数据零散存放在外部  -> 定义一个数据对象来封装
 * 2. 为了把运行期间的数据放到外部存储起来，模拟流程的对象被迫把内部数据结构开放出来，暴露了对象实现细节，破坏对象的封装性
 *    本来这些数据只是模拟流程的对象内部数据，应该是不对外的
 */
public class FlowAMock {
    /**
     * 流程名称，不需要外部存储的状态数据
     */
    private final String flowName;
    /**
     * 示意，指代某个中间结果，需要外部存储的状态数据
     */
    private int tempResult;
    /**
     * 示意，指代某个中间结果，需要外部存储的状态数据
     */
    private String tempState;

    /**
     * 构造方法
     * @param flowName 流程名称
     */
    public FlowAMock(String flowName) {
        this.flowName = flowName;
    }

    /**
     * 示意，运行流程的第一个阶段
     */
    public void runPhraseOne() {
        // 在这个阶段，可能产生了中间结果，示意一下
        tempResult = 3;
        tempState = "PhaseOne";
    }

    /**
     * 示意按照方案一来运行流程后半部分
     */
    public void schema1() {
        //示意，需要使用第一个阶段产生的数据
        this.tempState += ", Schema1";
        System.out.println(this.tempState + " : now run " + tempResult);
        this.tempResult += 11;
    }

    /**
     * 示意按照方案二来运行流程后半部分
     */
    public void schema2() {
        //示意，需要使用第一个阶段产生的数据
        this.tempState += ", Schema2";
        System.out.println(this.tempState + " : now run " + tempResult);
        this.tempResult += 22;
    }

    public int getTempResult() {
        return tempResult;
    }

    public void setTempResult(int tempResult) {
        this.tempResult = tempResult;
    }

    public String getTempState() {
        return tempState;
    }

    public void setTempState(String tempState) {
        this.tempState = tempState;
    }
}
