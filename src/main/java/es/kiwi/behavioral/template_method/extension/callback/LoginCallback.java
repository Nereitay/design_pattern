package es.kiwi.behavioral.template_method.extension.callback;

import es.kiwi.behavioral.template_method.solution.LoginModel;

/**
 * 登录控制的模板方法需要的回调接口，需要把所偶有需要的接口方法都定义出来
 * 或者说是所有可能被扩展的方法都需要被定义出来
 */
public interface LoginCallback {
    /**
     * 根据登录编号来查找和获取存储中相应的数据
     * @param loginId 登录编号
     * @return 登录编号在存储中相对应的数据
     */
    LoginModel findLoginUser(String loginId);

    /**
     * 对密码数据进行加密
     * @param pwd 密码数据
     * @param template LoginTemplate对象，通过它来调用在
     *                 LoginTemplate中定义的公共方法或默认实现
     * @return 加密后的密码数据
     */
    String encryptPwd(String pwd, LoginTemplate template);

    /**
     * 判断用户填写的登录数据和存储中相应的数据是否匹配得上
     * @param lm 用户填写的登录数据
     * @param dbLm 在存储中相应的数据
     * @param template LoginTemplate对象，通过它来调用在
     *                 LoginTemplate中定义的公共方法或默认实现
     * @return true匹配成功，false匹配失败
     */
    boolean match(LoginModel lm, LoginModel dbLm, LoginTemplate template);


}
