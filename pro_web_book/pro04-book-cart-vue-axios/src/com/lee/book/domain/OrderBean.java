package com.lee.book.domain;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class OrderBean {
    private Integer id;
    private String orderNo;
    private LocalDateTime orderDate;
    private Integer orderUser;
    private Double orderMoney;
    private Integer orderStatus;

    private User orderUserObj;
    private List<OrderItem> orderItemList;//1:N
    private Integer totalBookCount;

    public OrderBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(Integer orderUser) {
        this.orderUser = orderUser;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public User getOrderUserObj() {
        return orderUserObj;
    }

    public void setOrderUserObj(User orderUserObj) {
        this.orderUserObj = orderUserObj;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public Integer getTotalBookCount() {
        totalBookCount = 0;
        for (OrderItem orderItem : orderItemList) {
            totalBookCount += orderItem.getBuyCount();
        }
        return totalBookCount;
    }
}
