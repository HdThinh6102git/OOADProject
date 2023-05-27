package com.hcmute.edu.vn.OronProject.service.impl;

import com.hcmute.edu.vn.OronProject.constant.SystemConstant;
import com.hcmute.edu.vn.OronProject.dto.CustomUserDetails;
import com.hcmute.edu.vn.OronProject.entity.RoleEntity;
import com.hcmute.edu.vn.OronProject.entity.UserEntity;
import com.hcmute.edu.vn.OronProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
        if(userEntity == null){
            throw new UsernameNotFoundException("No user was found");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(RoleEntity role: userEntity.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }
        CustomUserDetails customUserDetails = new CustomUserDetails(userEntity.getUserName(), userEntity.getPassword(),
                true, true, true, true, authorities);
        customUserDetails.setDisplayName(userEntity.getDisplayName());
        customUserDetails.setId(userEntity.getId());
        return customUserDetails;
    }
}
