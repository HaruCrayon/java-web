package com.lee.book.service;

import com.lee.book.domain.User;

/**
 * @author LiJing
 * @version 1.0
 */
public interface UserService {
    //登录验证
    User login(String uname, String pwd);
    //注册用户
    void regist(User user);
    //校验用户名是否已经被占用
    User getUser(String uname);

}
