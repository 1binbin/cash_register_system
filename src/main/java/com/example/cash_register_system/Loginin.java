package com.example.cash_register_system;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @author hongxiaobin
 */
public class Loginin extends Application {
    public static String logintime;
    public static Stage stageclose;
    public static Stage deleteclose;
    public static Stage addclose;
    public static Connection connection;

    /**
     * 初始化数据库连接
     *
     * @Param:
     * @Return:
     */
    @Override
    public void init() throws Exception {
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String driver = properties.getProperty("driver");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
    }

    @Override
    public void start(Stage stage) throws Exception {
        loginStage().show();
    }

    public Stage loginStage() throws Exception {
        Stage stage = new Stage();
        stageclose = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Loginin.class.getResource("loginin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 380, 410);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("超市管理系统");
        return stage;
    }

    public Stage findpasswordsstage() throws Exception {
        Stage stage = new Stage();
        stageclose = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Loginin.class.getResource("findpassword.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 380, 440);
        stage.setScene(scene);
        stage.setTitle("找回密码");
        stage.setResizable(false);
        return stage;
    }

    public Stage cashierStage() throws Exception {
        Stage stage = new Stage();
        stageclose = stage;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logintime = simpleDateFormat.format(date);
        FXMLLoader fxmlLoader = new FXMLLoader(Loginin.class.getResource("Cashier.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 750);
        stage.setOnCloseRequest(Event::consume);
        stage.setScene(scene);
        stage.setTitle("收银员 编号：" + LogininEvent.eid);
        return stage;
    }

    public Stage adminStage() throws Exception {
        Stage stage = new Stage();
        stageclose = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Loginin.class.getResource("Admin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 750);
        stage.setOnCloseRequest(Event::consume);
        stage.setScene(scene);
        stage.setTitle("管理员");
        return stage;
    }

    public Stage ticketstage() throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Loginin.class.getResource("Ticket.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 700);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("小票");
        return stage;
    }

    public Stage batchaddstage() throws Exception {
        Stage stage = new Stage();
        addclose = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Loginin.class.getResource("Batchadd.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 200);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("批量添加");
        return stage;
    }

    public Stage batchdelete() throws Exception {
        Stage stage = new Stage();
        deleteclose = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Loginin.class.getResource("Batchdelete.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setOnCloseRequest(Event::consume);
        stage.setTitle("批量删除");
        return stage;
    }
}