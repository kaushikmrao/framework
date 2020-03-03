package com.example.demo.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.validation.ValidationException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.model.UserInfo;
import com.example.demo.repository.UserInfoRepository;
import com.example.demo.service.UserInfoApplication;

@RestController
public class UserInfoController {


    final
    private UserInfoApplication userinfoapplication;

//    private HashData hashData = new HashData();

    public UserInfoController(UserInfoApplication userinfoapplication) {
        this.userinfoapplication = userinfoapplication;
    }


    @PostMapping("/user")
    public Boolean create(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException {
        String username = body.get("username");
        if (userinfoapplication.existsByUsername(username)){

            throw new ValidationException("Username already existed");

        }

        String password = body.get("password");
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
//        String hashedPassword = hashData.get_SHA_512_SecurePassword(password);
        String fullname = body.get("fullname");
        userinfoapplication.save(new UserInfo(username, encodedPassword, fullname));
        return true;
    }

}