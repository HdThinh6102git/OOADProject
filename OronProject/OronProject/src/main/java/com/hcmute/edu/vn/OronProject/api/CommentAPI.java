package com.hcmute.edu.vn.OronProject.api;
import com.hcmute.edu.vn.OronProject.api.output.CommentOutput;
import com.hcmute.edu.vn.OronProject.api.output.PostOutput;
import com.hcmute.edu.vn.OronProject.dto.CommentDTO;
import com.hcmute.edu.vn.OronProject.dto.PostDTO;
import com.hcmute.edu.vn.OronProject.service.ICommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api")
@RestController
@RequiredArgsConstructor
public class CommentAPI {
    private final ICommentService commentService;
    @PostMapping(value = "/comment")
    public Object createComment(@RequestBody CommentDTO dto){

        return commentService.save(dto);
    }
    @PutMapping(value = "/comment/{id}")
    public Object updateComment(@RequestBody CommentDTO dto, @PathVariable("id") Long id){
        dto.setId(id);
        return commentService.save(dto);
    }
    @DeleteMapping(value = "/comment/{id}")
    public Object deleteComment(@PathVariable("id") Long id){
        commentService.delete(id);
        return ResponseEntity.status(200).body("Deleted successfully");
    }

    @GetMapping(value = "/comment/{id}")
    public List<CommentOutput> showListCommentsByPostId(@PathVariable("id") Long id){

        return commentService.loadActiveCommentsByPostId(id);
    }
}
