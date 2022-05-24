import com.example.cash_register_system.Loginin;

import java.sql.Connection;

/**
 * 数据库连接测试方法
 *
 * @Author hongxiaobin
 * @Time 2022/5/24-15:23
 */
public class ConnectionTest {
    public static void main(String[] args) {
        try {
            Loginin loginin = new Loginin();
            loginin.init();
            Connection connection = Loginin.connection;
            System.out.println(connection);
            if (connection != null) {
                System.out.println("数据库连接正常");
            } else {
                System.out.println("数据库连接异常，请检查");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
