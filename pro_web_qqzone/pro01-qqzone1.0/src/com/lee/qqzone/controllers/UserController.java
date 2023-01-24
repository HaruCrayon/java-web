package com.lee.qqzone.controllers;

import com.lee.qqzone.domain.Topic;
import com.lee.qqzone.domain.UserBasic;
import com.lee.qqzone.service.TopicService;
import com.lee.qqzone.service.UserBasicService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class UserController {
    private UserBasicService userBasicService;
    private TopicService topicService;

    public String login(String loginId, String pwd, HttpSession session) {
        //1.登录验证
        UserBasic userBasic = userBasicService.login(loginId, pwd);
        if (userBasic != null) {
            //1-1 获取好友列表
            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            //1-2 获取日志列表
            List<Topic> topicList = topicService.getTopicList(userBasic);

            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);

            //userBasic这个key保存的是登录者的信息
            //friend这个key保存的是当前进入的是谁的空间
            session.setAttribute("userBasic", userBasic);
            session.setAttribute("friend", userBasic);

            return "index";
        } else {
            return "login";
        }
    }

    public String friend(Integer id, HttpSession session) {
        UserBasic currfriend = userBasicService.getUserBasicById(id);
        List<Topic> topicList = topicService.getTopicList(currfriend);
        currfriend.setTopicList(topicList);
        session.setAttribute("friend", currfriend);

        return "index";
    }
}
