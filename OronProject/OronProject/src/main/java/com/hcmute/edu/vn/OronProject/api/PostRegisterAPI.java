package com.hcmute.edu.vn.OronProject.api;

import com.hcmute.edu.vn.OronProject.api.output.PostOutput;
import com.hcmute.edu.vn.OronProject.api.output.PostRegisterOutput;
import com.hcmute.edu.vn.OronProject.dto.PostDTO;
import com.hcmute.edu.vn.OronProject.dto.PostRegisterDTO;
import com.hcmute.edu.vn.OronProject.service.impl.PostRegisterService;
import com.hcmute.edu.vn.OronProject.service.impl.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api")
@RestController
@RequiredArgsConstructor
public class PostRegisterAPI {
    private final PostRegisterService postRegisterService;
    private final PostService postService;
    @PostMapping(value = "/postregister")
    public Object createPostRegister(@RequestBody PostRegisterDTO dto){
        if(postRegisterService.findOneByUserIdAndPostId(dto.getUserId(), dto.getPostId()).getUserId() != null ){

            return ResponseEntity.status(409).body("This post already registered");
        }
        if(postService.findOneById(dto.getPostId()).getUserId() == dto.getUserId()){
            return ResponseEntity.status(410).body("Can not register your post");
        }
        if(postService.findOneById(dto.getPostId()).getStatus() == 2 || postService.findOneById(dto.getPostId()).getStatus() == 3 ){
            return ResponseEntity.status(411).body("Can not register transfering or received  post");
        }

        return postRegisterService.save(dto);
    }
    @PutMapping(value = "/postregister/{id}")
    public Object updatePostRegister(@RequestBody PostRegisterDTO dto, @PathVariable("id") Long id){
        dto.setId(id);
        return postRegisterService.save(dto);
    }
    @DeleteMapping(value = "/postregister/{id}")
    public void deletePostRegister(@PathVariable("id") Long id){
        postRegisterService.delete(id);
    }

    @GetMapping(value = "/postregister/byuserid/{id}")
    public List<PostRegisterOutput> showListPostRegisterByUserId(@PathVariable("id") Long id){

        return postRegisterService.loadRegisterByUserId(id);
    }
    @GetMapping(value = "/postregister/forowner/{id}")
    public List<PostRegisterOutput> showListPostRegisterForOwner(@PathVariable("id") Long id){

        return postRegisterService.loadRegisterForOwnerPost(id);
    }
}
