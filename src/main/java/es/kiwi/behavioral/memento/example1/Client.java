package es.kiwi.behavioral.memento.example1;

public class Client {
    public static void main(String[] args) {
        // 创建模拟运行流程的对象
        FlowAMock mock = new FlowAMock("TestFlow");
        //运行流程的第一个阶段
        mock.runPhaseOne();
        //得到第一个阶段运行所产生的数据，后面要用
        int tempResult = mock.getTempResult();
        String tempState = mock.getTempState();

        //按照方案一来运行流程后半部分
        mock.schema1();

        //把第一个阶段运行所产生的数据重新设置回去
        mock.setTempResult(tempResult);
        mock.setTempState(tempState);

        //按照方案二来运行流程后半部分
        mock.schema2();
    }

    /*问题：
    * 为了把运行期间的数据放到外部存储起来，模拟流程的对象被迫把内部的数据结构开放出来，
    * 这暴露了对象的实现细节，而且也破坏了对象的封装性。
    * */
}
