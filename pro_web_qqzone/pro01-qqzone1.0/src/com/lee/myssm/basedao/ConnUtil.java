package com.lee.myssm.basedao;

import com.lee.myssm.utils.JDBCUtilsByDruid;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author LiJing
 * @version 1.0
 */
public class ConnUtil {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public static Connection getConn() {
        Connection connection = threadLocal.get();
        if (connection == null) {
            connection = JDBCUtilsByDruid.getConnection();
            threadLocal.set(connection);
        }
        return threadLocal.get();
    }

    public static void closeConn() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection == null) {
            return;
        }
        if (!connection.isClosed()) {
            connection.close();
//            threadLocal.set(null);
            threadLocal.remove();
        }
    }
}


/*
- set方法源码分析：
public void set(T value) {
     Thread t = Thread.currentThread(); //获取当前的线程
     ThreadLocalMap map = getMap(t);    //每一个线程都维护各自的一个容器（ThreadLocalMap）
     if (map != null)
         map.set(this, value);  //这里的key对应的是ThreadLocal，因为我们的组件中需要传输（共享）的对象可能会有多个（不止Connection）
     else
         createMap(t, value);  //默认情况下map是没有初始化的，那么第一次往其中添加数据时，会去初始化
}

-get方法源码分析：
public T get() {
	Thread t = Thread.currentThread(); //获取当前的线程
	ThreadLocalMap map = getMap(t);    //获取和这个线程（企业）相关的ThreadLocalMap（也就是工作纽带的集合）
	if (map != null) {
		ThreadLocalMap.Entry e = map.getEntry(this);   //this指的是ThreadLocal对象，通过它才能知道是哪一个工作纽带
		if (e != null) {
			@SuppressWarnings("unchecked")
			T result = (T)e.value; //entry.value就可以获取到工具箱了
			return result;
		}
	}
	return setInitialValue();
}
 */