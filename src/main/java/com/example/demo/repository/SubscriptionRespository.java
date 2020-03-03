package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Subscription;

@Repository
public interface  SubscriptionRespository extends JpaRepository<Subscription, Long>,CrudRepository<Subscription, Long>,QuerydslPredicateExecutor<Subscription>{

}