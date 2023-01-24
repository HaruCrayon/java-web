package com.qqzone.service.impl;

import com.qqzone.dao.HostReplyDAO;
import com.qqzone.domain.HostReply;
import com.qqzone.domain.Reply;
import com.qqzone.service.HostReplyService;

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
