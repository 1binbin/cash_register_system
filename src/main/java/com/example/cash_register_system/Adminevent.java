package com.example.cash_register_system;

import Dao.AdminDaoImpl;
import JDBCUtils.Allentity;
import JDBCUtils.JdbcConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author hongxiaobin
 * @create 2022/1/19-21:10
 * @description 定义管理员界面事件
 */
@SuppressWarnings("DuplicatedCode")
public class Adminevent {
    private static final ArrayList<String> arrayList = new ArrayList<>();
    private static final SimpleDateFormat simpledateformat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat simpledateformat2 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
    private static final SimpleDateFormat simpledateformat3 = new SimpleDateFormat("yyyy-MM-dd");
    public static int a;
    public static int b;
    public static String fristString = null;
    public static String secondString = null;
    public static String thirdString = null;
    public static String fourthString = null;
    public static String fifthString = null;
    public static String sixthString = null;
    public static String seventhString = null;
    public static String eighthString = null;
    public static String ninthString = null;
    public static String tenthString = null;
    public static String eleventhString = null;
    private static int choise;
    private static int goodschoise;
    private static int employeechoise;
    private static File file;
    private static double num;
    private static boolean isget;
    private final AdminDaoImpl adminDao = new AdminDaoImpl();
    Function function = new Function();
    Loginin loginin = new Loginin();
    private Connection connection;
    @FXML
    private TableColumn<Allentity, String> gidcolumn;
    @FXML
    private TableColumn<Allentity, String> gnamecolumn;
    @FXML
    private TableColumn<Allentity, String> gcategorycolumn;
    @FXML
    private TableColumn<Allentity, String> gorigincolumn;
    @FXML
    private TableColumn<Allentity, String> gindatecolumn;
    @FXML
    private TableColumn<Allentity, String> gnumcolumn;
    @FXML
    private TableColumn<Allentity, String> gpurchasepricecolumn;
    @FXML
    private TableColumn<Allentity, String> gppricecolumn;
    @FXML
    private TableColumn<Allentity, String> gvpricecolumn;
    @FXML
    private TableColumn<Allentity, String> gsuppliercolumn;
    @FXML
    private TableColumn<Allentity, String> gdiscountcolumn;
    @FXML
    private TableColumn<Allentity, String> cgoodscolumn;
    @FXML
    private TableColumn<Allentity, String> cemployeecolumn;
    @FXML
    private TableColumn<Allentity, String> eidcolumn;
    @FXML
    private TableColumn<Allentity, String> enamecolumn;
    @FXML
    private TableColumn<Allentity, String> erolecolumn;
    @FXML
    private TableColumn<Allentity, String> eaddresscolumn;
    @FXML
    private TableColumn<Allentity, String> ephonecolumn;
    @FXML
    private TableColumn<Allentity, String> edaddresscolumn;
    @FXML
    private TableColumn<Allentity, String> specificition;
    @FXML
    private TableColumn<Allentity, String> eagecolumn;
    @FXML
    private TableColumn<Allentity, String> esexcolumn;
    @FXML
    private TableColumn<Allentity, String> recolumn;
    @FXML
    private TableColumn<Allentity, String> esalarycolumn;
    @FXML
    private TableView<Allentity> goodstable;
    @FXML
    private TableView<Allentity> cgoodstable;
    @FXML
    private TableView<Allentity> cemployeetable;
    @FXML
    private TableView<Allentity> employeetable;
    @FXML
    private TableView<Allentity> reficitiontable;
    @FXML
    private TextField deletetf;
    @FXML
    private ComboBox<String> gcategorycb;
    @FXML
    private TextField gidtf;
    @FXML
    private TextField ginnumtf;
    @FXML
    private TextField gppricetf;
    @FXML
    private TextField gnametf;
    @FXML
    private TextField gpushertf;
    @FXML
    private TextField gsuppliertf;
    @FXML
    private TextField gvpricetf;
    @FXML
    private Slider gvipslider;
    @FXML
    private TextField selecttf;
    @FXML
    private ComboBox<String> rangecb;
    @FXML
    private HBox dateselecthb;
    @FXML
    private DatePicker begindate;
    @FXML
    private DatePicker enddate;
    @FXML
    private ComboBox<String> provincecb;
    @FXML
    private ComboBox<String> citycb;
    @FXML
    private ComboBox<String> areacb;
    @FXML
    private ComboBox<Integer> vipchoose;
    @FXML
    private TextField updategidtf;
    @FXML
    private ComboBox<String> updatecb;
    @FXML
    private ComboBox<Integer> uvipchoose;
    @FXML
    private TextField ugvpricetf;
    @FXML
    private Slider ugvipslider;
    @FXML
    private TextField updatetf;
    @FXML
    private DatePicker updatedata;
    @FXML
    private ComboBox<String> uprovincecb;
    @FXML
    private ComboBox<String> ucitycb;
    @FXML
    private ComboBox<String> uareacb;
    @FXML
    private ComboBox<String> ctablecb;
    @FXML
    private ComboBox<String> coperationcb;
    @FXML
    private ComboBox<String> cobjectcb;
    @FXML
    private TextField cgettexttf;
    @FXML
    private ComboBox<String> selectcategorycb;
    @FXML
    private ComboBox<String> sprovincecb;
    @FXML
    private ComboBox<String> scitycb;
    @FXML
    private ComboBox<String> sareacb;
    @FXML
    private ComboBox<String> eprovincecb;
    @FXML
    private ComboBox<String> ecitycb;
    @FXML
    private ComboBox<String> eareacb;
    @FXML
    private ComboBox<String> ucategorycb;
    @FXML
    private ComboBox<String> eselectrangecb;
    @FXML
    private ComboBox<String> erolecb;
    @FXML
    private ComboBox<String> esrolecb;
    @FXML
    private TextField eselecttf;
    @FXML
    private TextField eidtf;
    @FXML
    private TextField enametf;
    @FXML
    private TextField edaddresstf;
    @FXML
    private TextField esalarytf;
    @FXML
    private ComboBox<String> soptioncb;
    @FXML
    private RadioButton eboy;
    @FXML
    private Label yuanla;
    @FXML
    private Label jifenla;
    @FXML
    private TextField yuantf;
    @FXML
    private TextField jifentf;
    @FXML
    private ComboBox<String> recb;
    @FXML
    private ComboBox<String> grecb;
    @FXML
    private ComboBox<String> gmonthcb;
    @FXML
    private Label gyearla;
    @FXML
    private TextField ggidtf;
    @FXML
    private TextField nowcounttf;
    @FXML
    private TextField nowprice;
    @FXML
    private TextField lasttf;
    @FXML
    private TextField lastpricetf;
    @FXML
    private TableView<Allentity> cptable;
    @FXML
    private TableView<Allentity> ccptable;
    @FXML
    private TableView<Allentity> seidtable1;
    @FXML
    private TableView<Allentity> seidtable2;
    @FXML
    private TableView<Allentity> sptable;
    @FXML
    private TableColumn<Allentity, String> cptid;
    @FXML
    private TableColumn<Allentity, String> cpvid;
    @FXML
    private TableColumn<Allentity, String> cpeid;
    @FXML
    private TableColumn<Allentity, String> cpdatetime;
    @FXML
    private TableColumn<Allentity, String> cpcash;
    @FXML
    private TableColumn<Allentity, String> cpintergal;
    @FXML
    private TableColumn<Allentity, String> ccptid;
    @FXML
    private TableColumn<Allentity, String> cpgid;
    @FXML
    private TableColumn<Allentity, String> cpgname;
    @FXML
    private TableColumn<Allentity, String> cpprice;
    @FXML
    private TableColumn<Allentity, String> cptnum;
    @FXML
    private TableColumn<Allentity, String> cpnumprice;
    @FXML
    private TableColumn<Allentity, String> sspecificition;
    @FXML
    private TableColumn<Allentity, String> sccolumn;
    @FXML
    private TableColumn<Allentity, String> ssscolumn;
    @FXML
    private TableColumn<Allentity, String> seidcolumn;
    @FXML
    private TableColumn<Allentity, String> snamecolumn;
    @FXML
    private TableColumn<Allentity, String> svcolumn;
    @FXML
    private TableColumn<Allentity, String> spcolumn;
    @FXML
    private TableColumn<Allentity, String> sscolumn;
    @FXML
    private TableColumn<Allentity, String> sdcolumn;
    @FXML
    private TableColumn<Allentity, String> sppcolumn;
    @FXML
    private TableColumn<Allentity, String> sncolumn;
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
    private TextField seidtf;
    @FXML
    private TextField countnumtf;
    @FXML
    private TextField countpricetf;
    @FXML
    private TextField filetf;
    @FXML
    private TextArea badeleteta;
    @FXML
    private PieChart piechart;
    @FXML
    private DatePicker cbegindate;
    @FXML
    private DatePicker cenddate;
    @FXML
    private BarChart<String, Double> barchart1;
    @FXML
    private CategoryAxis xaxis1;
    @FXML
    private LineChart<String, Double> linechart;
    @FXML
    private CategoryAxis xaxis2;
    @FXML
    private ComboBox<Integer> yearcombox;
    @FXML
    private LineChart<String, Double> linechartyear;
    @FXML
    private CategoryAxis xaxis3;
    @FXML
    private TextField January;
    @FXML
    private TextField February;
    @FXML
    private TextField March;
    @FXML
    private TextField April;
    @FXML
    private TextField May;
    @FXML
    private TextField June;
    @FXML
    private TextField July;
    @FXML
    private TextField August;
    @FXML
    private TextField September;
    @FXML
    private TextField October;
    @FXML
    private TextField November;
    @FXML
    private TextField December;
    @FXML
    private Label statisticallabel;
    @FXML
    private TextField totalrevenue;
    @FXML
    private TextField totalcost;
    @FXML
    private TextField grossprofit;
    @FXML
    private TextField averageprofit;
    @FXML
    private TextField tlgrowth;
    @FXML
    private TextField trgrowth;
    @FXML
    private TextField gpgrowth;
    @FXML
    private TextField apgrowth;

    {
        try {
            connection = JdbcConnection.getConnection();
        } catch (Exception e) {
            function.setAlert("数据库连接出错！");
        }
    }

    /*管理员面板事件*/
//    是否退出登录
    @FXML
    protected void isoutlogin() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("注销");
        alert.setHeaderText("是否要退出登录");
        Optional<ButtonType> button = alert.showAndWait();
        if (button.isPresent() && button.get() == ButtonType.OK) {
            try {
                Loginin.stageclose.close();
                loginin.loginStage().show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            resetlogins();
        }
    }

    //    重新登录
    @FXML
    public void resetlogins() {
        Loginin.stageclose.close();
        try {
            loginin.adminStage().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*商品管理界面事件*/
//    商品管理界面初始化
    @FXML
    public void admingoods() {
        gidcolumn.setCellValueFactory(new PropertyValueFactory<>("gid"));
        gnamecolumn.setCellValueFactory(new PropertyValueFactory<>("gname"));
        gcategorycolumn.setCellValueFactory(new PropertyValueFactory<>("gcategory"));
        gorigincolumn.setCellValueFactory(new PropertyValueFactory<>("gorigin"));
        gindatecolumn.setCellValueFactory(new PropertyValueFactory<>("gindate"));
        gnumcolumn.setCellValueFactory(new PropertyValueFactory<>("gnum"));
        gpurchasepricecolumn.setCellValueFactory(new PropertyValueFactory<>("gpurchaseprice"));
        gppricecolumn.setCellValueFactory(new PropertyValueFactory<>("gpprice"));
        gvpricecolumn.setCellValueFactory(new PropertyValueFactory<>("gvprice"));
        gsuppliercolumn.setCellValueFactory(new PropertyValueFactory<>("gsupplier"));
        gdiscountcolumn.setCellValueFactory(new PropertyValueFactory<>("gdiscount"));
        specificition.setCellValueFactory(new PropertyValueFactory<>("specifications"));
        goodstablevalue();
        goodstable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        goodstable.getSelectionModel().selectedItemProperty().addListener((observable, oldvalue, newvalue) -> {
            ObservableList<Allentity> allentityObservable = goodstable.getSelectionModel().getSelectedItems();
            for (Allentity allentity : allentityObservable) {
                arrayList.add(allentity.getGid());
            }
        });
//        鼠标双击
        goodstable.setRowFactory(tv -> {
            TableRow<Allentity> TableRow = new TableRow<>();
            TableRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !TableRow.isEmpty()) {
                    ggidtf.setText(TableRow.getItem().getGid());
                    updategidtf.setText(TableRow.getItem().getGid());
                    deletetf.setText(TableRow.getItem().getGid());
                    getgoodsstatistical();
                }
            });
            return TableRow;
        });
        if (rangecb.getItems().isEmpty()) {
            rangecb.getItems().addAll("全部", "商品号", "商品名", "类别", "供货商", "产地", "进货日期");
        }
        function.setCbItem(provincecb);
        function.setCbItem(uprovincecb);
        function.setCbItem(sprovincecb);
        if (vipchoose.getItems().isEmpty()) {
            for (int i = 15; i <= 100; i += 5) {
                vipchoose.getItems().add(i);
            }
        }
        if (updatecb.getItems().isEmpty()) {
            updatecb.getItems().addAll("商品号", "商品名", "类别", "产地", "供货商", "进货日期", "现有库存量", "进价", "售价", "会员折扣", "规格");
        }
        if (uvipchoose.getItems().isEmpty()) {
            for (int i = 15; i <= 100; i += 5) {
                uvipchoose.getItems().add(i);
            }
        }
        begindate.setEditable(false);
        enddate.setEditable(false);
        if (gmonthcb.getItems().isEmpty()) {
            for (int i = 1; i <= 12; i++) {
                gmonthcb.getItems().add(i + "");
            }
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        gyearla.setText(calendar.get(Calendar.YEAR) + "年份");
        gmonthcb.setValue((calendar.get(Calendar.MONTH) + 1) + "");
        getgoodsstatistical();
    }

