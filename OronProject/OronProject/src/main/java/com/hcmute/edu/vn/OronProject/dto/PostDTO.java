package com.hcmute.edu.vn.OronProject.dto;

public class PostDTO extends AbstractDTO {
    private String description;
    private String displayScope;
    private String pictures;
    private Integer status;
    private Integer numberReaction;
    private Long userId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
