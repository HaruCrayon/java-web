package com.qqzone.service.impl;

import com.qqzone.dao.TopicDAO;
import com.qqzone.domain.Reply;
import com.qqzone.domain.Topic;
import com.qqzone.domain.UserBasic;
import com.qqzone.service.ReplyService;
import com.qqzone.service.TopicService;
import com.qqzone.service.UserBasicService;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class TopicServiceImpl implements TopicService {
    private TopicDAO topicDAO;
    private ReplyService replyService;
    private UserBasicService userBasicService;

    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        List<Topic> topicList = topicDAO.getTopicList(userBasic);

        return topicList;
    }

    @Override
    public Topic getTopicById(Integer id) {
        Topic topic = topicDAO.getTopicById(id);
        UserBasic authorObj = userBasicService.getUserBasicById(topic.getAuthor());
        List<Reply> replyList = replyService.getReplyList(topic);
        topic.setAuthorObj(authorObj);
        topic.setReplyList(replyList);

        return topic;
    }

    @Override
    public void delTopicById(Integer id) {
        Topic topic = topicDAO.getTopicById(id);
        List<Reply> replyList = replyService.getReplyList(topic);
        for (int i = 0; i < replyList.size(); i++) {
            Reply reply = replyList.get(i);
            replyService.delReplyById(reply.getId());
        }
        topicDAO.delTopicById(id);
    }
}
