package com.lee.book.dao;

import com.lee.book.domain.OrderBean;
import com.lee.book.domain.User;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public interface OrderDAO {
    //新增订单
    void addOrderBean(OrderBean orderBean);
    //查询订单表中最大id值,即为新增订单的id
    Integer getMaxId();
    //查询订单列表
    List<OrderBean> getOrderList(User user);
}
