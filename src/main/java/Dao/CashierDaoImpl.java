package Dao;

import JDBCUtils.Allentity;
import com.example.cash_register_system.Cashierevent;

import java.sql.Connection;
import java.util.List;

/**
 * @author hongxiaobin
 * @create 2022/3/2-22:57
 * @description
 */
public class CashierDaoImpl extends BaseDao<Allentity> implements CashierDao {
    @Override
    public void deleteTickettid(Connection connection) {
        String sql = "delete from ticketc where tid = ?";
        update(connection, sql, Cashierevent.fristString);
    }

    @Override
    public void insertInsign(Connection connection) {
        String sql = "insert into insign(idate,ioutdate,eid) values(?,?,?)";
        update(connection, sql, Cashierevent.fristString, Cashierevent.secondString, Cashierevent.thirdString);
    }

    @Override
    public void deleteTickettidgid(Connection connection) {
        String sql = "delete from ticket where tid = ? and gid = ?";
        update(connection, sql, Cashierevent.fristString, Cashierevent.secondString);
    }
    /*收银中心*/

    @Override
    public List<Allentity> getGoodsgid(Connection connection) {
        String sql = "select * from goods ,origin where goods.gsupplier = origin.gsupplier and gid = ?";
        return getBeanList(connection, sql, Cashierevent.fristString);
    }

    @Override
    public List<Allentity> getTickettidgid(Connection connection) {
        String sql = "select * from ticket where tid = ? and gid = ?";
        return getBeanList(connection, sql, Cashierevent.fristString, Cashierevent.secondString);
    }

    @Override
    public void insertTicket(Connection connection) {
        String sql = "insert into ticket(tid,gid,tnum) values(?,?,?)";
        update(connection, sql, Cashierevent.fristString, Cashierevent.secondString, Cashierevent.thirdString);
    }

    @Override
    public void insertTicketc(Connection connection) {
        String sql = "insert into ticketc(tid) values(?)";
        update(connection, sql, Cashierevent.fristString);
    }


    @Override
    public void updateTicksttnum(Connection connection) {
        String sql = "update ticket set tnum = tnum + ?";
        update(connection, sql, Cashierevent.fristString);
    }

    @Override
    public void updateGoodsgnum(Connection connection) {
        String sql = "update goods set gnum = gnum - ?";
        update(connection, sql, Cashierevent.fristString);
    }

    @Override
    public Object getTicketsumtnum(Connection connection) {
        String sql = "select sum(tnum) from ticket where tid = ?";
        return getValue(connection, sql, Cashierevent.fristString);
    }

    @Override
    public Object getpPrice(Connection connection) {
        String sql = "select sum(goods.gpprice * tnum) from goods,ticket where goods.gid = ticket.gid and tid = ?";
        return getValue(connection, sql, Cashierevent.fristString);
    }

    @Override
    public Object getvPrice(Connection connection) {
        String sql = "select sum(goods.gvprice * tnum) from goods,ticket where goods.gid = ticket.gid and tid = ?";
        return getValue(connection, sql, Cashierevent.fristString);
    }

    @Override
    public List<Allentity> getTickettid(Connection connection) {
        String sql = "select * from ticketc where tid = ?";
        return getBeanList(connection, sql, Cashierevent.fristString);
    }

    @Override
    public List<Allentity> getVipcustomervid(Connection connection) {
        String sql = "select * from vipcustomer where vid = ?";
        return getBeanList(connection, sql, Cashierevent.fristString);
    }

    @Override
    public List<Allentity> getIntegralpvalue(Connection connection) {
        String sql = "select pvalue from integral";
        return getBeanList(connection, sql);
    }

    @Override
    public void insertVsales(Connection connection) {
        String sql = "insert into vsales(tid,vid,sdate,scash,eid,sintegral) values(?,?,?,?,?,?)";
        update(connection, sql, Cashierevent.fristString, Cashierevent.secondString, Cashierevent.thirdString, Cashierevent.fourthString, Cashierevent.fifthString, Cashierevent.sixthString);
    }

    @Override
    public void updateVipcostomervintegral(Connection connection) {
        String sql = "update vipcustomer set vintegral = vintegral + ?";
        update(connection, sql, Cashierevent.sixthString);
    }

    @Override
    public List<Allentity> getPsalespid(Connection connection) {
        String sql = "select * from psales where pid = ?";
        return getBeanList(connection, sql, Cashierevent.fristString);
    }

