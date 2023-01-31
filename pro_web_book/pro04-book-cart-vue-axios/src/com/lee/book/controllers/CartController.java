package com.lee.book.controllers;

import com.google.gson.Gson;
import com.lee.book.domain.Cart;
import com.lee.book.domain.CartItem;
import com.lee.book.domain.User;
import com.lee.book.service.CartItemService;

import javax.servlet.http.HttpSession;

/**
 * @author LiJing
 * @version 1.0
 */
public class CartController {
    private CartItemService cartItemService;

    public String index(HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);
        user.setCart(cart);
        session.setAttribute("currUser", user);

        return "cart/cart";
    }

    public String addCart(Integer bookId, HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        CartItem cartItem = new CartItem(bookId, 1, user.getId());
        //将指定的图书添加到当前用户的购物车中
        cartItemService.addOrUpdateCartItem(cartItem, user.getCart());

        return "redirect:cart.do";
    }

    public String editCart(Integer cartItemId, Integer buyCount) {
        CartItem cartItem = new CartItem(cartItemId, buyCount);
        cartItemService.updateCartItem(cartItem);

        return "redirect:cart.do";
    }

    public String cartInfo(HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);
        Gson gson = new Gson();
        String cartJsonStr = gson.toJson(cart);
        return "json:" + cartJsonStr;
    }
}
