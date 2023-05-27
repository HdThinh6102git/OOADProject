package com.hcmute.edu.vn.OronProject.service.impl;

import com.hcmute.edu.vn.OronProject.api.output.PostOutput;
import com.hcmute.edu.vn.OronProject.converter.PostConverter;
import com.hcmute.edu.vn.OronProject.dto.PostDTO;
import com.hcmute.edu.vn.OronProject.entity.PostEntity;
import com.hcmute.edu.vn.OronProject.entity.UserEntity;
import com.hcmute.edu.vn.OronProject.repository.PostRepository;
import com.hcmute.edu.vn.OronProject.repository.UserRepository;
import com.hcmute.edu.vn.OronProject.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class PostService implements IPostService {
    private final PostRepository postRepository;
    private final PostConverter postConverter;
    private final UserRepository userRepository;



    @Override
    public List<PostOutput> loadAllActivePosts() {
        List<PostEntity> postEntityList = new ArrayList<>();
        postEntityList = postRepository.findActivePosts();

        List<PostOutput> postOutputList = new ArrayList<>();
        for (PostEntity postEntity: postEntityList) {
            PostOutput postOutput = new PostOutput();
            postOutput.setId(postEntity.getId());
            postOutput.setCreatedBy(postEntity.getCreatedBy());
            postOutput.setUserId(postEntity.getUser().getId());
            UserEntity userEntity = userRepository.getOne(postEntity.getUser().getId());
            postOutput.setProfilePic(userEntity.getProfilePic());
            postOutput.setDescription(postEntity.getDescription());
            postOutput.setPictures(postEntity.getPictures());
            postOutput.setNumberReaction(postEntity.getNumberReaction());
            postOutput.setDisplayScope(postEntity.getDisplayScope());
            postOutput.setModifiedDate(postEntity.getModifiedDate());

            postOutputList.add(postOutput);
        }

        return postOutputList;
    }

    @Override
    public PostDTO save(PostDTO postDTO) {
        PostEntity postEntity = new PostEntity();
        if (postDTO.getId() != null) {//update

            //Find One By id
            PostEntity oldPostEntity = postRepository.getOne(postDTO.getId());
            //set new values and assign to userEntity
            postEntity = postConverter.toEntity(postDTO, oldPostEntity);
        } else {//create

            postEntity = postConverter.toEntity(postDTO);
            //TO DO add userId below
            UserEntity userEntity = new UserEntity();
            userEntity = userRepository.findOneByid(postDTO.getUserId());
            postEntity.setUser(userEntity);
            userEntity.getPosts().add(postEntity);

        }

        //Save entity to database
        postEntity = postRepository.save(postEntity);
        //Return DTO to API
        return postConverter.toDTO(postEntity);

    }

    @Override
    public void delete(long id) {

            postRepository.deleteById(id);

    }

    @Override
    public List<PostOutput> loadAllProfilePosts(long id) {
        List<PostEntity> postEntityList = new ArrayList<>();
        postEntityList = postRepository.findActiveProfilePosts(id);

        List<PostOutput> postOutputList = new ArrayList<>();
        for (PostEntity postEntity: postEntityList) {
            PostOutput postOutput = new PostOutput();
            postOutput.setId(postEntity.getId());
            postOutput.setCreatedBy(postEntity.getCreatedBy());
            postOutput.setUserId(postEntity.getUser().getId());
            UserEntity userEntity = userRepository.getOne(postEntity.getUser().getId());
            postOutput.setProfilePic(userEntity.getProfilePic());
            postOutput.setDescription(postEntity.getDescription());
            postOutput.setPictures(postEntity.getPictures());
            postOutput.setNumberReaction(postEntity.getNumberReaction());
            postOutput.setDisplayScope(postEntity.getDisplayScope());
            postOutput.setModifiedDate(postEntity.getModifiedDate());

            postOutputList.add(postOutput);
        }

        return postOutputList;
    }
}
