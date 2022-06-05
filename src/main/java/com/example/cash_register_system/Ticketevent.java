package com.example.cash_register_system;

import Dao.TicketDaoImpl;
import JDBCUtils.Allentity;
import JDBCUtils.JdbcConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;

/**
 * @author hongxiaobin
 * @create 2022/1/23-1:07
 * @description
 */
public class Ticketevent {
    public static String fristString = null;
    public static String secondString = null;
    Function function = new Function();
    private TicketDaoImpl ticketDao = new TicketDaoImpl();
    private Connection connection;
    @FXML
    private TextArea tinfornation;
    @FXML
    private Label tchance;
    @FXML
    private Label ttidlabel;
    @FXML
    private Label tcash;
    @FXML
    private Label tnumprice;
    @FXML
    private Label tvid;
    @FXML
    private Label tintergal;
    @FXML
    private Label tcountnum;
    @FXML
    private GridPane vipg;
    @FXML
    private Label saletime;
    @FXML
    private Label saleeid;
    @FXML
    private Label binla;

    {
        try {
            connection = JdbcConnection.getConnection();
        } catch (Exception e) {
            function.setAlert("数据库连接出错！");
        }
    }

    @FXML
    protected void setinfornation() {
        if (Objects.equals(ttidlabel.getText(), "")) {
            saletime.setText(Cashierevent.datatime);
            saleeid.setText(Cashierevent.eid);
            tnumprice.setText(Cashierevent.tpricenum);
            tcountnum.setText(Cashierevent.tcountnum);
            tchance.setText(Cashierevent.tchance);
            tcash.setText(Cashierevent.tcash);
            ttidlabel.setText(Cashierevent.ttid);
            fristString = ttidlabel.getText();
            gettable(ticketDao.getTicket(connection));
            if (Cashierevent.choise == 0) {
                vipg.setVisible(false);
            } else {
                vipg.setVisible(true);
                tvid.setText(Cashierevent.tvid);
                secondString = Cashierevent.tvid;
                List<Allentity> list = ticketDao.getVsales(connection);
                assert list != null;
                if (!list.isEmpty()) {
                    tintergal.setText(list.get(0).getVintegral() + "");
                    binla.setText(list.get(0).getSintegral() + "");
                }
            }
        }
    }

    private void gettable(List<Allentity> plist) {
        assert plist != null;
        StringBuilder infornation = new StringBuilder();
        for (Allentity allentity : plist) {
            infornation.append(allentity.getGid()).append("\t").append(allentity.getGname()).append("\t").append(allentity.getGpprice()).append("\t").append(allentity.getGvprice()).append("\t").append(allentity.getTnum()).append("\t").append(allentity.getSpecifications()).append("\n");
        }
        tinfornation.setText(infornation.toString());
    }

}
