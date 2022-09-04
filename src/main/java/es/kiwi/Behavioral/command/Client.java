package es.kiwi.Behavioral.command;

import es.kiwi.Behavioral.command.extension.degenerate.Command2;
import es.kiwi.Behavioral.command.extension.degenerate.Invoker;
import es.kiwi.Behavioral.command.extension.degenerate.Invoker2;
import es.kiwi.Behavioral.command.extension.degenerate.PrintService;
import es.kiwi.Behavioral.command.extension.macro_command.ChopCommand;
import es.kiwi.Behavioral.command.extension.macro_command.DuckCommand;
import es.kiwi.Behavioral.command.extension.macro_command.GarlicPorkCommand;
import es.kiwi.Behavioral.command.extension.macro_command.Waiter;
import es.kiwi.Behavioral.command.extension.parameterized.ResetCommand;
import es.kiwi.Behavioral.command.extension.queue_request.CookManager;
import es.kiwi.Behavioral.command.extension.revocable.AddCommand;
import es.kiwi.Behavioral.command.extension.revocable.Calculator;
import es.kiwi.Behavioral.command.extension.revocable.Operation;
import es.kiwi.Behavioral.command.extension.revocable.SubtractCommand;
import es.kiwi.Behavioral.command.solution.*;

public class Client {

    public static void main(String[] args) {
        //使用命令模式
//        command();

        //参数化配置
//        parameterized();

        //可撤销的操作
//        revocable();

        //宏命令
//        macro();

        //队列请求
//        queue();

        //日志请求
//        log();

        //退化的命令模式
//        degenerate();

        //进一步退化
        degenerate2();
    }

    private static void degenerate2() {
        //准备要发出的命令,没有具体实现类了
        Command2 cmd = new Command2(){ //匿名内部类来实现命令

            private String str = "";
            @Override
            public void execute() {
                System.out.println("打印内容为 = " + str);
            }

            @Override
            public void setStr(String s) {
                str = s;
            }
        };

        cmd.setStr("退化的命令模式；类似于JAVA回调的示例");
        //这个时候的Invoker或许该称为服务了
        Invoker2 invoker = new Invoker2();
        //按下按钮，真正启动执行命令
        invoker.startPrint(cmd);
    }

    private static void degenerate() {
        //准备要发出的命令
        es.kiwi.Behavioral.command.extension.degenerate.Command cmd = new PrintService("退化的命令模式示例");
        //设置命令给持有方
        Invoker invoker = new Invoker();
        invoker.setCmd(cmd);

        //按下按钮，真正启动执行命令
        invoker.startPrint();
    }

    private static void log() {
        //先要启动后台，让整个程序运行起来
        es.kiwi.Behavioral.command.extension.log_request.CookManager.runCookManager();

        //为了简单，直接循环模拟多个桌号点菜
        for (int i = 0; i < 5; i++) {
            //创建服务员
            es.kiwi.Behavioral.command.extension.log_request.Waiter waiter =
                    new es.kiwi.Behavioral.command.extension.log_request.Waiter();
            //创建命令对象，就是要点的菜
            es.kiwi.Behavioral.command.extension.queue_request.Command chop =
                    new es.kiwi.Behavioral.command.extension.log_request.ChopCommand(i);
            es.kiwi.Behavioral.command.extension.queue_request.Command duck =
                    new es.kiwi.Behavioral.command.extension.log_request.DuckCommand(i);

            //点菜，就是把这些菜让服务员记录下来
            waiter.orderDish(chop);
            waiter.orderDish(duck);

            //点菜完毕
            waiter.orderOver();
        }
    }

    private static void queue() {
        //先要启动后台，让整个程序运行起来
        CookManager.runCookManager();

        //为了简单，直接循环模拟多个桌号点菜
        for (int i = 0; i < 5; i++) {
            //创建服务员
            es.kiwi.Behavioral.command.extension.queue_request.Waiter waiter =
                    new es.kiwi.Behavioral.command.extension.queue_request.Waiter();
            //创建命令对象，就是要点的菜
            es.kiwi.Behavioral.command.extension.queue_request.Command chop =
                    new es.kiwi.Behavioral.command.extension.queue_request.ChopCommand(i);
            es.kiwi.Behavioral.command.extension.queue_request.Command duck =
                    new es.kiwi.Behavioral.command.extension.queue_request.DuckCommand(i);

            //点菜，就是把这些菜让服务员记录下来
            waiter.orderDish(chop);
            waiter.orderDish(duck);

            //点菜完毕
            waiter.orderOver();
        }
    }

