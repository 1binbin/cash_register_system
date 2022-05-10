package com.example.cash_register_system;

import Dao.FunctionDaoImpl;
import JDBCUtils.Allentity;
import JDBCUtils.JdbcConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.sql.Connection;
import java.util.List;

/**
 * @author hongxiaobin
 * @create 2022/1/22-11:17
 * @description 定义共有功能
 */
public class Function {
    private static final Alert ALERT = new Alert(Alert.AlertType.WARNING);
    private static final Alert ALERT_1 = new Alert(Alert.AlertType.INFORMATION);
    public static String fristString = null;
    public static String secondString = null;
    public static String thirdString = null;
    public static String fourthString = null;
    public static String fifthString = null;
    public static String sixthString = null;
    private FunctionDaoImpl functionDao = new FunctionDaoImpl();
    private Connection connection;

    {
        try {
            connection = JdbcConnection.getConnection();
        } catch (Exception e) {
            setAlert("数据库连接出错！");
        }
    }

    public String getaddress(ComboBox<String> uprovincecb, ComboBox<String> ucitycb, ComboBox<String> uareacb) {
        String gorigin;
        String provien = "";
        String city = "";
        String area = "";
        if (uprovincecb.getValue() != null) {
            provien = uprovincecb.getValue();
        }
        if (ucitycb.getValue() != null && !"市辖区".equals(ucitycb.getValue()) && !"县".equals(ucitycb.getValue()) && !"<空>".equals(ucitycb.getValue())) {
            city = ucitycb.getValue();
        }
        if (uareacb.getValue() != null && !"<空>".equals(uareacb.getValue())) {
            area = uareacb.getValue();
        }
        gorigin = provien + city + area;
        return gorigin;
    }

    public ObservableList<Allentity> gettablevalue(List<Allentity> list) {
        assert list != null;
        return FXCollections.observableList(list);
    }

    public void setcityshow(ComboBox<String> provincecb, ComboBox<String> citycb) {
        fristString = provincecb.getValue();
        List<Allentity> list = functionDao.getCity(connection);
        if (citycb.getItems().isEmpty()) {
            assert list != null;
            if (!list.isEmpty()) {
                for (Allentity allentity : list) {
                    citycb.getItems().add(allentity.getCity());
                }
            }
            citycb.getItems().add("<空>");
        }
    }

    public void setareashow(ComboBox<String> ucitycb, ComboBox<String> uareacb) {
        fristString = ucitycb.getValue();
        List<Allentity> list = functionDao.getArea(connection);
        if (uareacb.getItems().isEmpty()) {
            assert list != null;
            if (!list.isEmpty()) {
                for (Allentity allentity : list) {
                    uareacb.getItems().add(allentity.getArea());
                }
            }
            uareacb.getItems().add("<空>");
        }
    }

    public void setcityempty(ComboBox<String> ucitycb, ComboBox<String> uareacb) {
        int citynum = ucitycb.getItems().size();
        if (citynum > 0) {
            ucitycb.getItems().subList(0, citynum).clear();
        }
        int areanum = uareacb.getItems().size();
        if (areanum > 0) {
            uareacb.getItems().subList(0, areanum).clear();
        }
    }

    public void setCbItem(ComboBox<String> provincecb) {
        if (provincecb.getItems().isEmpty()) {
            List<Allentity> list = functionDao.getProvince(connection);
            assert list != null;
            if (!list.isEmpty()) {
                for (Allentity allentity : list) {
                    provincecb.getItems().add(allentity.getProvince());
                }
            }
        }
    }

    public void getgcategory(ComboBox<String> gcategorycb) {
        List<Allentity> list = functionDao.getGoods(connection);
        assert list != null;
        if (!list.isEmpty()) {
            if (gcategorycb.getItems().isEmpty()) {
                gcategorycb.setValue(list.get(0).getGoods());
                for (Allentity allentity : list) {
                    gcategorycb.getItems().add(allentity.getGoods());
                }
            }
        }
    }


    public void setrangecb(ComboBox<String> rangecb, TextField selecttf, HBox dateselecthb, ComboBox<String> selectcategorycb, ComboBox<String> sprovincecb, ComboBox<String> scitycb, ComboBox<String> sareacb, TableView<Allentity> tableView, Function function) {
        tableView.setItems(function.gettablevalue(functionDao.getGoodslist(connection)));
        if ("类别".equals(rangecb.getValue())) {
            selecttf.setVisible(false);
            selectcategorycb.setVisible(true);
            sprovincecb.setVisible(false);
            scitycb.setVisible(false);
            sareacb.setVisible(false);
            dateselecthb.setVisible(false);
            selecttf.setEditable(true);
        } else if ("产地".equals(rangecb.getValue())) {
            selecttf.setVisible(true);
            selectcategorycb.setVisible(false);
            sprovincecb.setVisible(true);
            scitycb.setVisible(true);
            sareacb.setVisible(true);
            dateselecthb.setVisible(false);
            selecttf.setEditable(false);
        } else if ("进货日期".equals(rangecb.getValue())) {
            selecttf.setVisible(false);
            selectcategorycb.setVisible(false);
            sprovincecb.setVisible(false);
            scitycb.setVisible(false);
            sareacb.setVisible(false);
            dateselecthb.setVisible(true);
            selecttf.setEditable(true);
        } else {
            selecttf.setVisible(true);
            selectcategorycb.setVisible(false);
            sprovincecb.setVisible(false);
            scitycb.setVisible(false);
            sareacb.setVisible(false);
            dateselecthb.setVisible(false);
            selecttf.setEditable(true);
        }
    }

    public void setAlert(String s) {
        ALERT.setTitle("警告!");
        ALERT.setHeaderText(s);
        ALERT.show();
    }

    public void setAlert1(String s) {
        ALERT_1.setTitle("提示!");
        ALERT_1.setHeaderText(s);
        ALERT_1.show();
    }

}
