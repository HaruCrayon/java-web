package com.qqzone.dao;

import com.qqzone.domain.Reply;
import com.qqzone.domain.Topic;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public interface ReplyDAO {
    //获取指定日志的回复列表
    List<Reply> getReplyList(Topic topic);
    //添加回复
    void addReply(Reply reply);
    //删除回复
    void delReplyById(Integer id);
}
