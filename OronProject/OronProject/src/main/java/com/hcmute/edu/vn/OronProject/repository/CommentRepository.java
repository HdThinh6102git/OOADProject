package com.hcmute.edu.vn.OronProject.repository;

import com.hcmute.edu.vn.OronProject.entity.CommentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    @Query(
            value = "select * from comment m where m.status = 1 and m.post_id = :post_id ORDER BY m.created_date desc;",
            nativeQuery = true)
    List<CommentEntity> findCommentsByPostId(@Param("post_id") Long postId);
}
