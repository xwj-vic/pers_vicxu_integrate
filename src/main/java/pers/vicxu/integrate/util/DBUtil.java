package pers.vicxu.integrate.util;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Create By Vic Xu on 7/10/2018
 */
public class DBUtil {

    private static Properties conf = new Properties();
    private static BasicDataSource dataSource = new BasicDataSource();
    private static String url;
    private static String username;
    private static String password;
    private static String driver;

    static {
        try {
            InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("dbconf.properties");
            conf.load(in);
            url = conf.getProperty("url");
            username = conf.getProperty("username");
            password = conf.getProperty("password");
            driver = conf.getProperty("driverClass");
            int initSize = Integer.parseInt(conf.getProperty("initsize"));
            int minIdle = Integer.parseInt(conf.getProperty("minidle"));
            int maxActive = Integer.parseInt(conf.getProperty("maxactive"));
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            dataSource.setDriverClassName(driver);
            dataSource.setInitialSize(initSize);
            dataSource.setMinIdle(minIdle);
            dataSource.setMaxActive(maxActive);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnectionWithDbcp() {
        Connection con = null;
        try {
            con = dataSource.getConnection();
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
