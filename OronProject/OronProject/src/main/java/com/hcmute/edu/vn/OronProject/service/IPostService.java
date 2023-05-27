package com.hcmute.edu.vn.OronProject.service;

import com.hcmute.edu.vn.OronProject.api.output.PostOutput;
import com.hcmute.edu.vn.OronProject.dto.PostDTO;


import java.util.List;

public interface IPostService {
    List<PostOutput> loadAllActivePosts();
    PostDTO save(PostDTO postDTO);
    void delete(long id);
    List<PostOutput> loadAllProfilePosts(long id);
}
