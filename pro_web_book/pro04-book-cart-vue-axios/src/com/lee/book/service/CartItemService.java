package com.lee.book.service;

import com.lee.book.domain.Cart;
import com.lee.book.domain.CartItem;
import com.lee.book.domain.User;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public interface CartItemService {
    //添加cartItem
    void addCartItem(CartItem cartItem);
    //修改cartItem
    void updateCartItem(CartItem cartItem);
    //获取特定用户的cartItemList
    List<CartItem> getCartItemList(User user);
    //添加或修改cartItem
    void addOrUpdateCartItem(CartItem cartItem, Cart cart);
    //加载特定用户的Cart
    Cart getCart(User user);
    //删除cartItem
    void delCartItem(CartItem cartItem);
}
