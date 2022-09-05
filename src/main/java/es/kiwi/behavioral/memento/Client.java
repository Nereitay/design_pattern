package es.kiwi.behavioral.memento;


import es.kiwi.behavioral.memento.extension.prototype.FlowAMockPrototype;
import es.kiwi.behavioral.memento.scenario.FlowAMock;
import es.kiwi.behavioral.memento.solution.FlowAMementoCareTaker;
import es.kiwi.behavioral.memento.solution.FlowAMockMemento;

public class Client {

    public static void main(String[] args) {
//        before();

        //使用备忘录模式改造后
//        after();

        //结合原型模式
        prototype();

    }

    private static void prototype() {
        FlowAMockPrototype mock = new FlowAMockPrototype("TestFlow");
        mock.runPhraseOne();

        FlowAMementoCareTaker careTaker = new FlowAMementoCareTaker();
        FlowAMockMemento memento = mock.createMemento();
        careTaker.saveMemento(memento);

        mock.schema1();

        mock.setMemento(careTaker.retrieveMemento());

        mock.schema2();
    }

    private static void after() {
        // 创建模拟运行流程对象
        es.kiwi.behavioral.memento.solution.FlowAMock mock =
                new es.kiwi.behavioral.memento.solution.FlowAMock("TestFlow");
        //运行流程第一阶段
        mock.runPhraseOne();

        //创建一个管理者
        FlowAMementoCareTaker careTaker = new FlowAMementoCareTaker();
        //创建此时对象的备忘录对象，并保存到管理者对象那里，后面要用
        FlowAMockMemento memento = mock.createMemento();
        careTaker.saveMemento(memento);

        //按照方案一来运行流程的后半部分
        mock.schema1();

        //从管理者获取备忘录对象，然后设置回去
        //让模拟运行流程的对象自己恢复自己的内部状态
        mock.setMemento(careTaker.retrieveMemento());

        //按照方案二来运行流程后半部分
        mock.schema2();
    }

    private static void before() {
        // 创建模拟运行流程对象
        FlowAMock mock = new FlowAMock("TestFlow");
        //运行流程第一阶段
        mock.runPhraseOne();
        //得到第一个阶段运行所产生的数据，后面要用
        int tempResult = mock.getTempResult();
        String tempState = mock.getTempState();

        //按照方案一来运行流程后半部分
        mock.schema1();

        //把第一个阶段运行产生的数据重新设置回去
        mock.setTempResult(tempResult);
        mock.setTempState(tempState);

        //按照方案二来运行流程后半部分
        mock.schema2();
    }
}
