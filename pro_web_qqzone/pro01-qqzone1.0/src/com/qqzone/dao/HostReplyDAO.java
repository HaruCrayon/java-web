package com.qqzone.dao;

import com.qqzone.domain.HostReply;
import com.qqzone.domain.Reply;

/**
 * @author LiJing
 * @version 1.0
 */
public interface HostReplyDAO {
    HostReply getHostReplyByReplyId(Integer replyId);
    void delHostReplyById(Integer id);
}
