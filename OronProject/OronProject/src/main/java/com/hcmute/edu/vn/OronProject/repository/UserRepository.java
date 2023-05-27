package com.hcmute.edu.vn.OronProject.repository;


import com.hcmute.edu.vn.OronProject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
//    @Query("select u from User u where u.username = :username and u.status = :status")
//@Param("status")


    UserEntity findOneByUserNameAndStatus(String userName, Integer status);

    @Query(
            value = "select * from user u where (u.username = :username or u.display_name = :display_name or u.email_address = :email_address) and u.status = 1",
            nativeQuery = true)

    List<UserEntity> findActiveUserByUserNameOrEmailOrDispName(@Param("username") String userName,
                                                               @Param("display_name") String displayName,
                                                               @Param("email_address") String emailAddress);

    UserEntity findOneByid(Long userId);
}
