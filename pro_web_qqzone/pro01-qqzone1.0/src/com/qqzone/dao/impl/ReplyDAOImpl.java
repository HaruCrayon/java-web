package com.qqzone.dao.impl;

import com.myssm.basedao.TransBasicDAO;
import com.qqzone.dao.ReplyDAO;
import com.qqzone.domain.Reply;
import com.qqzone.domain.Topic;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class ReplyDAOImpl extends TransBasicDAO<Reply> implements ReplyDAO {
    @Override
    public List<Reply> getReplyList(Topic topic) {
        String sql = "select * from t_reply where topic=?";
        List<Reply> replyList = super.queryMulti(sql, Reply.class, topic.getId());

        return replyList;
    }

    @Override
    public void addReply(Reply reply) {
        String sql = "insert into t_reply values(null,?,?,?,?)";
        super.update(sql, reply.getContent(), reply.getReplyDate(), reply.getAuthor(), reply.getTopic());
    }

    @Override
    public void delReplyById(Integer id) {
        String sql = "delete from t_reply where id=?";
        super.update(sql, id);
    }
}
