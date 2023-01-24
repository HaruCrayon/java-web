package com.lee.qqzone.dao;

import com.lee.qqzone.domain.HostReply;
import com.lee.qqzone.domain.Reply;

/**
 * @author LiJing
 * @version 1.0
 */
public interface HostReplyDAO {
    HostReply getHostReplyByReplyId(Integer replyId);
    void delHostReplyById(Integer id);
}
