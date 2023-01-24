package com.myssm.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author LiJing
 * @version 1.0
 * 基于 druid 数据库连接池的工具类
 */
public class JDBCUtilsByDruid {
    private static DataSource ds;

    //在静态代码块完成 ds初始化
    static {
        InputStream inputStream = JDBCUtilsByDruid.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            //在实际开发中，可以这样处理
            //1. 将编译异常转成运行异常
            //2. 调用者可以选择捕获该异常，也可以选择默认处理该异常，比较方便
            throw new RuntimeException(e);
        }
    }

    //获取连接
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //关闭连接
    //在数据库连接池技术中，close()不是真的断掉连接，而是把使用的Connection对象放回连接池
    public static void close(ResultSet set, Statement statement, Connection connection) {
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
