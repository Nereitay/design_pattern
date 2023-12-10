package es.kiwi.behavioral.memento.example3;

import java.io.Serializable;

/**
 * 模拟运行流程A的对象的备忘录接口，是个窄接口
 */
public interface FlowAMockMemento extends Serializable { // 实现序列化是为了可以存储到文件中
    //空的
}
