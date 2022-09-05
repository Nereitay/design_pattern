package es.kiwi.behavioral.template_method.solution;
/**
 * 普通用户登录控制的逻辑处理
 */
public class UserLogin extends LoginTemplate {


    @Override
    protected LoginModel findLoginUser(String loginId) {
        //这里省略具体的处理，仅做示意，返回一个有默认数据的对象
        LoginModel lm = new LoginModel();
        lm.setLoginId(loginId);
        lm.setPwd("testPwd");
        return lm;
    }
}
