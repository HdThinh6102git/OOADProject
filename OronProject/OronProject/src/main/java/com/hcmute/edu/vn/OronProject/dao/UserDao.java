//package com.hcmute.edu.vn.OronProject.dao;
//
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Repository;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//
//@Repository
//public class UserDao {
//    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
//            new User(
//                    "admin@gmail.com",
//                    "password",
//                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
//            ),
//            new User(
//                    "user@gmail.com",
//                    "password",
//                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
//            )
//    );
//    public UserDetails findUserByUserName(String username){
//        return APPLICATION_USERS
//                .stream()
//                .filter(u -> u.getUsername().equals(username))
//                .findFirst()
//                .orElseThrow(() -> new UsernameNotFoundException("No user was found"))
//        ;
//    }
//}
