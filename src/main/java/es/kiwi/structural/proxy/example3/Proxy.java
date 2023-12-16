package es.kiwi.structural.proxy.example3;

import es.kiwi.utils.JDBCUtils;
import lombok.ToString;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 代理对象,代理用户数据对象
 */
@ToString
public class Proxy implements UserModelApi {
    /**
     * 持有被代理的具体的目标对象
     */
    private UserModel realSubject;

    /**
     * 构造方法，传入被代理的具体的目标对象
     *
     * @param realSubject 被代理的具体的目标对象
     */
    public Proxy(UserModel realSubject) {
        this.realSubject = realSubject;
    }

    /**
     * 标示是否已经重新装载过数据了
     */
    private boolean loaded = false;

    /*用户编号和姓名是已经获取到的数据，直接调用具体目标对象的数据就可以了*/
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

    /*setter方法不需要重新查询数据库，直接调用具体的目标对象的相应功能就可以了*/
    @Override
    public void setDepId(String depId) {
        realSubject.setDepId(depId);
    }

    @Override
    public void setSex(String sex) {
        realSubject.setSex(sex);
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
    public String getSex() {
        if (!this.loaded) {
            reload();
            this.loaded = true;
        }
        return realSubject.getSex();
    }

    /**
     * 重新查询数据库以获取完整的用户数据
     */
    private void reload() {
        System.out.println("重新查询数据库获取完整的用户数据，userId == " + realSubject.getUserId());

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from tbl_user where userId = ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, realSubject.getUserId());

            rs = pstmt.executeQuery();
            while (rs.next()) {
                // 只需要重新获取除了userId 和 name外的数据
                realSubject.setDepId(rs.getString("depId"));
                realSubject.setSex(rs.getString("sex"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
    }

}
