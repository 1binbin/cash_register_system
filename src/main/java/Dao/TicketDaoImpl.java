package Dao;

import JDBCUtils.Allentity;
import com.example.cash_register_system.Ticketevent;

import java.sql.Connection;
import java.util.List;

/**
 * @author hongxiaobin
 * @create 2022/3/2-22:01
 * @description
 */
public class TicketDaoImpl extends BaseDao<Allentity> implements TicketDao {
    @Override
    public List<Allentity> getTicket(Connection connection) {
        String sql = "select tid,goods.gid,gname,gcategory,gpprice ,gvprice,tnum,specifications from goods,ticket where goods.gid = ticket.gid and tid = ?";
        return getBeanList(connection, sql, Ticketevent.fristString);
    }

    @Override
    public List<Allentity> getVsales(Connection connection) {
        String sql = "select vintegral,sintegral from vipcustomer,vsales where vsales.vid  = vipcustomer.vid and vsales.vid = ?";
        return getBeanList(connection, sql, Ticketevent.secondString);
    }
}
