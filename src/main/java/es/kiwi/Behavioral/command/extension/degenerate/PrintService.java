package es.kiwi.Behavioral.command.extension.degenerate;

public class PrintService implements Command{
    /**
     * 要输出的内容
     */
    private String str = "";

    /**
     * 构造方法，传入要输出的内容
     * @param str 要输出的内容
     */
    public PrintService(String str) {
        this.str = str;
    }

    //智能的体现，自己知道怎么实现命令所要求的功能，并真正地实现了对应地功能，不再转调接收者了
    @Override
    public void execute() {
        System.out.println("打印的内容为 = " + str);
    }
}
