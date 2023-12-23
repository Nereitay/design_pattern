package es.kiwi.behavioral.command.example5;

/**
 * 厨师对象，做凉菜
 */
public class ColdCook implements CookApi {
    /**
     * 示意，做菜的方法
     *
     * @param name 菜名
     */
    @Override
    public void cook(String name) {
        System.out.println("凉菜" + name + "已经做好，本厨师正在装盘。");
    }
}
