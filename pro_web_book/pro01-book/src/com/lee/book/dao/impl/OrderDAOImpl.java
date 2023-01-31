package com.lee.book.dao.impl;

import com.lee.book.dao.OrderDAO;
import com.lee.book.domain.OrderBean;
import com.lee.book.domain.User;
import com.lee.myssm.basedao.TransBasicDAO;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class OrderDAOImpl extends TransBasicDAO<OrderBean> implements OrderDAO {
    @Override
    public void addOrderBean(OrderBean orderBean) {
        String sql = "insert into t_order values(null,?,?,?,?,?)";
        super.update(sql, orderBean.getOrderNo(), orderBean.getOrderDate(), orderBean.getOrderUser(),
                orderBean.getOrderMoney(), orderBean.getOrderStatus());
    }

    @Override
    public Integer getMaxId() {
        String sql = "select id from t_order order by id desc limit 1";
        Integer maxId = (Integer) super.queryScalar(sql);
        return maxId;
    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        String sql = "select * from t_order where orderUser=?";
        List<OrderBean> orderList = super.queryMulti(sql, OrderBean.class, user.getId());
        return orderList;
    }
}
