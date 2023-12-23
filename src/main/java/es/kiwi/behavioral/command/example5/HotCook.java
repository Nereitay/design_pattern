package es.kiwi.behavioral.command.example5;

/**
 * 厨师对象，做热菜
 */
public class HotCook implements CookApi {
    /**
     * 示意，做菜的方法
     *
     * @param name 菜名
     */
    @Override
    public void cook(String name) {
        System.out.println("本厨师正在做：" + name);
    }
}