    @Override
    public void insertPsales(Connection connection) {
        String sql = "insert into psales(tid,pid,pdate,pcash,eid) values(?,?,?,?,?)";
        update(connection, sql, Cashierevent.fristString, Cashierevent.secondString, Cashierevent.thirdString, Cashierevent.fourthString, Cashierevent.fifthString);
    }

    @Override
    public List<Allentity> getVipcostomervodate(Connection connection) {
        String sql = "select vodate from vipcustomer where vid = ?";
        return getBeanList(connection, sql, Cashierevent.fristString);
    }

    @Override
    public List<Allentity> getGoods(Connection connection) {
        String sql = "select * from goods ,origin where goods.gsupplier = origin.gsupplier";
        return getBeanList(connection, sql);
    }

    @Override
    public List<Allentity> getGoodsgid1(Connection connection) {
        String sql = "select * from goods ,origin where goods.gsupplier = origin.gsupplier and gid like concat('%',?,'%')";
        return getBeanList(connection, sql, Cashierevent.fristString);
    }

    @Override
    public List<Allentity> getGoodsgname(Connection connection) {
        String sql = "select * from goods ,origin where goods.gsupplier = origin.gsupplier and gname like concat('%',?,'%')";
        return getBeanList(connection, sql, Cashierevent.fristString);
    }

    @Override
    public List<Allentity> getGoodsgcategory(Connection connection) {
        String sql = "select * from goods ,origin where goods.gsupplier = origin.gsupplier and gcategory like concat('%',?,'%') ";
        return getBeanList(connection, sql, Cashierevent.secondString);
    }

    @Override
    public List<Allentity> getGoodsgorigin(Connection connection) {
        String sql = "select * from goods ,origin where goods.gsupplier = origin.gsupplier and goods.gorigin like concat('%',?,'%') ";
        return getBeanList(connection, sql, Cashierevent.thirdString);
    }

    @Override
    public List<Allentity> getGoodsgsupplier(Connection connection) {
        String sql = "select * from goods ,origin where goods.gsupplier = origin.gsupplier and gindate between concat('%',?,'%') and concat('%',?,'%')";
        return getBeanList(connection, sql, Cashierevent.fourthString, Cashierevent.fifthString);
    }

    @Override
    public List<Allentity> getGoodsgindate(Connection connection) {
        String sql = "select vodate from vipcustomer where vid = ?";
        return getBeanList(connection, sql, Cashierevent.fristString);
    }

    /*小票查询*/
    @Override
    public Object getTicktesumtnum(Connection connection) {
        String sql = "select sum(tnum) from ticket where tid = ?";
        return getValue(connection, sql, Cashierevent.fristString);
    }

    @Override
    public List<Allentity> getTickettid1(Connection connection) {
        String sql = "select * from vsales where tid like concat('%',?,'%') union all select tid, pid vid, pdate sdate, pcash scash, eid, 0 sintegral from psales where tid like concat('%',?,'%')";
        return getBeanList(connection, sql, Cashierevent.fristString, Cashierevent.fristString);
    }

    @Override
    public List<Allentity> getTicketvid(Connection connection) {
        String sql = "select * from vsales where vid like concat('%',?,'%') union all select tid, pid vid, pdate sdate, pcash scash, eid, 0 sintegral from psales where pid like concat('%',?,'%')";
        return getBeanList(connection, sql, Cashierevent.fristString, Cashierevent.fristString);
    }

    @Override
    public List<Allentity> getTicketsdate(Connection connection) {
        String sql = "select * from vsales where sdate >= ? and sdate <= ? union all select tid, pid vid, pdate sdate, pcash scash, eid, 0 sintegral from psales where  pdate >= ? and pdate <= ? ";
        return getBeanList(connection, sql, Cashierevent.secondString,Cashierevent.thirdString, Cashierevent.secondString,Cashierevent.thirdString);
    }

    @Override
    public List<Allentity> getTicketeid(Connection connection) {
        String sql = "select * from vsales where eid like concat('%',?,'%') union all select tid, pid vid, pdate sdate, pcash scash, eid, 0 sintegral from psales where eid like concat('%',?,'%')";
        return getBeanList(connection, sql, Cashierevent.fristString, Cashierevent.fristString);
    }

    @Override
    public List<Allentity> getSales(Connection connection) {
        String sql = "select tid,pid vid,pdate sdate,pcash scash,eid,0 sintegral from psales union all select * from vsales";
        return getBeanList(connection, sql);
    }

    @Override
    public List<Allentity> getpSales(Connection connection) {
        String sql = "select tid,goods.gid,gname,gcategory,gpprice gprice,tnum,(goods.gpprice * tnum)sumprice from goods,ticket where goods.gid = ticket.gid and tid = ?";
        return getBeanList(connection, sql,Cashierevent.fristString);
    }

