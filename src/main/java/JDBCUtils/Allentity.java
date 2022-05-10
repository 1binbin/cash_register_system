package JDBCUtils;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author hongxiaobin
 * @create 2022/1/19-19:15
 * @description 包含所有实体的类
 */
public class Allentity {
    private String eid;
    private String ename;
    private String epassword;
    private String erole;
    private String eaddress;
    private String edaddress;
    private String ephone;
    private Date ebirthday;
    private String esex;
    private String gid;
    private String gname;
    private String gcategory;
    private String gorigin;
    private String gsupplier;
    private Date gindate;
    private double gnum;
    private double gpurchaseprice;
    private double gpprice;
    private double gvprice;
    private double gdiscount;

    private Date idate;
    private Date ioutdate;
    private Date vrdate;
    private Date vodate;

    private String tid;
    private String vid;
    private LocalDateTime sdate;

    private double tnum;
    private String vname;
    private String vsex;
    private String vphone;
    private int vintegral;

    private String province;
    private String city;
    private String area;
    private double eage;

    private String goods;
    private String employee;
    private double sumprice;
    private double gprice;
    private double scash;
    private int ivalue;
    private int pvalue;
    private double sintegral;
    private String specifications;
    private String reficitions;
    private double esalary;
    private double sv;
    private double sp;
    private double ss;
    private String percentage;
    private double sum;
    private String datee;
    private double profits;

    private LocalDateTime pdate;
    private double pcash;
    private String pid;
    private String vstate;


    public Allentity() {
    }

    public Allentity(String eid, String ename, String epassword, String erole, String eaddress, String edaddress, String ephone, Date ebirthday, String esex, String gid, String gname, String gcategory, String gorigin, String gsupplier, Date gindate, double gnum, double gpurchaseprice, double gpprice, double gvprice, double gdiscount, Date idate, Date ioutdate, Date vrdate, Date vodate, String tid, String vid, LocalDateTime sdate, double tnum, String vname, String vsex, String vphone, int vintegral, String province, String city, String area, double eage, String goods, String employee, double sumprice, double gprice, double scash, int ivalue, int pvalue, double sintegral, String specifications, String reficitions, double esalary, double sv, double sp, double ss, String percentage, double sum, String datee, double profits, LocalDateTime pdate, double pcash, String pid, String vstate) {
        this.eid = eid;
        this.ename = ename;
        this.epassword = epassword;
        this.erole = erole;
        this.eaddress = eaddress;
        this.edaddress = edaddress;
        this.ephone = ephone;
        this.ebirthday = ebirthday;
        this.esex = esex;
        this.gid = gid;
        this.gname = gname;
        this.gcategory = gcategory;
        this.gorigin = gorigin;
        this.gsupplier = gsupplier;
        this.gindate = gindate;
        this.gnum = gnum;
        this.gpurchaseprice = gpurchaseprice;
        this.gpprice = gpprice;
        this.gvprice = gvprice;
        this.gdiscount = gdiscount;
        this.idate = idate;
        this.ioutdate = ioutdate;
        this.vrdate = vrdate;
        this.vodate = vodate;
        this.tid = tid;
        this.vid = vid;
        this.sdate = sdate;
        this.tnum = tnum;
        this.vname = vname;
        this.vsex = vsex;
        this.vphone = vphone;
        this.vintegral = vintegral;
        this.province = province;
        this.city = city;
        this.area = area;
        this.eage = eage;
        this.goods = goods;
        this.employee = employee;
        this.sumprice = sumprice;
        this.gprice = gprice;
        this.scash = scash;
        this.ivalue = ivalue;
        this.pvalue = pvalue;
        this.sintegral = sintegral;
        this.specifications = specifications;
        this.reficitions = reficitions;
        this.esalary = esalary;
        this.sv = sv;
        this.sp = sp;
        this.ss = ss;
        this.percentage = percentage;
        this.sum = sum;
        this.datee = datee;
        this.profits = profits;
        this.pdate = pdate;
        this.pcash = pcash;
        this.pid = pid;
        this.vstate = vstate;
    }

    public String getVstate() {
        return vstate;
    }

