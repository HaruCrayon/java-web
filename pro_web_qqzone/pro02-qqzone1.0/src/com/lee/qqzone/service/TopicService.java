package com.lee.qqzone.service;

import com.lee.qqzone.domain.Topic;
import com.lee.qqzone.domain.UserBasic;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public interface TopicService {
    //查询特定用户的日志列表
    List<Topic> getTopicList(UserBasic userBasic);
    //根据id获取特定topic
    Topic getTopicById(Integer id);
    //根据id删除topic
    void delTopicById(Integer id);
}
