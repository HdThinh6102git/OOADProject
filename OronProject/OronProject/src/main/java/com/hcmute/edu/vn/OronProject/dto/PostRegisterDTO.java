package com.hcmute.edu.vn.OronProject.dto;

public class PostRegisterDTO extends AbstractDTO{
    private Integer status;
    private Long postId;
    private Long userId;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
