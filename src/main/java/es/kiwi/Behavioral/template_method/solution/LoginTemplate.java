package es.kiwi.Behavioral.template_method.solution;

/**
 * 登录控制的模板
 */
public abstract class LoginTemplate {
    /**
     * 判断登录数据是否正确，也就是是否能够登录成功
     * @param lm 封装登录数据的Model
     * @return true 表示登录成功，false 表示登录失败
     */
    public final boolean login (LoginModel lm) {
        //1：根据登录人员编号去获取相应的数据
        LoginModel dbLm = this.findLoginUser(lm.getLoginId());
        if (dbLm != null) {
            //2：对密码进行加密
            String encryptPwd = this.encryptPwd(lm.getPwd());
            //把加密后的密码设置回到登录数据模型中
            lm.setPwd(encryptPwd);
            //3：判断是否匹配
            return this.match(lm, dbLm);

        }
        return false;
    }

    /**
     * 判断用户填写的登录数据和存储中相应的数据是否匹配得上
     * @param lm 用户填写的登录数据
     * @param dbLm 在存储中相应的数据
     * @return true匹配成功，false匹配失败
     */
    protected boolean match(LoginModel lm, LoginModel dbLm){
        return (lm.getLoginId().equals(dbLm.getLoginId())
                && lm.getPwd().equals(dbLm.getPwd()));

    }

    /**
     * 对密码数据进行加密
     * @param pwd 密码数据
     * @return 加密后的密码数据
     */
    protected String encryptPwd(String pwd){
        return pwd;
    }

    /**
     * 根据登录编号来查找和获取存储中相应的数据
     * @param loginId 登录编号
     * @return 登录编号在存储中相应的数据
     */
    protected abstract LoginModel findLoginUser(String loginId);
}
