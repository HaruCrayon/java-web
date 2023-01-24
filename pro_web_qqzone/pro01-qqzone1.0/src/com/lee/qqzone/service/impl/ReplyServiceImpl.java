package com.lee.qqzone.service.impl;

import com.lee.qqzone.dao.ReplyDAO;
import com.lee.qqzone.domain.HostReply;
import com.lee.qqzone.domain.Reply;
import com.lee.qqzone.domain.Topic;
import com.lee.qqzone.domain.UserBasic;
import com.lee.qqzone.service.HostReplyService;
import com.lee.qqzone.service.ReplyService;
import com.lee.qqzone.service.UserBasicService;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class ReplyServiceImpl implements ReplyService {
    private ReplyDAO replyDAO;
    private HostReplyService hostReplyService;
    private UserBasicService userBasicService;

    @Override
    public List<Reply> getReplyList(Topic topic) {
        List<Reply> replyList = replyDAO.getReplyList(topic);
        for (int i = 0; i < replyList.size(); i++) {
            Reply reply = replyList.get(i);
            UserBasic authorObj = userBasicService.getUserBasicById(reply.getAuthor());
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            reply.setAuthorObj(authorObj);
            reply.setHostReply(hostReply);
        }

        return replyList;
    }

    @Override
    public void addReply(Reply reply) {
        replyDAO.addReply(reply);
    }

    @Override
    public void delReplyById(Integer id) {
        HostReply hostReply = hostReplyService.getHostReplyByReplyId(id);
        if (hostReply != null) {
            hostReplyService.delHostReplyById(hostReply.getId());
        }
        replyDAO.delReplyById(id);
    }
}
