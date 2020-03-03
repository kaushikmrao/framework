package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "Subscription")
public class Subscription {

	private String subscriptionName;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Sub_Id;
	private  String price;
	
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private  User user;
     
    @Column(name = "SubsciptionName")
	public String getSubscriptionName() {
		return subscriptionName;
	}

	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}
	   @Column(name = "price")
	public String getPrice() {
		return price;
	}
	   @Column(name = "id")
	public long getSub_Id() {
		return Sub_Id;
	}

	public void setSub_Id(long sub_Id) {
		Sub_Id = sub_Id;
	}
	   @Column(name = "price")
	public void setPrice(String price) {
		this.price = price;
	}

	public Subscription() {
		
	}

	@Override
	public String toString() {
		return "subscription [subscriptionName=" + subscriptionName + ", price=" + price + "]";
	}

	public Subscription(String subscriptionName, String price) {
	
		this.subscriptionName = subscriptionName;
		this.price = price;
	}




}