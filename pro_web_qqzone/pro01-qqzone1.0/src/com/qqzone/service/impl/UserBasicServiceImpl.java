package com.qqzone.service.impl;

import com.qqzone.dao.UserBasicDAO;
import com.qqzone.domain.UserBasic;
import com.qqzone.service.UserBasicService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class UserBasicServiceImpl implements UserBasicService {
    private UserBasicDAO userBasicDAO;

    @Override
    public UserBasic login(String loginId, String pwd) {
        UserBasic userBasic = userBasicDAO.getUserBasic(loginId, pwd);
        return userBasic;
    }

    @Override
    public List<UserBasic> getFriendList(UserBasic userBasic) {
        List<UserBasic> userBasicList = userBasicDAO.getUserBasicList(userBasic);
        List<UserBasic> friendList = new ArrayList<>(userBasicList.size());
        for (int i = 0; i < userBasicList.size(); i++) {
            UserBasic friend = userBasicList.get(i);
            friend = userBasicDAO.getUserBasicById(friend.getId());
            friendList.add(friend);
        }
        return friendList;
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        UserBasic userBasic = userBasicDAO.getUserBasicById(id);

        return userBasic;
    }
}
