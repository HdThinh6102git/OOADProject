package com.hcmute.edu.vn.OronProject.api;
import com.hcmute.edu.vn.OronProject.api.output.PostOutput;
import com.hcmute.edu.vn.OronProject.dto.PostDTO;
import com.hcmute.edu.vn.OronProject.dto.UserDTO;
import com.hcmute.edu.vn.OronProject.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api")
@RestController
@RequiredArgsConstructor
public class PostAPI {
    private final IPostService postService;
    @GetMapping(value = "/post")
    public List<PostOutput> showListPosts(){

        return postService.loadAllActivePosts();
    }
    @GetMapping(value = "/post/profile/{id}")
    public List<PostOutput> showListProfilePosts(@PathVariable("id") Long id){

        return postService.loadAllProfilePosts(id);
    }
    @PostMapping(value = "/post")
    public Object createPost(@RequestBody PostDTO dto){

        return postService.save(dto);
    }
    @PutMapping(value = "/post/{id}")
    public Object updatePost(@RequestBody PostDTO dto, @PathVariable("id") Long id){
        dto.setId(id);
        return postService.save(dto);
    }
    @DeleteMapping(value = "/post/{id}")
    public void deletePost(@PathVariable("id") Long id){
        postService.delete(id);
    }
    @PutMapping(value = "/post/updatestatus/{id}")
    public Object updatePostStatus(@RequestBody PostDTO dto, @PathVariable("id") Long id){
        dto.setId(id);

        postService.updateStatus(dto);
        return ResponseEntity.status(200).body("Updated status successfully");
    }
}
