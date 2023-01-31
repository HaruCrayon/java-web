package com.lee.book.dao;

import com.lee.book.domain.User;

/**
 * @author LiJing
 * @version 1.0
 */
public interface UserDAO {
    User getUser(String uname, String pwd);
    void addUser(User user);
    User getUser(String uname);
}