    @Override
    public List<Allentity> getvSales(Connection connection) {
        String sql = "select tid,goods.gid,gname,gcategory,gvprice gprice,tnum,(goods.gvprice * tnum)sumprice from goods,ticket where goods.gid = ticket.gid and tid = ?";
        return getBeanList(connection, sql,Cashierevent.fristString);
    }
    /*会员中心*/

    @Override
    public void updateVipcustomer(Connection connection) {
        String sql ="update vipcustomer set vstate = ? where vodate = ?";
        update(connection,sql,Cashierevent.fristString,Cashierevent.secondString);
    }

    @Override
    public void updateVipcustomerall(Connection connection) {
        String sql ="update vipcustomer set vodate = ? ,vstate = ? where vid = ?";
        update(connection,sql,Cashierevent.fristString,Cashierevent.secondString,Cashierevent.thirdString);
    }

    @Override
    public void updateVipcustomerchange(Connection connection) {
        String sql ="update vipcustomer set vintegral = vintegral - ? where vid = ?";
        update(connection,sql,Cashierevent.fristString,Cashierevent.secondString);
    }

    @Override
    public void insertVipcustomer(Connection connection) {
        String sql = "insert into vipcustomer(vid,vname,vsex,vphone,vintegral,vrdate,vodate,vstate) value(?,?,?,?,?,?,?,?)";
        update(connection,sql,Cashierevent.fristString, Cashierevent.secondString, Cashierevent.thirdString, Cashierevent.fourthString, Cashierevent.fifthString,Cashierevent.sixthString,Cashierevent.seventhString,Cashierevent.eighthString);
    }

    @Override
    public void deleteVipcustomer(Connection connection) {
        String sql  ="delete from vipcustomer where vid = ?";
        update(connection,sql,Cashierevent.fristString);
    }

    @Override
    public void updateVipcustomerall1(Connection connection) {
        String sql  ="update vipcustomer set vname = ? , vsex = ? , vphone = ? , vintegral = ? where vid = ?";
        update(connection,sql,Cashierevent.fristString, Cashierevent.secondString, Cashierevent.thirdString, Cashierevent.fourthString, Cashierevent.fifthString);
    }

    @Override
    public List<Allentity> getVipcustomervid1(Connection connection) {
        String sql  ="select * from vipcustomer where vid like concat('%',?,'%')";
        return getBeanList(connection,sql,Cashierevent.fristString);
    }

    @Override
    public List<Allentity> getVipcustomervname(Connection connection) {
        String sql  ="select * from vipcustomer where vname like concat('%',?,'%')";
        return getBeanList(connection,sql,Cashierevent.fristString);
    }

    @Override
    public List<Allentity> getVipcustomervphone(Connection connection) {
        String sql  ="select * from vipcustomer where vphone like concat('%',?,'%')";
        return getBeanList(connection,sql,Cashierevent.fristString);
    }

    @Override
    public List<Allentity> getVipcustomer(Connection connection) {
        String sql = "select * from vipcustomer";
        return getBeanList(connection,sql);
    }
    /*个人中心*/

    @Override
    public List<Allentity> getPsqlessql(Connection connection) {
        String sql  ="select * from vsales where eid = ? union all select tid, pid vid, pdate sdate, pcash scash, eid, 0 sintegral from psales where eid = ?";
        return getBeanList(connection,sql,Cashierevent.fristString,Cashierevent.fristString);
    }

    @Override
    public Object getPsalesvsql(Connection connection) {
        String sql  ="select sum(goods.gvprice * ticket.tnum) from goods,ticket,vsales where goods.gid = ticket.gid and vsales.tid = ticket.tid and eid = ?";
        return getValue(connection,sql,Cashierevent.fristString);
    }

    @Override
    public Object getPsalespsql(Connection connection) {
        String sql  ="select sum(goods.gpprice * ticket.tnum) from goods,ticket,psales where goods.gid = ticket.gid and psales.tid = ticket.tid and eid = ?";
        return getValue(connection,sql,Cashierevent.fristString);
    }

    @Override
    public Object getPsalesvcount(Connection connection) {
        String sql  ="select count(distinct tid) from vsales where eid = ?";
        return getValue(connection,sql,Cashierevent.fristString);
    }

    @Override
    public Object getPsalespcount(Connection connection) {
        String sql  ="select count(distinct tid) from psales where eid = ?";
        return getValue(connection,sql,Cashierevent.fristString);
    }

