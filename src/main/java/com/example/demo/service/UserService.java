package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.User;

@Service
public  interface UserService{
	public  List<User> findByAllUsers();
	 User save(User user);

public List<User>findByUser_id(long user_id);
 public List<User> findByFirstName(String firstName);
 public List<User> findByLastName(String lastName) ;
 public void deleteUser(Long user_id)throws RecordNotFoundException;
 
 public ResponseEntity<User> updateDetails(Long user_id, User userdetails) throws RecordNotFoundException;
}