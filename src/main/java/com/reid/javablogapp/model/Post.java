package com.reid.javablogapp.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long postId;
    private String title;

    @Column(length = 500)
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    public Post() {};

    public Post(long postId, String title, String content, Date createdAt) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
