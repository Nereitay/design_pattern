package es.kiwi.Creational.abstract_factory.no_pattern;

public class Client {
    public static void main(String[] args) {


        //创建装机工程师对象
        ComputerEngineer engineer = new ComputerEngineer();

        //告诉装机工程师自己选择的配件，让装机工程师组装电脑
        // 问题：CPU对象和主板对象其实是有关系的，是需要相互匹配的
        engineer.makeComputer(1, 2);
    }
}
