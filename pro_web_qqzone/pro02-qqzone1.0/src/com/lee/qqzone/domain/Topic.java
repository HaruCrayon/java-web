package com.lee.qqzone.domain;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class Topic {
    private Integer id ;
    private String title ;
    private String content ;
    private LocalDateTime topicDate ;
    private Integer author ;          //M:1

    private UserBasic authorObj;
    private List<Reply> replyList ;     //1:N

    public Topic() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTopicDate() {
        return topicDate;
    }

    public void setTopicDate(LocalDateTime topicDate) {
        this.topicDate = topicDate;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public UserBasic getAuthorObj() {
        return authorObj;
    }

    public void setAuthorObj(UserBasic authorObj) {
        this.authorObj = authorObj;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }
}
