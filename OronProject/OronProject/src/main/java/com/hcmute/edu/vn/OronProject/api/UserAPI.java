package com.hcmute.edu.vn.OronProject.api;

import com.hcmute.edu.vn.OronProject.api.loadData.output.UserOutput;
import com.hcmute.edu.vn.OronProject.dto.UserDTO;
import com.hcmute.edu.vn.OronProject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("api")
@RestController
public class UserAPI {
    @Autowired
    private IUserService userService;
    @PostMapping(value = "/register")
    public Object createUser(@RequestBody UserDTO dto){
        //check email or username or display name is not exist
        UserOutput output = new UserOutput();
        output.setListResult(userService.findActiveUserByUserNameOrEmailOrDispName(dto.getUserName(), dto.getDisplayName(), dto.getEmailAddress()));
        if(output.getListResult().size() > 0){

                return ResponseEntity.status(409).body("User already existed");

        }
        return userService.save(dto);
    }
    @PutMapping(value = "/user/{id}")
    public UserDTO updateUser(@RequestBody UserDTO dto,@PathVariable("id") Long id){
        dto.setId(id);
        return userService.save(dto);
    }

    @DeleteMapping(value = "/user")
    public void deleteUser(@RequestBody long[] ids){
        userService.delete(ids);
    }
    @GetMapping(value = "/user")
    public UserDTO showListUser(@RequestBody UserDTO dto){
//        UserOutput result = new UserOutput();
//        result.setListResult(userService.findAll());
//        return result;
        UserDTO result = new UserDTO();
        result = userService.loadUserByUserName(dto.getUserName());
        return result;
    }
    @GetMapping(value = "/user/{id}")
    public Object showUserById(@PathVariable("id") Long id){

        UserDTO result = new UserDTO();
        result = userService.loadUserById(id);
        if(result != null){
            return result;
        }
        return ResponseEntity.status(500).body("User is not existed");
    }
}
