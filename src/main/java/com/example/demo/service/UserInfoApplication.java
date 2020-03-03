package com.example.demo.service;

import com.example.demo.model.UserInfo;

public interface  UserInfoApplication {
	   Boolean existsByUsername(String username);
	    UserInfo findByUsername(String username);
		void save(UserInfo userInfo);

}
