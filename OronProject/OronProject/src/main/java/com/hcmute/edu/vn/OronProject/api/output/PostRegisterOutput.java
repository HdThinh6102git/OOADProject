package com.hcmute.edu.vn.OronProject.api.output;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PostRegisterOutput {
    private Long id;
    private String createdBy;
    private String description;
    private Date createdDate;
    private String profilePic;
    private Integer status;
    private Long postId;

}
