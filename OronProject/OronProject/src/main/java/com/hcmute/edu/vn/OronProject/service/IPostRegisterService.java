package com.hcmute.edu.vn.OronProject.service;

import com.hcmute.edu.vn.OronProject.api.output.PostRegisterOutput;
import com.hcmute.edu.vn.OronProject.dto.PostRegisterDTO;

import java.util.List;

public interface IPostRegisterService {
    PostRegisterDTO save(PostRegisterDTO dto);
    void delete(long id);
    List<PostRegisterOutput> loadRegisterByUserId(Long userId);
    List<PostRegisterOutput> loadRegisterByPostId(Long postId);
    List<PostRegisterOutput> loadRegisterForOwnerPost(Long userId);
    PostRegisterDTO findOneByUserIdAndPostId(Long userId, Long postId);
}
