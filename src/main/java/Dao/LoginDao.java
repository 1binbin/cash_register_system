package Dao;

import JDBCUtils.Allentity;

import java.sql.Connection;
import java.util.List;

/**
 * @author hongxiaobin
 * @create 2022/3/2-9:54
 * @description
 */
public interface LoginDao {
    /**查询所有员工编号*/
    List<Allentity> getEmployee(Connection connection);
    /**修改员工信息*/
    void updateEmployee(Connection connection);
    List<Allentity> getEcategory(Connection connection);
    List<Allentity> getGcategory(Connection connection);
    List<Allentity> getReficition(Connection connection);
    void insertGcategory(Connection connection);
    void insertEcategory(Connection connection);
    void insertReficition(Connection connection);
}
