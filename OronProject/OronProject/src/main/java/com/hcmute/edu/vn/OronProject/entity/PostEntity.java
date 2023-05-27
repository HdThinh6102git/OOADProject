package com.hcmute.edu.vn.OronProject.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
public class PostEntity extends BaseEntity{
    @Column(name = "description")
    private String description;
    @Column(name = "display_scope")
    private String displayScope ="public";
    @Column(name = "pictures")
    private String pictures;
    @Column(name = "status")
    private Integer status = 1;
    @Column(name = "number_reaction")
    private Integer numberReaction = 0;

    //Relationship
    //Post and User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    //Post and Comment
    @OneToMany(mappedBy = "post")
    private List<CommentEntity> comments = new ArrayList<>();

    //Post and Register
    @OneToMany(mappedBy = "post")
    private List<RegisterEntity> registers = new ArrayList<>();


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayScope() {
        return displayScope;
    }

    public void setDisplayScope(String displayScope) {
        this.displayScope = displayScope;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }



    public Integer getNumberReaction() {
        return numberReaction;
    }

    public void setNumberReaction(Integer numberReaction) {
        this.numberReaction = numberReaction;
    }


    //Getter and Setter for relationship

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public List<RegisterEntity> getRegisters() {
        return registers;
    }

    public void setRegisters(List<RegisterEntity> registers) {
        this.registers = registers;
    }
}