    @Override
    public List<Allentity> getPsqlessqltid(Connection connection) {
        String sql  ="select * from vsales where eid = ? and tid like concat('%',?,'%') union all select tid, pid vid, pdate sdate, pcash scash, eid, 0 sintegral from psales where eid = ? and tid like concat('%',?,'%')";
        return getBeanList(connection,sql,Cashierevent.fristString,Cashierevent.secondString,Cashierevent.fristString,Cashierevent.secondString);
    }

    @Override
    public Object getPsalesvsqltid(Connection connection) {
        String sql = "select sum(goods.gvprice * ticket.tnum) from goods,ticket,vsales where goods.gid = ticket.gid and vsales.tid = ticket.tid  and eid = ? and vsales.tid like concat('%',?,'%')";
        return getValue(connection,sql,Cashierevent.fristString,Cashierevent.secondString);
    }

    @Override
    public Object getPsalespsqltid(Connection connection) {
        String sql  ="select sum(goods.gpprice * ticket.tnum) from goods,ticket,psales where goods.gid = ticket.gid and psales.tid = ticket.tid  and eid = ?  and psales.tid like concat('%',?,'%')";
        return getValue(connection,sql,Cashierevent.fristString,Cashierevent.secondString);
    }

    @Override
    public Object getPsalesvcounttid(Connection connection) {
        String sql  ="select count(distinct tid) from vsales where eid = ? and tid like concat('%',?,'%')";
        return getValue(connection,sql,Cashierevent.fristString,Cashierevent.secondString);
    }

    @Override
    public Object getPsalespcounttid(Connection connection) {
        String sql  ="select count(distinct tid) from psales where eid = ? and tid like concat('%',?,'%')";
        return getValue(connection,sql,Cashierevent.fristString,Cashierevent.secondString);
    }

    @Override
    public List<Allentity> getPsqlessqlvid(Connection connection) {
        String sql  ="select * from vsales where eid = ? and vid like concat('%',?,'%') union all select tid, pid vid, pdate sdate, pcash scash, eid, 0 sintegral from psales where eid = ? and pid like concat('%',?,'%')";
        return getBeanList(connection,sql,Cashierevent.fristString,Cashierevent.secondString,Cashierevent.fristString,Cashierevent.secondString);
    }

    @Override
    public Object getPsalesvsqlvid(Connection connection) {
        String sql  ="select sum(goods.gvprice * ticket.tnum) from goods,ticket,vsales where goods.gid = ticket.gid and vsales.tid = ticket.tid  and eid = ? and vid like concat('%',?,'%')";
        return getValue(connection,sql,Cashierevent.fristString,Cashierevent.secondString);
    }

    @Override
    public Object getPsalespsqlvid(Connection connection) {
        String sql  ="select sum(goods.gpprice * ticket.tnum) from goods,ticket,psales where goods.gid = ticket.gid and psales.tid = ticket.tid  and eid = ? and pid like concat('%',?,'%')";
        return getValue(connection,sql,Cashierevent.fristString,Cashierevent.secondString);
    }

    @Override
    public Object getPsalesvcountvid(Connection connection) {
        String sql  ="select count(distinct tid) from vsales where eid = ? and vid like concat('%',?,'%')";
        return getValue(connection,sql,Cashierevent.fristString,Cashierevent.secondString);
    }

    @Override
    public Object getPsalespcountvid(Connection connection) {
        String sql  ="select count(distinct tid) from psales where eid = ? and pid like concat('%',?,'%')";
        return getValue(connection,sql,Cashierevent.fristString,Cashierevent.secondString);
    }

    @Override
    public List<Allentity> getPsqlessqldate(Connection connection) {
        String sql  ="select * from vsales where eid = ? and sdate >= ? and sdate <= ? union all select tid, pid vid, pdate sdate, pcash scash, eid, 0 sintegral from psales where eid = ? and pdate >= ? and pdate <= ?";
        return getBeanList(connection,sql,Cashierevent.fristString,Cashierevent.thirdString,Cashierevent.fourthString,Cashierevent.fristString,Cashierevent.thirdString,Cashierevent.fourthString);
    }

    @Override
    public Object getPsalesvsqldate(Connection connection) {
        String sql  ="select sum(goods.gvprice * ticket.tnum) from goods,ticket,vsales where goods.gid = ticket.gid and vsales.tid = ticket.tid  and eid = ? and sdate >= ? and sdate <= ?";
        return getValue(connection,sql,Cashierevent.fristString,Cashierevent.thirdString,Cashierevent.fourthString);
    }

