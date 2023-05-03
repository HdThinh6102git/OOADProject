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
        entity.setStatus(dto.getStatus());

        return entity;
    }
    public UserDTO toDTO(UserEntity entity){
        UserDTO dto = new UserDTO();
        //set dto values
        dto.setUserName(entity.getUserName());
        dto.setPassword(entity.getPassword());
        dto.setDisplayName(entity.getDisplayName());
        dto.setAddress(entity.getAddress());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setEmailAddress(entity.getEmailAddress());
        dto.setStatus(entity.getStatus());

        return dto;
    }
}
