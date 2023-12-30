package es.kiwi.creational.abstract_factory.example3;

public class Client {
    public static void main(String[] args) {
        //创建装机工程师对象
        ComputerEngineer engineer = new ComputerEngineer();
        //👇客户选择并创建需要使用的装机方案对象
        AbstractFactory schema = new Schema1();
        //告诉装机工程师自己选择的装机方案，让装机工程师组装电脑
        engineer.makeComputer(schema);
    }
}

/*
* 问题：这种实现有一个麻烦，就是如果在产品簇中要新增加一种产品，
* 抽象工厂里面要添加方法，所有实现都要发生变化
* -> 定义可扩展的工厂
* */
