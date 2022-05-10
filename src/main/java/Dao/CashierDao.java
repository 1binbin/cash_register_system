package Dao;

import JDBCUtils.Allentity;

import java.sql.Connection;
import java.util.List;

/**
 * @author hongxiaobin
 * @create 2022/3/2-22:57
 * @description
 */
public interface CashierDao {
    /*收银员面板*/
    void deleteTickettid(Connection connection);

    void insertInsign(Connection connection);

    void deleteTickettidgid(Connection connection);

    /*收银中心*/
    List<Allentity> getGoodsgid(Connection connection);

    List<Allentity> getTickettidgid(Connection connection);

    void insertTicket(Connection connection);

    void updateTicksttnum(Connection connection);

    void updateGoodsgnum(Connection connection);

    Object getTicketsumtnum(Connection connection);

    Object getvPrice(Connection connection);

    Object getpPrice(Connection connection);

    List<Allentity> getTickettid(Connection connection);

    List<Allentity> getVipcustomervid(Connection connection);

    List<Allentity> getIntegralpvalue(Connection connection);

    void insertVsales(Connection connection);

    void updateVipcostomervintegral(Connection connection);

    List<Allentity> getPsalespid(Connection connection);

    void insertPsales(Connection connection);

    List<Allentity> getVipcostomervodate(Connection connection);

    /*商品查询*/
    List<Allentity> getGoods(Connection connection);

    List<Allentity> getGoodsgid1(Connection connection);

    List<Allentity> getGoodsgname(Connection connection);

    List<Allentity> getGoodsgcategory(Connection connection);

    List<Allentity> getGoodsgorigin(Connection connection);

    List<Allentity> getGoodsgsupplier(Connection connection);

    List<Allentity> getGoodsgindate(Connection connection);

    /*小票查询*/
    Object getTicktesumtnum(Connection connection);

    List<Allentity> getTickettid1(Connection connection);

    List<Allentity> getTicketvid(Connection connection);

    List<Allentity> getTicketsdate(Connection connection);

    List<Allentity> getTicketeid(Connection connection);

    List<Allentity> getSales(Connection connection);

    List<Allentity> getpSales(Connection connection);

    List<Allentity> getvSales(Connection connection);

    /*会员中心*/
    void updateVipcustomer(Connection connection);

    void updateVipcustomerall(Connection connection);

    void updateVipcustomerchange(Connection connection);

    void insertVipcustomer(Connection connection);

    void deleteVipcustomer(Connection connection);

    void updateVipcustomerall1(Connection connection);

    List<Allentity> getVipcustomervid1(Connection connection);

    List<Allentity> getVipcustomervname(Connection connection);

    List<Allentity> getVipcustomervphone(Connection connection);

    List<Allentity> getVipcustomer(Connection connection);

    /*个人中心*/
    List<Allentity> getPsqlessql(Connection connection);

    Object getPsalesvsql(Connection connection);

    Object getPsalespsql(Connection connection);

    Object getPsalesvcount(Connection connection);

    Object getPsalespcount(Connection connection);

    List<Allentity> getPsqlessqltid(Connection connection);

    Object getPsalesvsqltid(Connection connection);

    Object getPsalespsqltid(Connection connection);

    Object getPsalesvcounttid(Connection connection);

    Object getPsalespcounttid(Connection connection);

    List<Allentity> getPsqlessqlvid(Connection connection);

    Object getPsalesvsqlvid(Connection connection);

    Object getPsalespsqlvid(Connection connection);

    Object getPsalesvcountvid(Connection connection);

    Object getPsalespcountvid(Connection connection);

    List<Allentity> getPsqlessqldate(Connection connection);

    Object getPsalesvsqldate(Connection connection);

    Object getPsalespsqldate(Connection connection);

    Object getPsalesvcountdate(Connection connection);

    Object getPsalespcountdate(Connection connection);

    List<Allentity> setTbalerefresh(Connection connection);

    List<Allentity> getEmployee(Connection connection);

    Object gteVssql(Connection connection);

    Object gtePssql(Connection connection);

    Object gteVsql(Connection connection);

    Object gtePsql(Connection connection);

    void updateEmployeeename(Connection connection);

    void updateEmployeeephone(Connection connection);

    void updateEmployeeeadd(Connection connection);

    void updateEmployeeebirthday(Connection connection);

    void updateEmployeesex(Connection connection);

    /*修改密码*/
    void updateEmployeeepassword(Connection connection);

    List<Allentity> getTicket(Connection connection);
}
