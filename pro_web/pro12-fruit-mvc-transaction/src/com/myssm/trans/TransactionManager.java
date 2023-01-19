package com.myssm.trans;

import com.myssm.basedao.ConnUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author LiJing
 * @version 1.0
 */
public class TransactionManager {
    //开启事务
    public static void beginTrans() throws SQLException {
        Connection conn = ConnUtil.getConn();
        conn.setAutoCommit(false);
    }

    //提交事务
    public static void commit() throws SQLException {
        Connection conn = ConnUtil.getConn();
        conn.commit();
        ConnUtil.closeConn();
    }

    //回滚事务
    public static void rollback() throws SQLException {
        Connection conn = ConnUtil.getConn();
        conn.rollback();
        ConnUtil.closeConn();
    }
}
