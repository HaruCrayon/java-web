package com.lee.book.service.impl;

import com.lee.book.dao.CartItemDAO;
import com.lee.book.domain.Book;
import com.lee.book.domain.Cart;
import com.lee.book.domain.CartItem;
import com.lee.book.domain.User;
import com.lee.book.service.BookService;
import com.lee.book.service.CartItemService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiJing
 * @version 1.0
 */
public class CartItemServiceImpl implements CartItemService {
    private CartItemDAO cartItemDAO;
    private BookService bookService;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDAO.addCartItem(cartItem);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemDAO.updateCartItem(cartItem);
    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        List<CartItem> cartItemList = cartItemDAO.getCartItemList(user);
        for (CartItem cartItem : cartItemList) {
            Book bookObj = bookService.getBookById(cartItem.getBook());
            cartItem.setBookObj(bookObj);
        }

        return cartItemList;
    }

    @Override
    public void addOrUpdateCartItem(CartItem cartItem, Cart cart) {
        //1.如果当前用户的购物车中已经存在这个图书了，那么将购物车中这本图书的数量+1
        //2.否则，在当前用户的购物车中新增一个这本图书的CartItem，数量是1
        //判断当前用户的购物车中是否有这本书的CartItem，有->update , 无->add
        if (cart != null) {
            Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
            if (cartItemMap == null) {
                cartItemMap = new HashMap<>();
            }
            if (cartItemMap.containsKey(cartItem.getBook())) {
                CartItem cartItemTemp = cartItemMap.get(cartItem.getBook());
                cartItemTemp.setBuyCount(cartItemTemp.getBuyCount() + 1);
                updateCartItem(cartItemTemp);
            } else {
                addCartItem(cartItem);
            }
        } else {//连购物车都没有的情况
            addCartItem(cartItem);
        }
    }

    @Override
    public Cart getCart(User user) {
        List<CartItem> cartItemList = getCartItemList(user);
        Map<Integer, CartItem> cartItemMap = new HashMap<>();
        for (CartItem cartItem : cartItemList) {
            cartItemMap.put(cartItem.getBook(), cartItem);
        }
        Cart cart = new Cart();
        cart.setCartItemMap(cartItemMap);

        return cart;
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        cartItemDAO.delCartItem(cartItem);
    }
}
