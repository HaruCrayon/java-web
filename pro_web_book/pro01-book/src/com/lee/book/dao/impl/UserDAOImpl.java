package com.lee.book.dao.impl;

import com.lee.book.dao.UserDAO;
import com.lee.book.domain.User;
import com.lee.myssm.basedao.TransBasicDAO;

/**
 * @author LiJing
 * @version 1.0
 */
public class UserDAOImpl extends TransBasicDAO<User> implements UserDAO {
    @Override
    public User getUser(String uname, String pwd) {
        String sql = "select * from t_user where uname like ? and pwd like ?";
        User user = super.querySingle(sql, User.class, uname, pwd);

        return user;
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into t_user values(null,?,?,?,?)";
        super.update(sql, user.getUname(), user.getPwd(), user.getEmail(), user.getRole());
    }

    @Override
    public User getUser(String uname) {
        String sql = "select * from t_user where uname=?";
        User user = super.querySingle(sql, User.class, uname);

        return user;
    }
}
