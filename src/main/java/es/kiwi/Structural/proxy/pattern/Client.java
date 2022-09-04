package es.kiwi.Structural.proxy.pattern;

import java.util.List;

public class Client {

    public static void main(String[] args) throws Exception {
        UserManager userManager = new UserManager();
        List<UserModelApi> list = userManager.getUserByDepId("0101");

        //如果只是显示用户名称，则不需要重新查询数据库
        for (UserModelApi umApi : list) {
            System.out.println("用户编号：= " + umApi.getUserId()
                    + "，用户姓名： = " + umApi.getName());
        }

        //如果访问非用户编号和用户姓名外的属性，那就会重新查询数据库
        for (UserModelApi umApi : list) {
            System.out.println("用户编号：= " + umApi.getUserId()
                    + "，用户姓名： = " + umApi.getName()
                    + "，所属部门：= " + umApi.getDepId());
        }
    }
}
