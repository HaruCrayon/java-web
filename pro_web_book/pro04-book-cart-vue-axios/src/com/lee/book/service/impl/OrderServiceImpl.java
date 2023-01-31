package com.lee.book.service.impl;

import com.lee.book.dao.OrderDAO;
import com.lee.book.dao.OrderItemDAO;
import com.lee.book.domain.*;
import com.lee.book.service.BookService;
import com.lee.book.service.CartItemService;
import com.lee.book.service.OrderService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private CartItemService cartItemService;
    private BookService bookService;

    @Override
    public void addOrderBean(OrderBean orderBean) {
        //结账
        //1 订单表t_order: 添加一条记录
        orderDAO.addOrderBean(orderBean);
        //查询这个orderBean在数据库中对应记录的id (id是自增列,最大id值即为新增记录的id)
        Integer orderId = orderDAO.getMaxId();
        orderBean.setId(orderId);

        //2 订单详情表t_order_item: 添加对应的多条记录
        Collection<CartItem> cartItems = orderBean.getOrderUserObj().getCart().getCartItemMap().values();
        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem(cartItem.getBook(), cartItem.getBuyCount(), orderId);
            orderItemDAO.addOrderItem(orderItem);
        }

        //3 购物车项表t_cart_item: 删除对应的多条记录
        for (CartItem cartItem : cartItems) {
            cartItemService.delCartItem(cartItem);
        }
    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        List<OrderBean> orderList = orderDAO.getOrderList(user);
        for (OrderBean orderBean : orderList) {
            List<OrderItem> orderItemList = orderItemDAO.getOrderItemList(orderBean.getId());
            for (OrderItem orderItem : orderItemList) {
                Book book = bookService.getBookById(orderItem.getBook());
                orderItem.setBookObj(book);
            }
            orderBean.setOrderItemList(orderItemList);
        }
        return orderList;
    }

}
