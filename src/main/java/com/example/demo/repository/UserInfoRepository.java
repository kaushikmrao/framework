package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserInfo;


@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {

    Boolean existsByUsername(String username);
    UserInfo findByUsername(String username);


}