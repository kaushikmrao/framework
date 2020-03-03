package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Subscription;
import com.example.demo.model.User;

import com.example.demo.service.SubscriptionService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(path = "api/v1/")
public class UserController {

		@Autowired
		
		private UserService userservice;
		@Autowired
		private SubscriptionService subscriptionservice;
		

		@PostMapping()
		public User savDetails(@Valid  @RequestBody User user ) {
			return userservice.save(user);
				
		}
	@PostMapping("subscription/subs")
	public Subscription saveSubscriptiom(@Valid    @RequestBody  Subscription subscription) {
		 return subscriptionservice.save(subscription);

	}
	@GetMapping("subscription/details")
	public List<Subscription>ListSubscription(){
		return subscriptionservice.DisplaytheDetails();
	}



	@GetMapping("/users")
	public List<User> getDetails() {
		return userservice.findByAllUsers();



	}

	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public List<User>GetByUserId(@PathVariable Long user_id){
		return userservice.findByUser_id(user_id);
	}
	@RequestMapping(value="/Users/firstName/{firstName}", method=RequestMethod.GET)

	public List<User>GetByFirstName(@PathVariable String firstName){
		return userservice.findByFirstName(firstName);
	}
	@RequestMapping(value="/Users/lastName/{lastName}", method=RequestMethod.GET)
	public List<User>getByLastName(@PathVariable String lastName){
		return userservice.findByLastName(lastName);
	}
	@RequestMapping(value="/User/Delete/{user_id}", method=RequestMethod.DELETE)
	public  void deleteByUserId(@PathVariable Long user_id) throws RecordNotFoundException{
	 userservice.deleteUser(user_id);


	}
	@RequestMapping(value="/User/update/{user_id}", method=RequestMethod.PUT)
	public ResponseEntity<User>UpdatinguserDetails(@PathVariable long user_id,  @Valid @RequestBody User userbody) throws RecordNotFoundException{
		return userservice.updateDetails(user_id, userbody);
		
	}
		



	}
	 



