package top.joww.game.util;

import java.sql.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBCUtil {

    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;

    static {
        InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            Properties properties = new Properties();
            properties.load(is);
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
        connect();
    }
    
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    private static void connect() {
        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
    	if (connection == null) {
    		connect();
    	}
        return connection;
    }

    public static void disconnect() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
