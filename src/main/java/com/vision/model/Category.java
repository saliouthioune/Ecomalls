package com.vision.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="catId")
  private long catId;
  private String name;
  
public Category() {
	super();
}
public long getCatId() {
	return catId;
}
public void setCatId(long catId) {
	this.catId = catId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Category(long catId, String name) {
	super();
	this.catId = catId;
	this.name = name;
}
}
