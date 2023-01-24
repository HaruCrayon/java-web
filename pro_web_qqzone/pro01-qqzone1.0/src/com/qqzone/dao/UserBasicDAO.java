package com.qqzone.dao;

import com.qqzone.domain.UserBasic;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public interface UserBasicDAO {
    //根据账号和密码获取特定用户信息
    UserBasic getUserBasic(String loginId , String pwd ) ;
    //获取指定用户的好友列表
    List<UserBasic> getUserBasicList(UserBasic userBasic);
    //根据id获取特定用户的信息
    UserBasic getUserBasicById(Integer id);
}
