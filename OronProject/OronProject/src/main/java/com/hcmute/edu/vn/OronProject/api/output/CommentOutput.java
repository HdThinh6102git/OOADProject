package com.hcmute.edu.vn.OronProject.api.output;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentOutput {
    private Long id;
    private String content;
    private Integer status;
    private String createdBy;
    private Date modifiedDate;
    private String profilePic;
}
