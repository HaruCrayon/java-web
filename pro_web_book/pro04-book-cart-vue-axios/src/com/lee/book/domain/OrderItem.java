package com.lee.book.domain;

import java.math.BigDecimal;

/**
 * @author LiJing
 * @version 1.0
 */
public class OrderItem {
    private Integer id;
    private Integer book;//M:1
    private Integer buyCount;
    private Integer orderBean;//M:1

    private Double money;
    private Book bookObj;

    public OrderItem() {
    }

    public OrderItem(Integer book, Integer buyCount, Integer orderBean) {
        this.book = book;
        this.buyCount = buyCount;
        this.orderBean = orderBean;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBook() {
        return book;
    }

    public void setBook(Integer book) {
        this.book = book;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Integer getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(Integer orderBean) {
        this.orderBean = orderBean;
    }

    public Book getBookObj() {
        return bookObj;
    }

    public void setBookObj(Book bookObj) {
        this.bookObj = bookObj;
    }

    public Double getMoney() {
        BigDecimal bigDecimalPrice = new BigDecimal("" + bookObj.getPrice());
        BigDecimal bigDecimalBuyCount = new BigDecimal("" + buyCount);
        BigDecimal bigDecimalMoney = bigDecimalPrice.multiply(bigDecimalBuyCount);
        money = bigDecimalMoney.doubleValue();

        return money;
    }
}
