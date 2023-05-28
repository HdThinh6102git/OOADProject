package com.hcmute.edu.vn.OronProject.repository;


import com.hcmute.edu.vn.OronProject.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRegisterRepository extends JpaRepository<RegisterEntity, Long> {
    @Query(
            value = "select * from register r where r.status = 1 and r.user_id = :userid ORDER BY r.created_date desc;",
            nativeQuery = true)
    List<RegisterEntity> findRegisterByUserId(@Param("userid") Long userId);
    @Query(
            value = "select * from register r where r.status = 1 and r.post_id = :post_id ORDER BY r.created_date desc;",
            nativeQuery = true)
    List<RegisterEntity> findRegisterByPostId(@Param("post_id") Long postId);
    @Query(
            value = "select * from register r where r.status = 1 and r.post_id = :post_id and r.user_id = :userid",
            nativeQuery = true)
    RegisterEntity findOneByUserIdAndPostId(@Param("userid") Long userId,@Param("post_id") Long postId );
}
