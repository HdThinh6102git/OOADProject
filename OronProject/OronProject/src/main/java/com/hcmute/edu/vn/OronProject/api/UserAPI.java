package com.hcmute.edu.vn.OronProject.api;

import com.hcmute.edu.vn.OronProject.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserAPI {
    @PostMapping(value = "/user")
    public UserDTO createUser(@RequestBody UserDTO model){
        return model;
    }
    @PutMapping(value = "/user")
    public UserDTO updateUser(@RequestBody UserDTO model){
        return model;
    }

    @DeleteMapping(value = "/user")
    public void deleteUser(@RequestBody long[] ids){

    }
}
