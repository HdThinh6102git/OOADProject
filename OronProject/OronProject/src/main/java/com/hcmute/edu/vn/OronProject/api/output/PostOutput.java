package com.hcmute.edu.vn.OronProject.api.output;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PostOutput {
    private Long id;
    private String createdBy;
    private Long userId;
    private String profilePic;
    private String description;
    private String pictures;
    private Integer numberReaction;
    private String displayScope;
    private Date modifiedDate;
}
