package com.example.cash_register_system;

import Dao.LoginDaoImpl;
import JDBCUtils.Allentity;
import JDBCUtils.JdbcConnection;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author hongxiaobin
 */
public class LogininEvent {
    private static final Alert ALERT = new Alert(Alert.AlertType.WARNING);
    public static String eid;
    public static String epassword;
    public static String gid;
    public static String logintime;
    public static String fristString;
    public static List<Allentity> employeelist = new ArrayList<>();
    private static String code;
    private static int a;
    private final LoginDaoImpl loginDaoImpl = new LoginDaoImpl();
    @FXML
    public TextField idtf;
    LoginDaoImpl loginDao = new LoginDaoImpl();
    Loginin loginin = new Loginin();
    List<Allentity> list = new ArrayList<>();
    private Connection connection = null;
    @FXML
    private TextField passwordtf;
    @FXML
    private TextField codetf;
    @FXML
    private Label labelled;
    @FXML
    private Label codelabble = new Label("");
    @FXML
    private RadioButton roleadmin;
    @FXML
    private RadioButton roleemployee;
    @FXML
    private TextField fidtf;
    @FXML
    private TextField fnametf;
    @FXML
    private TextField fphonetf;
    @FXML
    private PasswordField fpasswordtf;
    @FXML
    private PasswordField fppasswordtf;
    @FXML
    private TextField fcodetf;
    @FXML
    private Label fcodelabble;
    @FXML
    private Button okbutton;