    private static void macro() {
        //客户只是负责向服务员点菜就好了
        //创建服务员
        Waiter waiter = new Waiter();

        //创建命令对象，就是要点的菜
        es.kiwi.Behavioral.command.extension.macro_command.Command chop = new ChopCommand();
        es.kiwi.Behavioral.command.extension.macro_command.Command duck = new DuckCommand();
        es.kiwi.Behavioral.command.extension.macro_command.Command pork = new GarlicPorkCommand();

        //点菜，就是把这次菜让服务员记录下来
        waiter.orderDish(chop);
        waiter.orderDish(duck);
        waiter.orderDish(pork);

        //点菜完毕
        waiter.orderOver();
    }

    private static void revocable() {
        //1. 组装命令和接收者
        //创建接收者
        Operation operation = new Operation();
        //创建命令对象，并组装命令和接收者
        AddCommand addCmd = new AddCommand(operation, 5);
        SubtractCommand subCmd = new SubtractCommand(operation, 3);
        //2. 把命令设置到持有者，也就是计算器里面
        Calculator calculator = new Calculator();
        calculator.setAddCmd(addCmd);
        calculator.setSubtractCmd(subCmd);

        //3. 模拟按下按钮，测试一下
        calculator.addPressed();
        System.out.println("一次加法运算后的结果为：" + operation.getResult());
        calculator.subtractPressed();
        System.out.println("一次减法运算后的结果为：" + operation.getResult());

        //测试撤销
        calculator.undoPressed();
        System.out.println("撤销一次后的结果为：" + operation.getResult());
        calculator.undoPressed();
        System.out.println("再撤销一次后的结果为：" + operation.getResult());

        //测试恢复
        calculator.redoPressed();
        System.out.println("恢复一次后的结果为：" + operation.getResult());
        calculator.redoPressed();
        System.out.println("再恢复一次后的结果为：" + operation.getResult());
    }

    private static void parameterized() {
        //1. 把命令和真正的实现组合起来，相当于在组装机器
        //把机箱上按钮的连接线插接到主板上
        es.kiwi.Behavioral.command.extension.parameterized.MainBoardApi mainBoard =
                new es.kiwi.Behavioral.command.extension.parameterized.GigaMainBoard();

        //创建开机命令
        Command openCommand = new es.kiwi.Behavioral.command.extension.parameterized.OpenCommand(mainBoard);
        //创建重启机器的命令
        Command resetCommand = new ResetCommand(mainBoard);

        //2. 为机箱上按钮的设置对应的命令，让按钮知道该干什么
        es.kiwi.Behavioral.command.extension.parameterized.Box box =
                new es.kiwi.Behavioral.command.extension.parameterized.Box();
        //先正确配置，就是开机按钮对开机命令，重启按钮对重启命令
        box.setOpenCommand(openCommand);
        box.setResetCommand(resetCommand);

        //3. 模拟按下机箱上的按钮
        System.out.println("正确配置下----------------------->");
        System.out.println(">>>按下开机按钮<<<");
        box.openButtonPressed();
        System.out.println(">>>按下重启按钮<<<");
        box.resetButtonPressed();

        //然后来错误配置一回，反正是进行参数化配置
        //就是开机按钮对重启命令，重启按钮对开机命令
        box.setOpenCommand(resetCommand);
        box.setResetCommand(openCommand);

        //4. 再来模拟按下机箱上的按钮
        System.out.println("错误配置下----------------------->");
        System.out.println(">>>按下开机按钮<<<");
        box.openButtonPressed();
        System.out.println(">>>按下重启按钮<<<");
        box.resetButtonPressed();
    }

    private static void command() {
        //1. 把命令和真正的实现组合起来，相当于在组装机器
        //把机箱上按钮的连接线插接到主板上
        MainBoardApi mainBoard = new GigaMainBoard();
        Command command = new OpenCommand(mainBoard);

        //2. 为机箱上按钮的连接线插接到主板上
        Box box = new Box();
        box.setOpenCommand(command);

        //3. 然后模拟按下机箱上的按钮
        box.openButtonPressed();
    }
}
