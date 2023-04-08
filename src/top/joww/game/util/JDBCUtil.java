package top.joww.game.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtil {
    static String driverClass;
    static String url;
    static String username;
    static String password;
    static {
        Properties properties = new Properties();
        InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(is);
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public List<String> sqlQuery(String sql, String[] keys) {
        List<String> ls = new ArrayList<>();
        try {
            statement = connection.createStatement();
            System.out.println("mysql> " + sql + ";");
            resultSet = statement.executeQuery(sql);
            ls.add(String.join("\t", keys));
            while (resultSet.next()) {
                String[] items = new String[keys.length];
                for (int k = 0; k < keys.length; k++) {
                    items[k] = String.valueOf(resultSet.getString(keys[k]));
                }
                ls.add(String.join("\t", items));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ls;
    }

    public boolean sqlExecute(String sql) {
        boolean ret = false;
        try {
            statement = connection.createStatement();
            System.out.println("mysql> " + sql + ";");
            ret = statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    public void connect() {
        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        this.connect();
        return connection;
    }

    public void disconnect() {
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

    void showTable(String select_sql, String[] keys) {
        List<String> lst = sqlQuery(select_sql, keys);
        for (String item : lst) {
            System.out.println(item);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] keys = { "id", "name", "cover_url", "created_at", "updated_at" };
        String select_sql = "SELECT `" + String.join("`,`", keys) + "` FROM `game`";

        JDBCUtil test = new JDBCUtil();

        // 连接
        test.connect();

        // 查询 0
        test.showTable(select_sql, keys);

        // 增加
        test.sqlExecute("INSERT INTO `game` (`id`, `name`, `cover_url`) VALUES ('7', 'surf', 'a.bc.def/pic.jpg')");
        // 查询 1
        test.showTable(select_sql, keys);

        // 修改
        test.sqlExecute("UPDATE `game` SET `cover_url` = 'gg.xyz/new.bmp' WHERE `id` = '7'");
        // 查询 2
        test.showTable(select_sql, keys);

        // 删除
        test.sqlExecute("DELETE FROM `game` WHERE `name` = 'surf'");
        // 查询 3
        test.showTable(select_sql, keys);

        // 断开连接
        test.disconnect();
    }
}
