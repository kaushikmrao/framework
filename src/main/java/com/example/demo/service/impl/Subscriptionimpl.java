package com.example.demo.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.QSubscription;
import com.example.demo.model.Subscription;
import com.example.demo.repository.SubscriptionRespository;
import com.example.demo.service.SubscriptionService;
import com.querydsl.jpa.impl.JPAQuery;

@Service
 public class Subscriptionimpl implements SubscriptionService  {

	 
		@Autowired
		private EntityManager em;
		
		
		
		 @Autowired
		 private SubscriptionRespository subscriptionrepository;
	@Override
	public Subscription save(Subscription subs) {
		return     subscriptionrepository.save(subs);
	}

	@Override
	public List<Subscription> DisplaytheDetails() {

		QSubscription qSubscription = QSubscription.subscription;
		JPAQuery query =  (JPAQuery)new JPAQuery(em).from(qSubscription);
		return query.fetch();
	}

}
