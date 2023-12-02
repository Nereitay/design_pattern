package es.kiwi.structural.bridge.example8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * <p>典型例子 -- JDBC</p>
 * <p>应用程序使用JDBC驱动程序进行开发的方式：
 * - 	驱动程序：按照预先约定好的接口来操作计算机系统或者是外围设备的程序
 * </p>
 */
public class JDBCTest {
    public static void main(String[] args) throws Exception {
        String sql = "具体要操作的sql语句";
        // 1：装载驱动
        Class.forName("驱动的名字");
        // 2：创建连接
        /*通过DriverManager来得到JDBC的API
         * 这些接口相当于桥接模式中抽象部分的接口
         * JDBC的驱动程序实现了JDBC的API，驱动程序就相当于桥接模式中的具体实现部分 --> 不同的数据库会有不同的驱动实现
         * */
        Connection conn = DriverManager.getConnection("连接数据库服务的URL", "用户名",
                "密码");

        // 3：创建statement或者是preparedStatement
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // 4：执行sql，如果是查询，再获取ResultSet
        ResultSet rs = pstmt.executeQuery(sql);

        // 5：循环从ResultSet中把值取出来，封装到数据对象中去
        while (rs.next()) {
            // 取值示意，按名称取值
            String uuid = rs.getString("uuid");
            // 取值示意，按索引取值
            int age = rs.getInt(2);
        }
        //6：关闭
        rs.close();
        pstmt.close();
        conn.close();
    }
}