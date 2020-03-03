package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Subscription;

@Service
public interface SubscriptionService {
Subscription save(Subscription subs);
List<Subscription> DisplaytheDetails();

}
