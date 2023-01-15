package com.vision.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.*;
@Entity
@Table(name="product")
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productId")
    private long productId;
	private String name;
	private int price;
	private String status;
	@ManyToOne()
	@JoinColumn(name="catId",referencedColumnName="catId")
	private Category category;
	@Column(name="image",length=1000)
	private byte[] image;
	
	public Product() {
		super();
	}
	
	public Product(long productId, String name, int price, String status, Category category, byte[] image) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.status = status;
		this.category = category;
		this.image = image;
	}

	public Product(String name, int price, String status, Category category, byte[] image) {
		super();
		this.name = name;
		this.price = price;
		this.status = status;
		this.category = category;
		this.image = image;
	}
	public long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
    
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}

	
}