    {
        try {
            connection = JdbcConnection.getConnection();
            employeelist = loginDao.getEmployee(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void setResetbutton() {
        idtf.clear();
        passwordtf.clear();
        codetf.clear();
    }

    @FXML
    protected void setOkbutton() {
        fristString = "<???>";
        if (loginDaoImpl.getGcategory(connection).isEmpty()) {
            loginDaoImpl.insertGcategory(connection);
        }
        if (loginDaoImpl.getEcategory(connection).isEmpty()) {
            loginDaoImpl.insertEcategory(connection);
        }
        if (loginDaoImpl.getReficition(connection).isEmpty()) {
            loginDaoImpl.insertReficition(connection);
        }
        if (!idtf.getText().isEmpty() && !passwordtf.getText().isEmpty()) {
            eid = idtf.getText();
            for (int i = 0; i < employeelist.size(); i++) {
                if (employeelist.get(i).getEid().equals(eid)) {
                    list.add(employeelist.get(i));
                    break;
                }
            }
            try {
                Long.parseLong(idtf.getText());
                if (idtf.getText().length() == 10) {
                    assert list != null;
                    if (!list.isEmpty()) {
                        if (passwordtf.getText().equals(list.get(0).getEpassword())) {
                            if (code.equalsIgnoreCase(codetf.getText())) {
                                Loginin loginin = new Loginin();
                                if (roleadmin.isSelected() && "?????????".equals(list.get(0).getErole())) {
                                    Loginin.stageclose.close();
                                    gid = idtf.getText();
                                    try {
                                        loginin.adminStage().show();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } else if (roleemployee.isSelected() && "?????????".equals(list.get(0).getErole())) {
                                    Loginin.stageclose.close();
                                    Date date = new Date();
                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    logintime = simpleDateFormat.format(date);
                                    eid = idtf.getText();
                                    try {
                                        loginin.cashierStage().show();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    setAlert("????????????????????????");
                                }
                            } else {
                                setAlert("???????????????????????????");
                            }
                        } else {
                            setAlert("????????????");
                        }
                    } else {
                        setAlert("???????????????");
                    }
                } else {
                    setAlert("??????????????????10???");
                }
            } catch (NumberFormatException e) {
                setAlert("??????????????????");
            }
        } else {
            setAlert("?????????????????????");
        }
    }


    @FXML
    protected void setCodetf() {
        setcode(codelabble);
    }

    @FXML
    protected void setfCodetf() {
        setcode(fcodelabble);
    }

    private void setcode(Label codelabble) {
        if (codelabble.getText().isEmpty()) {
            char a = (char) (Math.random() * 25 + 65);
            char b = (char) (Math.random() * 25 + 65);
            char c = (char) (Math.random() * 25 + 65);
            char d = (char) (Math.random() * 25 + 65);
            code = a + "" + b + "" + c + "" + d;
            codelabble.setText(code);
        }
    }

    @FXML
    protected void setFindpasswordlabel() {
        Loginin loginin = new Loginin();
        try {
            Loginin.stageclose.close();
            loginin.findpasswordsstage().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void setreturn() {
        Loginin loginin = new Loginin();
        try {
            Loginin.stageclose.close();
            loginin.loginStage().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void fokbutton() {
        boolean is;
        if (a == 2) {
            if (!fidtf.getText().isEmpty() && !fnametf.getText().isEmpty() && !fphonetf.getText().isEmpty()) {
                eid = fidtf.getText();
                List<Allentity> list = loginDaoImpl.getEmployee(connection);
                assert list != null;
                if (!list.isEmpty()) {
                    if (list.get(0).getEname().equals(fnametf.getText()) && list.get(0).getEphone().equals(fphonetf.getText())) {
                        is = true;
                    } else {
                        is = false;
                        setAlert("??????????????????????????????");
                    }
                } else {
                    is = false;
                    setAlert("??????????????????");
                }
            } else {
                is = false;
                setAlert("?????????????????????????????????????????????");
            }
        } else {
            if (!fidtf.getText().isEmpty()) {
                eid = fidtf.getText();
                List<Allentity> list = loginDaoImpl.getEmployee(connection);
                assert list != null;
                if (!list.isEmpty()) {
                    is = true;
                } else {
                    is = false;
                    setAlert("??????????????????");
                }
            } else {
                is = false;
                setAlert("?????????????????????");
            }
        }
        if (is) {
            if (fpasswordtf.getText().length() >= 6) {
                if (fpasswordtf.getText().equals(fppasswordtf.getText())) {
                    if (fcodelabble.getText().equalsIgnoreCase(fcodetf.getText())) {
                        epassword = fpasswordtf.getText();
                        eid = fidtf.getText();
                        loginDaoImpl.updateEmployee(connection);
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("????????????");
                        alert.setHeaderText("?????????????????????");
                        Optional<ButtonType> buttonType = alert.showAndWait();
                        if (buttonType.isPresent() && buttonType.get() == ButtonType.OK) {
                            Loginin.stageclose.close();
                            try {
                                loginin.loginStage().show();
                            } catch (Exception e) {
                                setAlert(e.getMessage());
                            }
                        }
                    } else {
                        setAlert("??????????????????");
                    }
                } else {
                    setAlert("???????????????????????????????????????");
                }
            } else {
                setAlert("?????????????????????6??????");
            }
        }
    }

    @FXML
    protected void setEdit() {
        eid = fidtf.getText();
        List<Allentity> list = loginDaoImpl.getEmployeeEid(connection, eid);
        if (!list.isEmpty()) {
            if ("?????????".equals(list.get(0).getErole())) {
                a = 1;
                fnametf.setPromptText("???????????????????????????????????????");
                fphonetf.setPromptText("???????????????????????????????????????");
                fnametf.setEditable(false);
                fphonetf.setEditable(false);
            } else {
                a = 2;
                fnametf.setPromptText("???????????????");
                fphonetf.setPromptText("?????????????????????");
                fnametf.setEditable(true);
                fphonetf.setEditable(true);
            }
        } else {
            a = 2;
            fnametf.setPromptText("???????????????");
            fphonetf.setPromptText("?????????????????????");
            fnametf.setEditable(true);
            fphonetf.setEditable(true);
        }
    }

    private void setAlert(String s) {
        ALERT.setTitle("??????!");
        ALERT.setHeaderText(s);
        ALERT.show();
    }
}