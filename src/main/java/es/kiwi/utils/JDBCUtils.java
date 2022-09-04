package es.kiwi.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * 资源文件读取，只需要读取一次即可，-> 使用静态代码块
     */
    static {
        //读取资源文件获取值

        try {
            Properties prop = new Properties();
            URL propUrl = JDBCUtils.class.getClassLoader().getResource("jdbc.properties");

            assert propUrl != null;
            prop.load(new FileReader(propUrl.getPath()));

            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            driver = prop.getProperty("driver");

            //注册驱动
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
    }

    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn) {
        close(null, stmt, conn);
    }
}
