package es.kiwi.Behavioral.command.extension.macro_command;

/**
 * 厨师对象做凉菜
 */
public class ColdDishesCook implements CookApi{
    @Override
    public void cook(String name) {
        System.out.println("凉菜" + name + "已经做好，本厨师正在装盘。");
    }
}
