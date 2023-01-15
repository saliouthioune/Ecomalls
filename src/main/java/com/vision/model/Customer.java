package com.vision.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name="Customer")
public class Customer {
  @Id
  @Column(name="customerId")
  private long customerId;
  @Column(name="email",nullable=true)
  private String email;
  @Column(name="firstname",nullable=true)
  private String firstname;
  @Column(name="lastname",nullable=true)
  private String lastname;
  @Column(name="password",nullable=true)
  private String password;
  @Column(name="age",nullable=true)
  private int age;
  @Column(name="sexe",nullable=true)
  private String sexe;
  @Column(name="address",nullable=true)
  private String address;
  @Column(name="phone",nullable=true)
  private int phone;
  @Column(name="bathdate",nullable=true)
  private Date bathdate;
  
  private String role;
public Customer() {
	super();
}
public long getCustomerId() {
	return customerId;
}
public void setCustomerId(long customerId) {
	this.customerId = customerId;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getSexe() {
	return sexe;
}
public void setSexe(String sexe) {
	this.sexe = sexe;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}
public Date getBathdate() {
	return bathdate;
}
public void setBathdate(Date bathdate) {
	this.bathdate = bathdate;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
  
}
