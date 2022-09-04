package es.kiwi.Structural.proxy.pattern;

import es.kiwi.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现示例要求的功能
 */
public class UserManager {
    /**
     * 根据部门编号来获取该部门下的所有人员
     * @param depId 部门编号
     * @return 该部门下的所有人员
     * @throws Exception
     */
    public List<UserModelApi> getUserByDepId(String depId) throws Exception {
        List<UserModelApi> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            //只需要查询userId和name两个值就可以了
            String sql = "select u.userId, u.name from tbl_user u, tbl_dep d where u.depId = d.depId and d.depId like ?";
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, depId + "%");
            rs = ptst.executeQuery();

            while (rs.next()) {
                //这里是创建的代理对象，而不是直接创建UserModel的对象
                Proxy proxy = new Proxy(new UserModel());
                //只是设置userId和name两个值可以了
                proxy.setUserId(rs.getString("userId"));
                proxy.setName(rs.getString("name"));
                list.add(proxy);
            }
        } finally {
            JDBCUtils.close(rs, ptst, conn);
        }

        return list;
    }
}
