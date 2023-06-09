package com.hcmute.edu.vn.OronProject.converter;

import com.hcmute.edu.vn.OronProject.dto.UserDTO;
import com.hcmute.edu.vn.OronProject.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity toEntity(UserDTO dto){
        UserEntity entity = new UserEntity();
        //set entity values
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        entity.setDisplayName(dto.getDisplayName());
        entity.setAddress(dto.getAddress());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmailAddress(dto.getEmailAddress());
        entity.setProfilePic(dto.getProfilePic());
        entity.setCoverPic(dto.getCoverPic());



        return entity;
    }
    public UserDTO toDTO(UserEntity entity){
        UserDTO dto = new UserDTO();
        //set dto values
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setUserName(entity.getUserName());
        dto.setPassword(entity.getPassword());
        dto.setDisplayName(entity.getDisplayName());
        dto.setAddress(entity.getAddress());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setEmailAddress(entity.getEmailAddress());
        dto.setStatus(entity.getStatus());
        dto.setProfilePic(entity.getProfilePic());
        dto.setCoverPic(entity.getCoverPic());
        //base entity fields
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setModifiedBy(entity.getModifiedBy());

        return dto;
    }

    public UserEntity toEntity(UserDTO dto, UserEntity entity){

        //set entity values
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        entity.setDisplayName(dto.getDisplayName());
        entity.setAddress(dto.getAddress());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmailAddress(dto.getEmailAddress());
        entity.setStatus(dto.getStatus());
        entity.setProfilePic(dto.getProfilePic());
        entity.setCoverPic(dto.getCoverPic());
        return entity;
    }
}
