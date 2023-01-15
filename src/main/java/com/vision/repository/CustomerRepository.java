package com.vision.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vision.model.*;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    @Query("Select count(c) from  Customer c")
	public Long getcountOfCustomer();
    @Query("Select max(c.customerId) from Customer c")
    public int getMaxOfCustomer();
    public Customer findByEmailAndPassword(String email, String password);
    public Customer findByEmail(String email);
    public Customer findByRole(String role);
}
