package es.kiwi.Behavioral.command.extension.macro_command;

/**
 * 命令对象，蒜泥白肉
 * 这里实现命令的时候，跟标准的命令模式的命令实现有一点不同，
 *  标准的命令模式的命令实现的时候，是通过构造方法传入接收者对象，
 *  这里改成了使用setter的方式来设置接收者对象，也就是说可以动态地切换接收者对象，而无须重新构建对象
 */
public class GarlicPorkCommand implements Command{
    /**
     * 持有具体做菜的厨师对象
     */
    private CookApi cookApi = null;

    /**
     * 设置具体做菜的厨师对象
     * @param cookApi 具体做菜的厨师的对象
     */
    public void setCookApi(CookApi cookApi) {
        this.cookApi = cookApi;
    }

    @Override
    public void execute() {
        this.cookApi.cook("蒜泥白肉");
    }
}
