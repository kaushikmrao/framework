package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.model.UserInfo;
import com.example.demo.repository.UserInfoRepository;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    
    @Autowired(required=true)
    private UserInfoRepository userInfoRepository;


    @Override
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo user = userInfoRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

}