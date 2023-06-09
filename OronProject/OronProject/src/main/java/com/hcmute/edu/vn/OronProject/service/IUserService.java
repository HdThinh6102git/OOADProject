package com.hcmute.edu.vn.OronProject.service;

import com.hcmute.edu.vn.OronProject.dto.UserDTO;



import java.util.List;

public interface IUserService {
    UserDTO save(UserDTO userDTO);
    void delete(long ids[]);
    List<UserDTO> findAll();
    UserDTO loadUserByUserName(String userName);
    List<UserDTO> findActiveUserByUserNameOrEmailOrDispName(String userName, String displayName, String emailAddress);
    UserDTO loadUserById(long userId);

}
