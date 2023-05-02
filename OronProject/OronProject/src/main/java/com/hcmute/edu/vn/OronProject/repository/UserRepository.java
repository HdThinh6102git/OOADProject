package com.hcmute.edu.vn.OronProject.repository;

import com.hcmute.edu.vn.OronProject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
