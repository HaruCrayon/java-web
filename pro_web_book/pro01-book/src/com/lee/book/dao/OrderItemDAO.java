package com.lee.book.dao;

import com.lee.book.domain.OrderBean;
import com.lee.book.domain.OrderItem;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public interface OrderItemDAO {
    //新增订单项
    void addOrderItem(OrderItem orderItem);
    //查询特定订单的订单项列表
    List<OrderItem> getOrderItemList(Integer orderId);
}
