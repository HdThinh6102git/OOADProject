package com.hcmute.edu.vn.OronProject.service.impl;

import com.hcmute.edu.vn.OronProject.entity.RoleEntity;
import com.hcmute.edu.vn.OronProject.repository.RoleRepository;
import com.hcmute.edu.vn.OronProject.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleService implements IRoleService {
    private final RoleRepository roleRepository;
    @Override
    public RoleEntity findRoleByRoleName(String roleName) {

        return roleRepository.findOneByName(roleName);
    }
}
