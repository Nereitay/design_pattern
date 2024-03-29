package es.kiwi.behavioral.command.example6;

/**
 * <p>命令队列</p>
 * 厨师对象，做热菜
 */
public class HotCook implements CookApi, Runnable {
    /**
     * 厨师姓名
     */
    private String name;

    /**
     * 构造方法，传入厨师姓名
     *
     * @param name 厨师姓名
     */
    public HotCook(String name) {
        this.name = name;
    }

    /**
     * 示意，做菜的方法
     *
     * @param name 菜名
     */
    @Override
    public void cook(int tableNum, String name) {
        // 每次做菜的时间是不一定的，用随机数来模拟一下
        int cookTime = (int) (20 * Math.random());
        System.out.println(this.name + "厨师正在为" + tableNum + "号桌做：" + name);
        try {
            // 让线程休息这么长时间，表示正在做菜
            Thread.sleep(cookTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + "厨师为" + tableNum + "号桌做好了：" + name + "，共计耗时 = " + cookTime + "秒");
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> specificRequest to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the specificRequest <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (true) {
            //从命令队列里面获取命令对象
            Command cmd = CommandQueue.getOneCommand();
            if (cmd != null) {
                //说明取到命令对象了，这个命令对象还没有设置接收者
                //因为前面都还不知道到底哪一个厨师来真正执行这个命令
                //现在知道了，就是当前厨师实例，设置到命令对象里面
                cmd.setCookApi(this);
                //然后真正执行这个命令
                cmd.execute();
            }
            // 休息1秒
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
