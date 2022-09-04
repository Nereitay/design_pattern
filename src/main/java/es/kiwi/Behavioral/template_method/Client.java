package es.kiwi.Behavioral.template_method;

import es.kiwi.Behavioral.template_method.extension.callback.LoginCallback;
import es.kiwi.Behavioral.template_method.extension.crud.UserJDBC;
import es.kiwi.Behavioral.template_method.extension.crud.UserQueryModel;
import es.kiwi.Behavioral.template_method.extension.extend_function.UserLogin2;
import es.kiwi.Behavioral.template_method.extension.extend_function.UserLoginModel;
import es.kiwi.Behavioral.template_method.extension.sort.UserModel;
import es.kiwi.Behavioral.template_method.solution.LoginModel;
import es.kiwi.Behavioral.template_method.solution.LoginTemplate;
import es.kiwi.Behavioral.template_method.solution.UserLogin;
import es.kiwi.Behavioral.template_method.solution.WorkerLogin;

import java.util.*;

public class Client {

    public static void main(String[] args) {

//        templateMethod();

        //扩展功能
//        extendFunction();

        //Java回调与模板方法模式
//        callback();

        //典型应用：排序
//        sort();

        //实现通用的增删改查
//        crud();
    }

    private static void crud() {
        UserJDBC uj = new UserJDBC();
        //先新增几条
        es.kiwi.Behavioral.template_method.extension.crud.UserModel um1 =
                new es.kiwi.Behavioral.template_method.extension.crud.UserModel();
        um1.setUuid("u1");
        um1.setName("Zumo");
        um1.setAge(22);
        uj.create(um1);
        es.kiwi.Behavioral.template_method.extension.crud.UserModel um2 =
                new es.kiwi.Behavioral.template_method.extension.crud.UserModel();
        um2.setUuid("u2");
        um2.setName("Pan");
        um2.setAge(25);
        uj.create(um2);
        es.kiwi.Behavioral.template_method.extension.crud.UserModel um3 =
                new es.kiwi.Behavioral.template_method.extension.crud.UserModel();
        um3.setUuid("u3");
        um3.setName("Ensalada");
        um3.setAge(32);
        uj.create(um3);

        //测试修改
        um3.setName("u3 modified");
        um3.setAge(35);
        uj.update(um3);

        //测试查询
        UserQueryModel uqm = new UserQueryModel();
        uqm.setAge(20);
        uqm.setAge2(36);
        Collection<es.kiwi.Behavioral.template_method.extension.crud.UserModel> col =
                (Collection<es.kiwi.Behavioral.template_method.extension.crud.UserModel>) uj.getByCondition(uqm);
        col.forEach(System.out::println);

        //测试删除
        uj.delete(um3);
    }

    private static void sort() {
        //准备要测试的数据
        UserModel um1 = new UserModel("u1", "user1", 23);
        UserModel um2 = new UserModel("u2", "user2", 22);
        UserModel um3 = new UserModel("u3", "user3", 21);
        UserModel um4 = new UserModel("u4", "user4", 24);
        //添加到列表中
        List<UserModel> list = new ArrayList<>();
        list.add(um1);
        list.add(um2);
        list.add(um3);
        list.add(um4);

        System.out.println("排序前------------------> ");
        printList(list);

        //实现比较器，也可以单独用一个类来实现
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //假如实现按照年龄升序排序
                UserModel tempUm1 = (UserModel) o1;
                UserModel tempUm2 = (UserModel) o2;

                if (tempUm1.getAge() > tempUm2.getAge())
                    return 1;
                else if (tempUm1.getAge() == tempUm2.getAge())
                    return 0;
                else if (tempUm1.getAge() < tempUm2.getAge())
                    return -1;

                return 0;
            }
        };

        //排序
        Collections.sort(list, c);

        System.out.println("排序后------------------> ");
        printList(list);
    }

    private static void printList(List<UserModel> list) {
        for (UserModel um : list) {
            System.out.println(um);
        }
    }

    private static void callback() {
        //准备登录人的信息
        LoginModel lm = new LoginModel();
        lm.setLoginId("admin");
        lm.setPwd("workerPwd");
        //准备用来进行判断的对象
        es.kiwi.Behavioral.template_method.extension.callback.LoginTemplate lt =
                new es.kiwi.Behavioral.template_method.extension.callback.LoginTemplate();

        //进行登录测试，先测试普通人员登录
        boolean flag = lt.login(lm, new LoginCallback() {
            @Override
            public LoginModel findLoginUser(String loginId) {
                //这里省略具体的处理，仅做示意，返回一个有默认数据的对象
                LoginModel lm = new LoginModel();
                lm.setLoginId(loginId);
                lm.setPwd("testPwd");
                return lm;
            }

            @Override
            public String encryptPwd(String pwd,
                                     es.kiwi.Behavioral.template_method.extension.callback.LoginTemplate template) {
                //自己不需要实现这个功能，直接转调模板中的默认实现
                return template.encryptPwd(pwd);
            }

            @Override
            public boolean match(LoginModel lm, LoginModel dbLm,
                                 es.kiwi.Behavioral.template_method.extension.callback.LoginTemplate template) {
                //自己不需要覆盖，直接转调模板中的默认实现
                return template.match(lm, dbLm);
            }
        });

        System.out.println("可以进行普通人员登录=" + flag);

        //测试工作人员登录
        boolean flag2 = lt.login(lm, new LoginCallback() {
            @Override
            public LoginModel findLoginUser(String loginId) {
                //这里省略具体的处理，仅做示意，返回一个有默认数据的对象
                LoginModel lm = new LoginModel();
                lm.setLoginId(loginId);
                lm.setPwd("workerPwd");
                return lm;
            }

            @Override
            public String encryptPwd(String pwd,
                                     es.kiwi.Behavioral.template_method.extension.callback.LoginTemplate template) {
                //覆盖父类的方法，提供真正的加密实现
                //这里对密码进行加密，比如使用MD5,3DES等，省略了
                System.out.println("使用MD5进行密码加密");
                return pwd;
            }

            @Override
            public boolean match(LoginModel lm, LoginModel dbLm,
                                 es.kiwi.Behavioral.template_method.extension.callback.LoginTemplate template) {
                //自己不需要覆盖，直接转调模板中的默认实现
                return template.match(lm, dbLm);
            }
        });

        System.out.println("可以登录工作平台=" + flag2);
    }

    private static void extendFunction() {
        //准备登录人的信息
        UserLoginModel nlm = new UserLoginModel();
        nlm.setLoginId("testUser");
        nlm.setPwd("testPwd");
        nlm.setQuestion("testQuestion");
        nlm.setAnswer("testAnswer");
        //准备用来进行判断的对象
        LoginTemplate lt3 = new UserLogin2();
        boolean flag3 = lt3.login(nlm);
        System.out.println("可以进行普通人员加强版登录=" + flag3);
    }

    private static void templateMethod() {
        //准备登录人的信息
        LoginModel lm = new LoginModel();
        lm.setLoginId("admin");
        lm.setPwd("workerPwd");

        //准备用来进行判断的对象
        LoginTemplate lt = new WorkerLogin();
        LoginTemplate lt2 = new UserLogin();

        //进行登录测试
        boolean flag = lt.login(lm);
        System.out.println("可以登录工作平台=" + flag);

        boolean flag2 = lt2.login(lm);
        System.out.println("可以进行普通人员登录=" + flag2);
    }
}
