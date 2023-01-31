package com.lee.book.dao.impl;

import com.lee.book.dao.OrderItemDAO;
import com.lee.book.domain.OrderBean;
import com.lee.book.domain.OrderItem;
import com.lee.myssm.basedao.TransBasicDAO;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class OrderItemDAOImpl extends TransBasicDAO<OrderItem> implements OrderItemDAO {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item values(null,?,?,?)";
        super.update(sql, orderItem.getBook(), orderItem.getBuyCount(), orderItem.getOrderBean());
    }

    @Override
    public List<OrderItem> getOrderItemList(Integer orderId) {
        String sql = "select * from t_order_item where orderBean=?";
        List<OrderItem> orderItemList = super.queryMulti(sql, OrderItem.class, orderId);
        return orderItemList;
    }
}
