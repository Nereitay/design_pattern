package es.kiwi.behavioral.command.example3;


public class Client {
    public static void main(String[] args) {
        //1：把命令和真正的实现组合起来，相当于在组装机器，
        //把机箱上按钮的连接线插接到主板上。
        MainBoardApi mainBoard = new GigaMainBoard();
        //创建开机命令
        OpenCommand openCommand = new OpenCommand(mainBoard);
        //创建重启机器的命令

        ResetCommand resetCommand = new ResetCommand(mainBoard);

        /*真正的客户端测试👇 - 任务就是面对机箱，按下机箱上的按钮*/
        //2：为机箱上的按钮设置对应的命令，让按钮知道该干什么
        Box box = new Box();
        //先正确配置，就是开机按钮对开机命令，重启按钮对重启命令
        box.setOpenCommand(openCommand);
        box.setResetCommand(resetCommand);

        //3：然后模拟按下机箱上的按钮
        System.out.println("正确配置下------------------------->");
        System.out.println(">>>按下开机按钮：>>>");
        box.openButtonPressed();
        System.out.println(">>>按下重启按钮：>>>");
        box.resetButtonPressed();

        //然后来错误配置一回，反正是进行参数化配置
        //就是开机按钮对重启命令，重启按钮对开机命令
        box.setOpenCommand(resetCommand);
        box.setResetCommand(openCommand);
        //4：然后还是来模拟按下机箱上的按钮
        System.out.println("错误配置下------------------------->");
        System.out.println(">>>按下开机按钮：>>>");
        box.openButtonPressed();
        System.out.println(">>>按下重启按钮：>>>");
        box.resetButtonPressed();
    }
}
