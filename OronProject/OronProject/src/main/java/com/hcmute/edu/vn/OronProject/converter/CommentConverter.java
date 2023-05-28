package com.hcmute.edu.vn.OronProject.converter;

import com.hcmute.edu.vn.OronProject.dto.CommentDTO;
import com.hcmute.edu.vn.OronProject.dto.PostRegisterDTO;
import com.hcmute.edu.vn.OronProject.entity.CommentEntity;
import com.hcmute.edu.vn.OronProject.entity.RegisterEntity;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {
    public CommentEntity toEntity(CommentDTO dto){
        CommentEntity entity = new CommentEntity();
        entity.setContent(dto.getContent());
        return entity;
    }
    public CommentDTO toDTO(CommentEntity entity){
        CommentDTO dto = new CommentDTO();
        //set dto values
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setContent(entity.getContent());
        dto.setPostId(entity.getPost().getId());
        dto.setUserId(entity.getUser().getId());
        dto.setStatus(entity.getStatus());
        //base entity fields
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setModifiedBy(entity.getModifiedBy());


        return dto;
    }
    public CommentEntity toEntity(CommentDTO dto, CommentEntity entity){

        //set entity values

        entity.setContent(dto.getContent());
        return entity;
    }
}
