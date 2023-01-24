package com.qqzone.service;

import com.qqzone.domain.UserBasic;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public interface UserBasicService {
    //登录验证
    UserBasic login(String loginId , String pwd );
    //获取好友列表
    List<UserBasic> getFriendList(UserBasic userBasic);
    //根据id获取指定用户
    UserBasic getUserBasicById(Integer id);
}
