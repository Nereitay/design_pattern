package es.kiwi.structural.proxy.example1;

import java.util.Collection;

public class Client {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Collection<UserModel> col = userManager.getUserByDepId("0101");
        System.out.println(col);
    }
}
/*
* 问题：当一次性访问的数据条数过多，而且每条描述的数据量又很大的话，将会消耗较多的内存
*
* */
