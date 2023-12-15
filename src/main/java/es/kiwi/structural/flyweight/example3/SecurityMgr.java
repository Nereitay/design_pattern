package es.kiwi.structural.flyweight.example3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Client角色：使用享元的对象</p>
 * <p>
 * 安全管理，实现成单例
 */
public class SecurityMgr {

    private static SecurityMgr securityMgr = new SecurityMgr();

    private SecurityMgr() {
    }

    public static SecurityMgr getInstance() {
        return securityMgr;
    }

    /**
     * <p>可以把安全实体和权限描述定义成为享元，而和他们结合的人员数据，就可以作为享元的外部数据</p>
     * 在运行期间，用来存放登录人员对应的权限，
     * 在Web应用中，这些数据通常会存放到session中
     */
    private Map<String, Collection<Flyweight>> map = new HashMap<>();

    /**
     * 模拟登录的功能
     *
     * @param user 登录的用户
     */
    public void login(String user) {
        //登录的时候就需要把该用户所拥有的权限，从数据库中取出来，放到缓存中去
        Collection<Flyweight> col = queryByUser(user);
        map.put(user, col);
    }

    /**
     * 从数据库中获取某人所拥有的权限
     *
     * @param user 需要获取所拥有的权限的人员
     * @return 某人所拥有的权限
     */
    private Collection<Flyweight> queryByUser(String user) {
        Collection<Flyweight> col = new ArrayList<>();
        for (String s : TestDB.colDB) {
            String[] ss = s.split(",");
            if (ss[0].equals(user)) {
                /*👇*/
                Flyweight fm = FlyweightFactory.getInstance().getFlyweight(ss[1] + "," + ss[2]);
                col.add(fm);
            }
        }
        return col;
    }

    /**
     * 判断某用户对某个安全实体是否拥有某权限
     *
     * @param user           被检测权限的用户
     * @param securityEntity 安全实体
     * @param permit         权限
     * @return true表示拥有相应权限，false表示没有相应权限
     */
    public boolean hasPermit(String user, String securityEntity, String permit) {
        Collection<Flyweight> col = map.get(user);
        if (col == null || col.size() == 0) {
            System.out.println(user + "没有登录或是没有被分配任何权限");
            return false;
        }
        for (Flyweight fm : col) {
            // 输出当前实例，看看是否是同一个实例对象
            System.out.println("fm == " + fm);
            /*👇*/
            if (fm.match(securityEntity, permit)) {
                return true;
            }
        }
        return false;
    }

}
