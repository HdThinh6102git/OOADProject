package com.hcmute.edu.vn.OronProject.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity{
    @Column(name = "username", unique=true)
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "display_name", unique=true)
    private String displayName;
    @Column(name = "email_address", unique=true)
    private String emailAddress;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "status")
    private Integer status = 1;
    @Column(name = "profile_pic")
    private String profilePic;
    @Column(name = "cover_pic")
    private String coverPic;

    //Relationship
    //User and Role
    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEntity> roles = new ArrayList<>();

    //User and Post
    @OneToMany(mappedBy = "user")
    private List<PostEntity> posts = new ArrayList<>();

    //User and Comment
    @OneToMany(mappedBy = "user")
    private List<CommentEntity> comments = new ArrayList<>();

    //User and Register
    @OneToMany(mappedBy = "user")
    private List<RegisterEntity> registers = new ArrayList<>();


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getCoverPic() {
        return coverPic;
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic;
    }
    //Getter and Setter for relationship


    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }


    public List<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntity> posts) {
        this.posts = posts;
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
