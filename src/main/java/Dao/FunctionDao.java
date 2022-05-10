package Dao;

import JDBCUtils.Allentity;

import java.sql.Connection;
import java.util.List;

/**
 * @author hongxiaobin
 * @create 2022/3/2-22:34
 * @description
 */
public interface FunctionDao {
    List<Allentity> getCity(Connection connection);
    List<Allentity> getArea(Connection connection);
    List<Allentity> getProvince(Connection connection);
    List<Allentity> getGoods(Connection connection);
    List<Allentity> getGoodslist(Connection connection);
}
