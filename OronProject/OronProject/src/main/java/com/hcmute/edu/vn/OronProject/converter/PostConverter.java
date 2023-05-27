package com.hcmute.edu.vn.OronProject.converter;

import com.hcmute.edu.vn.OronProject.dto.PostDTO;
import com.hcmute.edu.vn.OronProject.dto.UserDTO;
import com.hcmute.edu.vn.OronProject.entity.PostEntity;
import com.hcmute.edu.vn.OronProject.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {
    public PostEntity toEntity(PostDTO dto){
        PostEntity entity = new PostEntity();
        entity.setDescription(dto.getDescription());
        entity.setPictures(dto.getPictures());
        return entity;
    }
    public PostDTO toDTO(PostEntity entity){
        PostDTO dto = new PostDTO();
        //set dto values
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setDescription(entity.getDescription());
        dto.setDisplayScope(entity.getDisplayScope());
        dto.setPictures(entity.getPictures());
        dto.setStatus(entity.getStatus());
        dto.setNumberReaction(entity.getNumberReaction());
        dto.setUserId(entity.getUser().getId());

        //base entity fields
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setModifiedBy(entity.getModifiedBy());


        return dto;
    }
    public PostEntity toEntity(PostDTO dto, PostEntity entity){

        //set entity values
        entity.setDescription(dto.getDescription());
        entity.setDisplayScope(dto.getDisplayScope());
        entity.setPictures(dto.getPictures());
        entity.setStatus(dto.getStatus());
        entity.setNumberReaction(dto.getNumberReaction());

        return entity;
    }
}
