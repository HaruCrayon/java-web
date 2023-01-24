package com.qqzone.service;

import com.qqzone.domain.HostReply;
import com.qqzone.domain.Reply;

/**
 * @author LiJing
 * @version 1.0
 */
public interface HostReplyService {
    HostReply getHostReplyByReplyId(Integer replyId);
    void delHostReplyById(Integer id);

}
