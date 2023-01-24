package com.qqzone.domain;

import java.time.LocalDateTime;

/**
 * @author LiJing
 * @version 1.0
 */
public class Reply {
    private Integer id ;
    private String content ;
    private LocalDateTime replyDate ;
    private Integer author ;  //M:1
    private Integer topic ;       //M:1

    private UserBasic authorObj;
    private HostReply hostReply ;   //1:1

    public Reply() {
    }

    public Reply(String content, LocalDateTime replyDate, Integer author, Integer topic) {
        this.content = content;
        this.replyDate = replyDate;
        this.author = author;
        this.topic = topic;
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

    public LocalDateTime getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(LocalDateTime replyDate) {
        this.replyDate = replyDate;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getTopic() {
        return topic;
    }

    public void setTopic(Integer topic) {
        this.topic = topic;
    }

    public UserBasic getAuthorObj() {
        return authorObj;
    }

    public void setAuthorObj(UserBasic authorObj) {
        this.authorObj = authorObj;
    }

    public HostReply getHostReply() {
        return hostReply;
    }

    public void setHostReply(HostReply hostReply) {
        this.hostReply = hostReply;
    }
}
