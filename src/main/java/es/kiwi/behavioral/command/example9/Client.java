package es.kiwi.behavioral.command.example9;

public class Client {
    public static void main(String[] args) {
        //🧠准备要发出的命令，没有具体的实现类了
        Command cmd = new Command() { // 匿名内部类来实现命令
            private String str = "";
            @Override
            public void execute() {
                System.out.println("打印的内容为=" + str);
            }

            @Override
            public void setStr(String s) {
                str = s;
            }
        };
        cmd.setStr("退化的命令模式类似于Java回调的示例");

        //这个时候的Invoker或许该称为服务了
        Invoker invoker = new Invoker();

        //按下按钮，真正启动执行命令
        invoker.startPrint(cmd);
    }
}
/*
* 把单独实现命令接口的类改成匿名内部类的实现，
* 这个时候就只剩下命令的接口、Invoker类、还有客户端了
* */
