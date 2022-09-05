package es.kiwi.structural.flyweight.scenario;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 安全管理，实现成单例
 */
public class SecurityMgr {

    private static SecurityMgr securityMgr = new SecurityMgr();

    private SecurityMgr() {}

    public static SecurityMgr getInstance() {
        return securityMgr;
    }

    /**
     * 在运行期间，用来存放登录人员对应的权限
     * 在Web应用中，这些数据通常会存放到session中
     */
    private Map<String, List<AuthorizationModel>> map = new HashMap<>();

    /**
     * 模拟登录功能
     * @param user 登录的用户
     */
    public void login(String user) {
        //登录时就需要把该用户所拥有的权限，从数据库中取出来，放到缓存中去
        List<AuthorizationModel> list = queryByUser(user);
        map.put(user, list);
    }

    /**
     * 从数据库中获取某人所拥有的权限
     * @param user 需要获取所拥有的权限人员
     * @return 某人所拥有的权限
     */
    private List<AuthorizationModel> queryByUser(String user) {
        List<AuthorizationModel> list = new ArrayList<>();

        for (String s : TestDB.dbList) {
            String[] ss = s.split(",");
            if (ss[0].equals(user)) {
                AuthorizationModel am = new AuthorizationModel();
                am.setUser(ss[0]);
                am.setSecurityEntity(ss[1]);
                am.setPermit(ss[2]);

                list.add(am);
            }
        }

        return list;
    }

    /**
     * 判断某个用户对某个安全实体是否拥有某种权限
     * @param user 被检测权限的用户
     * @param securityEntity 安全实体
     * @param permit 权限
     * @return true表示拥有相应的权限，false表示没有相应的权限
     */
    public boolean hasPermit(String user, String securityEntity, String permit) {
        List<AuthorizationModel> list = map.get(user);

        if (CollectionUtils.isEmpty(list)) {
            System.out.println(user + "没有登录或是没有被分配任何权限");
            return false;
        }

        for (AuthorizationModel am : list) {
            //输出当前实例，看看是否同一个实例对象
            System.out.println("am====" + am);
            if (am.getSecurityEntity().equals(securityEntity) && am.getPermit().equals(permit))
                return true;

        }
        return false;
    }


}
