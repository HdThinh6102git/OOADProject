package com.hcmute.edu.vn.OronProject.api;

import com.hcmute.edu.vn.OronProject.dto.UserDTO;
import com.hcmute.edu.vn.OronProject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserAPI {
    @Autowired
    private IUserService userService;
    @PostMapping(value = "/user")
    public UserDTO createUser(@RequestBody UserDTO dto){

        return userService.save(dto);
    }
    @PutMapping(value = "/user")
    public UserDTO updateUser(@RequestBody UserDTO model){
        return model;
    }

    @DeleteMapping(value = "/user")
    public void deleteUser(@RequestBody long[] ids){

    }
}
