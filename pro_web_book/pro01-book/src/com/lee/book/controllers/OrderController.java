package com.lee.book.controllers;

import com.lee.book.domain.OrderBean;
import com.lee.book.domain.OrderItem;
import com.lee.book.domain.User;
import com.lee.book.service.OrderService;

import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author LiJing
 * @version 1.0
 */
public class OrderController {
    private OrderService orderService;

    public String checkout(HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        OrderBean orderBean = new OrderBean();
        LocalDateTime now = LocalDateTime.now();
        orderBean.setOrderNo(UUID.randomUUID().toString());
        orderBean.setOrderDate(now);
        orderBean.setOrderUser(user.getId());
        orderBean.setOrderMoney(user.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);
        orderBean.setOrderUserObj(user);

        orderService.addOrderBean(orderBean);

        //需要重新从数据库查询当前用户的购物车,覆盖到session
        return "redirect:cart.do";
    }

    public String getOrderList(HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        List<OrderBean> orderList = orderService.getOrderList(user);
        user.setOrderList(orderList);
        session.setAttribute("currUser", user);

        return "order/order";
    }

    public String getOrderDetail(HttpSession session, Integer orderId) {
        User user = (User) session.getAttribute("currUser");
        List<OrderBean> orderList = user.getOrderList();
        for (OrderBean orderBean : orderList) {
            if (orderBean.getId() == orderId) {
                session.setAttribute("orderDetail", orderBean);
                return "order/order_detail";
            }
        }

        return "order/order";
    }
}
