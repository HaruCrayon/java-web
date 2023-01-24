package com.qqzone.service;

import com.qqzone.domain.Topic;
import com.qqzone.domain.UserBasic;

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
