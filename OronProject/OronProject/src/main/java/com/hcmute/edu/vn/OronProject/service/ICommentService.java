package com.hcmute.edu.vn.OronProject.service;


import com.hcmute.edu.vn.OronProject.api.output.CommentOutput;
import com.hcmute.edu.vn.OronProject.dto.CommentDTO;

import java.util.List;


public interface ICommentService {
    CommentDTO save(CommentDTO dto);

    void delete(Long id);

    List<CommentOutput> loadActiveCommentsByPostId(Long id);
}
