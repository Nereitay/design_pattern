package es.kiwi.Behavioral.template_method.extension.crud;

import org.apache.commons.lang3.StringUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 具体的实现用户管理的增删改查功能
 */
public class UserJDBC extends JDBCTemplate{
    @Override
    protected String getMainSql(int type) {
        //根据操作类型，返回相应的主干sql语句
        String sql = "";
        if (type == TYPE_CREATE) {
            sql = "insert into tb1_user values (?, ?, ?)";
        } else if (type == TYPE_DELETE) {
            sql = "delete from tb1_user where uuid = ?";
        }else if (type == TYPE_UPDATE) {
            sql = "update tb1_user set name = ?, age = ? where uuid = ?";
        }else if (type == TYPE_CONDITION) {
            sql = "select * from tb1_user where 1 = 1 ";
        }
        return sql;
    }

    @Override
    protected void setUpdateSqlValue(int type, PreparedStatement pstmt, Object obj) throws Exception {
        //设置增删改操作中的“？”对应的值
        if (type == TYPE_CREATE) {
            this.setCreateValue(pstmt, (UserModel) obj);
        } else if (type == TYPE_DELETE) {
            this.setDeleteValue(pstmt, (UserModel) obj);
        } else if (type == TYPE_UPDATE) {
            this.setUpdateValue(pstmt, (UserModel) obj);
        }
    }

    private void setUpdateValue(PreparedStatement pstmt, UserModel um) throws SQLException {
        pstmt.setString(1, um.getName());
        pstmt.setInt(2, um.getAge());
        pstmt.setString(3, um.getUuid());

    }

    private void setDeleteValue(PreparedStatement pstmt, UserModel um) throws SQLException {
        pstmt.setString(1, um.getUuid());
    }

    private void setCreateValue(PreparedStatement pstmt, UserModel um) throws Exception {
        pstmt.setString(1, um.getUuid());
        pstmt.setString(2, um.getName());
        pstmt.setInt(3, um.getAge());
    }

    @Override
    protected Object rs2Object(ResultSet rs) throws Exception {
        UserModel um = new UserModel();
        String uuid = rs.getString("uuid");
        String name = rs.getString("name");
        int age = rs.getInt("age");

        um.setUuid(uuid);
        um.setName(name);
        um.setAge(age);

        return um;
    }

    @Override
    protected String prepareQuerySql(String sql, Object qm) {
        UserQueryModel uqm = (UserQueryModel) qm;
        StringBuilder sb = new StringBuilder();
        sb.append(sql);
        if (StringUtils.isNotBlank(uqm.getUuid())) {
            sb.append(" and uuid = ? ");
        }
        if (StringUtils.isNotBlank(uqm.getName())) {
            sb.append(" and name like ? ");
        }
        if (uqm.getAge() > 0) {
            sb.append(" and age >= ?");
        }
        if (uqm.getAge2() > 0) {
            sb.append(" and age <= ?");
        }

        return sb.toString();

    }

    @Override
    protected void setQuerySqlValue(PreparedStatement pstmt, Object qm) throws Exception {
        UserQueryModel uqm = (UserQueryModel) qm;
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
}
