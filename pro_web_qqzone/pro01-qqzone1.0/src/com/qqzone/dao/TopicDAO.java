package com.qqzone.dao;

import com.qqzone.domain.Topic;
import com.qqzone.domain.UserBasic;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public interface TopicDAO {
    //获取指定用户的日志列表
    List<Topic> getTopicList(UserBasic userBasic);
    //添加日志
    void addTopic(Topic topic);
    //删除日志
    void delTopicById(Integer id);
    //根据topic的id获取特定日志信息
    Topic getTopicById(Integer id);
}
