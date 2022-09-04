package es.kiwi.Structural.proxy.pattern;

import es.kiwi.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 代理对象，代理用户数据对象
 */
public class Proxy implements UserModelApi {

    /**
     * 持有被代理的具体目标对象
     */
    private UserModel realSubject = null;
    /**
     * 标示是否已经重新装载过数据了
     */
    private boolean loaded = false;

    /**
     * 构造方法，传入被代理的具体的目标对象
     *
     * @param realSubject 被代理的具体目标对象
     */
    public Proxy(UserModel realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public String getUserId() {
        return realSubject.getUserId();
    }

    @Override
    public void setUserId(String userId) {
        realSubject.setUserId(userId);
    }

    @Override
    public String getName() {
        return realSubject.getName();
    }

    @Override
    public void setName(String name) {
        realSubject.setName(name);
    }

    @Override
    public String getDepId() {
        //需要判断是否已经装载过了
        if (!this.loaded) {
            //从数据库中重新装载
            reload();
            //设置重新装载的标志为true
            this.loaded = true;
        }
        return realSubject.getDepId();
    }

    @Override
    public void setDepId(String depId) {
        realSubject.setDepId(depId);
    }

    @Override
    public String getSex() {
        if (!loaded) {
            reload();
            this.loaded = true;
        }
        return realSubject.getSex();
    }

    @Override
    public void setSex(String sex) {
        realSubject.setSex(sex);
    }

    /**
     * 重新查询数据库以获取完整的用户数据
     */
    private void reload() {
        System.out.println("重新查询数据库获取完整的用户数据，userId == "
                + realSubject.getUserId());

        Connection conn = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from tbl_user where userId = ?";
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, realSubject.getUserId());
            rs = ptst.executeQuery();

            if (rs.next()) {
                //著需要重新获取除了userId和name外的数据
                realSubject.setDepId(rs.getString("depId"));
                realSubject.setSex(rs.getString("sex"));
            }
        }catch (Exception err) {
            err.printStackTrace();
        } finally {
            JDBCUtils.close(rs, ptst, conn);
        }
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId='" + getUserId() + '\'' +
                ", name='" + getName() + '\'' +
                ", depId='" + getDepId() + '\'' +
                ", sex='" + getSex() + '\'' +
                '}';
    }
}
