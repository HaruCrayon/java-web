package com.lee.book.dao.impl;

import com.lee.book.dao.CartItemDAO;
import com.lee.book.domain.CartItem;
import com.lee.book.domain.User;
import com.lee.myssm.basedao.TransBasicDAO;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class CartItemDAOImpl extends TransBasicDAO<CartItem> implements CartItemDAO {
    @Override
    public void addCartItem(CartItem cartItem) {
        String sql = "insert into t_cart_item values(null,?,?,?)";
        super.update(sql, cartItem.getBook(), cartItem.getBuyCount(), cartItem.getUserBean());
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        String sql = "update t_cart_item set buyCount=? where id=?";
        super.update(sql, cartItem.getBuyCount(), cartItem.getId());
    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        String sql = "select * from t_cart_item where userBean=?";
        List<CartItem> cartItemList = super.queryMulti(sql, CartItem.class, user.getId());

        return cartItemList;
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        String sql = "delete from t_cart_item where id=?";
        super.update(sql, cartItem.getId());
    }
}
