package es.kiwi.behavioral.template_method.scenario;

/**
 * 普通用户登录控制的逻辑处理
 */
public class UserLogin {

    /**
     * 判断登录数据是否正确，也就是是否能够登录成功
     * @param lm 封装登录数据的Model
     * @return true 表示登录成功没法绿色表示登录失败
     */
    public boolean login(LoginModelU lm) {
        //1：从数据库获取登录人员的信息，就是根据用户编号去获取人员的数据
        UserModel um = this.findUserByUserId(lm.getUserId());
        //2：判断从前台传递过来的登录数据和数据库中已有的数据是否匹配
        //先判断用户是否存在，如果um为null,说明用户肯定不存在
        //但是不为null,用户不一定存在，因为数据层可能返回new UserModel();
        //因此还需要做进一步判断
        if (um != null) {
            // 如果用户存在，检查用户编号和密码是否匹配
            return (um.getUserId().equals(lm.getUserId())
                    && um.getPwd().equals(lm.getPwd()));
        }

        return false;
    }

    /**
     * 根据用户标号获取用户的详细信息
     * @param userId 用户编号
     * @return 对应的用户的详细信息
     */
    private UserModel findUserByUserId (String userId) {
        //这里省略具体的处理，仅做示意，返回一个有默认数据的对象
        UserModel um = new UserModel();
        um.setUserId(userId);
        um.setName("test");
        um.setPwd("test");
        um.setUuid("User0001");
        return um;
    }
}
