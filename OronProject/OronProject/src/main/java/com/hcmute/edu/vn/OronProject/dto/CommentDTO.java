package com.hcmute.edu.vn.OronProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO extends AbstractDTO{
    private String content;
    private Integer status;
    private Long postId;
    private Long userId;
}
