package com.hcmute.edu.vn.OronProject.service.impl;

import com.hcmute.edu.vn.OronProject.converter.UserConverter;
import com.hcmute.edu.vn.OronProject.dto.UserDTO;
import com.hcmute.edu.vn.OronProject.entity.UserEntity;
import com.hcmute.edu.vn.OronProject.repository.UserRepository;
import com.hcmute.edu.vn.OronProject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO save(UserDTO userDTO) {

        UserEntity userEntity = new UserEntity();
        if (userDTO.getId() != null) {//update

            //Find One By id
            UserEntity oldUserEntity = userRepository.getOne(userDTO.getId());
            //set new values and assign to userEntity
            userEntity = userConverter.toEntity(userDTO, oldUserEntity);
        } else {//create
            userEntity = userConverter.toEntity(userDTO);
        }

        //Save entity to database
        userEntity = userRepository.save(userEntity);
        //Return DTO to API
        return userConverter.toDTO(userEntity);
    }

    @Override
    public void delete(long[] ids) {
        for(long item: ids) {
            userRepository.deleteById(item);
        }
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> listResult = new ArrayList<>();
        List<UserEntity> listEntity = userRepository.findAll();
        for (UserEntity item: listEntity) {
            UserDTO userDTO = userConverter.toDTO(item);
            listResult.add(userDTO);
        }
        return listResult;
    }


}