    public void setVstate(String vstate) {
        this.vstate = vstate;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public double getSintegral() {
        return sintegral;
    }

    public void setSintegral(double sintegral) {
        this.sintegral = sintegral;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public LocalDateTime getPdate() {
        return pdate;
    }

    public void setPdate(LocalDateTime pdate) {
        this.pdate = pdate;
    }

    public double getPcash() {
        return pcash;
    }

    public void setPcash(double pcash) {
        this.pcash = pcash;
    }

    public double getEsalary() {
        return esalary;
    }

    public void setEsalary(double esalary) {
        this.esalary = esalary;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getDatee() {
        return datee;
    }

    public void setDatee(String datee) {
        this.datee = datee;
    }

    public double getProfits() {
        return profits;
    }

    public void setProfits(double profits) {
        this.profits = profits;
    }


    public double getSv() {
        return sv;
    }

    public void setSv(double sv) {
        this.sv = sv;
    }

    public double getSp() {
        return sp;
    }

    public void setSp(double sp) {
        this.sp = sp;
    }

    public double getSs() {
        return ss;
    }

    public void setSs(double ss) {
        this.ss = ss;
    }

    public Date getVrdate() {
        return vrdate;
    }

    public void setVrdate(Date vrdate) {
        this.vrdate = vrdate;
    }

    public Date getVodate() {
        return vodate;
    }

    public void setVodate(Date vodate) {
        this.vodate = vodate;
    }

    public double getEage() {
        return eage;
    }

    public void setEage(double eage) {
        this.eage = eage;
    }

    public double getTnum() {
        return tnum;
    }

    public void setTnum(double tnum) {
        this.tnum = tnum;
    }

    public String getReficitions() {
        return reficitions;
    }

    public void setReficitions(String reficitions) {
        this.reficitions = reficitions;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }


    public void setCountprice(double countprice) {
    }

    public Date getEbirthday() {
        return ebirthday;
    }

    public void setEbirthday(Date ebirthday) {
        this.ebirthday = ebirthday;
    }

    public LocalDateTime getSdate() {
        return sdate;
    }

    public void setSdate(LocalDateTime sdate) {
        this.sdate = sdate;
    }


    public int getPvalue() {
        return pvalue;
    }

    public void setPvalue(int pvalue) {
        this.pvalue = pvalue;
    }

    public int getIvalue() {
        return ivalue;
    }

    public void setIvalue(int ivalue) {
        this.ivalue = ivalue;
    }

    public double getScash() {
        return scash;
    }

    public void setScash(double scash) {
        this.scash = scash;
    }

    public double getGprice() {
        return gprice;
    }

    public void setGprice(double gprice) {
        this.gprice = gprice;
    }

    public double getSumprice() {
        return sumprice;
    }

    public void setSumprice(double sumprice) {
        this.sumprice = sumprice;
    }


    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    public String getEdaddress() {
        return edaddress;
    }

    public void setEdaddress(String edaddress) {
        this.edaddress = edaddress;
    }

    public String getEaddress() {
        return eaddress;
    }

    public void setEaddress(String eaddress) {
        this.eaddress = eaddress;
    }

    public String getEphone() {
        return ephone;
    }

    public void setEphone(String ephone) {
        this.ephone = ephone;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEpassword() {
        return epassword;
    }

    public void setEpassword(String epassword) {
        this.epassword = epassword;
    }

    public String getErole() {
        return erole;
    }

    public void setErole(String erole) {
        this.erole = erole;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGcategory() {
        return gcategory;
    }

    public void setGcategory(String gcategory) {
        this.gcategory = gcategory;
    }

    public String getGorigin() {
        return gorigin;
    }

    public void setGorigin(String gorigin) {
        this.gorigin = gorigin;
    }

    public String getGsupplier() {
        return gsupplier;
    }

    public void setGsupplier(String gsupplier) {
        this.gsupplier = gsupplier;
    }

    public Date getGindate() {
        return gindate;
    }

    public void setGindate(Date gindate) {
        this.gindate = gindate;
    }

    public double getGnum() {
        return gnum;
    }

    public void setGnum(double gnum) {
        this.gnum = gnum;
    }

    public double getGpurchaseprice() {
        return gpurchaseprice;
    }

    public void setGpurchaseprice(double gpurchaseprice) {
        this.gpurchaseprice = gpurchaseprice;
    }

    public double getGpprice() {
        return gpprice;
    }

    public void setGpprice(double gpprice) {
        this.gpprice = gpprice;
    }

    public double getGvprice() {
        return gvprice;
    }

    public void setGvprice(double gvprice) {
        this.gvprice = gvprice;
    }

    public double getGdiscount() {
        return gdiscount;
    }

    public void setGdiscount(double gdiscount) {
        this.gdiscount = gdiscount;
    }

    public Date getIdate() {
        return idate;
    }

    public void setIdate(Date idate) {
        this.idate = idate;
    }

    public Date getIoutdate() {
        return ioutdate;
    }

    public void setIoutdate(Date ioutdate) {
        this.ioutdate = ioutdate;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }


    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVsex() {
        return vsex;
    }

    public void setVsex(String vsex) {
        this.vsex = vsex;
    }

    public String getVphone() {
        return vphone;
    }

    public void setVphone(String vphone) {
        this.vphone = vphone;
    }

    public int getVintegral() {
        return vintegral;
    }

    public void setVintegral(int vintegral) {
        this.vintegral = vintegral;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }


    @Override
    public String toString() {
        return "Allentity{" +
                "eid='" + eid + '\'' +
                ", ename='" + ename + '\'' +
                ", epassword='" + epassword + '\'' +
                ", erole='" + erole + '\'' +
                ", eaddress='" + eaddress + '\'' +
                ", edaddress='" + edaddress + '\'' +
                ", ephone='" + ephone + '\'' +
                ", ebirthday=" + ebirthday +
                ", esex='" + esex + '\'' +
                ", gid='" + gid + '\'' +
                ", gname='" + gname + '\'' +
                ", gcategory='" + gcategory + '\'' +
                ", gorigin='" + gorigin + '\'' +
                ", gsupplier='" + gsupplier + '\'' +
                ", gindate=" + gindate +
                ", gnum=" + gnum +
                ", gpurchaseprice=" + gpurchaseprice +
                ", gpprice=" + gpprice +
                ", gvprice=" + gvprice +
                ", gdiscount=" + gdiscount +
                ", idate=" + idate +
                ", ioutdate=" + ioutdate +
                ", vrdate=" + vrdate +
                ", vodate=" + vodate +
                ", tid='" + tid + '\'' +
                ", vid='" + vid + '\'' +
                ", sdate=" + sdate +
                ", tnum=" + tnum +
                ", vname='" + vname + '\'' +
                ", vsex='" + vsex + '\'' +
                ", vphone='" + vphone + '\'' +
                ", vintegral=" + vintegral +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", eage=" + eage +
                ", goods='" + goods + '\'' +
                ", employee='" + employee + '\'' +
                ", sumprice=" + sumprice +
                ", gprice=" + gprice +
                ", scash=" + scash +
                ", ivalue=" + ivalue +
                ", pvalue=" + pvalue +
                ", sintegral=" + sintegral +
                ", specifications='" + specifications + '\'' +
                ", reficitions='" + reficitions + '\'' +
                ", sv=" + sv +
                ", sp=" + sp +
                ", ss=" + ss +
                '}';
    }
}