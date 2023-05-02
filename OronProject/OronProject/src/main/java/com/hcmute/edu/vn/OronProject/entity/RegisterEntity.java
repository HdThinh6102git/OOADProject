package com.hcmute.edu.vn.OronProject.entity;

import javax.persistence.*;

@Entity
@Table(name = "register")
public class RegisterEntity extends BaseEntity{
    @Column(name = "status")
    private Integer status;

    //Relationship
    //Register and Post
    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    //Register and User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


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
