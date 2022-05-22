package JDBCUtils;

import com.example.cash_register_system.Loginin;

import java.sql.Connection;

/**
 * @author hongxiaobin
 * @create 2021/12/11-20:46
 * @function 用于数据库连接和针对注册登录的操作
 */
@SuppressWarnings("ALL")
public class JdbcConnection {
    /**
     * 获取数据库连接
     *
     * @Param:
     * @Return:
     */
    public static Connection getConnection() throws Exception {
        return Loginin.connection;
    }
}