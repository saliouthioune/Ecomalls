package com.vision.service;
import com.vision.model.*;
import java.util.*;
public interface CustomerService {
 public List<Customer> getAllCustomer(); 
 public Customer addCustomer(Customer c);
 public Customer deleteCustomer(long customerId);
 public Customer editCustomer(Customer c,long customerId);
 public Optional<Customer>  getCustomerById(long customerId);
 public int generatedId();
 public Customer login(String email,String password);
 public Customer findByEmail(String amail);
 public Customer findByRole(String role);
}
