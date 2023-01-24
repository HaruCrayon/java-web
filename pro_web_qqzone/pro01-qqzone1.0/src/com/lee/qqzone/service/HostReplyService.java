package com.lee.qqzone.service;

import com.lee.qqzone.domain.HostReply;
import com.lee.qqzone.domain.Reply;

/**
 * @author LiJing
 * @version 1.0
 */
public interface HostReplyService {
    HostReply getHostReplyByReplyId(Integer replyId);
    void delHostReplyById(Integer id);

}
