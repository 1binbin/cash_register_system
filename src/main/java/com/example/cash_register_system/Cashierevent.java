package com.example.cash_register_system;

import Dao.CashierDaoImpl;
import JDBCUtils.Allentity;
import JDBCUtils.JdbcConnection;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author hongxiaobin
 * @create 2022/1/20-15:07
 * @description
 */
public class Cashierevent {
    public static String outlogintime;
    public static String tpricenum;
    public static String tcountnum;
    public static String tcash;
    public static String tchance;
    public static String tvid;
    public static String ttid;
    public static String datatime;
    public static String eid;
    public static int choise;
    public static String fristString = null;
    public static String secondString = null;
    public static String thirdString = null;
    public static String fourthString = null;
    public static String fifthString = null;
    public static String sixthString = null;
    public static String seventhString = null;
    public static String eighthString = null;
    private static String tid;
    private static boolean is = true;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
    Function function = new Function();
    CashierDaoImpl cashierDao = new CashierDaoImpl();
    private Connection connection;
    @FXML
    private TableView<Allentity> cashiertable;
    @FXML
    private TableView<Allentity> ctticktable;
    @FXML
    private TableView<Allentity> ctgoodstable;
    @FXML
    private TableView<Allentity> cptable;
    @FXML
    private TableView<Allentity> ccptable;
    @FXML
    private TableColumn<Allentity, String> gid;
    @FXML
    private TableColumn<Allentity, String> gname;
    @FXML
    private TableColumn<Allentity, String> gdiscount;
    @FXML
    private TableColumn<Allentity, String> gcount;
    @FXML
    private TableColumn<Allentity, String> gorigin;
    @FXML
    private TableColumn<Allentity, String> gpprice;
    @FXML
    private TableColumn<Allentity, String> gvprice;
    @FXML
    private TableColumn<Allentity, String> gsupplier;
    @FXML
    private TableColumn<Allentity, String> gcategory;
    @FXML
    private TableColumn<Allentity, String> cttidcolumn;
    @FXML
    private TableColumn<Allentity, String> ctvidcolumn;
    @FXML
    private TableColumn<Allentity, String> ctdatetimecolumn;
    @FXML
    private TableColumn<Allentity, String> cteidcolumn;
    @FXML
    private TableColumn<Allentity, String> ctcashcolumn;
    @FXML
    private TableColumn<Allentity, String> ctintergalcolumn;
    @FXML
    private TableColumn<Allentity, String> cgtidcolumn;
    @FXML
    private TableColumn<Allentity, String> cggidcolumn;
    @FXML
    private TableColumn<Allentity, String> cggnameolumn;
    @FXML
    private TableColumn<Allentity, String> cgpricecolumn;
    @FXML
    private TableColumn<Allentity, String> cgnumcolumn;
    @FXML
    private TableColumn<Allentity, String> cgpricenumcolumn;
    @FXML
    private TableColumn<Allentity, String> cptid;
    @FXML
    private TableColumn<Allentity, String> cpgid;
    @FXML
    private TableColumn<Allentity, String> cpvid;
    @FXML
    private TableColumn<Allentity, String> cpgname;
    @FXML
    private TableColumn<Allentity, String> cptnum;
    @FXML
    private TableColumn<Allentity, String> cpprice;
    @FXML
    private TableColumn<Allentity, String> cpnumprice;
    @FXML
    private TableColumn<Allentity, String> cpdatetime;
    @FXML
    private TableColumn<Allentity, String> cpcash;
    @FXML
    private TableColumn<Allentity, String> cpintergal;
    @FXML
    private TableColumn<Allentity, String> ccptid;
    @FXML
    private TableColumn<Allentity, String> vrdatecolumn;
    @FXML
    private TableColumn<Allentity, String> vodatecolumn;
    @FXML
    private TableColumn<Allentity, String> vstatecolumn;
    @FXML
    private TextField cselecttf;
    @FXML
    private DatePicker cenddate;
    @FXML
    private DatePicker cbegindate;
    @FXML
    private ComboBox<String> csprovincecb;
    @FXML
    private ComboBox<String> cscitycb;
    @FXML
    private ComboBox<String> csareacb;
    @FXML
    private ComboBox<String> crangecb;
    @FXML
    private ComboBox<String> cselectcategorycb;
    @FXML
    private HBox cdateselecthb;
    @FXML
    private TableView<Allentity> cctable;
    @FXML
    private TableView<Allentity> vtable;
    @FXML
    private TableColumn<Allentity, String> sumprice;
    @FXML
    private TableColumn<Allentity, String> ccgprice;
    @FXML
    private TableColumn<Allentity, String> cctnumcolumn;
    @FXML
    private TableColumn<Allentity, String> ccgidcolumn;
    @FXML
    private TableColumn<Allentity, String> ccgnamecolumn;
    @FXML
    private TableColumn<Allentity, String> ccgcategorycolumn;
    @FXML
    private TableColumn<Allentity, String> cctidcolumn;
    @FXML
    private TableColumn<Allentity, String> vidcolumn;
    @FXML
    private TableColumn<Allentity, String> vnamecolumn;
    @FXML
    private TableColumn<Allentity, String> vsexcolumn;
    @FXML
    private TableColumn<Allentity, String> vphonecolumn;
    @FXML
    private TableColumn<Allentity, String> vintegralcolumn;
    @FXML
    private TextField ccgidtf;
    @FXML
    private TextField cctnumtf;
    @FXML
    private Tab cctab;
    @FXML
    private TextField cccashtf;
    @FXML
    private TextField ccchangetf;
    @FXML
    private TextField ccvidtf;
    @FXML
    private RadioButton truerb;
    @FXML
    private TextField ccnumsumtf;
    @FXML
    private TextField ccpricesumtf;
    @FXML
    private ComboBox<String> voptioncb;
    @FXML
    private ComboBox<String> vselectrangecb;
    @FXML
    private RadioButton vboyrb;
    @FXML
    private TextField vidtf;
    @FXML
    private TextField vnametf;
    @FXML
    private TextField vphonetf;
    @FXML
    private TextField vintegraltf;
    @FXML
    private TextField vselecttf;
    @FXML
    private ComboBox<String> ctselectrangecb;
    @FXML
    private TextField ctselecttf;
    @FXML
    private HBox cthb;
    @FXML
    private DatePicker ctbegindate;
    @FXML
    private DatePicker ctenddate;
    @FXML
    private TextField countpricetf;
    @FXML
    private TextField countnumtf;
    @FXML
    private ComboBox<String> cprangecb;
    @FXML
    private TextField cpselecttf;
    @FXML
    private HBox cphb;
    @FXML
    private DatePicker cpbegin;
    @FXML
    private DatePicker cpend;
    @FXML
    private TextField ppeidtf;
    @FXML
    private TextField ppeaddresstf;
    @FXML
    private TextField ppenametf;
    @FXML
    private TextField ppephonetf;
    @FXML
    private TextField ppsextf;
    @FXML
    private TextField ppebirthday;
    @FXML
    private Label yearla;
    @FXML
    private ComboBox<Integer> monthcb;
    @FXML
    private TextField countla;
    @FXML
    private TextField lastcountla;
    @FXML
    private TextField countpricela;
    @FXML
    private TextField lastcountpricela;
    @FXML
    private Label codela;
    @FXML
    private PasswordField opassword;
    @FXML
    private PasswordField npassword;
    @FXML
    private PasswordField nnpassword;
    @FXML
    private TextField ppcode;
    @FXML
    private HBox pphb;
    @FXML
    private TextField pptf;
    @FXML
    private DatePicker ppdp;
    @FXML
    private ComboBox<String> ppcb;
    @FXML
    private RadioButton pboyeb;
    @FXML
    private HBox sexhb;
    @FXML
    private ComboBox<String> ppprovince;
    @FXML
    private ComboBox<String> ppcity;
    @FXML
    private ComboBox<String> pparea;
    @FXML
    private TextField ppaddtf;
    @FXML
    private Label vlabel;
    @FXML
    private ComboBox<Integer> vdatecb;
    @FXML
    private ComboBox<Integer> yearcb;

