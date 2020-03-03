package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long user_id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNumber;
	private String note;

	@Column(name = "user_id")
	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	@Column(name = "firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "middleName")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "phoneNumber")
	public String getNote() {
		return note;
	}
  @Column(name="notes")
	public void setNote(String note) {
		this.note = note;
	}

	public User(String firstName, String middleName, String lastName, String phoneNumber, String note) {

		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.note = note;
	}

	public User() {

	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", Note=" + note + "]";
	}

}