package Dao;

import JDBCUtils.Allentity;
import com.example.cash_register_system.Adminevent;

import java.sql.Connection;
import java.util.List;

/**
 * @author hongxiaobin
 * @create 2022/3/2-10:33
 * @description
 */
public class AdminDaoImpl extends BaseDao<Allentity> implements AdminDao{
    @Override
    public Object getGidcount(Connection connection) {
        String sql = "select count(distinct gid) from goods where date_format(gindate,'%Y-%m-%d')>=date_format(?,'%Y-%m-%d') and date_format(gindate,'%Y-%m-%d')<=date_format(?,'%Y-%m-%d')";
        return getValue(connection,sql, Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public Object getGidcount1(Connection connection) {
        String sql = "select count(distinct gid) from goods where date_format(gindate,'%Y-%m-%d')>=date_format(?,'%Y-%m-%d') and date_format(gindate,'%Y-%m-%d')<=date_format(?,'%Y-%m-%d') and gid = ?";
        return getValue(connection,sql, Adminevent.fristString,Adminevent.secondString,Adminevent.thirdString);
    }

    @Override
    public Object getSumgpurchaseprice(Connection connection) {
        String sql = "select sum(gpurchaseprice) from goods where date_format(gindate,'%Y-%m-%d')>=date_format(?,'%Y-%m-%d') and date_format(gindate,'%Y-%m-%d')<=date_format(?,'%Y-%m-%d')";
        return getValue(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }
    @Override
    public Object getSumgpurchaseprice1(Connection connection) {
        String sql = "select sum(gpurchaseprice) from goods where date_format(gindate,'%Y-%m-%d')>=date_format(?,'%Y-%m-%d') and date_format(gindate,'%Y-%m-%d')<=date_format(?,'%Y-%m-%d') and gid = ?";
        return getValue(connection,sql,Adminevent.fristString,Adminevent.secondString,Adminevent.thirdString);
    }

    @Override
    public void deleteGoods(Connection connection) {
        String sql = "delete from goods where gid = ?";
        update(connection,sql,Adminevent.fristString);
    }

    @Override
    public List<Allentity> getGidlist(Connection connection) {
        String sql = "select gid from goods where gid = ?";
        return getBeanList(connection,sql,Adminevent.fristString);
    }
/**
* 获取所有商品信息*/
    @Override
    public List<Allentity> getGoods(Connection connection) {
        String sql = "select * from goods,origin where goods.gsupplier = origin.gsupplier";
        return getBeanList(connection,sql);
    }
    /*商品搜索界面*/

    @Override
    public List<Allentity> getGoodsgid(Connection connection) {
        String sql = "select * from goods ,origin where goods.gsupplier = origin.gsupplier and gid like concat('%',?,'%')";
        return getBeanList(connection,sql,Adminevent.fristString);
    }

    @Override
    public List<Allentity> getGoodsgname(Connection connection) {
        String sql = "select * from goods ,origin where goods.gsupplier = origin.gsupplier and gname like concat('%',?,'%')";
        return getBeanList(connection,sql,Adminevent.fristString);
    }

    @Override
    public List<Allentity> getGoodsgcategory(Connection connection) {
        String sql = "select * from goods ,origin where goods.gsupplier = origin.gsupplier and gcategory like concat('%',?,'%')";
        return getBeanList(connection,sql,Adminevent.fristString);
    }

    @Override
    public List<Allentity> getGoodsgorigin(Connection connection) {
        String sql = "select * from goods , origin where  goods.gsupplier = origin.gsupplier and gorigin like concat('%',?,'%')";
        return getBeanList(connection,sql,Adminevent.fristString);
    }

    @Override
    public List<Allentity> getGoodsgsupplier(Connection connection) {
        String sql = "select * from goods ,origin where goods.gsupplier = origin.gsupplier and goods.gsupplier like concat('%',?,'%')";
        return getBeanList(connection,sql,Adminevent.fristString);
    }

    @Override
    public List<Allentity> getGoodsgindate(Connection connection) {
        String sql = "select * from goods ,origin where goods.gsupplier = origin.gsupplier and gindate between ? and ?";
        return getBeanList(connection, sql, Adminevent.fristString, Adminevent.secondString);
    }

    /*批量上传界面*/

    @Override
    public List<Allentity> isGsupplier(Connection connection) {
        String sql = "select * from origin where gsupplier = ?";
        return getBeanList(connection, sql, Adminevent.fifthString);
    }

    @Override
    public void insertGsupplier(Connection connection) {
        String sql = "insert into origin(gorigin,gsupplier) value (?,?)";
        update(connection, sql, Adminevent.fourthString, Adminevent.fifthString);
    }

    @Override
    public void insertGoods(Connection connection) {
        String sql = "insert into goods(gid,gname,gcategory,gsupplier,gindate,gnum,specifications,gpurchaseprice,gpprice,gdiscount) values(?,?,?,?,?,?,?,?,?,?)";
        update(connection, sql, Adminevent.fristString, Adminevent.secondString, Adminevent.thirdString, Adminevent.fifthString, Adminevent.sixthString, Adminevent.seventhString, Adminevent.eighthString, Adminevent.ninthString, Adminevent.tenthString, Adminevent.eleventhString);
    }

    @Override
    public List<Allentity> getGcategory(Connection connection) {
        String sql = "select * from goodsc where gcategory = ?";
        return getBeanList(connection, sql, Adminevent.fristString);
    }

    @Override
    public List<Allentity> getReficition(Connection connection) {
        String sql = "select * from reficition where specifications = ?";
        return getBeanList(connection,sql,Adminevent.fristString);
    }

    @Override
    public List<Allentity> getGcategory1(Connection connection) {
        String sql = "select * from goodsc";
        return getBeanList(connection,sql);
    }

    @Override
    public List<Allentity> getGoodsgid1(Connection connection) {
        String sql = "select * from goods ,origin where goods.gsupplier = origin.gsupplier and gid = ?";
        return getBeanList(connection,sql,Adminevent.fristString);
    }

    @Override
    public void updateGoods(Connection connection) {
        String sql = "update goods set gname = ? , gcategory = ? ,  gsupplier = ? , gindate = ? , gnum = gnum + ? , specifications = ? , gpurchaseprice = ? , gpprice = ? , gdiscount = ? where gid = ?";
        update(connection, sql, Adminevent.secondString, Adminevent.thirdString, Adminevent.fifthString, Adminevent.sixthString, Adminevent.seventhString, Adminevent.eighthString, Adminevent.ninthString, Adminevent.tenthString, Adminevent.eleventhString, Adminevent.fristString);
    }

    @Override
    public List<Allentity> getEmployeeemployee(Connection connection) {
        String sql = "select * from employeec where erole = ?";
        return getBeanList(connection ,sql,Adminevent.fristString);
    }

    @Override
    public void insertEmployee(Connection connection) {
        String sql = "insert into employee(eid,ename,epassword,erole,eaddress,edaddress,ephone,esex,esalary) values(?,?,?,?,?,?,?,?,?)";
        update(connection,sql,Adminevent.fristString,Adminevent.secondString,Adminevent.thirdString,Adminevent.fourthString,Adminevent.fifthString,Adminevent.sixthString,Adminevent.seventhString,Adminevent.eighthString,Adminevent.ninthString);
    }

    @Override
    public List<Allentity> getEmployeeeid(Connection connection) {
        String sql = "select * from employee where eid = ?";
        return getBeanList(connection,sql,Adminevent.fristString);
    }
    /*员工删除*/

    @Override
    public void deleteEmloyee(Connection connection) {
        String sql = "delete from employee where eid = ?";
        update(connection,sql,Adminevent.fristString);
    }
    /*搜索规格*/

    @Override
    public List<Allentity> getReficitionsreficition(Connection connection) {
        String sql = "select * from reficition";
        return getBeanList(connection,sql);
    }
    /*修改商品信息界面*/

    @Override
    public void updateGoodsgid(Connection connection) {
        String sql = "update goods set gid = ? where gid = ?";
        update(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public void updateGoodsganme(Connection connection) {
        String sql = "update goods set gname = ? where gid = ?";
        update(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public void updateGoodsgcategory(Connection connection) {
        String sql = "update goods set gcategory = ? where gid = ?";
        update(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public void updateGoodsspecification(Connection connection) {
        String sql = "update goods set specifications = ? where gid = ?";
        update(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public void updateGoodsgorigin(Connection connection) {
        String sql = "update origin set gorigin = ? where gsupplier =?";
        update(connection, sql, Adminevent.thirdString, Adminevent.secondString);
    }

    @Override
    public void updateGoodsgsupplier(Connection connection) {
        String sql = "update goods set gsupplier = ? where gid = ?";
        update(connection, sql, Adminevent.fifthString, Adminevent.secondString);
    }

    public List<Allentity> getGorigin(Connection connection) {
        String sql = "select gorigin from goods , origin where goods.gsupplier =  origin.gsupplier and gid = ?";
        return getBeanList(connection, sql, Adminevent.secondString);
    }

    @Override
    public void updateGoodsggindate(Connection connection) {
        String sql = "update goods set gindate = ? where gid = ?";
        update(connection, sql, Adminevent.fristString, Adminevent.secondString);
    }

    @Override
    public void updateGoodsggnum(Connection connection) {
        String sql = "update goods set gnum = ? where gid = ?";
        update(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public void updateGoodsgpurchasepriee(Connection connection) {
        String sql = "update goods set gpurchaseprice = ? where gid = ?";
        update(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public void updateGoodsgprice(Connection connection) {
        String sql = "update goods set gpprice = ? where gid = ?";
        update(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public void updateGoodsdiscount(Connection connection) {
        String sql = "update goods set gdiscount = ? where gid = ?";
        update(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }
    /*员工管理界面*/

    @Override
    public List<Allentity> getEcategory(Connection connection) {
        String sql = "select erole from employeec where erole = ?";
        return getBeanList(connection,sql,Adminevent.fristString);
    }

    @Override
    public List<Allentity> getEmployeeesex(Connection connection) {
        String sql = "select * from employee where esex = ?";
        return getBeanList(connection,sql,Adminevent.fristString);
    }

    @Override
    public List<Allentity> getEmployee(Connection connection) {
        String sql = "select * from employee";
        return getBeanList(connection ,sql);
    }
    /*员工修改信息*/

    @Override
    public void updateEmployee(Connection connection) {
        String sql = "update employee set ename = ? , esex = ? , eaddress = ? , edaddress = ? ,erole = ?,esalary = ? where eid = ?";
        update(connection,sql,Adminevent.fristString,Adminevent.secondString,Adminevent.thirdString,Adminevent.fourthString,Adminevent.fifthString,Adminevent.sixthString,Adminevent.seventhString);
    }
    /*员工搜索界面*/

    @Override
    public List<Allentity> selectEmployeeeid(Connection connection) {
        String sql = "select eid,ename,erole,eaddress,edaddress,ephone,esex,round(timestampdiff(year,ebirthday,now()))eage, ebirthday from employee where eid like concat('%',?,'%')";
        return getBeanList(connection, sql, Adminevent.secondString);
    }

    @Override
    public List<Allentity> selectEmployeeename(Connection connection) {
        String sql = "select eid,ename,erole,eaddress,edaddress,ephone,esex,round(timestampdiff(year,ebirthday,now()))eage, ebirthday from employee where ename like concat('%',?,'%')";
        return getBeanList(connection, sql, Adminevent.secondString);
    }

    @Override
    public List<Allentity> selectEmployeeeaddress(Connection connection) {
        String sql = "select eid,ename,erole,eaddress,edaddress,ephone,esex,round(timestampdiff(year,ebirthday,now()))eage, ebirthday from employee where eaddress like concat('%',?,'%') and edaddress like concat('%',?,'%')";
        return getBeanList(connection, sql, Adminevent.secondString, Adminevent.thirdString);
    }

    @Override
    public List<Allentity> selectEmployeeephone(Connection connection) {
        String sql = "select eid,ename,erole,eaddress,edaddress,ephone,esex,round(timestampdiff(year,ebirthday,now()))eage, ebirthday from employee where ephone like concat('%',?,'%') ";
        return getBeanList(connection, sql, Adminevent.secondString);
    }

    @Override
    public List<Allentity> selectEmployeeerole(Connection connection) {
        String sql = "select eid,ename,erole,eaddress,edaddress,ephone,esex,round(timestampdiff(year,ebirthday,now()))eage, ebirthday from employee where erole = ?";
        return getBeanList(connection, sql, Adminevent.secondString);
    }
    @Override
    public List<Allentity> selectEmployeeesex(Connection connection) {
        String sql = "select eid,ename,erole,eaddress,edaddress,ephone,esex,round(timestampdiff(year,ebirthday,now()))eage, ebirthday from employee where esex = ?";
        return getBeanList(connection, sql, Adminevent.secondString);
    }

    @Override
    public List<Allentity> getEmployeetable(Connection connection) {
        String sql = "select eid,ename,erole,eaddress,edaddress,ephone,esex,round(timestampdiff(year,ebirthday,now()))eage, ebirthday ,esalary from employee";
        return getBeanList(connection, sql);
    }

    @Override
    public List<Allentity> getIntegral(Connection connection) {
        String sql = "select * from integral";
        return getBeanList(connection,sql);
    }

    @Override
    public void insertIntegral(Connection connection) {
        String sql = "insert into integral values(?,?)";
        update(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public void updateIntegral(Connection connection) {
        String sql = "update integral set ivalue = ? , pvalue = ?";
        update(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public List<Allentity> getGcategorygoods(Connection connection) {
        String sql = "select gcategory from goodsc";
        return getBeanList(connection,sql);
    }
    @Override
    public List<Allentity> getEcategoryemployee(Connection connection) {
        String sql = "select * from employeec";
        return getBeanList(connection,sql);
    }
    /*类别管理界面*/

    @Override
    public void insertGcategory(Connection connection) {
        String sql = "insert into goodsc(gcategory) values(?)";
        update(connection,sql,Adminevent.fristString);
    }
    @Override
    public void deleteGcategory(Connection connection) {
        String sql = "delete from goodsc where gcategory = ?";
        update(connection,sql,Adminevent.fristString);
    }

    @Override
    public void updateGcategory(Connection connection) {
        String sql = "update goodsc set gcategory = ? where gcategory = ?";
        update(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public void insertEcategory(Connection connection) {
        String sql = "insert into employeec(erole) values(?)";
        update(connection,sql,Adminevent.fristString);
    }

    @Override
    public void deleteEcategory(Connection connection) {
        String sql = "delete from employeec where erole = ?";
        update(connection,sql,Adminevent.fristString);
    }

    @Override
    public void updateEcategory(Connection connection) {
        String sql = "update employeec set erole = ? where erole = ?";
        update(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public void insertReficitions(Connection connection) {
        String sql = "insert into reficition(specifications) values(?)";
        update(connection,sql,Adminevent.fristString);
    }

    @Override
    public void deleteReficitions(Connection connection) {
        String sql = "delete from reficition where specifications = ?";
        update(connection,sql,Adminevent.fristString);
    }

    @Override
    public void updateReficitions(Connection connection) {
        String sql = "update reficition set specifications = ? where specifications = ?";
        update(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public List<Allentity> getReficitions(Connection connection) {
        String sql = "select specifications from reficition where specifications = ?";
        return getBeanList(connection,sql,Adminevent.fristString);
    }
    /*功能事件*/

    @Override
    public List<Allentity> getGpprice(Connection connection) {
        String sql = "select tid,goods.gid,gname,gcategory,gpprice gprice,tnum,(goods.gpprice * tnum)sumprice ,specifications from goods,ticket where goods.gid = ticket.gid and tid = ?";
        return getBeanList(connection,sql,Adminevent.fristString);
    }

    @Override
    public List<Allentity> getGvprice(Connection connection) {
        String sql = "select tid,goods.gid,gname,gcategory,gvprice gprice,tnum,(goods.gvprice * tnum)sumprice ,specifications from goods,ticket where goods.gid = ticket.gid and tid = ?";
        return getBeanList(connection,sql,Adminevent.fristString);
    }

    @Override
    public List<Allentity> setRefresh(Connection connection) {
        String sql = "select * from ticket where tid = '000000000000'";
        return getBeanList(connection,sql);
    }
    /*销售记录*/

    @Override
    public List<Allentity> getPsales(Connection connection) {
        String sql = "select * from vsales union all select tid, pid vid, pdate sdate, pcash scash, eid, 0 sintegral from psales ";
        return getBeanList(connection,sql);
    }

    @Override
    public Object getSumvprice(Connection connection) {
        String sql ="select sum(goods.gvprice * ticket.tnum) from goods,ticket,vsales where goods.gid = ticket.gid and vsales.tid = ticket.tid ";
        return getValue(connection,sql);
    }

    @Override
    public Object getSumpprice(Connection connection) {
        String sql ="select sum(goods.gpprice * ticket.tnum) from goods,ticket,psales where goods.gid = ticket.gid and psales.tid = ticket.tid ";
        return getValue(connection,sql);
    }

    @Override
    public Object getCountvtid(Connection connection) {
        String sql ="select count(distinct tid) from vsales ";
        return getValue(connection,sql);
    }

    @Override
    public Object getCountptid(Connection connection) {
        String sql ="select count(distinct tid) from psales ";
        return getValue(connection,sql);
    }

    @Override
    public List<Allentity> getSaleoutdate1(Connection connection) {
        String sql ="select ticket.tid,vid,vsales.eid,ename,sdate,scash,sintegral,ticket.gid,gname,gcategory,gpprice,gvprice,tnum,specifications from ticket,vsales,goods,employee where ticket.gid = goods.gid and ticket.tid = vsales.tid and vsales.eid = employee.eid union all select ticket.tid,pid,psales.eid,ename,pdate,pcash,0 sintegral,ticket.gid,gname,gcategory,gpprice,gvprice,tnum,specifications from ticket,psales,goods,employee where ticket.gid = goods.gid and ticket.tid = psales.tid and psales.eid = employee.eid";
        return getBeanList(connection,sql);
    }

    @Override
    public List<Allentity> getPsalestid(Connection connection) {
        String sql ="select * from vsales where tid like concat('%',?,'%') union all select tid, pid vid, pdate sdate, pcash scash, eid, 0 sintegral from psales where tid like concat('%',?,'%')";
        return getBeanList(connection,sql,Adminevent.fristString,Adminevent.fristString);
    }

    @Override
    public Object getSumvpricetid(Connection connection) {
        String sql ="select sum(goods.gvprice * ticket.tnum) from goods,ticket,vsales where goods.gid = ticket.gid and vsales.tid = ticket.tid and vsales.tid like concat('%',?,'%') ";
        return getValue(connection,sql,Adminevent.fristString);
    }

    @Override
    public Object getSumppricetid(Connection connection) {
        String sql ="select sum(goods.gpprice * ticket.tnum) from goods,ticket,psales where goods.gid = ticket.gid and psales.tid = ticket.tid and psales.tid like concat('%',?,'%')";
        return getValue(connection,sql,Adminevent.fristString);
    }

    @Override
    public Object getCountvtidtid(Connection connection) {
        String sql ="select count(distinct tid) from vsales where  tid like concat('%',?,'%')";
        return getValue(connection,sql,Adminevent.fristString);
    }

    @Override
    public Object getCountptidtid(Connection connection) {
        String sql ="select count(distinct tid) from psales where  tid like concat('%',?,'%')";
        return getValue(connection,sql,Adminevent.fristString);
    }

    @Override
    public List<Allentity> getSaleoutdate2(Connection connection) {
        String sql ="select ticket.tid,vid,vsales.eid,ename,sdate,scash,sintegral,ticket.gid,gname,gcategory,gpprice,gvprice,tnum,specifications from ticket,vsales,goods,employee where ticket.gid = goods.gid and ticket.tid = vsales.tid and vsales.eid = employee.eid and vsales.tid like concat('%',?,'%') union all select ticket.tid,pid,psales.eid,ename,pdate,pcash,0 sintegral,ticket.gid,gname,gcategory,gpprice,gvprice,tnum,specifications from ticket,psales,goods,employee where ticket.gid = goods.gid and ticket.tid = psales.tid and psales.eid = employee.eid and psales.tid like concat('%',?,'%')";
        return getBeanList(connection,sql,Adminevent.fristString,Adminevent.fristString);
    }

    @Override
    public List<Allentity> getPsalesvid(Connection connection) {
        String sql ="select * from vsales where vid like concat('%',?,'%') union all select tid, pid vid, pdate sdate, pcash scash, eid, 0 sintegral from psales where pid like concat('%',?,'%')";
        return getBeanList(connection,sql,Adminevent.fristString,Adminevent.fristString);
    }

    @Override
    public Object getSumvpricevid(Connection connection) {
        String sql ="select sum(goods.gvprice * ticket.tnum) from goods,ticket,vsales where goods.gid = ticket.gid and vsales.tid = ticket.tid and vid like concat('%',?,'%')";
        return getValue(connection,sql,Adminevent.fristString);
    }

    @Override
    public Object getSumppricevid(Connection connection) {
        String sql ="select sum(goods.gpprice * ticket.tnum) from goods,ticket,psales where goods.gid = ticket.gid and psales.tid = ticket.tid and pid like concat('%',?,'%')";
        return getValue(connection,sql,Adminevent.fristString);
    }

    @Override
    public Object getCountvtidvid(Connection connection) {
        String sql ="select count(distinct tid) from vsales where  vid like concat('%',?,'%')";
        return getValue(connection,sql,Adminevent.fristString);
    }

    @Override
    public Object getCountptidvid(Connection connection) {
        String sql ="select count(distinct tid) from psales where  pid like concat('%',?,'%')";
        return getValue(connection,sql,Adminevent.fristString);
    }

    @Override
    public List<Allentity> getSaleoutdate3(Connection connection) {
        String sql ="select ticket.tid,vid,vsales.eid,ename,sdate,scash,sintegral,ticket.gid,gname,gcategory,gpprice,gvprice,tnum,specifications from ticket,vsales,goods,employee where ticket.gid = goods.gid and ticket.tid = vsales.tid and vsales.eid = employee.eid and vid like concat('%',?,'%') union all select ticket.tid,pid,psales.eid,ename,pdate,pcash,0 sintegral,ticket.gid,gname,gcategory,gpprice,gvprice,tnum,specifications from ticket,psales,goods,employee where ticket.gid = goods.gid and ticket.tid = psales.tid and psales.eid = employee.eid and pid like concat('%',?,'%')";
        return getBeanList(connection,sql,Adminevent.fristString,Adminevent.fristString);
    }

    @Override
    public List<Allentity> getPsalessdate(Connection connection) {
        String sql = "select * from vsales where date_format(sdate,'%Y-%m-%d')>=date_format(?,'%Y-%m-%d') and date_format(sdate,'%Y-%m-%d')<=date_format(?,'%Y-%m-%d') union all select tid, pid vid, pdate sdate, pcash scash, eid, 0 sintegral from psales where  date_format(pdate,'%Y-%m-%d')>=date_format(?,'%Y-%m-%d') and date_format(pdate,'%Y-%m-%d')<=date_format(?,'%Y-%m-%d')";
        return getBeanList(connection,sql,Adminevent.secondString,Adminevent.thirdString,Adminevent.secondString,Adminevent.thirdString);
    }

    @Override
    public Object getSumvpricesdate(Connection connection) {
        String sql ="select sum(goods.gvprice * ticket.tnum) from goods,ticket,vsales where goods.gid = ticket.gid and vsales.tid = ticket.tid and date_format(sdate,'%Y-%m-%d')>=date_format(?,'%Y-%m-%d') and date_format(sdate,'%Y-%m-%d')<=date_format(?,'%Y-%m-%d')";
        return getValue(connection,sql,Adminevent.secondString,Adminevent.thirdString);
    }

    @Override
    public Object getSumppricesdate(Connection connection) {
        String sql ="select sum(goods.gpprice * ticket.tnum) from goods,ticket,psales where goods.gid = ticket.gid and psales.tid = ticket.tid and date_format(pdate,'%Y-%m-%d')>=date_format(?,'%Y-%m-%d') and date_format(pdate,'%Y-%m-%d')<=date_format(?,'%Y-%m-%d') ";
        return getValue(connection,sql,Adminevent.secondString,Adminevent.thirdString);
    }

    @Override
    public Object getCountvtidsdate(Connection connection) {
        String sql ="select count(distinct tid) from vsales where  date_format(sdate,'%Y-%m-%d')>=date_format(?,'%Y-%m-%d') and date_format(sdate,'%Y-%m-%d')<=date_format(?,'%Y-%m-%d')";
        return getValue(connection,sql,Adminevent.secondString,Adminevent.thirdString);
    }

    @Override
    public Object getCountptidsdate(Connection connection) {
        String sql ="select count(distinct tid) from psales where  date_format(pdate,'%Y-%m-%d')>=date_format(?,'%Y-%m-%d') and date_format(pdate,'%Y-%m-%d')<=date_format(?,'%Y-%m-%d')";
        return getValue(connection,sql,Adminevent.secondString,Adminevent.thirdString);
    }

    @Override
    public List<Allentity> getSaleoutdate4(Connection connection) {
        String sql ="select ticket.tid,vid,vsales.eid,ename,sdate,scash,sintegral,ticket.gid,gname,gcategory,gpprice,gvprice,tnum,specifications from ticket,vsales,goods,employee where ticket.gid = goods.gid and ticket.tid = vsales.tid and vsales.eid = employee.eid and date_format(sdate,'%Y-%m-%d')>=date_format(?,'%Y-%m-%d') and date_format(sdate,'%Y-%m-%d')<=date_format(?,'%Y-%m-%d') union all select ticket.tid,pid,psales.eid,ename,pdate,pcash,0 sintegral,ticket.gid,gname,gcategory,gpprice,gvprice,tnum,specifications from ticket,psales,goods,employee where ticket.gid = goods.gid and ticket.tid = psales.tid and psales.eid = employee.eid and date_format(pdate,'%Y-%m-%d')>=date_format(?,'%Y-%m-%d') and date_format(pdate,'%Y-%m-%d')<=date_format(?,'%Y-%m-%d')";
        return getBeanList(connection,sql,Adminevent.secondString,Adminevent.thirdString,Adminevent.secondString,Adminevent.thirdString);
    }

    @Override
    public List<Allentity> getPsaleseid(Connection connection) {
        String sql ="select * from vsales where eid like concat('%',?,'%') union all select tid, pid vid, pdate sdate, pcash scash, eid, 0 sintegral from psales where eid like concat('%',?,'%')";
        return getBeanList(connection,sql,Adminevent.fristString,Adminevent.fristString);
    }

    @Override
    public Object getSumvpriceeid(Connection connection) {
        String sql ="select sum(goods.gvprice * ticket.tnum) from goods,ticket,vsales where goods.gid = ticket.gid and vsales.tid = ticket.tid and vsales.eid like concat('%',?,'%')";
        return getValue(connection,sql,Adminevent.fristString);
    }

    @Override
    public Object getSumppriceeid(Connection connection) {
        String sql ="select sum(goods.gpprice * ticket.tnum) from goods,ticket,psales where goods.gid = ticket.gid and psales.tid = ticket.tid and psales.eid like concat('%',?,'%')";
        return getValue(connection,sql,Adminevent.fristString);
    }

    @Override
    public Object getCountvtideid(Connection connection) {
        String sql ="select count(distinct tid) from vsales where  eid like concat('%',?,'%')";
        return getValue(connection,sql,Adminevent.fristString);
    }

    @Override
    public Object getCountptideid(Connection connection) {
        String sql ="select count(distinct tid) from psales where  eid like concat('%',?,'%')";
        return getValue(connection,sql,Adminevent.fristString);
    }

    @Override
    public List<Allentity> getSaleoutdate5(Connection connection) {
        String sql ="select ticket.tid,vid,vsales.eid,ename,sdate,scash,sintegral,ticket.gid,gname,gcategory,gpprice,gvprice,tnum,specifications from ticket,vsales,goods,employee where ticket.gid = goods.gid and ticket.tid = vsales.tid and vsales.eid = employee.eid and vsales.eid like concat('%',?,'%') union all select ticket.tid,pid,psales.eid,ename,pdate,pcash,0 sintegral,ticket.gid,gname,gcategory,gpprice,gvprice,tnum,specifications from ticket,psales,goods,employee where ticket.gid = goods.gid and ticket.tid = psales.tid and psales.eid = employee.eid and psales.eid like concat('%',?,'%')";
        return getBeanList(connection,sql,Adminevent.fristString,Adminevent.fristString);
    }

    @Override
    public Object getSumvpricetideid(Connection connection) {
        String sql ="select sum(goods.gvprice * ticket.tnum) from goods,ticket,vsales where goods.gid = ticket.gid and vsales.tid = ticket.tid and vsales.tid like concat('%',?,'%') and vsales.eid = ?";
        return getValue(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public Object getSumppricetideid(Connection connection) {
        String sql ="select sum(goods.gpprice * ticket.tnum) from goods,ticket,psales where goods.gid = ticket.gid and psales.tid = ticket.tid and psales.tid like concat('%',?,'%') and psales.eid = ?";
        return getValue(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public Object getCountvtidtideid(Connection connection) {
        String sql ="select count(distinct tid) from vsales where  tid like concat('%',?,'%') and vsales.eid = ?";
        return getValue(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public Object getCountptidtideid(Connection connection) {
        String sql ="select count(distinct tid) from psales where  tid like concat('%',?,'%') and psales.eid = ?";
        return getValue(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }
    /*财务统计表格*/

    @Override
    public Object getVsql(Connection connection) {
        String sql ="select sum(tnum)s from goods,ticket,vsales where goods.gid = ticket.gid and ticket.tid = vsales.tid and sdate >= ? and sdate <= ? and gcategory = ? ";
        return getValue(connection,sql,Adminevent.fristString,Adminevent.secondString,Adminevent.thirdString);
    }

    @Override
    public Object getPsql(Connection connection) {
        String sql ="select sum(tnum)s from goods,ticket,psales where goods.gid = ticket.gid and ticket.tid = psales.tid and pdate >= ? and pdate <= ? and gcategory = ? ";
        return getValue(connection,sql,Adminevent.fristString,Adminevent.secondString,Adminevent.thirdString);
    }

    @Override
    public List<Allentity> getGcategorybarchart(Connection connection) {
        String sql = "select distinct gcategory from (select distinct gcategory from goods,ticket,vsales where goods.gid = ticket.gid and ticket.tid = vsales.tid and sdate >= ? and sdate <= ? union all select distinct gcategory from goods,ticket,psales where goods.gid = ticket.gid and ticket.tid = psales.tid and pdate >= ? and pdate <= ?)a";
        return getBeanList(connection,sql,Adminevent.fristString,Adminevent.secondString,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public Object getTnumsql2(Connection connection) {
        String sql = "select sum(tnum) from goods,ticket,vsales where goods.gid = ticket.gid and ticket.tid = vsales.tid and sdate >= ? and sdate <= ?";
        return getValue(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public Object getTnumpsql2(Connection connection) {
        String sql = "select sum(tnum) from goods,ticket,psales where goods.gid = ticket.gid and ticket.tid = psales.tid and pdate >= ? and pdate <= ?";
        return getValue(connection,sql,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public List<Allentity> getSeleteeidsql(Connection connection) {
        String sql = "select distinct eid,ename from (select distinct ename, vsales.eid from vsales,employee where vsales.eid = employee.eid  and sdate >= ? and sdate <= ? union all select distinct ename, psales.eid from psales,employee where psales.eid = employee.eid  and pdate >= ? and pdate <= ?)a";
        return getBeanList(connection,sql,Adminevent.fristString,Adminevent.secondString,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public Object getSumvtnum(Connection connection) {
        String sql = "select sum(goods.gvprice * ticket.tnum) from goods,ticket,vsales where goods.gid = ticket.gid and vsales.tid = ticket.tid and sdate >= ? and sdate <= ? and vsales.eid = ?";
        return getValue(connection,sql,Adminevent.fristString,Adminevent.secondString,Adminevent.thirdString);
    }

    @Override
    public Object getSumptnum(Connection connection) {
        String sql = "select sum(goods.gpprice * ticket.tnum) from goods,ticket,psales where goods.gid = ticket.gid and psales.tid = ticket.tid and pdate >= ? and pdate <= ? and psales.eid = ?";
        return getValue(connection,sql,Adminevent.fristString,Adminevent.secondString,Adminevent.thirdString);
    }
    /*财务统计*/

    @Override
    public Object getTotalrevenue1(Connection connection) {
        String sql = "select sum(ss) from (select sum(gvprice * ticket.tnum)ss from goods,ticket,vsales where goods.gid = ticket.gid and vsales.tid = ticket.tid and sdate>=? and sdate <= ? union all select sum(gpprice * ticket.tnum)ss from goods,ticket,psales where goods.gid = ticket.gid and psales.tid = ticket.tid and pdate>=? and pdate <= ?)a";
        return getValue(connection,sql,Adminevent.fristString,Adminevent.secondString,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public Object getTotalcost1(Connection connection) {
        String sql = "select sum(s) from (select sum(gpurchaseprice * ticket.tnum)s from goods,ticket,vsales where goods.gid = ticket.gid and vsales.tid = ticket.tid and sdate >= ? and sdate <= ? union all select sum(gpurchaseprice * ticket.tnum)s from goods,ticket,psales where goods.gid = ticket.gid and psales.tid = ticket.tid and pdate >= ? and pdate <= ?)a";
        return getValue(connection,sql,Adminevent.fristString,Adminevent.secondString,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public Object getGrossprofit1(Connection connection) {
        String sql = "select sum(s) from (select sum(gvprice * ticket.tnum) - sum(gpurchaseprice * ticket.tnum) s from goods,ticket,vsales where goods.gid = ticket.gid and vsales.tid = ticket.tid and sdate >= ? and sdate <= ? union all select sum(gpprice * ticket.tnum) - sum(gpurchaseprice * ticket.tnum) s  from goods,ticket,psales where goods.gid = ticket.gid and psales.tid = ticket.tid and pdate >= ? and pdate <= ?)a";
        return getValue(connection,sql,Adminevent.fristString,Adminevent.secondString,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public Object getLinechartdate(Connection connection) {
        String sql = "select sum(s) from(select sum(gvprice * ticket.tnum) - sum(gpurchaseprice * ticket.tnum) s from goods,ticket,vsales where goods.gid = ticket.gid and vsales.tid = ticket.tid and sdate >= ? and sdate <= ? union all select sum(gpprice * ticket.tnum) - sum(gpurchaseprice * ticket.tnum) s from goods,ticket,psales where goods.gid = ticket.gid and psales.tid = ticket.tid and pdate >= ? and pdate <= ?)a";
        return getValue(connection,sql,Adminevent.fristString,Adminevent.secondString,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public List<Allentity> setCharttable1(Connection connection) {
        String sql = "select eid ,ename,sum(sv1)sv,sum(sp1)sp,sum(ss1)ss from(select psales.eid, ename,0 sv1,sum(gpprice * ticket.tnum) sp1, sum(gpprice * ticket.tnum) ss1 from goods,ticket,psales,employee where goods.gid = ticket.gid and psales.tid = ticket.tid and psales.eid = employee.eid and pdate>=? and pdate <= ? group by psales.eid union all select vsales.eid, ename, sum(gvprice * ticket.tnum) sv1,0 sp1, sum(gvprice * ticket.tnum) ss1 from goods,ticket,vsales,employee where goods.gid = ticket.gid and vsales.tid = ticket.tid and vsales.eid = employee.eid and sdate>=? and sdate <= ? group by vsales.eid)a group by eid";
        return getBeanList(connection,sql,Adminevent.fristString,Adminevent.secondString,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public List<Allentity> setCharttable2(Connection connection) {
        String sql = "select gcategory,concat(sum(percentage1),'%')percentage ,sum(sum1)sum from(select gcategory,format((sum(tnum) / ?)*100,2)percentage1 ,sum(tnum)sum1 from goods,ticket,vsales where goods.gid = ticket.gid and ticket.tid = vsales.tid and sdate >= ? and sdate <= ? group by gcategory union all select gcategory,format((sum(tnum) / ?)*100,2)percentage1 ,sum(tnum)sum1 from goods,ticket,psales where goods.gid = ticket.gid and ticket.tid = psales.tid and pdate >= ? and pdate <= ? group by gcategory)a group by gcategory";
        return getBeanList(connection,sql,Adminevent.thirdString,Adminevent.fristString,Adminevent.secondString,Adminevent.thirdString,Adminevent.fristString,Adminevent.secondString);
    }

    @Override
    public List<Allentity> setCharttable3(Connection connection) {
        String sql = "select datee,sum(profits1)profits from(select date_format(sdate, '%y-%M-%d')datee,sum(gvprice * ticket.tnum) - sum(gpurchaseprice * ticket.tnum)profits1 from goods,ticket,vsales where goods.gid = ticket.gid and vsales.tid = ticket.tid and sdate >= ? and sdate <=? group by date_format(sdate, '%y-%M-%d') union all select date_format(pdate, '%y-%M-%d')datee,sum(gpprice * ticket.tnum) - sum(gpurchaseprice * ticket.tnum)profits1 from goods,ticket,psales where goods.gid = ticket.gid and psales.tid = ticket.tid and pdate >= ? and pdate <=? group by date_format(pdate, '%y-%M-%d'))a group by datee";
        return getBeanList(connection,sql,Adminevent.fristString,Adminevent.secondString,Adminevent.fristString,Adminevent.secondString);
    }
}
