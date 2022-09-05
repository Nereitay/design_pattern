package es.kiwi.behavioral.template_method.extension.extend_function;

import es.kiwi.behavioral.template_method.solution.LoginModel;
import es.kiwi.behavioral.template_method.solution.LoginTemplate;

/**
 * 普通用户登陆控制加强版的逻辑处理
 */
public class UserLogin2 extends LoginTemplate {
    @Override
    protected LoginModel findLoginUser(String loginId) {
        //这里省略具体的处理，仅做示意，返回一个有默认数据的对象

        //注意一点：这里使用的是自己需要的数据模型了
        UserLoginModel nlm = new UserLoginModel();
        nlm.setLoginId(loginId);
        nlm.setPwd("testPwd");
        nlm.setQuestion("testQuestion");
        nlm.setAnswer("testAnswer");

        return nlm;
    }

    @Override
    protected boolean match(LoginModel lm, LoginModel dbLm) {
        //这个方法需要覆盖，因为现在进行登录控制的时候，需要检测4个值是否正确，而不是仅仅是缺省的2个

        //先调用父类实现好的，检测编号和密码是否正确
        boolean f1 = super.match(lm, dbLm);
        if (f1) {
            //如果编号和密码正确，继续检查哦问题和答案是否正确

            //先把数据转换成自己需要的数据
            UserLoginModel nlm = (UserLoginModel) lm;
            UserLoginModel dbNlm = (UserLoginModel) dbLm;

            //检查问题和答案是否正确
            return(dbNlm.getQuestion().equals(nlm.getQuestion())
                    && dbNlm.getAnswer().equals(nlm.getAnswer()));

        }

        return false;
    }
}
