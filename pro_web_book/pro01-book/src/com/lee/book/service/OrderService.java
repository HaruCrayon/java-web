package com.lee.book.service;

import com.lee.book.domain.OrderBean;
import com.lee.book.domain.OrderItem;
import com.lee.book.domain.User;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public interface OrderService {
    //新增订单
    void addOrderBean(OrderBean orderBean);
    //查询订单列表
    List<OrderBean> getOrderList(User user);
}
