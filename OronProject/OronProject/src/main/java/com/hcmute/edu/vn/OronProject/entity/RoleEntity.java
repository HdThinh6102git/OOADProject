package com.hcmute.edu.vn.OronProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;

    //Relationship
    //Role and User
    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users = new ArrayList<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Getter and Setter for relationship

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
