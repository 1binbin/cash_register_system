package Dao;

import JDBCUtils.Allentity;

import java.sql.Connection;
import java.util.List;

/**
 * @author hongxiaobin
 * @create 2022/3/2-10:33
 * @description
 */
public interface AdminDao {
    /*统计商品编号个数*/
    Object getGidcount(Connection connection);

    Object getGidcount1(Connection connection);

    Object getSumgpurchaseprice(Connection connection);

    Object getSumgpurchaseprice1(Connection connection);

    void deleteGoods(Connection connection);

    List<Allentity> getGidlist(Connection connection);

    List<Allentity> getGoodsgid(Connection connection);

    List<Allentity> getGoodsgname(Connection connection);

    List<Allentity> getGoodsgcategory(Connection connection);

    List<Allentity> getGoodsgorigin(Connection connection);

    List<Allentity> getGoodsgsupplier(Connection connection);

    List<Allentity> getGoodsgindate(Connection connection);

    List<Allentity> getGoods(Connection connection);

    /*批量上传*/
    void insertGoods(Connection connection);

    List<Allentity> getGcategory(Connection connection);

    List<Allentity> getReficition(Connection connection);

    List<Allentity> getGoodsgid1(Connection connection);

    void updateGoods(Connection connection);

    List<Allentity> getEmployeeemployee(Connection connection);

    void insertEmployee(Connection connection);

    List<Allentity> getEmployeeeid(Connection connection);

    void deleteEmloyee(Connection connection);

    List<Allentity> getReficitionsreficition(Connection connection);

    void updateGoodsgid(Connection connection);

    void updateGoodsganme(Connection connection);

    void updateGoodsgcategory(Connection connection);

    void updateGoodsspecification(Connection connection);

    void updateGoodsgorigin(Connection connection);

    void updateGoodsgsupplier(Connection connection);

    void updateGoodsggindate(Connection connection);

    void updateGoodsggnum(Connection connection);

    void updateGoodsgpurchasepriee(Connection connection);

    void updateGoodsgprice(Connection connection);

    void updateGoodsdiscount(Connection connection);

    List<Allentity> getEcategory(Connection connection);

    List<Allentity> getEmployeeesex(Connection connection);

    List<Allentity> getEmployee(Connection connection);

    void updateEmployee(Connection connection);

    List<Allentity> selectEmployeeeid(Connection connection);

    List<Allentity> selectEmployeeename(Connection connection);

    List<Allentity> selectEmployeeeaddress(Connection connection);

    List<Allentity> selectEmployeeephone(Connection connection);

    List<Allentity> selectEmployeeerole(Connection connection);

    List<Allentity> getEmployeetable(Connection connection);

    List<Allentity> getIntegral(Connection connection);

    void insertIntegral(Connection connection);

    void updateIntegral(Connection connection);

    List<Allentity> getGcategorygoods(Connection connection);

    List<Allentity> getEcategoryemployee(Connection connection);

    void insertGcategory(Connection connection);

    void deleteGcategory(Connection connection);

    void updateGcategory(Connection connection);

    void insertEcategory(Connection connection);

    void deleteEcategory(Connection connection);

    void updateEcategory(Connection connection);

    void insertReficitions(Connection connection);

    void deleteReficitions(Connection connection);

    void updateReficitions(Connection connection);

    List<Allentity> getReficitions(Connection connection);

    List<Allentity> getGcategory1(Connection connection);

    List<Allentity> getGvprice(Connection connection);

    List<Allentity> getGpprice(Connection connection);

    List<Allentity> setRefresh(Connection connection);

    List<Allentity> getPsalestid(Connection connection);

    Object getSumvpricetid(Connection connection);

    Object getSumppricetid(Connection connection);

    Object getCountvtidtid(Connection connection);

    Object getCountptidtid(Connection connection);

    List<Allentity> getSaleoutdate2(Connection connection);

    List<Allentity> getPsalesvid(Connection connection);

    Object getSumvpricevid(Connection connection);

    Object getSumppricevid(Connection connection);

    Object getCountvtidvid(Connection connection);

    Object getCountptidvid(Connection connection);

    List<Allentity> getSaleoutdate3(Connection connection);

    List<Allentity> getPsalessdate(Connection connection);

    Object getSumvpricesdate(Connection connection);

    Object getSumppricesdate(Connection connection);

    Object getCountvtidsdate(Connection connection);

    Object getCountptidsdate(Connection connection);

    List<Allentity> getSaleoutdate4(Connection connection);

    List<Allentity> getPsaleseid(Connection connection);

    Object getSumvpriceeid(Connection connection);

    Object getSumppriceeid(Connection connection);

    Object getCountvtideid(Connection connection);

    Object getCountptideid(Connection connection);

    List<Allentity> getSaleoutdate5(Connection connection);

    List<Allentity> getPsales(Connection connection);

    Object getSumvprice(Connection connection);

    Object getSumpprice(Connection connection);

    Object getCountvtid(Connection connection);

    Object getCountptid(Connection connection);

    List<Allentity> getSaleoutdate1(Connection connection);

    Object getSumvpricetideid(Connection connection);

    Object getSumppricetideid(Connection connection);

    Object getCountvtidtideid(Connection connection);

    Object getCountptidtideid(Connection connection);

    List<Allentity> selectEmployeeesex(Connection connection);

    /*财务统计表格*/
    Object getVsql(Connection connection);

    Object getPsql(Connection connection);

    List<Allentity> getGcategorybarchart(Connection connection);

    Object getTnumsql2(Connection connection);

    Object getTnumpsql2(Connection connection);

    List<Allentity> getSeleteeidsql(Connection connection);

    Object getSumvtnum(Connection connection);

    Object getSumptnum(Connection connection);

    /*财务统计*/
    Object getTotalrevenue1(Connection connection);

    Object getTotalcost1(Connection connection);

    Object getGrossprofit1(Connection connection);

    Object getLinechartdate(Connection connection);

    List<Allentity> setCharttable1(Connection connection);

    List<Allentity> setCharttable2(Connection connection);

    List<Allentity> setCharttable3(Connection connection);

    List<Allentity> isGsupplier(Connection connection);

    void insertGsupplier(Connection connection);

    List<Allentity> getGorigin(Connection connection);
}
