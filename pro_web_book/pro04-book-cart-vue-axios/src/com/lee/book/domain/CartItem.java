package com.lee.book.domain;

import java.math.BigDecimal;

/**
 * @author LiJing
 * @version 1.0
 */
public class CartItem {
    private Integer id;
    private Integer book;
    private Integer buyCount;
    private Integer userBean;

    private Double money;
    private Book bookObj;

    public CartItem() {
    }

    public CartItem(Integer id, Integer buyCount) {
        this.id = id;
        this.buyCount = buyCount;
    }

    public CartItem(Integer book, Integer buyCount, Integer userBean) {
        this.book = book;
        this.buyCount = buyCount;
        this.userBean = userBean;
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

    public Integer getUserBean() {
        return userBean;
    }

    public void setUserBean(Integer userBean) {
        this.userBean = userBean;
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
