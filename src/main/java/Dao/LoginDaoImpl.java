package Dao;

import JDBCUtils.Allentity;
import com.example.cash_register_system.LogininEvent;

import java.sql.Connection;
import java.util.List;

/**
 * @author hongxiaobin
 * @create 2022/3/2-9:54
 * @description
 */
public class LoginDaoImpl extends BaseDao<Allentity> implements LoginDao {
    @Override
    public List<Allentity> getEmployee(Connection connection) {
        String sql = "select * from employee";
        return getBeanList(connection, sql);
    }

    @Override
    public void updateEmployee(Connection connection) {
        String sql = "update employee set epassword = ? where eid = ?";
        update(connection, sql, LogininEvent.epassword, LogininEvent.eid);
    }

    @Override
    public List<Allentity> getEcategory(Connection connection) {
        String sql = "select * from employeec where erole = ?";
        return getBeanList(connection,sql,LogininEvent.fristString);
    }

    @Override
    public List<Allentity> getGcategory(Connection connection) {
        String sql = "select * from goodsc where gcategory = ?";
        return getBeanList(connection,sql,LogininEvent.fristString);
    }

    @Override
    public List<Allentity> getReficition(Connection connection) {
        String sql = "select * from reficition where specifications = ?";
        return getBeanList(connection,sql,LogininEvent.fristString);
    }

    @Override
    public void insertGcategory(Connection connection) {
        String sql = "insert into goodsc(gcategory) values (?)";
        update(connection,sql,LogininEvent.fristString);
    }

    @Override
    public void insertEcategory(Connection connection) {
        String sql = "insert into employeec(erole) values (?)";
        update(connection,sql,LogininEvent.fristString);
    }

    @Override
    public void insertReficition(Connection connection) {
        String sql = "insert into reficition(specifications) values (?)";
        update(connection,sql,LogininEvent.fristString);
    }
}
