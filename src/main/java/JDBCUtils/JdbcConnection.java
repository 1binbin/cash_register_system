package JDBCUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author hongxiaobin
 * @create 2021/12/11-20:46
 * @function 用于数据库连接和针对注册登录的操作
 */
@SuppressWarnings("ALL")
public class JdbcConnection {
    /*连接数据库*/
    public static Connection getConnection() throws Exception {
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        String driver = properties.getProperty("driver");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}