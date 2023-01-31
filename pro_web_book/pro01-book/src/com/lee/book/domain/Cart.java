package com.lee.book.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

/**
 * @author LiJing
 * @version 1.0
 */
public class Cart {
    private Map<Integer, CartItem> cartItemMap;//购物车中购物车项的集合, key是bookId
    private Double totalMoney;//购物车的总金额
    private Integer totalCount;//购物车中购物车项的数量
    private Integer totalBookCount;//购物车中书本的总数量

    public Cart() {
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Double getTotalMoney() {
        totalMoney = 0.0;
        BigDecimal bigDecimalTotalMoney = new BigDecimal("" + totalMoney);
        if (cartItemMap != null && cartItemMap.size() > 0) {
            Collection<CartItem> cartItems = cartItemMap.values();
            for (CartItem cartItem : cartItems) {
                bigDecimalTotalMoney = bigDecimalTotalMoney.add(new BigDecimal("" + cartItem.getMoney()));
            }
            totalMoney = bigDecimalTotalMoney.doubleValue();
        }
        return totalMoney;
    }

    public Integer getTotalCount() {
        totalCount = 0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            totalCount = cartItemMap.size();
        }
        return totalCount;
    }

    public Integer getTotalBookCount() {
        totalBookCount = 0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            for (CartItem cartItem : cartItemMap.values()) {
                totalBookCount += cartItem.getBuyCount();
            }
        }
        return totalBookCount;
    }
}
