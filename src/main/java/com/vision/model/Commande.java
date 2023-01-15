package com.vision.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.*;
@Entity
@Table(name="commande")
public class Commande {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="comdId")
    private long comdId;
	@Column(name="datecomd")
	private Date datecomd;
	@Column(name="quantity")
	private int quantity;
	@Column(name="status")
	private String status;
	@ManyToOne()
	@JoinColumn(name="customerId",referencedColumnName="customerId")
	private Customer customer;
	@ManyToOne()
	@JoinColumn(name="productId",referencedColumnName="productId")
	private Product product;
	
	public Commande() {
		super();
	}
	public Commande(long comdId, Date datecomd, int quantity, String status, Customer customer, Product product) {
		super();
		this.comdId = comdId;
		this.datecomd = datecomd;
		this.quantity = quantity;
		this.status = status;
		this.customer = customer;
		this.product = product;
	}

	public long getComdId() {
		return comdId;
	}

	public void setComdId(long comdId) {
		this.comdId = comdId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getDatecomd() {
		return datecomd;
	}

	public void setDatecomd(Date datecomd) {
		this.datecomd = datecomd;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
