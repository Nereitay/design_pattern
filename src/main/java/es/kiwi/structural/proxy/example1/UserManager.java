package es.kiwi.structural.proxy.example1;

import es.kiwi.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 实现示例要求的功能
 */
public class UserManager {
    /**
     * 根据部门编号来获取该部门下的所有人员
     *
     * @param depId 部门编号
     * @return 该部门下的所有人员
     */
    public Collection<UserModel> getUserByDepId(String depId) {
        Collection<UserModel> col = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from tbl_user u, tbl_dep d where u.depId = d.depId and d.depId like ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, depId + "%");

            rs = pstmt.executeQuery();
            while (rs.next()) {
                UserModel um = new UserModel();
                um.setUserId(rs.getString("userId"));
                um.setName(rs.getString("name"));
                um.setDepId(rs.getString("depId"));
                um.setSex(rs.getString("sex"));

                col.add(um);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }

        return col;
    }
}
