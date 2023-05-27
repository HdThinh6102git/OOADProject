package com.hcmute.edu.vn.OronProject.service;

import com.hcmute.edu.vn.OronProject.entity.RoleEntity;

public interface IRoleService {
    RoleEntity findRoleByRoleName(String roleName);
}
