package es.kiwi.Behavioral.command.extension.macro_command;

/**
 * 厨师对象做热菜
 */
public class HotDishesCook implements CookApi{
    @Override
    public void cook(String name) {
        System.out.println("本厨师正在做：" + name);
    }
}
