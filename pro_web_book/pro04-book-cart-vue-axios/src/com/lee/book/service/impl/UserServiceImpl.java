package com.lee.book.service.impl;

import com.lee.book.dao.UserDAO;
import com.lee.book.domain.User;
import com.lee.book.service.UserService;
import com.lee.myssm.basedao.TransBasicDAO;

/**
 * @author LiJing
 * @version 1.0
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Override
    public User login(String uname, String pwd) {
        User user = userDAO.getUser(uname, pwd);

        return user;
    }

    @Override
    public void regist(User user) {
        userDAO.addUser(user);
    }

    @Override
    public User getUser(String uname) {
        User user = userDAO.getUser(uname);

        return user;
    }
}
