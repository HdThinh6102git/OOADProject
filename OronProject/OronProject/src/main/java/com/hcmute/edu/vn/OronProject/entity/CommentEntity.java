package com.hcmute.edu.vn.OronProject.entity;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class CommentEntity extends  BaseEntity{
    @Column(name = "content")
    private String content;
    @Column(name = "status")
    private Integer status;

    //Relationship
    //Comment and Post
    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    //Comment and User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    //Getter and Setter for relationship


    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
