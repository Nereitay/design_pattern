package es.kiwi.behavioral.command.example8;


public class PrintService implements Command {
    /**
     * 要输出的内容
     */
    private String str = "";

    /**
     * 构造方法，传入要输出的内容
     *
     * @param s 要输出的内容
     */
    public PrintService(String s) {
        this.str = s;
    }

    @Override
    public void execute() {
        /*智能的体现，自己知道怎么实现命令所要求的功能，并真正地实现了相应的功能，不再转调接收者了*/
        System.out.println("打印的内容为=" + str);
    }
}