    {
        try {
            connection = JdbcConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*收银员面板事件*/
//    重新登录
    @FXML
    protected void cresetlogins() {
        Loginin.stageclose.close();
        Loginin loginin = new Loginin();
        try {
            fristString = tid;
            cashierDao.deleteTickettid(connection);
            loginin.cashierStage().show();
        } catch (Exception e) {
            function.setAlert("出错！\n" + e.getMessage());
        }
    }

    //    注销
    @FXML
    protected void cisoutlogin() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("注销");
        alert.setHeaderText("是否要退出登录");
        Optional<ButtonType> button = alert.showAndWait();
        if (button.isPresent() && button.get() == ButtonType.OK) {
            Loginin loginin = new Loginin();
            try {
                closestage();
                loginin.loginStage().show();
            } catch (Exception e) {
                function.setAlert("出错！\n" + e.getMessage());
            }
        } else {
            cresetlogins();
        }
    }

    private void closestage() {
        Loginin.stageclose.close();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        outlogintime = simpleDateFormat.format(date);
        fristString = Loginin.logintime;
        secondString = outlogintime;
        thirdString = LogininEvent.eid;
        cashierDao.insertInsign(connection);
        fristString = tid;
        cashierDao.deleteTickettid(connection);
    }

    /*收银中心*/
    @FXML
    public void cashiercenter() {
        sumprice.setCellValueFactory(new PropertyValueFactory<>("sumprice"));
        ccgprice.setCellValueFactory(new PropertyValueFactory<>("gprice"));
        cctnumcolumn.setCellValueFactory(new PropertyValueFactory<>("tnum"));
        ccgidcolumn.setCellValueFactory(new PropertyValueFactory<>("gid"));
        ccgnamecolumn.setCellValueFactory(new PropertyValueFactory<>("gname"));
        ccgcategorycolumn.setCellValueFactory(new PropertyValueFactory<>("gcategory"));
        cctidcolumn.setCellValueFactory(new PropertyValueFactory<>("tid"));
        if (cctab.isSelected() && is) {
            gettid();
        }
        cctablevalue();
        cctable.setRowFactory(tv -> {
            TableRow<Allentity> tableRow = new TableRow<>();
            tableRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !tableRow.isEmpty()) {
                    ccgidtf.setText(tableRow.getItem().getGid());
                }
            });
            return tableRow;
        });
    }

    //    收银确认按钮
    @FXML
    protected void ccaddokbutton() {
        if (!ccgidtf.getText().isEmpty() && !cctnumtf.getText().isEmpty()) {
            fristString = ccgidtf.getText();
            List<Allentity> list = cashierDao.getGoodsgid(connection);
            assert list != null;
            if (!list.isEmpty()) {
                try {
                    Double.parseDouble(cctnumtf.getText());
                    if (Double.parseDouble(cctnumtf.getText()) > 0) {
                        ttid = tid;
                        fristString = tid;
                        secondString = ccgidtf.getText();
                        List<Allentity> list1 = cashierDao.getTickettidgid(connection);
                        assert list1 != null;
                        if (list1.isEmpty()) {
                            fristString = tid;
                            secondString = ccgidtf.getText();
                            thirdString = cctnumtf.getText();
                            List<Allentity> list2 = cashierDao.getTicket(connection);
                            if (list2.isEmpty()) {
                                cashierDao.insertTicketc(connection);
                            }
                            cashierDao.insertTicket(connection);
                        } else {
                            fristString = cctnumtf.getText();
                            cashierDao.updateTicksttnum(connection);
                        }
                        fristString = cctnumtf.getText();
                        cashierDao.updateGoodsgnum(connection);
                        ccgidtf.clear();
                        cctnumtf.clear();
                        fristString = tid;
                        ccnumsumtf.setText(String.valueOf(cashierDao.getTicketsumtnum(connection)));
                        if (!truerb.isSelected()) {
                            ccpricesumtf.setText(cashierDao.getpPrice(connection) + "");
                        } else {
                            ccpricesumtf.setText(cashierDao.getvPrice(connection) + "");
                        }
                        cctablevalue();
                    } else {
                        function.setAlert("数量输入不是正数！");
                    }
                } catch (NumberFormatException e) {
                    function.setAlert("数量输入不是数字！");
                }
            } else {
                function.setAlert("商品编号不存在！");
            }
        } else {
            function.setAlert("商品编号或数量为空！");
        }
    }

    //    收银删除按钮
    @FXML
    protected void ccdeletebutton() {
        if (!ccgidtf.getText().isEmpty()) {
            fristString = tid;
            secondString = ccgidtf.getText();
            List<Allentity> list = cashierDao.getTickettidgid(connection);
            assert list != null;
            if (!list.isEmpty()) {
                cashierDao.deleteTickettidgid(connection);
                ccgidtf.clear();
                cctablevalue();
            } else {
                function.setAlert("商品编号不存在！");
            }
        } else {
            function.setAlert("商品编号为空！");
        }
    }

    //    清空列表按钮
    @FXML
    protected void ccclearbutton() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("清空");
        alert.setHeaderText("确定是否要清空小票编号为 " + tid + " 的列表？");
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.isPresent() && buttonType.get() == ButtonType.OK) {
            fristString = tid;
            cashierDao.deleteTickettid(connection);
            cctablevalue();
        }
    }

    //    重置按钮
    @FXML
    protected void ccrefresh() {
        ccgidtf.clear();
        cctnumtf.clear();
        cccashtf.clear();
        ccvidtf.clear();
    }

    @FXML
    protected void setCcchangetf() {
        ccchangetf.clear();
    }

    //    选择
    @FXML
    protected void selectrb() {
        fristString = tid;
        if (!truerb.isSelected()) {
            ccvidtf.setEditable(false);
            ccpricesumtf.setText(cashierDao.getpPrice(connection) + "");
        } else {
            ccvidtf.setEditable(true);
            ccpricesumtf.setText(cashierDao.getvPrice(connection) + "");
        }
        cctablevalue();
    }

    //    确认结账
    @FXML
    protected void invoicingbutton() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("结账");
        alert.setHeaderText("确定是否结账？");
        Optional<ButtonType> optionalButtonType = alert.showAndWait();
        Date nowdata = new Date();
        datatime = simpleDateFormat2.format(nowdata);
        eid = LogininEvent.eid;
        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.OK) {
            fristString = tid;
            List<Allentity> istidlist = cashierDao.getTickettid(connection);
            assert istidlist != null;
            if (!istidlist.isEmpty()) {
                if (!cccashtf.getText().isEmpty()) {
                    try {
                        if (Pattern.matches("^(([0-9]+)|([0-9]+\\.[0-9]{0,2}))$", cccashtf.getText())) {
                            boolean is = true;
                            if (Double.parseDouble(cccashtf.getText()) < Double.parseDouble(ccpricesumtf.getText())) {
                                is = false;
                                function.setAlert("现金低于总价，请重新付款！");
                            }
                            if (is) {
                                if (truerb.isSelected()) {
                                    choise = 1;
                                    if (!ccvidtf.getText().isEmpty()) {
                                        fristString = ccvidtf.getText();
                                        List<Allentity> list = cashierDao.getVipcustomervid(connection);
                                        assert list != null;
                                        if (!list.isEmpty()) {
                                            if ("未到期".equals(list.get(0).getVstate())) {
                                                List<Allentity> ilist = cashierDao.getIntegralpvalue(connection);
                                                int pvalue;
                                                assert ilist != null;
                                                if (!ilist.isEmpty()) {
                                                    pvalue = ilist.get(0).getPvalue();
                                                } else {
                                                    pvalue = 1;
                                                }
                                                fristString = tid;
                                                secondString = ccvidtf.getText();
                                                thirdString = datatime;
                                                fourthString = cccashtf.getText();
                                                fifthString = LogininEvent.eid;
                                                sixthString = String.format(String.valueOf(Double.parseDouble(ccpricesumtf.getText()) / pvalue), "%.2f");
                                                cashierDao.insertVsales(connection);
                                                cashierDao.updateVipcostomervintegral(connection);
                                                fristString = ccvidtf.getText();
                                                List<Allentity> list1 = cashierDao.getVipcostomervodate(connection);
                                                Date newdate = Objects.requireNonNull(list1).get(0).getVodate();
                                                Loginin loginin = new Loginin();
                                                ccchangetf.setText(String.format("%.2f", Double.parseDouble(cccashtf.getText()) - Double.parseDouble(ccpricesumtf.getText())) + "");
                                                tpricenum = ccpricesumtf.getText();
                                                tcountnum = ccnumsumtf.getText();
                                                tchance = ccchangetf.getText();
                                                tcash = cccashtf.getText();
                                                tvid = ccvidtf.getText();
                                                try {
                                                    loginin.ticketstage().show();
                                                    Date olddate = new Date();
                                                    if (getday(olddate, newdate) <= 3) {
                                                        function.setAlert1("会员 " + ccvidtf.getText() + "\n将在 " + getday(olddate, newdate) + " 天后 " + newdate + " 到期\n请及时续费，到期不可使用！");
                                                    }
                                                } catch (Exception e) {
                                                    function.setAlert("小票出票出错！");
                                                }
                                                gettid();
                                                ccrefresh();
                                                cctablevalue();
                                            } else {
                                                function.setAlert("会员已到期，不可使用！");
                                            }
                                        } else {
                                            function.setAlert("会员编号不存在！");
                                        }
                                    } else {
                                        function.setAlert("会员编号输入为空！");
                                    }
                                } else {
                                    choise = 0;
                                    String pid;
                                    List<Allentity> list;
                                    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyMMdd");
                                    String data = simpleDateFormat1.format(nowdata);
                                    do {
                                        pid = "P" + data + (int) ((Math.random() * (999999 - 100000) + 1) + 100000);
                                        fristString = pid;
                                        list = cashierDao.getPsalespid(connection);
                                    } while (!Objects.requireNonNull(list).isEmpty());
                                    fristString = tid;
                                    secondString = pid;
                                    thirdString = datatime;
                                    fourthString = cccashtf.getText();
                                    fifthString = LogininEvent.eid;
                                    cashierDao.insertPsales(connection);
                                    Loginin loginin = new Loginin();
                                    ccchangetf.setText(String.format("%.2f", Double.parseDouble(cccashtf.getText()) - Double.parseDouble(ccpricesumtf.getText())) + "");
                                    tpricenum = ccpricesumtf.getText();
                                    tcountnum = ccnumsumtf.getText();
                                    tchance = ccchangetf.getText();
                                    tcash = cccashtf.getText();
                                    tvid = ccvidtf.getText();
                                    try {
                                        loginin.ticketstage().show();
                                    } catch (Exception e) {
                                        function.setAlert("小票出票出错！");
                                    }
                                    gettid();
                                    ccrefresh();
                                    cctablevalue();
                                }
                            }
                        } else {
                            function.setAlert("现金输入需为最多两位小数的非负数！");
                        }
                    } catch (NumberFormatException e) {
                        function.setAlert("现金输入不是数字！");
                    }
                } else {
                    function.setAlert("现金输入为空，暂为付款！");
                }
            } else {
                function.setAlert("暂不需付款！");
            }
        }
    }

    @FXML
    protected void cgoods() {
        istidchange();
        gid.setCellValueFactory(new PropertyValueFactory<>("gid"));
        gname.setCellValueFactory(new PropertyValueFactory<>("gname"));
        gcategory.setCellValueFactory(new PropertyValueFactory<>("gcategory"));
        gorigin.setCellValueFactory(new PropertyValueFactory<>("gorigin"));
        gcount.setCellValueFactory(new PropertyValueFactory<>("gnum"));
        gpprice.setCellValueFactory(new PropertyValueFactory<>("gpprice"));
        gvprice.setCellValueFactory(new PropertyValueFactory<>("gvprice"));
        gsupplier.setCellValueFactory(new PropertyValueFactory<>("gsupplier"));
        gdiscount.setCellValueFactory(new PropertyValueFactory<>("gdiscount"));
        cashiertable();
//        鼠标双击
        cashiertable.setRowFactory(tv -> {
            TableRow<Allentity> TableRow = new TableRow<>();
            TableRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !TableRow.isEmpty()) {
                    ccgidtf.setText(TableRow.getItem().getGid());
                }
            });
            return TableRow;
        });
        if (crangecb.getItems().isEmpty()) {
            crangecb.getItems().addAll("全部", "商品号", "商品名", "类别", "供货商", "产地", "进货日期");
        }
        function.setCbItem(csprovincecb);
        cbegindate.setEditable(false);
        cenddate.setEditable(false);
    }

    @FXML
    protected void crangecb() {
        function.setrangecb(crangecb, cselecttf, cdateselecthb, cselectcategorycb, csprovincecb, cscitycb, csareacb, cashiertable, function);
    }

    @FXML
    protected void cselectok() {
        fristString = cselecttf.getText();
        secondString = cselectcategorycb.getValue();
        if ("全部".equals(crangecb.getValue())) {
            cashiertable.setItems(function.gettablevalue(cashierDao.getGoods(connection)));
        } else if ("商品号".equals(crangecb.getValue())) {
            cashiertable.setItems(function.gettablevalue(cashierDao.getGoodsgid1(connection)));
        } else if ("商品名".equals(crangecb.getValue())) {
            cashiertable.setItems(function.gettablevalue(cashierDao.getGoodsgname(connection)));
        } else if ("类别".equals(crangecb.getValue())) {
            cashiertable.setItems(function.gettablevalue(cashierDao.getGoodsgcategory(connection)));
        } else if ("产地".equals(crangecb.getValue())) {
            thirdString = function.getaddress(csprovincecb, cscitycb, csareacb);
            cashiertable.setItems(function.gettablevalue(cashierDao.getGoodsgorigin(connection)));
        } else if ("供货商".equals(crangecb.getValue())) {
            cashiertable.setItems(function.gettablevalue(cashierDao.getGoodsgsupplier(connection)));
        } else if ("进货日期".equals(crangecb.getValue())) {
            fourthString = String.valueOf(cbegindate.getValue());
            fifthString = String.valueOf(cenddate.getValue());
            cashiertable.setItems(function.gettablevalue(cashierDao.getGoodsgindate(connection)));
        } else {
            function.setAlert("请选择搜索范围！");
        }
    }

    @FXML
    protected void cselectrefresh() {
        cselecttf.clear();
        cashiertable();
    }

    @FXML
    protected void cscityempty() {
        function.setcityempty(cscitycb, csareacb);
    }

    @FXML
    protected void csareaempty() {
        int areanum = csareacb.getItems().size();
        if (areanum > 0) {
            csareacb.getItems().subList(0, areanum).clear();
        }
    }

    @FXML
    protected void cscityshow() {
        function.setcityshow(csprovincecb, cscitycb);
    }

    @FXML
    protected void csareashow() {
        function.setareashow(csprovincecb, cscitycb, csareacb);
    }

    @FXML
    protected void csetgcategory() {
        function.getgcategory(cselectcategorycb);
    }

    /*小票查询*/
    @FXML
    protected void ctticket() {
        istidchange();
        cttidcolumn.setCellValueFactory(new PropertyValueFactory<>("tid"));
        ctvidcolumn.setCellValueFactory(new PropertyValueFactory<>("vid"));
        ctdatetimecolumn.setCellValueFactory(new PropertyValueFactory<>("sdate"));
        cteidcolumn.setCellValueFactory(new PropertyValueFactory<>("eid"));
        ctcashcolumn.setCellValueFactory(new PropertyValueFactory<>("scash"));
        ctintergalcolumn.setCellValueFactory(new PropertyValueFactory<>("sintegral"));
        ctticktablevalue();
        cgtidcolumn.setCellValueFactory(new PropertyValueFactory<>("tid"));
        cggidcolumn.setCellValueFactory(new PropertyValueFactory<>("gid"));
        cggnameolumn.setCellValueFactory(new PropertyValueFactory<>("gname"));
        cgpricecolumn.setCellValueFactory(new PropertyValueFactory<>("gprice"));
        cgnumcolumn.setCellValueFactory(new PropertyValueFactory<>("tnum"));
        cgpricenumcolumn.setCellValueFactory(new PropertyValueFactory<>("sumprice"));
        ctgrefreshtable();
        ctticktable.setRowFactory(tv -> {
            TableRow<Allentity> TableRow = new TableRow<>();
            TableRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !TableRow.isEmpty()) {
                    ctgoodstablevalue(TableRow.getItem().getVid(), TableRow.getItem().getTid());
                    datatime = String.valueOf(TableRow.getItem().getSdate());
                    eid = TableRow.getItem().getEid();
                    tcash = String.valueOf(TableRow.getItem().getScash());
                    ttid = TableRow.getItem().getTid();
                    tvid = TableRow.getItem().getVid();

                }
            });
            return TableRow;
        });
        if (ctselectrangecb.getItems().isEmpty()) {
            ctselectrangecb.getItems().addAll("小票编号", "顾客编号", "购买时间", "经手人");
        }
    }

    @FXML
    protected void gettickte() {
        if (ttid != null) {
            Loginin loginin = new Loginin();
            fristString = ttid;
            tcountnum = (double) cashierDao.getTicktesumtnum(connection) + "";
            if (tvid.charAt(0) == 'P') {
                tpricenum = (double) cashierDao.getpPrice(connection) + "";
            } else {
                tpricenum = (double) cashierDao.getvPrice(connection) + "";
            }
            tchance = String.format("%.2f", Double.parseDouble(tcash) - Double.parseDouble(tpricenum));
            try {
                loginin.ticketstage().show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    protected void setctselectrangecb() {
        setctrefresh();
        ctgrefreshtable();
        if ("购买时间".equals(ctselectrangecb.getValue())) {
            cthb.setVisible(true);
            ctselecttf.setVisible(false);
        } else {
            cthb.setVisible(false);
            ctselecttf.setVisible(true);
        }
    }

    @FXML
    protected void setctrefresh() {
        ctselecttf.clear();
        ctticktablevalue();
    }

    @FXML
    protected void setctokbutton() {
        fristString = ctselecttf.getText();
        if ("小票编号".equals(ctselectrangecb.getValue())) {
            ctticktable.setItems(function.gettablevalue(cashierDao.getTickettid1(connection)));
        } else if ("顾客编号".equals(ctselectrangecb.getValue())) {
            ctticktable.setItems(function.gettablevalue(cashierDao.getTicketvid(connection)));
        } else if ("购买时间".equals(ctselectrangecb.getValue())) {
            secondString = getDate(ctbegindate, ctenddate)[0];
            thirdString = getDate(ctbegindate, ctenddate)[1];
            ctticktable.setItems(function.gettablevalue(cashierDao.getTicketsdate(connection)));
        } else if ("经手人".equals(ctselectrangecb.getValue())) {
            ctticktable.setItems(function.gettablevalue(cashierDao.getTicketeid(connection)));
        } else {
            function.setAlert("搜索范围未选择！");
        }
    }

    private String[] getDate(DatePicker begindate, DatePicker enddate) {
        ZonedDateTime zonedDateTime = begindate.getValue().atStartOfDay(ZoneId.systemDefault());
        String begindate1 = simpleDateFormat3.format(Date.from(zonedDateTime.toInstant()));
        LocalDate localDate = enddate.getValue().plusDays(1);
        ZonedDateTime zonedDateTime1 = localDate.atStartOfDay(ZoneId.systemDefault());
        String enddate1 = simpleDateFormat3.format(Date.from(zonedDateTime1.toInstant()));
        return new String[]{begindate1, enddate1};
    }

    protected void ctticktablevalue() {
        ctticktable.setItems(function.gettablevalue(cashierDao.getSales(connection)));
    }

    protected void ctgoodstablevalue(String vid, String tid) {
        fristString = tid;
        if (vid.charAt(0) == 'P') {
            ctgoodstable.setItems(function.gettablevalue(cashierDao.getpSales(connection)));
        } else {
            ctgoodstable.setItems(function.gettablevalue(cashierDao.getvSales(connection)));
        }

    }

    /*会员中心*/
    @FXML
    protected void vipcenter() {
        istidchange();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        fristString = "已到期";
        secondString = simpleDateFormat.format(new Date());
        cashierDao.updateVipcustomer(connection);
        vidcolumn.setCellValueFactory(new PropertyValueFactory<>("vid"));
        vnamecolumn.setCellValueFactory(new PropertyValueFactory<>("vname"));
        vsexcolumn.setCellValueFactory(new PropertyValueFactory<>("vsex"));
        vphonecolumn.setCellValueFactory(new PropertyValueFactory<>("vphone"));
        vintegralcolumn.setCellValueFactory(new PropertyValueFactory<>("vintegral"));
        vrdatecolumn.setCellValueFactory(new PropertyValueFactory<>("vrdate"));
        vodatecolumn.setCellValueFactory(new PropertyValueFactory<>("vodate"));
        vstatecolumn.setCellValueFactory(new PropertyValueFactory<>("vstate"));
        vtablevalue();
        vtable.setRowFactory(tv -> {
            TableRow<Allentity> TableRow = new TableRow<>();
            TableRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !TableRow.isEmpty()) {
                    vidtf.setText(TableRow.getItem().getVid());
                    ccvidtf.setText(TableRow.getItem().getVid());
                    vnametf.setText(TableRow.getItem().getVname());
                    vphonetf.setText(TableRow.getItem().getVphone());
                }
            });
            return TableRow;
        });
        if (voptioncb.getItems().isEmpty()) {
            voptioncb.getItems().addAll("添加", "删除", "修改", "查询", "积分兑换", "会员续费");
        }
        if (vselectrangecb.getItems().isEmpty()) {
            vselectrangecb.getItems().addAll("会员编号", "姓名", "联系电话");
        }
        if (vdatecb.getItems().isEmpty()) {
            vdatecb.getItems().addAll(1, 3, 6, 12, 18, 24);
        }
        if (!vdatecb.getItems().isEmpty()) {
            vdatecb.setValue(1);
        }
    }

    @FXML
    protected void setVoptioncb() {
        if ("添加".equals(voptioncb.getValue())) {
            vidtf.setEditable(false);
            vnametf.setEditable(true);
            vphonetf.setEditable(true);
            vintegraltf.setEditable(false);
            vselecttf.setEditable(false);
            vlabel.setText("有效期");
        } else if ("删除".equals(voptioncb.getValue())) {
            vidtf.setEditable(true);
            vnametf.setEditable(false);
            vphonetf.setEditable(false);
            vintegraltf.setEditable(false);
            vselecttf.setEditable(false);
            vlabel.setText("续费时长");
        } else if ("修改".equals(voptioncb.getValue())) {
            vidtf.setEditable(true);
            vnametf.setEditable(true);
            vphonetf.setEditable(true);
            vintegraltf.setEditable(false);
            vselecttf.setEditable(false);
            vlabel.setText("续费时长");
        } else if ("查询".equals(voptioncb.getValue())) {
            vidtf.setEditable(false);
            vnametf.setEditable(false);
            vphonetf.setEditable(false);
            vintegraltf.setEditable(false);
            vselecttf.setEditable(true);
            vlabel.setText("续费时长");
        } else if ("积分兑换".equals(voptioncb.getValue())) {
            vidtf.setEditable(false);
            vnametf.setEditable(false);
            vphonetf.setEditable(false);
            vintegraltf.setEditable(true);
            vselecttf.setEditable(false);
            vlabel.setText("续费时长");
        } else if ("会员续费".equals(voptioncb.getValue())) {
            vidtf.setEditable(false);
            vnametf.setEditable(false);
            vphonetf.setEditable(false);
            vintegraltf.setEditable(false);
            vselecttf.setEditable(false);
            vlabel.setText("续费时长");
        }
    }

    @FXML
    protected void vokbutton() {
        if ("添加".equals(voptioncb.getValue())) {
            vadd();
        } else if ("删除".equals(voptioncb.getValue())) {
            vdelete();
        } else if ("修改".equals(voptioncb.getValue())) {
            vupdate();
        } else if ("积分兑换".equals(voptioncb.getValue())) {
            vexchange();
        } else if ("查询".equals(voptioncb.getValue())) {
            vidtf.clear();
            vnametf.clear();
            vphonetf.clear();
            vintegraltf.clear();
            vselect();
        } else if ("会员续费".equals(voptioncb.getValue())) {
            vdate();
        } else {
            vrefreshbutton();
            function.setAlert("操作类型未选择！");
        }
    }

    private void vdate() {
        if (!vidtf.getText().isEmpty()) {
            fristString = vidtf.getText();
            List<Allentity> list = cashierDao.getVipcustomervid(connection);
            assert list != null;
            if ("未到期".equals(list.get(0).getVstate())) {
                Date vodate = list.get(0).getVodate();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(vodate);
                calendar.add(Calendar.MONTH, vdatecb.getValue());
                fristString = simpleDateFormat.format(calendar.getTime());
                secondString = "未到期";
                thirdString = vidtf.getText();
                cashierDao.updateVipcustomerall(connection);
                function.setAlert1("会员" + vidtf.getText() + "\n" + "续费成功！");
                vtablevalue();
                vrefreshbutton();
            } else {
                function.setAlert("该会员已到期，不可续费！");
            }
        } else {
            function.setAlert("会员编号为空！" + "\n" + "请双击表格选择会员编号！");
        }
    }

    private void vexchange() {
        if (!vidtf.getText().isEmpty()) {
            if (!vintegraltf.getText().isEmpty()) {
                try {
                    long l = Long.parseLong(vintegraltf.getText());
                    if (l >= 0) {
                        fristString = vintegraltf.getText();
                        secondString = vidtf.getText();
                        List<Allentity> list = cashierDao.getIntegral(connection);
                        if (l <= list.get(0).getVintegral()) {
                            cashierDao.updateVipcustomerchange(connection);
                            vtablevalue();
                            vrefreshbutton();
                            function.setAlert1("兑换成功！");
                        } else {
                            function.setAlert("兑换积分超过已有积分");
                        }
                    } else {
                        function.setAlert("积分输入不是正数！");
                    }
                } catch (NumberFormatException e) {
                    function.setAlert("积分输入不是整数！");
                }
            } else {
                function.setAlert("积分兑换为空！");
            }
        } else {
            function.setAlert("会员编号为空！" + "\n" + "请双击表格选择会员编号！");
        }
    }

    private void vadd() {
        int num;
        if (vdatecb.getValue() <= 6) {
            num = 100;
        } else if (vdatecb.getValue() <= 12) {
            num = 200;
        } else {
            num = 500;
        }
        if (!vnametf.getText().isEmpty() && !vphonetf.getText().isEmpty()) {
            String vid;
            List<Allentity> list;
            Date nowdata = new Date();
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyMMdd");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String data = simpleDateFormat1.format(nowdata);
            String svrdate = simpleDateFormat.format(nowdata);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(nowdata);
            calendar.add(Calendar.MONTH, vdatecb.getValue());
            String svodate = simpleDateFormat.format(calendar.getTime());
            do {
                vid = "V" + data + (int) ((Math.random() * (999999 - 100000) + 1) + 100000);
                fristString = vid;
                list = cashierDao.getVipcustomervid(connection);
            } while (!Objects.requireNonNull(list).isEmpty());
            if (vphonetf.getText().length() <= 12) {
                fristString = vid;
                secondString = vnametf.getText();
                thirdString = (vboyrb.isSelected() ? "男" : "女");
                fourthString = vphonetf.getText();
                fifthString = String.valueOf(num);
                sixthString = svrdate;
                seventhString = svodate;
                eighthString = "未到期";
                cashierDao.insertVipcustomer(connection);
                vtablevalue();
                vrefreshbutton();
                function.setAlert1("注册成功！");
            } else {
                function.setAlert("联系方式长度超过12位");
            }
        } else {
            function.setAlert("姓名或联系电话输入为空！");
        }
    }


    private void vdelete() {
        if (!vidtf.getText().isEmpty()) {
            fristString = vidtf.getText();
            List<Allentity> list = cashierDao.getVipcustomervid(connection);
            assert list != null;
            if (!list.isEmpty()) {
                cashierDao.deleteVipcustomer(connection);
                function.setAlert1("删除成功！");
                vrefreshbutton();
                vtablevalue();
            }
        } else {
            function.setAlert("会员编号为空！");
        }
    }

    private void vupdate() {
        if (!vidtf.getText().isEmpty()) {
            try {
                long interal;
                if (vintegraltf.getText().isEmpty()) {
                    interal = 0;
                } else {
                    Long.parseLong(vintegraltf.getText());
                    interal = Long.parseLong(vintegraltf.getText());
                }
                if (interal >= 0) {
                    fristString = vidtf.getText();
                    List<Allentity> list = cashierDao.getVipcustomervid(connection);
                    assert list != null;
                    if (!list.isEmpty()) {
                        fristString = vnametf.getText();
                        secondString = (vboyrb.isSelected() ? "男" : "女");
                        thirdString = vphonetf.getText();
                        fourthString = String.valueOf(interal);
                        fifthString = vidtf.getText();
                        cashierDao.updateVipcustomerall1(connection);
                        vtablevalue();
                        function.setAlert1("修改成功！");
                        vrefreshbutton();
                    } else {
                        function.setAlert("会员编号不存在！");
                    }
                } else {
                    function.setAlert("积分输入不为正数！");
                }
            } catch (Exception e) {
                function.setAlert("积分输入不为整数");
            }
        } else {
            function.setAlert("会员编号为空！");
        }
    }

    private void vselect() {
        fristString = vselecttf.getText();
        if ("会员编号".equals(vselectrangecb.getValue())) {
            vtable.setItems(function.gettablevalue(cashierDao.getVipcustomervid1(connection)));
        } else if ("姓名".equals(vselectrangecb.getValue())) {
            vtable.setItems(function.gettablevalue(cashierDao.getVipcustomervname(connection)));
        } else if ("联系电话".equals(vselectrangecb.getValue())) {
            vtable.setItems(function.gettablevalue(cashierDao.getVipcustomervphone(connection)));
        } else {
            function.setAlert("搜索范围未选择！");
        }
    }

    @FXML
    protected void vrefreshbutton() {
        vidtf.clear();
        vnametf.clear();
        vphonetf.clear();
        vintegraltf.clear();
        vselecttf.clear();
        vtablevalue();
    }

    protected void vtablevalue() {
        vtable.setItems(function.gettablevalue(cashierDao.getVipcustomer(connection)));
    }

    /*个人中心*/
    @FXML
    protected void personal() {
        istidchange();
    }

    protected void cptablevalue() {
        fristString = LogininEvent.eid;
        getcountprice(cashierDao.getPsqlessql(connection), cashierDao.getPsalesvsql(connection), cashierDao.getPsalespsql(connection), cashierDao.getPsalesvcount(connection), cashierDao.getPsalespcount(connection));
    }

    private void getcountprice(List<Allentity> list, Object vsql, Object psql, Object vcount, Object pcount) {
        double vprice;
        double pprice;
        if (vsql == null) {
            vprice = 0.0;
        } else {
            vprice = (double) vsql;
        }
        if (psql == null) {
            pprice = 0.0;
        } else {
            pprice = (double) psql;
        }
        countpricetf.setText(String.valueOf(vprice + pprice));
        countnumtf.setText(String.valueOf((long) vcount + (long) pcount));
        cptable.setItems(function.gettablevalue(list));
    }

    protected void ccptablevalue(String vid, String tid) {
        fristString = tid;
        if (vid.charAt(0) == 'P') {
            ccptable.setItems(function.gettablevalue(cashierDao.getpSales(connection)));
        } else {
            ccptable.setItems(function.gettablevalue(cashierDao.getvSales(connection)));
        }
    }

    protected void ccprefreshtable() {
        ccptable.setItems(function.gettablevalue(cashierDao.setTbalerefresh(connection)));
    }

    protected void ctgrefreshtable() {
        ctgoodstable.setItems(function.gettablevalue(cashierDao.setTbalerefresh(connection)));
    }


    @FXML
    protected void personal1() {
        istidchange();
        getinfornation();
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        if (yearcb.getItems().isEmpty()) {
            for (int i = 2010; i <= 2070; i++) {
                yearcb.getItems().add(i);
            }
        }
        yearcb.setValue(year);
        int month = (calendar.get(Calendar.MONTH) + 1);
        if (monthcb.getItems().isEmpty()) {
            for (int i = 1; i <= 12; i++) {
                monthcb.getItems().add(i);
            }
        }
        monthcb.setValue(month);
        if (ppcb.getItems().isEmpty()) {
            ppcb.getItems().addAll("姓名", "联系电话", "住址", "生日", "性别");
        }
        function.setCbItem(ppprovince);
        setcount(yearcb.getValue(), monthcb.getValue());
    }

    private void getinfornation() {
        fristString = LogininEvent.eid;
        List<Allentity> list = cashierDao.getEmployee(connection);
        assert list != null;
        ppeidtf.setText(list.get(0).getEid());
        ppeaddresstf.setText(list.get(0).getEaddress() + list.get(0).getEdaddress());
        ppenametf.setText(list.get(0).getEname());
        ppephonetf.setText(list.get(0).getEphone());
        ppsextf.setText(list.get(0).getEsex());
        ppebirthday.setText(list.get(0).getEbirthday() + "");
    }

    @FXML
    protected void setmonthcb() {
        int year = 0;
        int month = 0;
        if (!yearcb.getItems().isEmpty() && !monthcb.getItems().isEmpty()) {
            year = yearcb.getValue();
            month = monthcb.getValue();
        }
        setcount(year, month);
    }

    public void setcount(int year, int month) {
        String begindate;
        String enddate;
        String begindate1;
        String enddate1;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        //获取前月的第一天
        Calendar cal_1 = Calendar.getInstance();
        cal_1.set(year, month - 1, 1);
        cal_1.add(Calendar.MONTH, -1);
        cal_1.set(Calendar.DAY_OF_MONTH, 1);
        begindate = simpleDateFormat3.format(cal_1.getTime());
        //获取前月的最后一天
        cal_1.set(year, month - 1, 1);
        cal_1.set(Calendar.DAY_OF_MONTH, 0);
        cal_1.add(Calendar.DATE, 1);
        enddate = simpleDateFormat3.format(cal_1.getTime());
        //获取当前月第一天：
        cal_1.set(year, month - 1, 1);
        cal_1.add(Calendar.MONTH, 0);
        cal_1.set(Calendar.DAY_OF_MONTH, 1);
        begindate1 = simpleDateFormat3.format(cal_1.getTime());
        //获取当前月最后一天
        cal_1.set(year, month - 1, 1);
        cal_1.set(Calendar.DAY_OF_MONTH, cal_1.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal_1.add(Calendar.DATE, 1);
        enddate1 = simpleDateFormat3.format(cal_1.getTime());
//      上一个月
        fristString = LogininEvent.eid;
        secondString = begindate;
        thirdString = enddate;
        Object vssql = cashierDao.gteVssql(connection);
        Object pssql = cashierDao.gtePssql(connection);
        Object vsql = cashierDao.gteVsql(connection);
        Object psql = cashierDao.gtePsql(connection);
//        本月
        secondString = begindate1;
        thirdString = enddate1;
        Object vssql1 = cashierDao.gteVssql(connection);
        Object pssql1 = cashierDao.gtePssql(connection);
        Object vsql1 = cashierDao.gteVsql(connection);
        Object psql1 = cashierDao.gtePsql(connection);
//           计算赋值
        countla.setText(String.valueOf(count(vssql1, pssql1)));
        countpricela.setText(String.valueOf(countprice(vsql1, psql1)));
        if (count(vssql, pssql) != 0) {
            lastcountla.setText(String.format("%.2f", (double) ((count(vssql1, pssql1) - count(vssql, pssql)) / count(vssql, pssql)) * 100) + "%");
        } else {
            lastcountla.setText("-");
        }
        if (countprice(vsql1, psql1) != 0.0) {
            lastcountpricela.setText(String.format("%.2f", ((countprice(vsql1, psql1) - countprice(vsql, psql)) / countprice(vsql, psql)) * 100) + "%");
        } else {
            lastcountpricela.setText("-");
        }
    }

    @FXML
    protected void setupbutton() {
        if ("生日".equals(ppcb.getValue())) {
            pptf.setVisible(false);
            pptf.setEditable(false);
            sexhb.setVisible(false);
            ppdp.setVisible(true);
            pphb.setVisible(false);
        } else if ("性别".equals(ppcb.getValue())) {
            pptf.setVisible(false);
            pptf.setEditable(false);
            sexhb.setVisible(true);
            ppdp.setVisible(false);
            pphb.setVisible(false);
        } else if ("住址".equals(ppcb.getValue())) {
            pptf.setVisible(true);
            pptf.setEditable(false);
            sexhb.setVisible(false);
            ppdp.setVisible(false);
            pphb.setVisible(true);
        } else {
            pptf.setVisible(true);
            pptf.setEditable(true);
            sexhb.setVisible(false);
            ppdp.setVisible(false);
            pphb.setVisible(false);
        }
    }

    @FXML
    protected void setupdateokbutton() {

        if ("姓名".equals(ppcb.getValue())) {
            if (!pptf.getText().isEmpty()) {
                fristString = pptf.getText();
                secondString = LogininEvent.eid;
                cashierDao.updateEmployeeename(connection);
                function.setAlert1("修改成功！");
            } else {
                function.setAlert("修改内容为空！");
            }
        } else if ("联系电话".equals(ppcb.getValue())) {
            if (!pptf.getText().isEmpty()) {
                fristString = pptf.getText();
                secondString = LogininEvent.eid;
                cashierDao.updateEmployeeephone(connection);
                function.setAlert1("修改成功！");

            } else {
                function.setAlert("修改内容为空！");

            }
        } else if ("住址".equals(ppcb.getValue())) {
            if (ppprovince.getValue() != null) {
                fristString = function.getaddress(ppprovince, ppcity, pparea);
                secondString = ppaddtf.getText();
                thirdString = LogininEvent.eid;
                cashierDao.updateEmployeeeadd(connection);
            } else {
                function.setAlert("省份选择为空！");
            }
        } else if ("生日".equals(ppcb.getValue())) {
            if (!(ppdp.getValue() + "").isEmpty()) {
                fristString = String.valueOf(ppdp.getValue());
                secondString = LogininEvent.eid;
                cashierDao.updateEmployeeebirthday(connection);
                function.setAlert1("修改成功！");
            } else {
                function.setAlert("日期选择为空！");
            }
        } else if ("性别".equals(ppcb.getValue())) {
            fristString = pboyeb.isSelected() ? "男" : "女";
            secondString = LogininEvent.eid;
            cashierDao.updateEmployeesex(connection);
            function.setAlert1("修改成功！");
        } else {
            function.setAlert("修改项未选择！");
        }
        getinfornation();
        setpprefresh();
    }

    @FXML
    protected void setpprefresh() {
        pptf.clear();
        ppaddtf.clear();
    }

    @FXML
    protected void pcityempty() {
        function.setcityempty(ppcity, pparea);
    }

    @FXML
    protected void peareaempty() {
        int areanum = pparea.getItems().size();
        if (areanum > 0) {
            pparea.getItems().subList(0, areanum).clear();
        }
    }

    @FXML
    protected void pecityshow() {
        function.setcityshow(ppprovince, ppcity);
    }

    @FXML
    protected void peareashow() {
        function.setareashow(ppprovince, ppcity, pparea);
    }

    private double countprice(Object vsql, Object psql) {
        double vprice;
        double pprice;
        if (vsql == null) {
            vprice = 0.0;
        } else {
            vprice = (double) vsql;
        }
        if (psql == null) {
            pprice = 0.0;
        } else {
            pprice = (double) psql;
        }
        return vprice + pprice;
    }

    private long count(Object vssql, Object pssql) {
        long vssql1;
        long pssql1;
        if (vssql == null) {
            vssql1 = 0;
        } else {
            vssql1 = (long) vssql;
        }
        if (pssql == null) {
            pssql1 = 0;
        } else {
            pssql1 = (long) pssql;
        }
        return vssql1 + pssql1;
    }


    @FXML
    protected void personalcenter() {
        istidchange();
        cptid.setCellValueFactory(new PropertyValueFactory<>("tid"));
        cpvid.setCellValueFactory(new PropertyValueFactory<>("vid"));
        cpdatetime.setCellValueFactory(new PropertyValueFactory<>("sdate"));
        cpcash.setCellValueFactory(new PropertyValueFactory<>("scash"));
        cpintergal.setCellValueFactory(new PropertyValueFactory<>("sintegral"));
        cptablevalue();
        ccptid.setCellValueFactory(new PropertyValueFactory<>("tid"));
        cpgid.setCellValueFactory(new PropertyValueFactory<>("gid"));
        cpgname.setCellValueFactory(new PropertyValueFactory<>("gname"));
        cpprice.setCellValueFactory(new PropertyValueFactory<>("gprice"));
        cptnum.setCellValueFactory(new PropertyValueFactory<>("tnum"));
        cpnumprice.setCellValueFactory(new PropertyValueFactory<>("sumprice"));
        ccprefreshtable();
        cptable.setRowFactory(tv -> {
            TableRow<Allentity> TableRow = new TableRow<>();
            TableRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !TableRow.isEmpty()) {
                    ccptablevalue(TableRow.getItem().getVid(), TableRow.getItem().getTid());
                }
            });
            return TableRow;
        });
        if (cprangecb.getItems().isEmpty()) {
            cprangecb.getItems().addAll("小票编号", "顾客编号", "购买时间");
        }
    }

    @FXML
    protected void setcpokbutton() {
        fristString = LogininEvent.eid;
        secondString = cpselecttf.getText();
        if ("小票编号".equals(cprangecb.getValue())) {
            getcountprice(cashierDao.getPsqlessqltid(connection), cashierDao.getPsalesvsqltid(connection), cashierDao.getPsalespsqltid(connection), cashierDao.getPsalesvcounttid(connection), cashierDao.getPsalespcounttid(connection));
        } else if ("顾客编号".equals(cprangecb.getValue())) {
            getcountprice(cashierDao.getPsqlessqlvid(connection), cashierDao.getPsalesvsqlvid(connection), cashierDao.getPsalespsqlvid(connection), cashierDao.getPsalesvcountvid(connection), cashierDao.getPsalespcountvid(connection));
        } else if ("购买时间".equals(cprangecb.getValue())) {
            thirdString = getDate(cpbegin, cpend)[0];
            fourthString = getDate(cpbegin, cpend)[0];
            getcountprice(cashierDao.getPsqlessqldate(connection), cashierDao.getPsalesvsqldate(connection), cashierDao.getPsalespsqldate(connection), cashierDao.getPsalesvcountdate(connection), cashierDao.getPsalespcountdate(connection));
        } else {
            function.setAlert("搜索范围未选择！");
        }
    }

    @FXML
    private void setcprefershbutton() {
        cpselecttf.clear();
        cptablevalue();
    }

    @FXML
    protected void setcpselect() {
        setcprefershbutton();
        ccprefreshtable();
        if ("购买时间".equals(cprangecb.getValue())) {
            cphb.setVisible(true);
            cpselecttf.setVisible(false);
        } else {
            cphb.setVisible(false);
            cpselecttf.setVisible(true);
        }
    }

    /*修改密码*/
    @FXML
    protected void setCode() {
        if (codela.getText().isEmpty()) {
            char a = (char) (Math.random() * 25 + 65);
            char b = (char) (Math.random() * 25 + 65);
            char c = (char) (Math.random() * 25 + 65);
            char d = (char) (Math.random() * 25 + 65);
            String code = a + "" + b + "" + c + "" + d;
            codela.setText(code);
        }
    }

    @FXML
    protected void setFindpassword() {
        Loginin loginin = new Loginin();
        try {
            closestage();
            loginin.findpasswordsstage().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void ppokbutton() {
        fristString = LogininEvent.eid;
        List<Allentity> list = cashierDao.getEmployee(connection);
        if (!opassword.getText().isEmpty() && !npassword.getText().isEmpty() && !nnpassword.getText().isEmpty() && npassword.getText().length() >= 6) {
            assert list != null;
            if (list.get(0).getEpassword().equals(opassword.getText())) {
                if (npassword.getText().equals(nnpassword.getText())) {
                    if (ppcode.getText().equalsIgnoreCase(codela.getText())) {
                        fristString = npassword.getText();
                        secondString = LogininEvent.eid;
                        cashierDao.updateEmployeeepassword(connection);
                        function.setAlert1("密码修改成功，请记住新密码！");
                    } else {
                        function.setAlert("验证码输入错误！");
                    }
                } else {
                    function.setAlert("确认密码与新密码输入不同！");
                }
            } else {
                function.setAlert("原密码错误！");
            }
        } else {
            function.setAlert("密码输入为空或新密码长度小于6位！");
        }
        pprefresh();
    }

    @FXML
    private void pprefresh() {
        opassword.clear();
        npassword.clear();
        nnpassword.clear();
        ppcode.clear();
    }

    private void istidchange() {
        fristString = tid;
        List<Allentity> list = cashierDao.getTicket(connection);
        assert list != null;
        is = list.isEmpty();
    }

    protected void cashiertable() {
        cashiertable.setItems(function.gettablevalue(cashierDao.getGoods(connection)));
    }

    protected void cctablevalue() {
        fristString = tid;
        if (!truerb.isSelected()) {
            cctable.setItems(function.gettablevalue(cashierDao.getpSales(connection)));
        } else {
            cctable.setItems(function.gettablevalue(cashierDao.getvSales(connection)));
        }
    }

    private void gettid() {
        Date noedata = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
        List<Allentity> list;
        do {
            tid = simpleDateFormat.format(noedata) + ((int) (Math.random() * (999999 - 100000 + 1) + 100000));
            fristString = tid;
            list = cashierDao.getTicket(connection);
        } while (!Objects.requireNonNull(list).isEmpty());
    }

    //    获取连个日期相差天数
    private long getday(Date oldddate, Date newdate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s1 = simpleDateFormat.format(oldddate);
        String s = simpleDateFormat.format(newdate);
        try {
            Date olddate1 = dateFormat.parse(s1);
            Date newdate1 = dateFormat.parse(s);
            return (newdate1.getTime() - olddate1.getTime()) / 1000 / 60 / 60 / 24;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}