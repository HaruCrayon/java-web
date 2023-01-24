package com.qqzone.controllers;

import com.qqzone.domain.Reply;
import com.qqzone.service.ReplyService;

import java.time.LocalDateTime;

/**
 * @author LiJing
 * @version 1.0
 */
public class ReplyController {
    private ReplyService replyService;

    public String addReply(String content, Integer authorId, Integer topicId) {
        Reply reply = new Reply(content, LocalDateTime.now(), authorId, topicId);
        replyService.addReply(reply);

        return "redirect:topic.do?operate=topicDetail&id=" + topicId;
    }

    public String delReply(Integer replyId, Integer topicId) {
        replyService.delReplyById(replyId);

        return "redirect:topic.do?operate=topicDetail&id=" + topicId;
    }
}
