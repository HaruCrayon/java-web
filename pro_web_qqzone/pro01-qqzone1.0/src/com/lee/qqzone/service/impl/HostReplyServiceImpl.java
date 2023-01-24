package com.lee.qqzone.service.impl;

import com.lee.qqzone.dao.HostReplyDAO;
import com.lee.qqzone.domain.HostReply;
import com.lee.qqzone.domain.Reply;
import com.lee.qqzone.service.HostReplyService;

/**
 * @author LiJing
 * @version 1.0
 */
public class HostReplyServiceImpl implements HostReplyService {
    private HostReplyDAO hostReplyDAO;

    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        HostReply hostReply = hostReplyDAO.getHostReplyByReplyId(replyId);

        return hostReply;
    }

    @Override
    public void delHostReplyById(Integer id) {
        hostReplyDAO.delHostReplyById(id);
    }
}
