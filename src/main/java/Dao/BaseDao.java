package Dao;

import javafx.scene.control.ComboBox;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.io.BufferedReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author hongxiaobin
 * @create 2022/3/2-9:44
 * @description
 */
public abstract class BaseDao<T> {
    private QueryRunner queryRunner = new QueryRunner();
    private Class<T> type;
    public BaseDao(){
        Class clazz = this.getClass();
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        Type[] types = parameterizedType.getActualTypeArguments();
        this.type = (Class<T>) types[0];
    }
    /**
     * 通用增删改操作*/
    public int update(Connection connection,String sql,Object... params){
        int count = 0;
        try {
            count = queryRunner.update(connection,sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
    /**
     * 获取多个对象*/
    public List<T> getBeanList(Connection connection,String sql,Object... params){
        List<T> list = null;
        try {
            list = queryRunner.query(connection,sql,new BeanListHandler<T>(type),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    /**
     * 获取一个值*/
    public Object getValue(Connection connection,String sql , Object... params){
        Object count = null;
        try {
            count = queryRunner.query(connection,sql,new ScalarHandler<T>(),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
