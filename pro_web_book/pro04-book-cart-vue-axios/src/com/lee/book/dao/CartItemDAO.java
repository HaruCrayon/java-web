package com.lee.book.dao;

import com.lee.book.domain.CartItem;
import com.lee.book.domain.User;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public interface CartItemDAO {
    //新增cartItem
    void addCartItem(CartItem cartItem);
    //修改cartItem
    void updateCartItem(CartItem cartItem);
    //获取特定用户的cartItemList
    List<CartItem> getCartItemList(User user);
    //删除cartItem
    void delCartItem(CartItem cartItem);
}
