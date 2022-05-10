package Dao;

import JDBCUtils.Allentity;

import java.sql.Connection;
import java.util.List;

/**
 * @author hongxiaobin
 * @create 2022/3/2-22:01
 * @description
 */
public interface TicketDao {
    List<Allentity> getTicket(Connection connection);

    List<Allentity> getVsales(Connection connection);
}
