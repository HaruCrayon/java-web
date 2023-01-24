package com.lee.qqzone.dao;

import com.lee.qqzone.domain.HostReply;

/**
 * @author LiJing
 * @version 1.0
 */
public interface HostReplyDAO {
    HostReply getHostReplyByReplyId(Integer replyId);
    void delHostReplyById(Integer id);
}
