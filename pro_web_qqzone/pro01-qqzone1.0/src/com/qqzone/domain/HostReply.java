package com.qqzone.domain;

import java.time.LocalDateTime;

/**
 * @author LiJing
 * @version 1.0
 */
public class HostReply {
    private Integer id ;
    private String content ;
    private LocalDateTime hostReplyDate ;
    private Integer author ; //M:1
    private Integer reply ;   //1:1

    public HostReply() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getHostReplyDate() {
        return hostReplyDate;
    }

    public void setHostReplyDate(LocalDateTime hostReplyDate) {
        this.hostReplyDate = hostReplyDate;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getReply() {
        return reply;
    }

    public void setReply(Integer reply) {
        this.reply = reply;
    }
}
