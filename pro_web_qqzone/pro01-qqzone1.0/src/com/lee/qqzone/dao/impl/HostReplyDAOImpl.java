package com.lee.qqzone.dao.impl;

import com.lee.myssm.basedao.TransBasicDAO;
import com.lee.qqzone.dao.HostReplyDAO;
import com.lee.qqzone.domain.HostReply;
import com.lee.qqzone.domain.Reply;

/**
 * @author LiJing
 * @version 1.0
 */
public class HostReplyDAOImpl extends TransBasicDAO<HostReply> implements HostReplyDAO {

    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        String sql = "select * from t_host_reply where reply=?";
        HostReply hostReply = super.querySingle(sql, HostReply.class, replyId);

        return hostReply;
    }

    @Override
    public void delHostReplyById(Integer id) {
        String sql = "delete from t_host_reply where id=?";
        super.update(sql, id);
    }
}
