package com.hcmute.edu.vn.OronProject.converter;

import com.hcmute.edu.vn.OronProject.dto.PostDTO;
import com.hcmute.edu.vn.OronProject.dto.PostRegisterDTO;
import com.hcmute.edu.vn.OronProject.entity.PostEntity;
import com.hcmute.edu.vn.OronProject.entity.RegisterEntity;
import org.springframework.stereotype.Component;

@Component
public class PostRegisterConverter {
    public RegisterEntity toEntity(PostRegisterDTO dto){
        RegisterEntity entity = new RegisterEntity();

        return entity;
    }
    public PostRegisterDTO toDTO(RegisterEntity entity){
        PostRegisterDTO dto = new PostRegisterDTO();
        //set dto values
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
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
    public RegisterEntity toEntity(PostRegisterDTO dto, RegisterEntity entity){

        //set entity values
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
