package com.hcmute.edu.vn.OronProject.repository;

import com.hcmute.edu.vn.OronProject.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
        RoleEntity findOneByName(String name);
}
