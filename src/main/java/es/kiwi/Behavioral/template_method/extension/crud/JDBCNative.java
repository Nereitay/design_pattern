package es.kiwi.Behavioral.template_method.extension.crud;

import es.kiwi.utils.JDBCUtils;
import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 使用纯JDBC来实现新增的功能
 */
public class JDBCNative {

    public void create(UserModel um) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils.getConnection();

            String sql = "insert into tb1_user values (?, ?, ?) ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, um.getUuid());
            pstmt.setString(2, um.getName());
            pstmt.setInt(3, um.getAge());

            pstmt.executeUpdate();


        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
    }

    public Collection<UserModel> getByCondition(UserQueryModel uqm) {
        Collection<UserModel> col = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();

            String sql = "select * from tb1_user where 1 = 1 ";
            sql = this.prepareSql(sql, uqm);
            pstmt = conn.prepareStatement(sql);
            this.setValue(pstmt, uqm);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                col.add(this.rs2object(rs));
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }

        return col;
    }

    /**
     * 为通用查询动态地拼接sql地条件部分，基本思路是：
     * 如果用户填写了相应的条件，那么才在sql中添加相应的条件
     *
     * @param sql sql的主干部分
     * @param uqm 封装查询条件的数据模型
     * @return 拼接好的sql语句
     */
    private String prepareSql(String sql, UserQueryModel uqm) {

        StringBuilder sb = new StringBuilder();
        sb.append(sql);
        //绝对匹配
        if (StringUtils.isNotBlank(uqm.getUuid())) {
            sb.append(" and uuid = ? ");
        }
        //模糊匹配
        if (StringUtils.isNotBlank(uqm.getName())) {
            sb.append(" and name like ? ");
        }
        //区间匹配
        if (uqm.getAge() > 0) {
            sb.append(" and age >= ?");
        }
        if (uqm.getAge2() > 0) {
            sb.append(" and age <= ?");
        }

        return sb.toString();
    }

    /**
     * 为通用查询的sql动态设置条件的值
     *
     * @param pstmt 预处理查询sql对象
     * @param uqm   封装查询条件的数据模型
     * @throws Exception
     */
    private void setValue(PreparedStatement pstmt, UserQueryModel uqm) throws Exception {

        int count = 1;
        if (StringUtils.isNotBlank(uqm.getUuid())) {
            pstmt.setString(count, uqm.getUuid());
            count++;
        }
        if (StringUtils.isNotBlank(uqm.getName())) {
            pstmt.setString(count, "%" + uqm.getName() + "%");
            count++;
        }
        if (uqm.getAge() > 0) {
            pstmt.setInt(count, uqm.getAge());
            count++;
        }
        if (uqm.getAge2() > 0) {
            pstmt.setInt(count, uqm.getAge2());
            count++;
        }
    }

    /**
     * 把查询返回的结果集转换成为对象
     *
     * @param rs 查询返回的结果集
     * @return 查询返回的结果集转换成为对象
     * @throws Exception
     */
    private UserModel rs2object(ResultSet rs) throws Exception {

        UserModel um = new UserModel();
        String uuid = rs.getString("uuid");
        String name = rs.getString("name");
        int age = rs.getInt("age");

        um.setUuid(uuid);
        um.setName(name);
        um.setAge(age);

        return um;
    }


}
