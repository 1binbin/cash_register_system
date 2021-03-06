package Dao;

import JDBCUtils.Allentity;
import com.example.cash_register_system.Function;

import java.sql.Connection;
import java.util.List;

/**
 * @author hongxiaobin
 * @create 2022/3/2-22:34
 * @description
 */
public class FunctionDaoImpl extends BaseDao<Allentity> implements FunctionDao {
    @Override
    public List<Allentity> getCity(Connection connection) {
        String sql = "select city from city where provinceID in (select provinceID from province where province = ?)";
        return getBeanList(connection, sql, Function.fristString);
    }

    @Override
    public List<Allentity> getArea(Connection connection) {
        String sql = "select * from area where cityID in (select cityID from city where city = ? and provinceID in (select provinceID from province where province = ?));";
        return getBeanList(connection, sql, Function.fristString, Function.secondString);
    }

    @Override
    public List<Allentity> getProvince(Connection connection) {
        String sql = "select province from province";
        return getBeanList(connection, sql);
    }

    @Override
    public List<Allentity> getGoods(Connection connection) {
        String sql = "select gcategory from goodsc";
        return getBeanList(connection, sql);
    }

    @Override
    public List<Allentity> getGoodslist(Connection connection) {
        String sql = "select * from goods , origin where goods.gsupplier = origin.gsupplier";
        return getBeanList(connection, sql);
    }
}