    @FXML
    protected void setsokbutton() {
        getgoodsstatistical();
    }

    @FXML
    protected void setrefresh() {
        ggidtf.clear();
    }

    @FXML
    protected void setcb() {
        getgoodsstatistical();
    }

    private void getgoodsstatistical() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String begindate, enddate, begindate1, enddate1;
        if ("1".equals(gmonthcb.getValue())) {
//                上一个月
            calendar.set(year - 1, Calendar.DECEMBER, 1);
            int lastdate = calendar.getActualMaximum(Calendar.DATE);
            calendar.set(Calendar.DAY_OF_MONTH, lastdate);
            begindate = (year - 1) + "-12-01";
            enddate = simpleDateFormat.format(calendar.getTime());
//                本月
            calendar.set(year, Calendar.JANUARY, 1);
            int lastdate1 = calendar.getActualMaximum(Calendar.DATE);
            calendar.set(Calendar.DAY_OF_MONTH, lastdate1);
            begindate1 = (year) + "-01-01";

        } else {
//                上一个月
            calendar.set(year, Integer.parseInt(gmonthcb.getValue()) - 2, 1);
            int lastdate = calendar.getActualMaximum(Calendar.DATE);
            calendar.set(Calendar.DAY_OF_MONTH, lastdate);
            begindate = (year) + "-" + (Integer.parseInt(gmonthcb.getValue()) - 1) + "-01";
            enddate = simpleDateFormat.format(calendar.getTime());
//                本月
            calendar.set(year, Integer.parseInt(gmonthcb.getValue()) - 1, 1);
            int lastdate1 = calendar.getActualMaximum(Calendar.DATE);
            calendar.set(Calendar.DAY_OF_MONTH, lastdate1);
            begindate1 = (year) + "-" + gmonthcb.getValue() + "-01";
        }
        enddate1 = simpleDateFormat.format(calendar.getTime());
        long gidnow, gidlast;
        String now, last;
        if (ggidtf.getText().isEmpty()) {
//            不按照商品号
            fristString = begindate1;
            secondString = enddate1;
            gidnow = (long) adminDao.getGidcount(connection);
            fristString = begindate;
            secondString = enddate;
            gidlast = (long) adminDao.getGidcount(connection);
            fristString = begindate;
            secondString = enddate;
            last = String.valueOf(adminDao.getSumgpurchaseprice(connection));
            fristString = begindate1;
            secondString = enddate1;
            now = String.valueOf(adminDao.getSumgpurchaseprice(connection));
            nowprice.setText(adminDao.getSumgpurchaseprice(connection) + "");

        } else {
//            按照商品号
            fristString = begindate1;
            secondString = enddate1;
            thirdString = ggidtf.getText();
            gidnow = (long) adminDao.getGidcount1(connection);
            fristString = begindate;
            secondString = enddate;
            thirdString = ggidtf.getText();
            gidlast = (long) adminDao.getGidcount1(connection);
            fristString = begindate;
            secondString = enddate;
            thirdString = ggidtf.getText();
            last = String.valueOf(adminDao.getSumgpurchaseprice1(connection));
            fristString = begindate1;
            secondString = enddate1;
            thirdString = ggidtf.getText();
            now = String.valueOf(adminDao.getSumgpurchaseprice1(connection));
            nowprice.setText(adminDao.getSumgpurchaseprice1(connection) + "");
        }
        nowcounttf.setText(gidnow + "");
        lasttf.setText(String.format("%.2f", (((double) gidnow - (double) gidlast) / (double) gidlast) * 100) + "%");
        if (!"null".equals(last) && !"null".equals(now)) {
            lastpricetf.setText(String.format("%.2f", ((Double.parseDouble(now) - Double.parseDouble(last))) / (Double.parseDouble(last)) * 100) + "%");
        } else {
            lastpricetf.setText("-");
        }
    }

    @FXML
    protected void setgcategory() {
        function.getgcategory(gcategorycb);
        function.getgcategory(selectcategorycb);
        function.getgcategory(ucategorycb);
    }

    //    搜索界面重置按钮
    @FXML
    protected void selectrefresh() {
        selecttf.clear();
        goodstablevalue();
    }

    //    确定删除按钮
    @FXML
    protected void okdelete() {
        if (!deletetf.getText().isEmpty()) {
            fristString = deletetf.getText();
            List<Allentity> list = adminDao.getGidlist(connection);
            assert list != null;
            if (!list.isEmpty()) {
                fristString = deletetf.getText();
                adminDao.deleteGoods(connection);
                goodstable.setItems(function.gettablevalue(adminDao.getGoods(connection)));
                deletetf.clear();
                function.setAlert1("删除成功！");
            } else {
                function.setAlert("商品编号不存在！");
            }
        } else {
            function.setAlert("商品编号为空！");
        }
    }

    //    搜索范围
    @FXML
    protected void rangecb() {
        function.setrangecb(rangecb, selecttf, dateselecthb, selectcategorycb, sprovincecb, scitycb, sareacb, goodstable, function);
    }

    //    搜索确定按钮
    @FXML
    protected void selectok() {
        if ("全部".equals(rangecb.getValue())) {
            goodschoise = 1;
            goodstable.setItems(function.gettablevalue(adminDao.getGoods(connection)));
        } else if ("商品号".equals(rangecb.getValue())) {
            goodschoise = 2;
            fristString = selecttf.getText();
            goodstable.setItems(function.gettablevalue(adminDao.getGoodsgid(connection)));
        } else if ("商品名".equals(rangecb.getValue())) {
            goodschoise = 3;
            fristString = selecttf.getText();
            goodstable.setItems(function.gettablevalue(adminDao.getGoodsgname(connection)));
        } else if ("类别".equals(rangecb.getValue())) {
            goodschoise = 4;
            fristString = selectcategorycb.getValue();
            goodstable.setItems(function.gettablevalue(adminDao.getGoodsgcategory(connection)));
        } else if ("产地".equals(rangecb.getValue())) {
            goodschoise = 5;
            fristString = function.getaddress(sprovincecb, scitycb, sareacb);
            goodstable.setItems(function.gettablevalue(adminDao.getGoodsgorigin(connection)));
        } else if ("供货商".equals(rangecb.getValue())) {
            goodschoise = 6;
            fristString = selecttf.getText();
            goodstable.setItems(function.gettablevalue(adminDao.getGoodsgsupplier(connection)));
        } else if ("进货日期".equals(rangecb.getValue())) {
            goodschoise = 7;
            fristString = String.valueOf(begindate.getValue());
            secondString = String.valueOf(enddate.getValue());
            goodstable.setItems(function.gettablevalue(adminDao.getGoodsgindate(connection)));
        } else {
            function.setAlert("请选择搜索范围！");
        }
    }

    //    搜索界面产地选择
    @FXML
    protected void scityempty() {
        function.setcityempty(scitycb, sareacb);
    }

    @FXML
    protected void sareaempty() {
        int areanum = sareacb.getItems().size();
        if (areanum > 0) {
            sareacb.getItems().subList(0, areanum).clear();
        }
    }

    @FXML
    protected void scityshow() {
        function.setcityshow(sprovincecb, scitycb);
    }

    @FXML
    protected void sareashow() {
        function.setareashow(scitycb, sareacb);
    }

    //    货物导出数据
    @FXML
    protected void goodsoutdata() {
        List<Allentity> list;
        switch (goodschoise) {
            case 1:
                list = adminDao.getGoods(connection);
                break;
            case 2:
                list = adminDao.getGoodsgid(connection);
                break;
            case 3:
                list = adminDao.getGoodsgname(connection);
                break;
            case 4:
                list = adminDao.getGoodsgcategory(connection);
                break;
            case 5:
                list = adminDao.getGoodsgorigin(connection);
                break;
            case 6:
                list = adminDao.getGoodsgsupplier(connection);
                break;
            case 7:
                list = adminDao.getGoodsgindate(connection);
                break;
            default:
                list = null;
        }
        if (list != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss");
            Date date = new Date();
            String sdate = simpleDateFormat.format(date);
            Stage stage = new Stage();
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File file = directoryChooser.showDialog(stage);
            //选择的文件夹路径
            if (file != null) {
                String path = file.getPath();
                String[] titles = {"商品号", "商品名", "类别", "产地", "供货商", "进货日期", "现有库存量", "规格", "进价", "零售价", "会员价", "会员折扣"};
                //        创建文件
                File file1 = new File(path + "/goods" + sdate + ".xls");
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(file1);
                    WritableSheet sheet = workbook.createSheet("sheet1", 0);
                    jxl.write.Label label;
                    //            添加标题
                    for (int i = 0; i < titles.length; i++) {
                        label = new jxl.write.Label(i, 0, titles[i]);
                        sheet.addCell(label);
                    }
                    //            添加数据
                    for (int i = 0; i < Objects.requireNonNull(list).size(); i++) {
                        label = new jxl.write.Label(0, i + 1, list.get(i).getGid());
                        sheet.addCell(label);
                        label = new jxl.write.Label(1, i + 1, list.get(i).getGname());
                        sheet.addCell(label);
                        label = new jxl.write.Label(2, i + 1, list.get(i).getGcategory());
                        sheet.addCell(label);
                        label = new jxl.write.Label(3, i + 1, list.get(i).getGorigin());
                        sheet.addCell(label);
                        label = new jxl.write.Label(4, i + 1, list.get(i).getGsupplier());
                        sheet.addCell(label);
                        label = new jxl.write.Label(5, i + 1, String.valueOf(list.get(i).getGindate()));
                        sheet.addCell(label);
                        label = new jxl.write.Label(6, i + 1, String.valueOf(list.get(i).getGnum()));
                        sheet.addCell(label);
                        label = new jxl.write.Label(7, i + 1, list.get(i).getSpecifications());
                        sheet.addCell(label);
                        label = new jxl.write.Label(8, i + 1, String.valueOf(list.get(i).getGpurchaseprice()));
                        sheet.addCell(label);
                        label = new jxl.write.Label(9, i + 1, String.valueOf(list.get(i).getGpprice()));
                        sheet.addCell(label);
                        label = new jxl.write.Label(10, i + 1, String.valueOf(list.get(i).getGvprice()));
                        sheet.addCell(label);
                        label = new jxl.write.Label(11, i + 1, String.valueOf(list.get(i).getGdiscount()));
                        sheet.addCell(label);
                    }
                    workbook.write();
                    workbook.close();
                    function.setAlert1("保存成功！" + "\n" + "路径为" + file1);
                } catch (Exception e) {
                    function.setAlert("出错，请重新保存！");
                }
            }
        }
    }

    //    文件选择
    @FXML
    protected void choosefile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择.xls文件");
        file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            if ("xls".equals(file.getName().substring(file.getName().length() - 3))) {
                filetf.setText(file.getName());
            } else {
                function.setAlert("请选择 .xls 文件");
            }
        }
    }

    //    重置
    @FXML
    protected void refresh() {
        filetf.clear();
        file = null;
    }

    //    批量上传
    @FXML
    protected void okbutton() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        numberFormat.setGroupingUsed(false);
        if (file != null) {
            try {
                InputStream inputStream = new FileInputStream(file);
                Workbook workbook = Workbook.getWorkbook(inputStream);
                if (Adminevent.a == 1) {
                    for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                        Sheet sheet = workbook.getSheet(i);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
                        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                        for (int j = 0; j < sheet.getRows(); j++) {
                            if (sheet.getColumns() >= 11) {
                                if (!sheet.getCell(0, j).getContents().isEmpty()) {
                                    try {
                                        String gid = sheet.getCell(0, j).getContents().strip().split("\t")[0];
                                        String gname = sheet.getCell(1, j).getContents().strip().split("\t")[0];
                                        String gcategory = sheet.getCell(2, j).getContents().strip().split("\t")[0];
                                        String gorgin = sheet.getCell(3, j).getContents().strip().split("\t")[0];
                                        String gsupplier = sheet.getCell(4, j).getContents().strip().split("\t")[0];
                                        Date date = simpleDateFormat.parse(sheet.getCell(5, j).getContents());
                                        double gnum = Double.parseDouble(sheet.getCell(6, j).getContents());
                                        String specifications = sheet.getCell(7, j).getContents().strip().split("\t")[0];
                                        double gprice = Double.parseDouble(sheet.getCell(8, j).getContents());
                                        double price = Double.parseDouble(sheet.getCell(9, j).getContents());
                                        double discount = Double.parseDouble(sheet.getCell(10, j).getContents());
                                        fristString = gcategory;
                                        List<Allentity> glist = adminDao.getGcategory(connection);
                                        fristString = specifications;
                                        List<Allentity> slist = adminDao.getReficition(connection);
                                        assert glist != null;
                                        if (!glist.isEmpty()) {
                                            assert slist != null;
                                            if (!slist.isEmpty()) {
                                                if (discount >= 0.0 && discount <= 1.0) {
                                                    fristString = gid;
                                                    secondString = gname;
                                                    thirdString = gcategory;
                                                    fourthString = gorgin;
                                                    fifthString = gsupplier;
                                                    sixthString = simpleDateFormat1.format(date);
                                                    seventhString = String.valueOf(gnum);
                                                    eighthString = specifications;
                                                    ninthString = numberFormat.format(gprice);
                                                    tenthString = numberFormat.format(price);
                                                    eleventhString = numberFormat.format(discount);
                                                    List<Allentity> list = adminDao.getGoodsgid1(connection);
                                                    List<Allentity> list1 = adminDao.isGsupplier(connection);
                                                    assert list != null;
                                                    assert list1 != null;
                                                    if (list1.isEmpty()) {
                                                        adminDao.insertGsupplier(connection);
                                                    }
                                                    if (list.isEmpty()) {
                                                        adminDao.insertGoods(connection);
                                                    } else {
                                                        adminDao.updateGoods(connection);
                                                    }
                                                }
                                            }
                                        }
                                    } catch (NumberFormatException | ParseException e) {
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                } else if (Adminevent.a == 2) {
                    for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                        Sheet sheet = workbook.getSheet(i);
                        for (int j = 0; j < sheet.getRows(); j++) {
                            if (sheet.getColumns() >= 7) {
                                if (!sheet.getCell(0, j).getContents().isEmpty()) {
                                    String eid;
                                    List<Allentity> islist;
                                    Date nowdata = new Date();
                                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyMM");
                                    try {
                                        String ename = sheet.getCell(0, j).getContents().strip().split("\t")[0];
                                        String erole = sheet.getCell(1, j).getContents().strip().split("\t")[0];
                                        String eaddress = sheet.getCell(2, j).getContents().strip().split("\t")[0];
                                        String edaddress = sheet.getCell(3, j).getContents().strip().split("\t")[0];
                                        long ephone = Long.parseLong(sheet.getCell(4, j).getContents());
                                        String esex = sheet.getCell(5, j).getContents().strip().split("\t")[0];
                                        double salary;
                                        try {
                                            salary = Double.parseDouble(sheet.getCell(6, j).getContents().strip().split("\t")[0]);
                                        } catch (NumberFormatException e) {
                                            break;
                                        }
                                        if ("男".equals(esex) || "女".equals(esex)) {
                                            fristString = erole;
                                            List<Allentity> list = adminDao.getEmployeeemployee(connection);
                                            assert list != null;
                                            if (!list.isEmpty()) {
                                                do {
                                                    eid = simpleDateFormat2.format(nowdata) + ("男".equals(esex) ? "01" : "02") + (int) (Math.random() * (9999 - 1000 + 1) + 1000);
                                                    fristString = eid;
                                                    islist = adminDao.getEmployeeeid(connection);
                                                } while (!Objects.requireNonNull(islist).isEmpty());
                                                fristString = eid;
                                                secondString = ename;
                                                thirdString = eid;
                                                fourthString = erole;
                                                fifthString = eaddress;
                                                sixthString = edaddress;
                                                seventhString = String.valueOf(ephone);
                                                eighthString = esex;
                                                ninthString = String.valueOf(salary);
                                                adminDao.insertEmployee(connection);
                                            }
                                        }
                                    } catch (NumberFormatException e) {
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                }
                refresh();
                Loginin.addclose.close();
                function.setAlert1("添加成功！" + "\n" + "请点击刷新按钮加载数据！");
                file = null;
            } catch (IOException | BiffException e) {
                function.setAlert("文件解析错误！" + "\n" + "请重新选择文件！");
            }
        } else {
            function.setAlert("文件未选择！");
        }
    }

    //    批量删除
    @FXML
    protected void gbadelete() {
        b = 1;
        try {
            loginin.batchdelete().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void ebadelete() {
        b = 2;
        try {
            loginin.batchdelete().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void getbatchvalue() {
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(i).equals(arrayList.get(j)) || arrayList.get(i).equals(LogininEvent.gid) || arrayList.get(i).equals(LogininEvent.eid)) {
                    arrayList.set(i, "same");
                    break;
                }
            }
        }
        for (String s : arrayList) {
            if (!"same".equals(s)) {
                badeleteta.appendText(s + "\t");
            }
        }
        arrayList.clear();
    }

    @FXML
    protected void resetbatchdelete() {
        arrayList.clear();
        Loginin.deleteclose.close();
    }

    @FXML
    protected void deleteok() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("删除");
        alert.setHeaderText("确定是否要删除");
        Optional<ButtonType> button = alert.showAndWait();
        if (button.isPresent() && button.get() == ButtonType.OK) {
            String[] strings = badeleteta.getText().split("\t");
            for (String s : strings) {
                if (b == 1) {
                    fristString = s;
                    List<Allentity> list1 = adminDao.getGoodsgid1(connection);
                    assert list1 != null;
                    if (!list1.isEmpty()) {
                        fristString = s;
                        adminDao.deleteGoods(connection);
                        function.setAlert1("删除成功！" + "\n" + "请点击刷新按钮刷新表格！");
                    }
                } else if (b == 2) {
                    fristString = s;
                    List<Allentity> list2 = adminDao.getEmployeeeid(connection);
                    assert list2 != null;
                    if (!list2.isEmpty()) {
                        fristString = s;
                        adminDao.deleteEmloyee(connection);
                        function.setAlert1("删除成功！" + "\n" + "请点击刷新按钮刷新表格！");
                    }
                } else {
                    function.setAlert("出错！");
                }
                resetbatchdelete();
            }
        } else {
            resetlogins();
        }
    }

    //    模板下载
    @FXML
    protected void badownload() {
        File in = new File("template/批量添加文件模板.xlsx");
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File file = directoryChooser.showDialog(new Stage());
        if (file != null) {
            File out = new File(file.getPath() + "/批量添加模板.xlsx");
            try {
                Files.copy(in.toPath(), out.toPath());
                function.setAlert1("保存成功！");
            } catch (IOException e) {
                function.setAlert("文件模板不存在" + "\n" + "请在template文件夹下先创建 批量添加文件模板.xlsx");
            }
        }
    }

    //    添加界面产地选择
    @FXML
    protected void cityempty() {
        function.setcityempty(citycb, areacb);
    }

    @FXML
    protected void areaempty() {
        int areanum = areacb.getItems().size();
        if (areanum > 0) {
            areacb.getItems().subList(0, areanum).clear();
        }
    }

    @FXML
    protected void cityshow() {
        function.setcityshow(provincecb, citycb);
    }

    @FXML
    protected void areashow() {
        function.setareashow(citycb, areacb);
    }

    //    更新界面产地选择
    @FXML
    protected void ucityempty() {
        function.setcityempty(ucitycb, uareacb);
    }

    @FXML
    protected void uareaempty() {
        int areanum = uareacb.getItems().size();
        if (areanum > 0) {
            uareacb.getItems().subList(0, areanum).clear();
        }
    }

    @FXML
    protected void ucityshow() {
        function.setcityshow(uprovincecb, ucitycb);
    }

    @FXML
    protected void uareashow() {
        function.setareashow(ucitycb, uareacb);
    }

    @FXML
    protected void getreficition() {
        getreficitions(recb);
    }

    @FXML
    protected void reficition() {
        getreficitions(grecb);
    }

    private void getreficitions(ComboBox<String> grecb) {
        List<Allentity> list = adminDao.getReficitionsreficition(connection);
        if (grecb.getItems().isEmpty()) {
            assert list != null;
            for (Allentity allentity : list) {
                grecb.getItems().add(allentity.getSpecifications());
            }
        }
    }

    //    添加确定按钮
    @FXML
    protected void goodsadd() {
        fristString = gidtf.getText();
        List<Allentity> gidlist = adminDao.getGoodsgid1(connection);
        String snowdate = getString();
//        计算会员价
        boolean is = true;
        String gpprice = "0";
        String gpushprice = "0";
        String gvprice = "0%";
        try {
            if (!gppricetf.getText().isEmpty()) {
                Double.parseDouble(gppricetf.getText());
                gpprice = gppricetf.getText();
            }
            if (!gpushertf.getText().isEmpty()) {
                Double.parseDouble(gpushertf.getText());
                gpushprice = gpushertf.getText();
            }
            if (!gvpricetf.getText().isEmpty()) {
                gvprice = gvpricetf.getText();
            }
            if (Double.parseDouble(gpprice) >= 0 && Double.parseDouble(gpushprice) >= 0) {
                if (Double.parseDouble(gpprice) >= Double.parseDouble(gpushprice) || Double.parseDouble(gpushprice) != 0) {
                    if (gpprice.contains(".") && gpushprice.contains(".")) {
                        if (!(gpprice.substring(gpprice.indexOf(".") + 1).length() <= 2 && gpushprice.substring(gpushprice.indexOf(".") + 1).length() <= 2)) {
                            function.setAlert("价格小数点后最多为2位！");
                            is = false;
                        }
                    }
                } else {
                    function.setAlert("售价低于进价！");
                    is = false;
                }
            } else {
                function.setAlert("价格输入不是正数！");
                is = false;
            }
        } catch (NumberFormatException e) {
            function.setAlert("价格输入不是数字！");
            is = false;
        }
//                获取产地
        String gorigin = function.getaddress(provincecb, citycb, areacb);
        assert gidlist != null;
        String ginnum = "0";
        if (!gidtf.getText().isEmpty()) {
            if (gidlist.isEmpty()) {
                try {
                    if (!ginnumtf.getText().isEmpty()) {
                        Long.parseLong(ginnumtf.getText());
                        ginnum = ginnumtf.getText();
                    }
                    if (is) {
                        fristString = gidtf.getText();
                        secondString = gnametf.getText();
                        thirdString = gcategorycb.getValue() == null ? "<空>" : gcategorycb.getValue();
                        fourthString = gorigin;
                        fifthString = gsuppliertf.getText();
                        sixthString = snowdate;
                        seventhString = ginnum;
                        eighthString = recb.getValue() == null ? "<空>" : recb.getValue();
                        ninthString = gpushprice;
                        tenthString = gpprice;
                        double d = Double.parseDouble(gvprice.substring(0, gvprice.length() - 1)) * 0.01;
                        eleventhString = String.valueOf(d);
                        List<Allentity> list = adminDao.isGsupplier(connection);
                        if (list.isEmpty()) {
                            adminDao.insertGsupplier(connection);
                        }
                        adminDao.insertGoods(connection);
                        goodstablevalue();
                        goodsrefresh();
                        function.setAlert1("添加成功！");
                    }
                } catch (NumberFormatException e) {
                    function.setAlert("进货量输入不是整数！");
                }
            } else {
                function.setAlert("商品号已存在！");
            }
        } else {
            function.setAlert("商品号为空！");
        }
    }

    //    批量添加产品
    @FXML
    protected void babutton() {
        try {
            a = 1;
            loginin.batchaddstage().show();
        } catch (Exception e) {
            function.setAlert("出错！");
        }
    }

    //    添加界面滑动条
    @FXML
    protected void vipsplider() {
        gvpricetf.setText((int) gvipslider.getValue() + "%");
    }

    @FXML
    protected void vipvhooseevent() {
        gvpricetf.setText(vipchoose.getValue() + "%");
        gvipslider.setValue(vipchoose.getValue());
    }

    //    更新界面滑动条
    @FXML
    protected void uvipsplider() {
        ugvpricetf.setText((int) ugvipslider.getValue() + "%");
    }

    @FXML
    protected void uvipvhooseevent() {
        ugvpricetf.setText(uvipchoose.getValue() + "%");
        ugvipslider.setValue(uvipchoose.getValue());
    }

    //    更新界面选择修改项
    @FXML
    protected void updaterange() {
        if ("会员折扣".equals(updatecb.getValue())) {
            updatetf.setVisible(false);
            uprovincecb.setVisible(false);
            ucitycb.setVisible(false);
            uareacb.setVisible(false);
            updatedata.setVisible(false);
            ugvpricetf.setVisible(true);
            ugvipslider.setVisible(true);
            uvipchoose.setVisible(true);
            updatetf.setEditable(true);
            ucategorycb.setVisible(false);
            grecb.setVisible(false);
        } else if ("进货日期".equals(updatecb.getValue())) {
            updatetf.setVisible(false);
            uprovincecb.setVisible(false);
            ucitycb.setVisible(false);
            uareacb.setVisible(false);
            updatedata.setVisible(true);
            ugvpricetf.setVisible(false);
            ugvipslider.setVisible(false);
            uvipchoose.setVisible(false);
            updatetf.setEditable(true);
            ucategorycb.setVisible(false);
            grecb.setVisible(false);
        } else if ("产地".equals(updatecb.getValue())) {
            updatetf.setVisible(true);
            updatetf.setEditable(false);
            uprovincecb.setVisible(true);
            ucitycb.setVisible(true);
            uareacb.setVisible(true);
            updatedata.setVisible(false);
            ugvpricetf.setVisible(false);
            ugvipslider.setVisible(false);
            uvipchoose.setVisible(false);
            ucategorycb.setVisible(false);
            grecb.setVisible(false);
        } else if ("类别".equals(updatecb.getValue())) {
            updatetf.setVisible(false);
            updatetf.setEditable(false);
            uprovincecb.setVisible(false);
            ucitycb.setVisible(false);
            uareacb.setVisible(false);
            updatedata.setVisible(false);
            ugvpricetf.setVisible(false);
            ugvipslider.setVisible(false);
            uvipchoose.setVisible(false);
            ucategorycb.setVisible(true);
            grecb.setVisible(false);
        } else if ("规格".equals(updatecb.getValue())) {
            updatetf.setVisible(false);
            uprovincecb.setVisible(false);
            ucitycb.setVisible(false);
            uareacb.setVisible(false);
            updatedata.setVisible(false);
            ugvpricetf.setVisible(false);
            ugvipslider.setVisible(false);
            uvipchoose.setVisible(false);
            updatetf.setEditable(false);
            ucategorycb.setVisible(false);
            grecb.setVisible(true);
        } else {
            updatetf.setVisible(true);
            uprovincecb.setVisible(false);
            ucitycb.setVisible(false);
            uareacb.setVisible(false);
            updatedata.setVisible(false);
            ugvpricetf.setVisible(false);
            ugvipslider.setVisible(false);
            uvipchoose.setVisible(false);
            updatetf.setEditable(true);
            ucategorycb.setVisible(false);
            grecb.setVisible(false);
        }
    }

    //    更新确定按钮
    @FXML
    protected void uokbutton() {
        if (!updategidtf.getText().isEmpty()) {
            fristString = updategidtf.getText();
            if (!Objects.requireNonNull(adminDao.getGoodsgid1(connection)).isEmpty()) {
                if (updatecb.getValue() != null) {
                    if ("商品号".equals(updatecb.getValue())) {
                        if (!updatetf.getText().isEmpty()) {
                            fristString = updatetf.getText();
                            secondString = updategidtf.getText();
                            adminDao.updateGoodsgid(connection);
                            function.setAlert1("修改成功");
                            goodstablevalue();
                        } else {
                            function.setAlert("修改内容为空！");
                        }
                    } else if ("商品名".equals(updatecb.getValue())) {
                        if (!updatetf.getText().isEmpty()) {
                            fristString = updatetf.getText();
                            secondString = updategidtf.getText();
                            adminDao.updateGoodsganme(connection);
                            function.setAlert1("修改成功！");
                            goodstablevalue();
                        } else {
                            function.setAlert("修改内容为空！");
                        }
                    } else if ("类别".equals(updatecb.getValue())) {
                        if (ucategorycb.getValue() != null) {
                            fristString = ucategorycb.getValue();
                            secondString = updategidtf.getText();
                            adminDao.updateGoodsgcategory(connection);
                            function.setAlert1("修改成功！");
                            goodstablevalue();
                        } else {
                            function.setAlert("修改内容为空！");
                        }
                    } else if ("规格".equals(updatecb.getValue())) {
                        if (grecb.getValue() != null) {
                            fristString = grecb.getValue();
                            secondString = updategidtf.getText();
                            adminDao.updateGoodsspecification(connection);
                            function.setAlert1("修改成功！");
                            goodstablevalue();
                        } else {
                            function.setAlert("修改内容为空！");
                        }
                    } else if ("产地".equals(updatecb.getValue())) {
                        if (uprovincecb.getValue() != null) {
                            thirdString = function.getaddress(uprovincecb, ucitycb, uareacb);
                            fifthString = updategidtf.getText();
                            secondString = adminDao.getGoodsgid1(connection).get(0).getGsupplier();
                            adminDao.updateGoodsgorigin(connection);
                            function.setAlert1("修改成功");
                            goodstablevalue();
                        } else {
                            function.setAlert("请选择产地！");
                        }
                    } else if ("供货商".equals(updatecb.getValue())) {
                        if (!updatetf.getText().isEmpty()) {
                            fifthString = updatetf.getText();
                            secondString = updategidtf.getText();
                            fourthString = adminDao.getGorigin(connection).get(0).getGorigin();
                            List<Allentity> list = adminDao.isGsupplier(connection);
                            if (list.isEmpty()) {
                                adminDao.insertGsupplier(connection);
                            }
                            adminDao.updateGoodsgsupplier(connection);
                            function.setAlert1("修改成功");
                            goodstablevalue();
                        } else {
                            function.setAlert("修改内容为空！");
                        }
                    } else if ("进货日期".equals(updatecb.getValue())) {
                        if (!(updatedata.getValue() + "").isEmpty()) {
                            fristString = String.valueOf(updatedata.getValue());
                            secondString = updategidtf.getText();
                            adminDao.updateGoodsggindate(connection);
                            function.setAlert1("修改成功");
                            goodstablevalue();
                        } else {
                            function.setAlert("日期选择为空！");
                        }
                    } else if ("现有库存量".equals(updatecb.getValue())) {
                        if (!updatetf.getText().isEmpty()) {
                            try {
                                Long.parseLong(updatetf.getText());
                                fristString = updatetf.getText();
                                secondString = updategidtf.getText();
                                adminDao.updateGoodsggnum(connection);
                                function.setAlert1("修改成功");
                                goodstablevalue();
                            } catch (NumberFormatException e) {
                                function.setAlert("现有库存量应为整数！");
                            }
                        } else {
                            function.setAlert("修改内容为空！");
                        }
                    } else if ("进价".equals(updatecb.getValue())) {
                        boolean a;
                        if (!updatetf.getText().isEmpty()) {
                            try {
                                Double.parseDouble(updatetf.getText());
                                if (Double.parseDouble(updatetf.getText()) >= 0) {
                                    if (updatetf.getText().contains(".")) {
                                        if (updatetf.getText().substring(updatetf.getText().indexOf(".") + 1).length() <= 2) {
                                            a = true;
                                        } else {
                                            a = false;
                                            function.setAlert("价格小数后最多为2位！");
                                        }
                                    } else {
                                        a = true;
                                    }
                                } else {
                                    a = false;
                                    function.setAlert("价格输入不是正数！");
                                }
                            } catch (NumberFormatException e) {
                                a = false;
                                function.setAlert("价格输入不是数字！");
                            }
                        } else {
                            a = false;
                            function.setAlert("修改内容为空！");
                        }
                        if (a) {
                            fristString = updatetf.getText();
                            secondString = updategidtf.getText();
                            adminDao.updateGoodsgpurchasepriee(connection);
                            function.setAlert1("修改成功");
                            goodstablevalue();
                        }
                    } else if ("售价".equals(updatecb.getValue())) {
                        if (!updatetf.getText().isEmpty()) {
                            try {
                                Double.parseDouble(updatetf.getText());
                                fristString = updategidtf.getText();
                                List<Allentity> list = adminDao.getGoodsgid1(connection);
                                assert list != null;
                                if (Double.parseDouble(updatetf.getText()) >= 0) {
                                    if (list.get(0).getGpurchaseprice() <= Double.parseDouble(updatetf.getText())) {
                                        if (updatetf.getText().contains(".")) {
                                            if (updatetf.getText().substring(updatetf.getText().indexOf(".") + 1).length() <= 2) {
                                                fristString = updatetf.getText();
                                                secondString = updategidtf.getText();
                                                adminDao.updateGoodsgprice(connection);
                                                function.setAlert1("修改成功");
                                                goodstablevalue();
                                            } else {
                                                function.setAlert("价格小数后最多为2位！");
                                            }
                                        } else {
                                            fristString = updatetf.getText();
                                            secondString = updategidtf.getText();
                                            adminDao.updateGoodsgprice(connection);
                                            function.setAlert1("修改成功");
                                            goodstablevalue();
                                        }
                                    } else {
                                        function.setAlert("售价低于进价！");
                                    }
                                } else {
                                    function.setAlert("价格输入不是正数！");
                                }
                            } catch (NumberFormatException e) {
                                function.setAlert("价格请输入数字！");
                            }
                        } else {
                            function.setAlert("修改内容为空！");
                        }
                    } else if ("会员折扣".equals(updatecb.getValue())) {
                        if (!ugvpricetf.getText().isEmpty()) {
                            fristString = String.valueOf(Double.parseDouble(ugvpricetf.getText().substring(0, ugvpricetf.getText().length() - 1)) * 0.01);
                            secondString = updategidtf.getText();
                            adminDao.updateGoodsdiscount(connection);
                            function.setAlert1("修改成功");
                            goodstablevalue();
                        } else {
                            function.setAlert("会员折扣为空！");
                        }
                    } else {
                        function.setAlert("出错！");
                    }
                } else {
                    function.setAlert("请选择修改项！");
                }
            } else {
                function.setAlert("商品号不存在！");
            }
        } else {
            function.setAlert("商品号为空！");
        }
    }

    //    显示商品表格所有内容
    @FXML
    public void goodstablevalue() {
        goodschoise = 1;
        goodstable.setItems(function.gettablevalue(adminDao.getGoods(connection)));
    }

    /*员工管理界面事件*/
//    数据初始化
    @FXML
    protected void adminemployee() {
        eidcolumn.setCellValueFactory(new PropertyValueFactory<>("eid"));
        enamecolumn.setCellValueFactory(new PropertyValueFactory<>("ename"));
        erolecolumn.setCellValueFactory(new PropertyValueFactory<>("erole"));
        eaddresscolumn.setCellValueFactory(new PropertyValueFactory<>("eaddress"));
        ephonecolumn.setCellValueFactory(new PropertyValueFactory<>("ephone"));
        edaddresscolumn.setCellValueFactory(new PropertyValueFactory<>("edaddress"));
        eagecolumn.setCellValueFactory(new PropertyValueFactory<>("eage"));
        esexcolumn.setCellValueFactory(new PropertyValueFactory<>("esex"));
        esalarycolumn.setCellValueFactory(new PropertyValueFactory<>("esalary"));
        employeetablevalue();
        function.setCbItem(eprovincecb);
        employeetable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        employeetable.getSelectionModel().selectedItemProperty().addListener((observable, oldvalue, newvalue) -> {
            ObservableList<Allentity> allentityObservable = employeetable.getSelectionModel().getSelectedItems();
            for (Allentity allentity : allentityObservable) {
                arrayList.add(allentity.getEid());
            }
        });
        employeetable.setRowFactory(tv -> {
            TableRow<Allentity> TableRow = new TableRow<>();
            TableRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !TableRow.isEmpty()) {
                    eidtf.setText(TableRow.getItem().getEid());
                    enametf.setText(TableRow.getItem().getEname());
                    erolecb.setValue(TableRow.getItem().getErole());
                    esalarytf.setText(TableRow.getItem().getEsalary() + "");
                }
            });
            return TableRow;
        });
        if (eselectrangecb.getItems().isEmpty()) {
            eselectrangecb.getItems().addAll("员工编号", "员工姓名", "员工住址", "联系电话", "职位", "性别");
        }
        if (soptioncb.getItems().isEmpty()) {
            soptioncb.getItems().addAll("添加", "删除", "修改", "查询");
        }
    }

    @FXML
    protected void setecategory() {
        getecategory(erolecb);
        getecategory(esrolecb);
    }

    public void getecategory(ComboBox<String> erolecb) {
        if (erolecb.getItems().isEmpty()) {
            List<Allentity> list = adminDao.getEcategoryemployee(connection);
            assert list != null;
            for (Allentity allentity : list) {
                erolecb.getItems().addAll(allentity.getErole());
            }
        }
    }

    @FXML
    protected void employeerefresh() {
        eidtf.clear();
        enametf.clear();
        edaddresstf.clear();
        eselecttf.clear();
        esalarytf.clear();
        employeetablevalue();
    }

    @FXML
    protected void setSoptioncb() {
        if ("添加".equals(soptioncb.getValue())) {
            eidtf.setEditable(false);
            enametf.setEditable(true);
            edaddresstf.setEditable(true);
            eselecttf.setEditable(false);
            esalarytf.setEditable(true);
        } else if ("删除".equals(soptioncb.getValue())) {
            eidtf.setEditable(true);
            enametf.setEditable(false);
            edaddresstf.setEditable(false);
            eselecttf.setEditable(false);
            esalarytf.setEditable(false);
        } else if ("修改".equals(soptioncb.getValue())) {
            eidtf.setEditable(false);
            enametf.setEditable(true);
            edaddresstf.setEditable(true);
            eselecttf.setEditable(false);
            esalarytf.setEditable(true);
        } else if ("查询".equals(soptioncb.getValue())) {
            eidtf.setEditable(false);
            enametf.setEditable(false);
            edaddresstf.setEditable(true);
            eselecttf.setEditable(true);
            esalarytf.setEditable(false);
        }
    }

    @FXML
    protected void setRadionbutton() {
        if ("查询".equals(soptioncb.getValue())) {
            if ("性别".equals(eselectrangecb.getValue())) {
                fristString = eboy.isSelected() ? "男" : "女";
                employeetable.setItems(function.gettablevalue(adminDao.getEmployeeesex(connection)));
            }
        }
    }

    //    确认按钮
    @FXML
    protected void setokbutton() {
        if (soptioncb.getValue() != null) {
            if ("添加".equals(soptioncb.getValue())) {
                eaddbutton();
            } else if ("删除".equals(soptioncb.getValue())) {
                edeletebutton();
            } else if ("修改".equals(soptioncb.getValue())) {
                eupdatebutton();
            } else if ("查询".equals(soptioncb.getValue())) {
                eseletebutton();
            }
        } else {
            function.setAlert("操作类型选择为空！");
        }
    }

    //    员工添加按钮
    protected void eaddbutton() {
        String eid;
        List<Allentity> islist;
        Date nowdata = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMM");
        do {
            eid = simpleDateFormat.format(nowdata) + (eboy.isSelected() ? "01" : "02") + (int) (Math.random() * (9999 - 1000 + 1) + 1000);
            fristString = eid;
            islist = adminDao.getEmployeeeid(connection);
        } while (!Objects.requireNonNull(islist).isEmpty());
        if (eidtf.getText().isEmpty()) {
            if (!enametf.getText().isEmpty() && !esalarytf.getText().isEmpty()) {
                if (erolecb.getValue() != null) {
                    double salary = getsalary();
                    if (isget) {
                        String eaddress = function.getaddress(eprovincecb, ecitycb, eareacb);
                        fristString = eid;
                        secondString = enametf.getText();
                        thirdString = eid;
                        fourthString = erolecb.getValue().isEmpty() ? "<空>" : erolecb.getValue();
                        fifthString = eaddress;
                        sixthString = edaddresstf.getText();
                        seventhString = "-";
                        eighthString = (eboy.isSelected() ? "男" : "女");
                        ninthString = String.valueOf(salary);
                        adminDao.insertEmployee(connection);
                        function.setAlert1("添加成功！");
                        employeetablevalue();
                    }
                } else {
                    function.setAlert("职位未选择！");
                }
            } else {
                function.setAlert("姓名或基本工资为空！");
            }
        } else {
            function.setAlert("员工编号已存在！");
        }
    }

    private double getsalary() {
        double salary = 0.0;
        try {
            Double.parseDouble(esalarytf.getText());
            if (Double.parseDouble(esalarytf.getText()) >= 0) {
                if (esalarytf.getText().contains(".")) {
                    if ((esalarytf.getText().substring(esalarytf.getText().indexOf(".") + 1)).length() <= 2) {
                        isget = true;
                        salary = Double.parseDouble(esalarytf.getText());
                    } else {
                        isget = false;
                        function.setAlert("基本工资小数点后最多为两位！");
                    }
                } else {
                    isget = true;
                    salary = Double.parseDouble(esalarytf.getText());
                }
            } else {
                isget = false;
                function.setAlert("基本工资不是正数！");
            }
        } catch (NumberFormatException e) {
            isget = false;
            function.setAlert("基本工资输入不是数字！");
        }
        return salary;
    }

    //    批量添加员工
    @FXML
    protected void ebabutton() {
        try {
            a = 2;
            loginin.batchaddstage().show();
        } catch (Exception e) {
            function.setAlert("出错！");
        }
    }

    //    员工删除按钮
    protected void edeletebutton() {
        if (!eidtf.getText().isEmpty()) {
            fristString = eidtf.getText();
            List<Allentity> list = adminDao.getEmployeeeid(connection);
            assert list != null;
            if (!list.isEmpty()) {
                if (Objects.equals(LogininEvent.gid, eidtf.getText()) || Objects.equals(LogininEvent.eid, eidtf.getText())) {
                    function.setAlert("删除的是本管理员或者正在登录的员工" + "\n" + "无法删除！");
                } else {
                    fristString = eidtf.getText();
                    adminDao.deleteEmloyee(connection);
                    employeetablevalue();
                    function.setAlert1("删除成功！");
                }
            } else {
                function.setAlert("员工编号不存在！");
            }
        } else {
            function.setAlert("员工编号为空！");
        }
    }

    //    员工修改按钮
    protected void eupdatebutton() {
        if (!eidtf.getText().isEmpty()) {
            List<Allentity> list = adminDao.getEmployee(connection);
            assert list != null;
            if (!list.isEmpty()) {
                if (erolecb.getValue() != null) {
                    double salary = getsalary();
                    if (isget) {
                        fristString = enametf.getText();
                        secondString = (eboy.isSelected() ? "男" : "女");
                        thirdString = function.getaddress(eprovincecb, ecitycb, eareacb);
                        fourthString = edaddresstf.getText();
                        fifthString = erolecb.getValue();
                        sixthString = String.valueOf(salary);
                        seventhString = eidtf.getText();
                        adminDao.updateEmployee(connection);
                        employeetablevalue();
                        function.setAlert1("修改成功！");
                    }
                } else {
                    function.setAlert("职位选择为空！");
                }
            } else {
                function.setAlert("员工编号不存在！");
            }
        } else {
            function.setAlert("员工编号为空！");
        }
    }

    //    员工查询按钮
    protected void eseletebutton() {
        fristString = getString();
        if ("员工编号".equals(eselectrangecb.getValue())) {
            employeechoise = 1;
            secondString = eselecttf.getText();
            employeetable.setItems(function.gettablevalue(adminDao.selectEmployeeeid(connection)));
        } else if ("员工姓名".equals(eselectrangecb.getValue())) {
            employeechoise = 2;
            secondString = eselecttf.getText();
            employeetable.setItems(function.gettablevalue(adminDao.selectEmployeeename(connection)));
        } else if ("员工住址".equals(eselectrangecb.getValue())) {
            employeechoise = 3;
            secondString = function.getaddress(eprovincecb, ecitycb, eareacb);
            thirdString = edaddresstf.getText();
            employeetable.setItems(function.gettablevalue(adminDao.selectEmployeeeaddress(connection)));
        } else if ("联系电话".equals(eselectrangecb.getValue())) {
            employeechoise = 4;
            secondString = eselecttf.getText();
            employeetable.setItems(function.gettablevalue(adminDao.selectEmployeeephone(connection)));
        } else if ("职位".equals(eselectrangecb.getValue())) {
            employeechoise = 5;
            secondString = esrolecb.getValue();
            employeetable.setItems(function.gettablevalue(adminDao.selectEmployeeerole(connection)));
        } else if ("性别".equals(eselectrangecb.getValue())) {
            employeechoise = 6;
            secondString = eboy.isSelected() ? "男" : "女";
            employeetable.setItems(function.gettablevalue(adminDao.selectEmployeeesex(connection)));
        } else {
            function.setAlert("搜索范围选择为空！");
        }

    }

    //    员工导出数据按钮
    @FXML
    protected void employeeoutdata() {
        List<Allentity> list;
        switch (employeechoise) {
            case 1:
                list = adminDao.selectEmployeeeid(connection);
                break;
            case 2:
                list = adminDao.selectEmployeeename(connection);
                break;
            case 3:
                list = adminDao.selectEmployeeeaddress(connection);
                break;
            case 4:
                list = adminDao.selectEmployeeephone(connection);
                break;
            case 5:
                list = adminDao.selectEmployeeerole(connection);
                break;
            case 6:
                list = adminDao.selectEmployeeesex(connection);
                break;
            default:
                list = null;

        }
        if (list != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss");
            Date date = new Date();
            String sdate = simpleDateFormat.format(date);
            Stage stage = new Stage();
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File file = directoryChooser.showDialog(stage);
            //选择的文件夹路径
            if (file != null) {
                String path = file.getPath();
                String[] titles = {"员工编号", "员工姓名", "员工住址", "联系电话", "生日", "性别", "职位","基本工资"};
                //        创建文件
                File file1 = new File(path + "/employee" + sdate + ".xls");
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(file1);
                    WritableSheet sheet = workbook.createSheet("sheet1", 0);
                    jxl.write.Label label;
                    //            添加标题
                    for (int i = 0; i < titles.length; i++) {
                        label = new jxl.write.Label(i, 0, titles[i]);
                        sheet.addCell(label);
                    }
                    //            添加数据
                    for (int i = 0; i < Objects.requireNonNull(list).size(); i++) {
                        label = new jxl.write.Label(0, i + 1, list.get(i).getEid());
                        sheet.addCell(label);
                        label = new jxl.write.Label(1, i + 1, list.get(i).getEname());
                        sheet.addCell(label);
                        label = new jxl.write.Label(2, i + 1, list.get(i).getEaddress() + list.get(i).getEdaddress());
                        sheet.addCell(label);
                        label = new jxl.write.Label(3, i + 1, list.get(i).getEphone());
                        sheet.addCell(label);
                        label = new jxl.write.Label(4, i + 1, String.valueOf(list.get(i).getEbirthday()));
                        sheet.addCell(label);
                        label = new jxl.write.Label(5, i + 1, String.valueOf(list.get(i).getEsex()));
                        sheet.addCell(label);
                        label = new jxl.write.Label(6, i + 1, String.valueOf(list.get(i).getErole()));
                        sheet.addCell(label);
                        label = new jxl.write.Label(7, i + 1, String.valueOf(list.get(i).getEsalary()));
                        sheet.addCell(label);
                    }
                    workbook.write();
                    workbook.close();
                    function.setAlert1("保存成功！" + "\n" + "路径为" + file1);
                } catch (Exception e) {
                    function.setAlert("出错，请重新保存！");
                }
            }
        }
    }

    //    员工管理搜索范围
    @FXML
    protected void setEselectrangecb() {
        if ("员工住址".equals(eselectrangecb.getValue())) {
            eselecttf.setEditable(false);
            esrolecb.setVisible(false);
            eselecttf.setVisible(true);
            eselecttf.setText("请在详细地址中输入查询内容");
            eidtf.setEditable(false);
            enametf.setEditable(false);
            edaddresstf.setEditable(true);
            esalarytf.setEditable(false);
        } else if ("职位".equals(eselectrangecb.getValue())) {
            eselecttf.setEditable(false);
            eselecttf.setVisible(false);
            eselecttf.clear();
            esrolecb.setVisible(true);
            eidtf.setEditable(false);
            enametf.setEditable(false);
            edaddresstf.setEditable(false);
            esalarytf.setEditable(false);
        } else {
            eselecttf.setEditable(true);
            eselecttf.setVisible(true);
            eselecttf.clear();
            esrolecb.setVisible(false);
            eidtf.setEditable(false);
            enametf.setEditable(false);
            edaddresstf.setEditable(false);
            esalarytf.setEditable(false);
        }
    }

    //    显示表格所有内容
    @FXML
    protected void employeetablevalue() {
        employeechoise = 1;
        employeetable.setItems(function.gettablevalue(adminDao.getEmployeetable(connection)));
    }

    private String getString() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    //    员工管理界面地址选择
    @FXML
    protected void ecityempty() {
        function.setcityempty(ecitycb, eareacb);
    }

    @FXML
    protected void eareaempty() {
        int areanum = eareacb.getItems().size();
        if (areanum > 0) {
            eareacb.getItems().subList(0, areanum).clear();
        }
    }

    @FXML
    protected void ecityshow() {
        function.setcityshow(eprovincecb, ecitycb);
    }

    @FXML
    protected void eareashow() {
        function.setareashow(ecitycb, eareacb);
    }

    /*类别管理界面事件*/
//    数据初始化
    @FXML
    protected void admincategory() {
        cgoodscolumn.setCellValueFactory(new PropertyValueFactory<>("gcategory"));
        cemployeecolumn.setCellValueFactory(new PropertyValueFactory<>("erole"));
        recolumn.setCellValueFactory(new PropertyValueFactory<>("specifications"));
        gctablevalue(cgoodstable);
        ectablevalue(cemployeetable);
        reficition(reficitiontable);
        if (ctablecb.getItems().isEmpty()) {
            ctablecb.getItems().addAll("商品类别", "员工类别", "规格管理");
        }
        if (coperationcb.getItems().isEmpty()) {
            coperationcb.getItems().addAll("添加", "删除", "修改");
        }
        List<Allentity> list = adminDao.getIntegral(connection);
        assert list != null;
        if (list.isEmpty()) {
            fristString = String.valueOf(0);
            secondString = String.valueOf(0);
            adminDao.insertIntegral(connection);
        }
        getpivalue();
    }

    //    兑换规则修改
    @FXML
    protected void setingetral() {
        if (!yuantf.getText().isEmpty() && !jifentf.getText().isEmpty()) {
            try {
                Long.parseLong(yuantf.getText());
                Long.parseLong(jifentf.getText());
                if (Long.parseLong(yuantf.getText()) > 0 && Long.parseLong(jifentf.getText()) > 0) {
                    fristString = jifentf.getText();
                    secondString = yuantf.getText();
                    adminDao.updateIntegral(connection);
                    function.setAlert1("修改成功！");
                    getpivalue();
                    yuantf.clear();
                    jifentf.clear();
                } else {
                    function.setAlert("输入不是正数！");
                }
            } catch (NumberFormatException e) {
                function.setAlert("输入不是整数！");
            }

        } else {
            function.setAlert("输入为空！");
        }
    }

    private void getpivalue() {
        List<Allentity> list = adminDao.getIntegral(connection);
        assert list != null;
        if (!list.isEmpty()) {
            yuanla.setText(list.get(0).getPvalue() + "");
            jifenla.setText(list.get(0).getIvalue() + "");
        } else {
            yuanla.setText("<空>");
            jifenla.setText("<空>");
        }
    }

    //    显示类别表格内容
    @FXML
    protected void gctablevalue(TableView<Allentity> tableView) {
        tableView.setItems(function.gettablevalue(adminDao.getGcategorygoods(connection)));
    }

    @FXML
    protected void ectablevalue(TableView<Allentity> tableView) {
        tableView.setItems(function.gettablevalue(adminDao.getEcategoryemployee(connection)));
    }

    @FXML
    protected void reficition(TableView<Allentity> tableView) {
        tableView.setItems(function.gettablevalue(adminDao.getReficitionsreficition(connection)));
    }

    @FXML
    protected void setCobjectcb() {
        if (cobjectcb.getItems().isEmpty()) {
            if ("商品类别".equals(ctablecb.getValue())) {
                List<Allentity> list = adminDao.getGcategorygoods(connection);
                assert list != null;
                for (Allentity allentity : list) {
                    if (allentity.getGcategory() != null) {
                        if (!"<空>".equals(allentity.getGcategory())) {
                            cobjectcb.getItems().add(allentity.getGcategory());
                        }
                    }
                }
            } else if ("员工类别".equals(ctablecb.getValue())) {
                List<Allentity> list = adminDao.getEcategoryemployee(connection);
                assert list != null;
                for (Allentity allentity : list) {
                    if (allentity.getErole() != null) {
                        if (!"<空>".equals(allentity.getErole())) {
                            cobjectcb.getItems().add(allentity.getErole());
                        }
                    }
                }
            } else if ("规格管理".equals(ctablecb.getValue())) {
                List<Allentity> list = adminDao.getReficitionsreficition(connection);
                assert list != null;
                for (Allentity allentity : list) {
                    if (allentity.getSpecifications() != null) {
                        if (!"<空>".equals(allentity.getSpecifications())) {
                            cobjectcb.getItems().add(allentity.getSpecifications());
                        }
                    }
                }
            }

        }
    }

    @FXML
    protected void cokbutton() {
        if (ctablecb.getValue() != null && coperationcb.getValue() != null) {
            if ("商品类别".equals(ctablecb.getValue())) {
                if ("添加".equals(coperationcb.getValue())) {
                    if (!cgettexttf.getText().isEmpty()) {
                        fristString = cgettexttf.getText();
                        List<Allentity> list = adminDao.getGcategory(connection);
                        assert list != null;
                        if (list.isEmpty()) {
                            fristString = cgettexttf.getText();
                            adminDao.insertGcategory(connection);
                            function.setAlert1("操作成功！");
                        } else {
                            function.setAlert("类别已存在！");
                        }
                    } else {
                        function.setAlert("输入为空！");
                    }
                } else if ("删除".equals(coperationcb.getValue())) {
                    if (cobjectcb.getValue() != null) {
                        fristString = cobjectcb.getValue();
                        adminDao.deleteGcategory(connection);
                        function.setAlert1("操作成功！");
                    } else {
                        function.setAlert("对象选择为空！");
                    }
                } else if ("修改".equals(coperationcb.getValue())) {
                    if (cobjectcb.getValue() != null) {
                        if (!cgettexttf.getText().isEmpty()) {
                            fristString = cgettexttf.getText();
                            secondString = cobjectcb.getValue();
                            adminDao.updateGcategory(connection);
                            function.setAlert1("操作成功！");
                        } else {
                            function.setAlert("输入为空！");
                        }
                    } else {
                        function.setAlert("对象选择为空！");
                    }
                }
                gctablevalue(cgoodstable);
            } else if ("员工类别".equals(ctablecb.getValue())) {
                if ("添加".equals(coperationcb.getValue())) {
                    if (!cgettexttf.getText().isEmpty()) {
                        fristString = cgettexttf.getText();
                        List<Allentity> list = adminDao.getEcategory(connection);
                        assert list != null;
                        if (list.isEmpty()) {
                            fristString = cgettexttf.getText();
                            adminDao.insertEcategory(connection);
                            function.setAlert1("操作成功！");
                        } else {
                            function.setAlert("类别已存在！");
                        }
                    } else {
                        function.setAlert("输入为空！");
                    }
                } else if ("删除".equals(coperationcb.getValue())) {
                    if (cobjectcb.getValue() != null) {
                        fristString = cobjectcb.getValue();
                        adminDao.deleteEcategory(connection);
                        function.setAlert1("操作成功！");
                    } else {
                        function.setAlert("对象选择为空！");
                    }
                } else if ("修改".equals(coperationcb.getValue())) {
                    if (cobjectcb.getValue() != null) {
                        if (!cgettexttf.getText().isEmpty()) {
                            fristString = cgettexttf.getText();
                            secondString = cobjectcb.getValue();
                            adminDao.updateEcategory(connection);
                            function.setAlert1("操作成功！");
                        } else {
                            function.setAlert("输入为空！");
                        }
                    } else {
                        function.setAlert("对象选择为空！");
                    }
                }
                ectablevalue(cemployeetable);
            } else if ("规格管理".equals(ctablecb.getValue())) {
                if ("添加".equals(coperationcb.getValue())) {
                    if (!cgettexttf.getText().isEmpty()) {
                        fristString = cgettexttf.getText();
                        List<Allentity> list = adminDao.getReficitions(connection);
                        assert list != null;
                        if (list.isEmpty()) {
                            fristString = cgettexttf.getText();
                            adminDao.insertReficitions(connection);
                            function.setAlert1("操作成功！");
                        } else {
                            function.setAlert("规格已存在！");
                        }
                    } else {
                        function.setAlert("输入为空！");
                    }
                } else if ("删除".equals(coperationcb.getValue())) {
                    if (cobjectcb.getValue() != null) {
                        fristString = cobjectcb.getValue();
                        adminDao.deleteReficitions(connection);
                        function.setAlert1("操作成功！");
                    } else {
                        function.setAlert("对象选择为空！");
                    }
                } else if ("修改".equals(coperationcb.getValue())) {
                    if (cobjectcb.getValue() != null) {
                        if (!cgettexttf.getText().isEmpty()) {
                            fristString = cgettexttf.getText();
                            secondString = cobjectcb.getValue();
                            adminDao.updateReficitions(connection);
                            function.setAlert1("操作成功！");
                        } else {
                            function.setAlert("输入为空！");
                        }
                    } else {
                        function.setAlert("对象选择为空！");
                    }
                }
                reficition(reficitiontable);
            }
        } else {
            function.setAlert("选择为空！");
        }
    }

    //    数据导出
    @FXML
    protected void cabbutton() {
        if ("商品类别".equals(ctablecb.getValue())) {
            List<Allentity> list = adminDao.getGcategory1(connection);
            Stage stage = new Stage();
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File file = directoryChooser.showDialog(stage);
            if (file != null) {
                String path = file.getPath();
                String[] titles = {"商品类别"};
                File file1 = new File(path + "/商品类别表" + ".xls");
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(file1);
                    WritableSheet sheet = workbook.createSheet("sheet1", 0);
                    jxl.write.Label label;
                    for (int i = 0; i < titles.length; i++) {
                        label = new jxl.write.Label(i, 0, titles[i]);
                        sheet.addCell(label);
                    }
                    for (int i = 0; i < Objects.requireNonNull(list).size(); i++) {
                        label = new jxl.write.Label(0, i + 1, list.get(i).getGoods());
                        sheet.addCell(label);
                    }
                    workbook.write();
                    workbook.close();
                    function.setAlert1("保存成功！" + "\n" + "路径为" + file1);
                } catch (Exception e) {
                    function.setAlert("出错，请重新保存！");
                }
            }
        } else if ("员工类别".equals(ctablecb.getValue())) {
            List<Allentity> list = adminDao.getEcategoryemployee(connection);
            Stage stage = new Stage();
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File file = directoryChooser.showDialog(stage);
            if (file != null) {
                String path = file.getPath();
                String[] titles = {"员工类别"};
                File file1 = new File(path + "/员工类别表" + ".xls");
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(file1);
                    WritableSheet sheet = workbook.createSheet("sheet1", 0);
                    jxl.write.Label label;
                    for (int i = 0; i < titles.length; i++) {
                        label = new jxl.write.Label(i, 0, titles[i]);
                        sheet.addCell(label);
                    }
                    for (int i = 0; i < Objects.requireNonNull(list).size(); i++) {
                        label = new jxl.write.Label(0, i + 1, list.get(i).getEmployee());
                        sheet.addCell(label);
                    }
                    workbook.write();
                    workbook.close();
                    function.setAlert1("保存成功！" + "\n" + "路径为" + file1);
                } catch (Exception e) {
                    function.setAlert("出错，请重新保存！");
                }
            }
        } else if ("规格管理".equals(ctablecb.getValue())) {
            List<Allentity> list = adminDao.getReficitionsreficition(connection);
            Stage stage = new Stage();
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File file = directoryChooser.showDialog(stage);
            if (file != null) {
                String path = file.getPath();
                String[] titles = {"规格类别"};
                File file1 = new File(path + "/规格类别表" + ".xls");
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(file1);
                    WritableSheet sheet = workbook.createSheet("sheet1", 0);
                    jxl.write.Label label;
                    for (int i = 0; i < titles.length; i++) {
                        label = new jxl.write.Label(i, 0, titles[i]);
                        sheet.addCell(label);
                    }
                    for (int i = 0; i < Objects.requireNonNull(list).size(); i++) {
                        label = new jxl.write.Label(0, i + 1, list.get(i).getReficitions());
                        sheet.addCell(label);
                    }
                    workbook.write();
                    workbook.close();
                    function.setAlert1("保存成功！" + "\n" + "路径为" + file1);
                } catch (Exception e) {
                    function.setAlert("出错，请重新保存！");
                }
            }
        } else {
            function.setAlert("表格未选择！");
        }
    }

    @FXML
    protected void removeCtablecb() {
        int num = cobjectcb.getItems().size();
        if (num > 0) {
            cobjectcb.getItems().subList(0, num).clear();
        }
    }

    /*功能事件*/
    //    重置按钮
    @FXML
    protected void goodsrefresh() {
        deletetf.clear();
        selecttf.clear();
        gidtf.clear();
        ginnumtf.clear();
        gppricetf.clear();
        gnametf.clear();
        gpushertf.clear();
        gsuppliertf.clear();
        gvpricetf.clear();
        gvipslider.setValue(0);
        ugvipslider.setValue(0);
        updatetf.clear();
        updategidtf.clear();
        cgettexttf.clear();
        goodstablevalue();
    }

    //    清空文本框事件
    @FXML
    protected void refreshtf() {
        selecttf.clear();
        cgettexttf.clear();
        deletetf.clear();
        gidtf.clear();
        ginnumtf.clear();
        gnametf.clear();
        gppricetf.clear();
        gpushertf.clear();
        gsuppliertf.clear();
        gvpricetf.clear();
    }

    //    提示标签清空事件
    @FXML
    protected void setemptybelled() {
        updatetf.clear();
    }

    @FXML
    protected void personalcenter() {
        cptid.setCellValueFactory(new PropertyValueFactory<>("tid"));
        cpvid.setCellValueFactory(new PropertyValueFactory<>("vid"));
        cpdatetime.setCellValueFactory(new PropertyValueFactory<>("sdate"));
        cpcash.setCellValueFactory(new PropertyValueFactory<>("scash"));
        cpintergal.setCellValueFactory(new PropertyValueFactory<>("sintegral"));
        cpeid.setCellValueFactory(new PropertyValueFactory<>("eid"));
        cptablevalue();
        ccptid.setCellValueFactory(new PropertyValueFactory<>("tid"));
        cpgid.setCellValueFactory(new PropertyValueFactory<>("gid"));
        cpgname.setCellValueFactory(new PropertyValueFactory<>("gname"));
        cpprice.setCellValueFactory(new PropertyValueFactory<>("gprice"));
        cptnum.setCellValueFactory(new PropertyValueFactory<>("tnum"));
        cpnumprice.setCellValueFactory(new PropertyValueFactory<>("sumprice"));
        sspecificition.setCellValueFactory(new PropertyValueFactory<>("specifications"));
        ccprefreshtable();
        cptable.setRowFactory(tv -> {
            TableRow<Allentity> TableRow = new TableRow<>();
            TableRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !TableRow.isEmpty()) {
                    ccptablevalue(TableRow.getItem().getVid(), TableRow.getItem().getTid());
                    seidtf.setText(TableRow.getItem().getEid());
                    setprefresh();
                }
            });
            return TableRow;
        });
        if (cprangecb.getItems().isEmpty()) {
            cprangecb.getItems().addAll("小票编号", "顾客编号", "购买时间", "经手人");
        }
    }

    protected void ccptablevalue(String vid, String tid) {
        if (vid.charAt(0) == 'P') {
            fristString = tid;
            ccptable.setItems(function.gettablevalue(adminDao.getGpprice(connection)));
        } else {
            fristString = tid;
            ccptable.setItems(function.gettablevalue(adminDao.getGvprice(connection)));
        }
    }

    @FXML
    protected void setcpselect() {
        setcprefershbutton();
        ccprefreshtable();
        seidtf.clear();
        if ("购买时间".equals(cprangecb.getValue())) {
            cphb.setVisible(true);
            cpselecttf.setVisible(false);
        } else {
            cphb.setVisible(false);
            cpselecttf.setVisible(true);
        }
    }

    @FXML
    private void setcprefershbutton() {
        cpselecttf.clear();
        cptablevalue();
    }

    protected void cptablevalue() {
        choise = 1;
        cptable.setItems(function.gettablevalue(adminDao.getPsales(connection)));
        Object vsql = adminDao.getSumvprice(connection);
        Object psql = adminDao.getSumpprice(connection);
        Object vcount = adminDao.getCountvtid(connection);
        Object pcount = adminDao.getCountptid(connection);
        getcountprice(vsql, psql, vcount, pcount);
    }

    private void getcountprice(Object vsql, Object psql, Object vcount, Object pcount) {
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
        countpricetf.setText(String.format("%.2f", vprice + pprice));
        countnumtf.setText(String.valueOf((long) vcount + (long) pcount));
    }

    protected void ccprefreshtable() {
        ccptable.setItems(function.gettablevalue(adminDao.setRefresh(connection)));
    }

    @FXML
    protected void setcpokbutton() {
        boolean is;
        Object vsql = null, psql = null, vcount = null, pcount = null;
        fristString = cpselecttf.getText();
        if ("小票编号".equals(cprangecb.getValue())) {
            is = true;
            choise = 2;
            cptable.setItems(function.gettablevalue(adminDao.getPsalestid(connection)));
            vsql = adminDao.getSumvpricetid(connection);
            psql = adminDao.getSumppricetid(connection);
            vcount = adminDao.getCountvtidtid(connection);
            pcount = adminDao.getCountptidtid(connection);
        } else if ("顾客编号".equals(cprangecb.getValue())) {
            is = true;
            choise = 3;
            cptable.setItems(function.gettablevalue(adminDao.getPsalesvid(connection)));
            vsql = adminDao.getSumvpricevid(connection);
            psql = adminDao.getSumppricevid(connection);
            vcount = adminDao.getCountvtidvid(connection);
            pcount = adminDao.getCountptidvid(connection);
        } else if ("购买时间".equals(cprangecb.getValue())) {
            is = true;
            choise = 4;
            secondString = String.valueOf(cpbegin.getValue());
            thirdString = String.valueOf(cpend.getValue());
            cptable.setItems(function.gettablevalue(adminDao.getPsalessdate(connection)));
            vsql = adminDao.getSumvpricesdate(connection);
            psql = adminDao.getSumppricesdate(connection);
            vcount = adminDao.getCountvtidsdate(connection);
            pcount = adminDao.getCountptidsdate(connection);
        } else if ("经手人".equals(cprangecb.getValue())) {
            is = true;
            choise = 5;
            cptable.setItems(function.gettablevalue(adminDao.getPsaleseid(connection)));
            vsql = adminDao.getSumvpriceeid(connection);
            psql = adminDao.getSumppriceeid(connection);
            vcount = adminDao.getCountvtideid(connection);
            pcount = adminDao.getCountptideid(connection);
        } else {
            function.setAlert("搜索范围未选择！");
            is = false;
        }
        if (is) {
            getcountprice(vsql, psql, vcount, pcount);
        }
    }

    @FXML
    protected void saleoutdata() {
        List<Allentity> list;
        switch (choise) {
            case 1:
                list = adminDao.getSaleoutdate1(connection);
                break;
            case 2:
                list = adminDao.getSaleoutdate2(connection);
                break;
            case 3:
                list = adminDao.getSaleoutdate3(connection);
                break;
            case 4:
                list = adminDao.getSaleoutdate4(connection);
                break;
            case 5:
                list = adminDao.getSaleoutdate5(connection);
                break;
            default:
                list = null;
                break;
        }
        if (list != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss");
            Date date = new Date();
            String sdate = simpleDateFormat.format(date);
            Stage stage = new Stage();
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File file = directoryChooser.showDialog(stage);
            //选择的文件夹路径
            if (file != null) {
                String path = file.getPath();
                String[] titles = {"小票编号", "顾客编号", "收银员编号", "收银员姓名", "结账时间", "顾客支付金额", "获得积分", "商品编号", "商品名称", "商品类别", "普通售价", "会员售价", "购买数量", "规格"};
                //        创建文件
                File file1 = new File(path + "/sales" + sdate + ".xls");
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(file1);
                    WritableSheet sheet = workbook.createSheet("sheet1", 0);
                    jxl.write.Label label;
                    //            添加标题
                    for (int i = 0; i < titles.length; i++) {
                        label = new jxl.write.Label(i, 0, titles[i]);
                        sheet.addCell(label);
                    }
                    //            添加数据
                    for (int i = 0; i < Objects.requireNonNull(list).size(); i++) {
                        label = new jxl.write.Label(0, i + 1, list.get(i).getTid());
                        sheet.addCell(label);
                        label = new jxl.write.Label(1, i + 1, list.get(i).getVid());
                        sheet.addCell(label);
                        label = new jxl.write.Label(2, i + 1, list.get(i).getEid());
                        sheet.addCell(label);
                        label = new jxl.write.Label(3, i + 1, list.get(i).getEname());
                        sheet.addCell(label);
                        label = new jxl.write.Label(4, i + 1, String.valueOf(list.get(i).getSdate()));
                        sheet.addCell(label);
                        label = new jxl.write.Label(5, i + 1, String.valueOf(list.get(i).getScash()));
                        sheet.addCell(label);
                        label = new jxl.write.Label(6, i + 1, String.valueOf(list.get(i).getSintegral()));
                        sheet.addCell(label);
                        label = new jxl.write.Label(7, i + 1, list.get(i).getGid());
                        sheet.addCell(label);
                        label = new jxl.write.Label(8, i + 1, list.get(i).getGname());
                        sheet.addCell(label);
                        label = new jxl.write.Label(9, i + 1, list.get(i).getGcategory());
                        sheet.addCell(label);
                        label = new jxl.write.Label(10, i + 1, String.valueOf(list.get(i).getGpprice()));
                        sheet.addCell(label);
                        label = new jxl.write.Label(11, i + 1, String.valueOf(list.get(i).getGvprice()));
                        sheet.addCell(label);
                        label = new jxl.write.Label(12, i + 1, String.valueOf(list.get(i).getTnum()));
                        sheet.addCell(label);
                        label = new jxl.write.Label(13, i + 1, list.get(i).getSpecifications());
                        sheet.addCell(label);
                    }
                    workbook.write();
                    workbook.close();
                    function.setAlert1("保存成功！");
                } catch (Exception e) {
                    function.setAlert("出错，请重新保存！");
                }
            }
        }
    }

    @FXML
    protected void setpfreshbutton() {
        setprefresh();
    }

    private void setprefresh() {
        Object vsql;
        Object psql;
        Object vcount;
        Object pcount;
        fristString = cpselecttf.getText();
        secondString = seidtf.getText();
        if (!seidtf.getText().isEmpty()) {
            vsql = adminDao.getSumvpricetideid(connection);
            psql = adminDao.getSumppricetideid(connection);
            vcount = adminDao.getCountvtidtideid(connection);
            pcount = adminDao.getCountptidtideid(connection);
        } else {
            vsql = adminDao.getSumvpricetid(connection);
            psql = adminDao.getSumppricetid(connection);
            vcount = adminDao.getCountvtidtid(connection);
            pcount = adminDao.getCountptidtid(connection);
        }
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
        countpricetf.setText(String.format("%.2f", vprice + pprice));
        countnumtf.setText(String.valueOf((long) vcount + (long) pcount));
    }

    /*财务统计*/
    @FXML
    protected void setchartdate() {
        seidcolumn.setCellValueFactory(new PropertyValueFactory<>("eid"));
        snamecolumn.setCellValueFactory(new PropertyValueFactory<>("ename"));
        svcolumn.setCellValueFactory(new PropertyValueFactory<>("sv"));
        spcolumn.setCellValueFactory(new PropertyValueFactory<>("sp"));
        sscolumn.setCellValueFactory(new PropertyValueFactory<>("ss"));

        sccolumn.setCellValueFactory(new PropertyValueFactory<>("gcategory"));
        ssscolumn.setCellValueFactory(new PropertyValueFactory<>("percentage"));
        sncolumn.setCellValueFactory(new PropertyValueFactory<>("sum"));

        sdcolumn.setCellValueFactory(new PropertyValueFactory<>("datee"));
        sppcolumn.setCellValueFactory(new PropertyValueFactory<>("profits"));
        String oledate = simpledateformat2.format(new Date());
        String newdate = simpledateformat1.format(new Date());
        setdate(oledate, newdate);
        setLinechart(getfirst(), simpledateformat3.format(new Date()));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        int year = Integer.parseInt(simpleDateFormat.format(new Date()));
        if (yearcombox.getItems().isEmpty()) {
            for (int i = 2010; i <= 2070; i++) {
                yearcombox.getItems().add(i);
            }
        }
        yearcombox.setValue(year);
        setLinechart1(yearcombox.getValue());
    }

    @FXML
    protected void setchartrefresh() {
        String olddate;
        String newdate;
        if (cbegindate.getValue() != null && cenddate.getValue() != null) {
            if ((int) (cenddate.getValue().toEpochDay() - cbegindate.getValue().toEpochDay()) >= 0) {
                if ((int) (cenddate.getValue().toEpochDay() - cbegindate.getValue().toEpochDay()) <= 365 * 3) {
                    ZonedDateTime zonedDateTime = cbegindate.getValue().atStartOfDay(ZoneId.systemDefault());
                    olddate = simpledateformat2.format(Date.from(zonedDateTime.toInstant()));
                    LocalDate localDate = cenddate.getValue().plusDays(1);
                    ZonedDateTime zonedDateTime1 = localDate.atStartOfDay(ZoneId.systemDefault());
                    ZonedDateTime zonedDateTime3 = cenddate.getValue().atStartOfDay(ZoneId.systemDefault());
                    newdate = simpledateformat2.format(Date.from(zonedDateTime1.toInstant()));
                    setdate(olddate, newdate);
                    setLinechart(simpledateformat3.format(Date.from(zonedDateTime.toInstant())), simpledateformat3.format(Date.from(zonedDateTime3.toInstant())));
                } else {
                    function.setAlert("查询时间间隔仅限于三年内！");
                }
            } else {
                function.setAlert("开始日期大于结束日期！");
            }
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            int year = Integer.parseInt(simpleDateFormat.format(new Date()));
            yearcombox.setValue(year);
            setLinechart1(yearcombox.getValue());
        }
    }

    @FXML
    protected void setYearcombox() {
        setLinechart1(yearcombox.getValue());
    }

    private double getcategortdata(String olddate, String newdate, String category) {
        fristString = olddate;
        secondString = newdate;
        thirdString = category;
        Object vsql = adminDao.getVsql(connection);
        Object psql = adminDao.getPsql(connection);
        double v;
        double p;
        if (vsql == null) {
            v = 0;
        } else {
            v = (double) vsql;
        }
        if (psql == null) {
            p = 0;
        } else {
            p = (double) psql;
        }
        return p + v;
    }

    private void setdate(String oledate, String newdate) {
//    销售类别占比统计图
        fristString = oledate;
        secondString = newdate;
        piechart.getData().clear();
        piechart.setTitle(oledate + " 至 " + newdate + " 售出商品类别占比图");
        Object sql2 = adminDao.getTnumsql2(connection);
        Object psql2 = adminDao.getTnumpsql2(connection);
        double num1;
        if (sql2 != null) {
            num1 = (Double) sql2;
        } else {
            num1 = 0.0;
        }
        double num2;
        if (psql2 != null) {
            num2 = (Double) psql2;
        } else {
            num2 = 0.0;
        }
        num = num1 + num2;
        List<String> list = new ArrayList<>();
        List<Allentity> Glist = adminDao.getGcategorybarchart(connection);
        assert Glist != null;
        for (Allentity value : Glist) {
            list.add(value.getGcategory());
        }
        if (piechart.getData().isEmpty()) {
            for (int i = 0; i < Objects.requireNonNull(list).size(); i++) {
                piechart.getData().add(new PieChart.Data(list.get(i), getcategortdata(oledate, newdate, list.get(i))));
            }
        }
//        某日员工营业收入额柱状图
        barchart1.getData().clear();
        barchart1.setTitle(oledate + " 至 " + newdate + "员工营业收入额柱状图");
        ObservableList<String> enamelist = FXCollections.observableArrayList();
        List<Allentity> list1 = adminDao.getSeleteeidsql(connection);
        assert list1 != null;
        if (!list1.isEmpty()) {
            for (Allentity allentity : list1) {
                enamelist.add(allentity.getEname());
            }
            if (barchart1.getData().isEmpty()) {
                XYChart.Series<String, Double> series1 = new XYChart.Series<>();
                XYChart.Series<String, Double> series2 = new XYChart.Series<>();
                XYChart.Series<String, Double> series3 = new XYChart.Series<>();
                series1.setName("会员销售收入");
                series2.setName("普通销售收入");
                series3.setName("总销售收入");
                double vprice;
                double pprice;
                for (int i = 0; i < Objects.requireNonNull(enamelist).size(); i++) {
                    String eid = list1.get(i).getEid();
                    String ename = list1.get(i).getEname();
                    thirdString = eid;
                    Object vsumsql = adminDao.getSumvtnum(connection);
                    Object psumsql = adminDao.getSumptnum(connection);
                    if (vsumsql == null) {
                        vprice = 0.0;
                    } else {
                        vprice = (Double) vsumsql;
                    }
                    if (psumsql == null) {
                        pprice = 0.0;
                    } else {
                        pprice = (Double) psumsql;
                    }
                    series1.getData().add(new XYChart.Data<>(ename, vprice));
                    series2.getData().add(new XYChart.Data<>(ename, pprice));
                    series3.getData().add(new XYChart.Data<>(ename, vprice + pprice));
                }
                xaxis1.setCategories(enamelist);
                barchart1.getData().addAll(series1, series2, series3);
            }
        }
        setcharttable1();
        setcharttable2();
        getstatistics(oledate, newdate);
    }


    //        财务统计
    private void getstatistics(String oledate, String newdate) {
        statisticallabel.setText(oledate + " 至 " + newdate + " 期间商店财务统计数据");
        fristString = oledate;
        secondString = newdate;
        double totalrevenue1 = getdate(adminDao.getTotalrevenue1(connection));
        double totalcost1 = getdate(adminDao.getTotalcost1(connection));
        double grossprofit1 = getdate(adminDao.getGrossprofit1(connection));
        double averageprofit1;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        long year = LocalDate.parse(newdate, dateTimeFormatter).toEpochDay() - LocalDate.parse(oledate, dateTimeFormatter).toEpochDay();
        if (year == 0) {
            averageprofit1 = grossprofit1;
        } else {
            averageprofit1 = Double.parseDouble(grossprofit.getText().substring(0, grossprofit.getText().length() - 2)) / year;
        }
        averageprofit.setText(String.format("%.2f", averageprofit1) + " 元");
        totalrevenue.setText(totalrevenue1 + "元");
        totalcost.setText(totalcost1 + "元");
        grossprofit.setText(grossprofit1 + "元");
        String olddate1 = dateTimeFormatter.format(LocalDateTime.parse(oledate, dateTimeFormatter).minusMonths(1));
        String newdate1 = dateTimeFormatter.format(LocalDateTime.parse(newdate, dateTimeFormatter).minusMonths(1));
        fristString = olddate1;
        secondString = newdate1;
        double totalrevenue2 = getdate(adminDao.getTotalrevenue1(connection));
        double totalcost2 = getdate(adminDao.getTotalcost1(connection));
        double grossprofit2 = getdate(adminDao.getGrossprofit1(connection));
        double averageprofit2;
        long date = LocalDate.parse(newdate, dateTimeFormatter).minusMonths(1).toEpochDay() - LocalDate.parse(oledate, dateTimeFormatter).minusMonths(1).toEpochDay();
        if (date == 0) {
            averageprofit2 = grossprofit2;
        } else {
            averageprofit2 = Double.parseDouble(String.format("%.2f", grossprofit1 / date));
        }
        tlgrowth.setText(String.format("%.2f", (((totalrevenue1 - totalrevenue2) / totalrevenue2) * 100)) + "%");
        trgrowth.setText(String.format("%.2f", (((totalcost1 - totalcost2) / totalcost2) * 100)) + "%");
        gpgrowth.setText(String.format("%.2f", (((grossprofit1 - grossprofit2) / grossprofit2) * 100)) + "%");
        apgrowth.setText(String.format("%.2f", (((averageprofit1 - averageprofit2) / averageprofit2) * 100)) + "%");
    }

    private void setLinechart(String begindate, String enddate) {
        linechart.getData().clear();
        linechart.setTitle(begindate + " 至 " + enddate + "商店利润变化图");
        ObservableList<String> observableList = findDates(begindate, enddate);
        List<String> list = new ArrayList<>();
        if (linechart.getData().isEmpty()) {
            double sum;
            XYChart.Series<String, Double> series = new XYChart.Series<>();
            for (int i = 0; i < observableList.size() - 1; i++) {
                list.add(observableList.get(i));
                fristString = observableList.get(i);
                secondString = observableList.get(i + 1);
                sum = getdate(adminDao.getLinechartdate(connection));
                series.getData().add(new XYChart.Data<>(observableList.get(i), sum));
            }
            xaxis2.setCategories(FXCollections.observableList(list));
            linechart.getData().add(series);
        }
        setcharttable3();
    }

    private void setLinechart1(int year) {
        linechartyear.getData().clear();
        linechartyear.setTitle(year + " 年份商店利润收入变化图");
        ObservableList<String> month = FXCollections.observableArrayList();
        List<String> getmonth = findDatesyear(year);
        if (linechartyear.getData().isEmpty()) {
            XYChart.Series<String, Double> series = new XYChart.Series<>();
            double sum;
            for (int i = 0; i < 12; i++) {
                month.add((i + 1) + "月份");
                fristString = getmonth.get(i);
                secondString = getmonth.get(i + 1);
                sum = getdate(adminDao.getLinechartdate(connection));
                series.getData().add(new XYChart.Data<>((i + 1) + "月份", sum));
            }
            xaxis3.setCategories(month);
            linechartyear.getData().add(series);
        }
        setmontfdata(getmonth);
    }

    //    设置每一个月份利润额
    private void setmontfdata(List<String> getmonth) {
        fristString = getmonth.get(0);
        secondString = getmonth.get(1);
        January.setText(getdate(adminDao.getLinechartdate(connection)) + " 元");
        fristString = getmonth.get(1);
        secondString = getmonth.get(2);
        February.setText(getdate(adminDao.getLinechartdate(connection)) + " 元");
        fristString = getmonth.get(2);
        secondString = getmonth.get(3);
        March.setText(getdate(adminDao.getLinechartdate(connection)) + " 元");
        fristString = getmonth.get(3);
        secondString = getmonth.get(4);
        April.setText(getdate(adminDao.getLinechartdate(connection)) + " 元");
        fristString = getmonth.get(4);
        secondString = getmonth.get(5);
        May.setText(getdate(adminDao.getLinechartdate(connection)) + " 元");
        fristString = getmonth.get(5);
        secondString = getmonth.get(6);
        June.setText(getdate(adminDao.getLinechartdate(connection)) + " 元");
        fristString = getmonth.get(6);
        secondString = getmonth.get(7);
        July.setText(getdate(adminDao.getLinechartdate(connection)) + " 元");
        fristString = getmonth.get(7);
        secondString = getmonth.get(8);
        August.setText(getdate(adminDao.getLinechartdate(connection)) + " 元");
        fristString = getmonth.get(8);
        secondString = getmonth.get(9);
        September.setText(getdate(adminDao.getLinechartdate(connection)) + " 元");
        fristString = getmonth.get(9);
        secondString = getmonth.get(10);
        October.setText(getdate(adminDao.getLinechartdate(connection)) + " 元");
        fristString = getmonth.get(10);
        secondString = getmonth.get(11);
        November.setText(getdate(adminDao.getLinechartdate(connection)) + " 元");
        fristString = getmonth.get(11);
        secondString = getmonth.get(12);
        December.setText(getdate(adminDao.getLinechartdate(connection)) + " 元");
    }

    private void setcharttable1() {
        fristString = barchart1.getTitle().substring(0, 19);
        secondString = barchart1.getTitle().substring(22, 41);
        List<Allentity> list = adminDao.setCharttable1(connection);
        assert list != null;
        seidtable1.setItems(FXCollections.observableList(list));
    }

    private void setcharttable2() {
        double sum;
        if (num != 0.0) {
            sum = num;
        } else {
            sum = 1.0;
        }
        fristString = piechart.getTitle().substring(0, 19);
        secondString = piechart.getTitle().substring(22, 41);
        thirdString = String.valueOf(sum);
        List<Allentity> list = adminDao.setCharttable2(connection);
        assert list != null;
        seidtable2.setItems(FXCollections.observableList(list));
    }

    private void setcharttable3() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(linechart.getTitle().substring(13, 23)));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        } catch (ParseException e) {
            function.setAlert("出错！");
        }
        fristString = linechart.getTitle().substring(0, 10);
        secondString = simpledateformat3.format(calendar.getTime());
        List<Allentity> list = adminDao.setCharttable3(connection);
        assert list != null;
        sptable.setItems(FXCollections.observableList(list));
    }

    //    获取一段时间之间的日期
    private ObservableList<String> findDates(String dbegin, String dend) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calbegin = Calendar.getInstance();
        Calendar calend = Calendar.getInstance();
        List<String> datelist = new ArrayList<>();
        try {
            calbegin.setTime(dateFormat.parse(dbegin));
            calend.setTime(dateFormat.parse(dend));
            calend.add(Calendar.DAY_OF_MONTH, 1);
            datelist.add(dbegin);
            while (calend.getTime().after(calbegin.getTime())) {
                calbegin.add(Calendar.DAY_OF_MONTH, 1);
                datelist.add(dateFormat.format(calbegin.getTime()));
            }
        } catch (ParseException e) {
            function.setAlert("出错！");
        }
        return FXCollections.observableList(datelist);
    }

    //    获取当前月份第一天
    private String getfirst() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return simpledateformat3.format(calendar.getTime());
    }

    //    获取某一年所有月份第一天
    public List<String> findDatesyear(int year) {
        List<String> list = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < 12; i++) {
            calendar.set(year, i, 1);
            list.add(simpledateformat2.format(calendar.getTime()));
        }
        calendar.add(Calendar.MONTH, 1);
        list.add(simpledateformat2.format(calendar.getTime()));
        return list;
    }

    private double getdate(Object sql) {
        double date;
        if (sql == null) {
            date = 0;
        } else {
            date = (double) sql;
        }
        return date;
    }
}