package com.lee.qqzone.dao.impl;

import com.lee.myssm.basedao.TransBasicDAO;
import com.lee.qqzone.dao.TopicDAO;
import com.lee.qqzone.domain.Topic;
import com.lee.qqzone.domain.UserBasic;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class TopicDAOImpl extends TransBasicDAO<Topic> implements TopicDAO {
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        String sql = "select * from t_topic where author=?";
        List<Topic> topicList = super.queryMulti(sql, Topic.class, userBasic.getId());

        return topicList;
    }

    @Override
    public void addTopic(Topic topic) {

    }

    @Override
    public void delTopicById(Integer id) {
        String sql = "delete from t_topic where id=?";
        super.update(sql, id);
    }

    @Override
    public Topic getTopicById(Integer id) {
        String sql = "select * from t_topic where id=?";
        Topic topic = super.querySingle(sql, Topic.class, id);

        return topic;
    }
}
