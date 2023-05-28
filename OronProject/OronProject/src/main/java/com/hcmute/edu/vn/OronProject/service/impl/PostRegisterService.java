package com.hcmute.edu.vn.OronProject.service.impl;

import com.hcmute.edu.vn.OronProject.api.output.PostRegisterOutput;
import com.hcmute.edu.vn.OronProject.converter.PostRegisterConverter;
import com.hcmute.edu.vn.OronProject.dto.PostRegisterDTO;
import com.hcmute.edu.vn.OronProject.entity.PostEntity;
import com.hcmute.edu.vn.OronProject.entity.RegisterEntity;
import com.hcmute.edu.vn.OronProject.entity.UserEntity;
import com.hcmute.edu.vn.OronProject.repository.PostRegisterRepository;
import com.hcmute.edu.vn.OronProject.repository.PostRepository;
import com.hcmute.edu.vn.OronProject.repository.UserRepository;
import com.hcmute.edu.vn.OronProject.service.IPostRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostRegisterService implements IPostRegisterService {
    private final PostRegisterRepository postRegisterRepository;
    private final PostRegisterConverter postRegisterConverter;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    @Override
    public PostRegisterDTO save(PostRegisterDTO dto) {
        RegisterEntity registerEntity = new RegisterEntity();
        if (dto.getId() != null) {//update

            //Find One By id
            RegisterEntity oldRegisterEntity = postRegisterRepository.getOne(dto.getId());
            //set new values and assign to userEntity
            registerEntity = postRegisterConverter.toEntity(dto, oldRegisterEntity);
        } else {//create

            registerEntity= postRegisterConverter.toEntity(dto);
            //TO DO add userId and postId below
            UserEntity userEntity = new UserEntity();
            userEntity = userRepository.getReferenceById(dto.getUserId());
            registerEntity.setUser(userEntity);
            userEntity.getRegisters().add(registerEntity);

            PostEntity postEntity = new PostEntity();
            postEntity = postRepository.getReferenceById(dto.getPostId());
            registerEntity.setPost(postEntity);
            postEntity.getRegisters().add(registerEntity);


        }

        //Save entity to database
        registerEntity = postRegisterRepository.save(registerEntity);
        //Return DTO to API
        return postRegisterConverter.toDTO(registerEntity);

    }

    @Override
    public void delete(long id) {
        postRegisterRepository.deleteById(id);
    }

    @Override
    public List<PostRegisterOutput> loadRegisterByUserId(Long userId) {
        List<RegisterEntity> listRegisterEntity  = new ArrayList<>();
        listRegisterEntity = postRegisterRepository.findRegisterByUserId(userId);
        List<PostRegisterOutput> postRegisterOutputList = new ArrayList<>();


        PostEntity postEntity = new PostEntity();
        UserEntity userEntity = new UserEntity();
        for (RegisterEntity registerEntity: listRegisterEntity) {
            PostRegisterOutput postRegisterOutput = new PostRegisterOutput();
            //cheat createdBy of Post not register
            postEntity = postRepository.getReferenceById(registerEntity.getPost().getId());
            userEntity = userRepository.getReferenceById(postEntity.getUser().getId());
            postRegisterOutput.setCreatedBy(userEntity.getDisplayName());
            //
            postRegisterOutput.setCreatedDate(registerEntity.getCreatedDate());
            postRegisterOutput.setId(registerEntity.getId());
            postRegisterOutput.setDescription(registerEntity.getPost().getDescription());
            postRegisterOutput.setStatus(registerEntity.getStatus());
            postRegisterOutput.setPostId(registerEntity.getPost().getId());
            //cheat profilePic is post picture not profile
            postRegisterOutput.setProfilePic(postEntity.getPictures());
            //
            postRegisterOutputList.add(postRegisterOutput);

        }
        return postRegisterOutputList;
    }

    @Override
    public List<PostRegisterOutput> loadRegisterByPostId(Long postId) {
        List<RegisterEntity> listRegisterEntity  = new ArrayList<>();
        listRegisterEntity = postRegisterRepository.findRegisterByPostId(postId);
        List<PostRegisterOutput> postRegisterOutputList = new ArrayList<>();



        for (RegisterEntity registerEntity: listRegisterEntity) {
            PostRegisterOutput postRegisterOutput = new PostRegisterOutput();
            postRegisterOutput.setCreatedBy(registerEntity.getUser().getDisplayName());
            postRegisterOutput.setCreatedDate(registerEntity.getCreatedDate());
            postRegisterOutput.setId(registerEntity.getId());
            postRegisterOutput.setDescription(registerEntity.getPost().getDescription());
            postRegisterOutput.setProfilePic(registerEntity.getUser().getProfilePic());
            postRegisterOutput.setStatus(registerEntity.getStatus());
            postRegisterOutput.setPostId(registerEntity.getPost().getId());
            postRegisterOutputList.add(postRegisterOutput);

        }
        return postRegisterOutputList;
    }

    @Override
    public List<PostRegisterOutput> loadRegisterForOwnerPost(Long userId) {
        List<PostEntity> postEntityList = postRepository.findActiveProfilePosts(userId);
        List<PostRegisterOutput> postRegisterOutputListForAll = new ArrayList<>();
        for (PostEntity postEntity:postEntityList
             ) {
            List<PostRegisterOutput> postRegisterOutputListForOne = loadRegisterByPostId(postEntity.getId());
            for (PostRegisterOutput postRegisterOutput: postRegisterOutputListForOne
                 ) {
                postRegisterOutputListForAll.add(postRegisterOutput);
            }
        }
        return postRegisterOutputListForAll;
    }

    @Override
    public PostRegisterDTO findOneByUserIdAndPostId(Long userId, Long postId) {
        RegisterEntity registerEntity = new RegisterEntity();
        registerEntity = postRegisterRepository.findOneByUserIdAndPostId(userId, postId);
        PostRegisterDTO postRegisterDTO = new PostRegisterDTO();
        if(registerEntity != null){
            postRegisterDTO = postRegisterConverter.toDTO(registerEntity);
        }
        return postRegisterDTO;
    }
}
