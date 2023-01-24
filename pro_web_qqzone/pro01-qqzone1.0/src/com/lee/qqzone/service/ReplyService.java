package com.lee.qqzone.service;

import com.lee.qqzone.domain.Reply;
import com.lee.qqzone.domain.Topic;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public interface ReplyService {
    //获取指定日志的回复列表
    List<Reply> getReplyList(Topic topic);
    //添加reply
    void addReply(Reply reply);
    //删除reply
    void delReplyById(Integer id);
}
