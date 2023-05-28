package com.hcmute.edu.vn.OronProject.service.impl;

import com.hcmute.edu.vn.OronProject.api.output.CommentOutput;

import com.hcmute.edu.vn.OronProject.converter.CommentConverter;
import com.hcmute.edu.vn.OronProject.dto.CommentDTO;
import com.hcmute.edu.vn.OronProject.entity.CommentEntity;
import com.hcmute.edu.vn.OronProject.entity.PostEntity;

import com.hcmute.edu.vn.OronProject.entity.UserEntity;
import com.hcmute.edu.vn.OronProject.repository.CommentRepository;
import com.hcmute.edu.vn.OronProject.repository.PostRepository;
import com.hcmute.edu.vn.OronProject.repository.UserRepository;
import com.hcmute.edu.vn.OronProject.service.ICommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService implements ICommentService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final CommentConverter commentConverter;
    @Override
    public CommentDTO save(CommentDTO dto) {
        CommentEntity commentEntity = new CommentEntity();
        if (dto.getId() != null) {//update

            //Find One By id
            CommentEntity oldCommentEntity = commentRepository.getOne(dto.getId());
            //set new values and assign to userEntity
            commentEntity = commentConverter.toEntity(dto, oldCommentEntity);
        } else {//create

            commentEntity= commentConverter.toEntity(dto);
            //TO DO add userId and postId below
            UserEntity userEntity = new UserEntity();
            userEntity = userRepository.getReferenceById(dto.getUserId());
            commentEntity.setUser(userEntity);
            userEntity.getComments().add(commentEntity);

            PostEntity postEntity = new PostEntity();
            postEntity = postRepository.getReferenceById(dto.getPostId());
            commentEntity.setPost(postEntity);
            postEntity.getComments().add(commentEntity);


        }

        //Save entity to database
        commentEntity = commentRepository.save(commentEntity);
        //Return DTO to API
        return commentConverter.toDTO(commentEntity);

    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<CommentOutput> loadActiveCommentsByPostId(Long id) {
        List<CommentEntity> commentEntityList = new ArrayList<>();
        commentEntityList = commentRepository.findCommentsByPostId(id);
        List<CommentOutput> commentOutputList = new ArrayList<>();
        for (CommentEntity commentEntity: commentEntityList
             ){
            CommentOutput commentOutput = new CommentOutput();
            commentOutput.setId(commentEntity.getId());
            commentOutput.setContent(commentEntity.getContent());
            commentOutput.setStatus(commentEntity.getStatus());
            commentOutput.setCreatedBy(commentEntity.getUser().getDisplayName());
            commentOutput.setModifiedDate(commentEntity.getModifiedDate());
            commentOutputList.add(commentOutput);
        }
        return commentOutputList;
    }
}
