package es.kiwi.creational.abstract_factory.example1;

public class Client {
    public static void main(String[] args) {
        //创建装机工程师对象
        ComputerEngineer engineer = new ComputerEngineer();
        //告诉装机工程师自己选择的配件，让装机工程师组装电脑
        engineer.makeComputer(1, 1);

        // 没有维护关联关系🤷
        engineer.makeComputer(1, 2);
    }
}

/*
* 问题：上面实现中没有维护 CPU和主板 的匹配关系
* */
