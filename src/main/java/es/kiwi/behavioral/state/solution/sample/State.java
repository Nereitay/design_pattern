package es.kiwi.behavioral.state.solution.sample;

/**
 * 封装一个与Context的一个特定状态相关的行为
 */
public interface State {
    /**
     * 状态对应的处理
     * @param sampleParameter 示例参数，说明可以传入参数， 具体传入什么样的参数，传入几个参数，由具体应用来具体分析
     */
   void handle (String sampleParameter);
}
