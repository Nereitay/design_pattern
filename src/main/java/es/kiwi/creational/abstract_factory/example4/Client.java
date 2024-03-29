package es.kiwi.creational.abstract_factory.example4;

public class Client {
    public static void main(String[] args) {
        //创建装机工程师对象
        ComputerEngineer engineer = new ComputerEngineer();
        //客户选择并创建需要使用的装机方案对象
        AbstractFactory schema = new Schema1();
        //告诉装机工程师自己选择的装机方案，让装机工程师组装电脑
        engineer.makeComputer(schema);

        /*扩展后*/
        System.out.println("-----工厂扩展后-----");
        schema = new Schema3();
        engineer.makeComputer(schema);
    }
}

