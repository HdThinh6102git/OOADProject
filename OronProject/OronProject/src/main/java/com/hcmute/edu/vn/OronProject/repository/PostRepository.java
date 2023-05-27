package com.hcmute.edu.vn.OronProject.repository;


import com.hcmute.edu.vn.OronProject.api.output.PostOutput;
import com.hcmute.edu.vn.OronProject.entity.PostEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    @Query(
            value = "select * from post p where p.status = 1 ORDER BY p.created_date desc",
            nativeQuery = true)
    List<PostEntity> findActivePosts();
    @Query(
            value = "select * from post p where p.status = 1 and p.user_id = :userid ORDER BY p.created_date desc",
            nativeQuery = true)
    List<PostEntity> findActiveProfilePosts(@Param("userid") long userId);

}
