package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.UserRepository;

import com.example.demo.service.UserService;
import com.querydsl.jpa.impl.JPAQuery;
@Service
public class UserImpl implements UserService{
	@Autowired
	private EntityManager em;
	@Autowired
	private UserRepository userepository;
	@Override
	public List<User> findByAllUsers() {
		QUser qUser = QUser.user;
		JPAQuery query = (JPAQuery) new JPAQuery(em).from(qUser);

		return query.fetch();
	
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		 return userepository.save(user);
		}
	

	@Override
	public List<User> findByUser_id(long user_id) {
		QUser qUser = QUser.user;
		JPAQuery query =  (JPAQuery)new JPAQuery(em).from(qUser);
		query.where(qUser.user_id.eq(user_id));
		return query.fetch();
	}

	@Override
	public List<User> findByFirstName(String firstName) {
		 QUser qUser = QUser.user;
			JPAQuery query =  (JPAQuery)new JPAQuery(em).from(qUser); 
			query.where(qUser.firstName.like(firstName));
			return query.fetch();
	}

	@Override
	public List<User> findByLastName(String lastName) {
		QUser qUser = QUser.user;
		JPAQuery query =  (JPAQuery)new JPAQuery(em).from(qUser); 
		query.where(qUser.lastName.like(lastName));
		return query.fetch();
	}

	@Override
	public void deleteUser(Long user_id) throws RecordNotFoundException {
		 Optional<User> user = userepository.findById(user_id);
			
			if(user.isPresent()) 
	        {
				userepository.deleteById(user_id);
	        }
	 else {
		 throw new RecordNotFoundException("No  user record exist for given user_id");
  }

	}

	@Override
	public ResponseEntity<User> updateDetails(Long user_id, User userdetails) throws RecordNotFoundException {
		User user =   userepository.findById(user_id)
		        .orElseThrow(() -> new RecordNotFoundException("Employee not found for this id :: " + user_id));

		        user.setFirstName(userdetails.getFirstName());
		        user.setMiddleName(userdetails.getMiddleName());
		        user.setLastName(userdetails.getLastName());
		        user.setNote(userdetails.getNote());
		        user.setPhoneNumber(userdetails.getPhoneNumber());
		        final  User saveDetails  = userepository.save(user);
		        return ResponseEntity.ok(saveDetails);
	}

	
}