    @Override
    public Object getPsalespsqldate(Connection connection) {
        String sql  ="select sum(goods.gpprice * ticket.tnum) from goods,ticket,psales where goods.gid = ticket.gid and psales.tid = ticket.tid  and eid = ? and pdate >= ? and pdate <= ?";
        return getValue(connection,sql,Cashierevent.fristString,Cashierevent.thirdString,Cashierevent.fourthString);
    }

    @Override
    public Object getPsalesvcountdate(Connection connection) {
        String sql  ="select count(distinct tid) from vsales where eid = ? and sdate >= ? and sdate <= ?";
        return getValue(connection,sql,Cashierevent.fristString,Cashierevent.thirdString,Cashierevent.fourthString);
    }

    @Override
    public Object getPsalespcountdate(Connection connection) {
        String sql  ="select count(distinct tid) from psales where eid = ? and pdate >= ? and pdate <= ?";
        return getValue(connection,sql,Cashierevent.fristString,Cashierevent.thirdString,Cashierevent.fourthString);
    }

    @Override
    public List<Allentity> setTbalerefresh(Connection connection) {
        String sql = "select * from ticketc where tid = '000000000000'";
        return getBeanList(connection,sql);
    }

    @Override
    public List<Allentity> getEmployee(Connection connection) {
        String sql = "select * from employee where eid = ?";
        return getBeanList(connection,sql,Cashierevent.fristString);
    }

    @Override
    public Object gteVssql(Connection connection) {
        String sql  ="select count(distinct tid) from vsales where eid = ? and sdate >= ? and sdate <= ?";
        return getValue(connection,sql,Cashierevent.fristString,Cashierevent.secondString,Cashierevent.thirdString);
    }

    @Override
    public Object gtePssql(Connection connection) {
        String sql  ="select count(distinct tid) from psales where eid = ? and  pdate >= ? and pdate <= ?";
        return getValue(connection,sql,Cashierevent.fristString,Cashierevent.secondString,Cashierevent.thirdString);
    }

    @Override
    public Object gteVsql(Connection connection) {
        String sql  ="select sum(goods.gvprice * ticket.tnum) from goods,ticket,vsales where goods.gid = ticket.gid and vsales.tid = ticket.tid and eid = ? and sdate >= ? and sdate <= ?";
        return getValue(connection,sql,Cashierevent.fristString,Cashierevent.secondString,Cashierevent.thirdString);
    }

    @Override
    public Object gtePsql(Connection connection) {
        String sql  ="select sum(goods.gpprice * ticket.tnum) from goods,ticket,psales where goods.gid = ticket.gid and psales.tid = ticket.tid and eid = ? and  pdate >= ? and pdate <= ?";
        return getValue(connection,sql,Cashierevent.fristString,Cashierevent.secondString,Cashierevent.thirdString);
    }

    @Override
    public void updateEmployeeename(Connection connection) {
        String sql  ="update employee set ename = ? where eid = ?";
        update(connection,sql,Cashierevent.fristString,Cashierevent.secondString);
    }

    @Override
    public void updateEmployeeephone(Connection connection) {
        String sql  ="update employee set ephone = ? where eid = ?";
        update(connection,sql,Cashierevent.fristString,Cashierevent.secondString);
    }

    @Override
    public void updateEmployeeeadd(Connection connection) {
        String sql  ="update employee set eaddress = ? ,edaddress = ? where eid = ?";
        update(connection,sql,Cashierevent.fristString,Cashierevent.secondString,Cashierevent.thirdString);
    }

    @Override
    public void updateEmployeeebirthday(Connection connection) {
        String sql  ="update employee set ebirthday = ? where eid = ?";
        update(connection,sql,Cashierevent.fristString,Cashierevent.secondString);
    }

    @Override
    public void updateEmployeesex(Connection connection) {
        String sql  ="update employee set esex = ? where eid = ?";
        update(connection,sql,Cashierevent.fristString,Cashierevent.secondString);
    }
    /*修改密码*/

    @Override
    public void updateEmployeeepassword(Connection connection) {
        String sql = "update employee set epassword = ? where eid = ?";
        update(connection, sql, Cashierevent.fristString, Cashierevent.secondString);
    }

    @Override
    public List<Allentity> getTicket(Connection connection) {
        String sql = "select tid from ticketc where tid = ?";
        return getBeanList(connection, sql, Cashierevent.fristString);
    }

    @Override
    public List<Allentity> getIntegral(Connection connection) {
        String sql = "select vintegral from vipcustomer where vid = ?";
        return getBeanList(connection, sql, Cashierevent.secondString);
    }
}
