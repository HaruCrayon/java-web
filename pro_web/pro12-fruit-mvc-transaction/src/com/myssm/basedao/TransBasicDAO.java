package com.myssm.basedao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 * 开发 BasicDAO,是其他 DAO 的父类,使用到 Apache-DBUtils
 */
public class TransBasicDAO<T> {//泛型指定具体类型
    private QueryRunner qr = new QueryRunner();

    //开发通用的 dml 方法, 针对任意的表
    public int update(String sql, Object... parameters) {
        try {
            Connection connection = ConnUtil.getConn();
            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //返回多个对象(即查询结果是多行), 针对任意表
    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) {
        try {
            Connection connection = ConnUtil.getConn();
            List<T> query = qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //返回单个对象(即查询结果是单行), 针对任意表
    public T querySingle(String sql, Class<T> clazz, Object... parameters) {
        try {
            Connection connection = ConnUtil.getConn();
            T query = qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //返回单值(即查询结果是单行单列), 针对任意表
    public Object queryScalar(String sql, Object... parameters) {
        try {
            Connection connection = ConnUtil.getConn();
            Object query = qr.query(connection, sql, new ScalarHandler<>(), parameters);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
