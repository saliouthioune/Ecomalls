package com.vision.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.vision.service.*;
import com.vision.model.*;
@RestController
@CrossOrigin(origins="*")
public class CustomerController {
 @Autowired
 private CustomerServiceImpl cService;
 @PostMapping("/addcustomer")
 public Customer addCustomer(@RequestBody Customer c) {
	 return cService.addCustomer(c);
 }
 @GetMapping("/getallcustomer")
 public List<Customer> getAllCustomer() {
	 return cService.getAllCustomer();
 }
 @DeleteMapping("/deletecustomer/{customerId}")
 public Customer deleteCustomer(@PathVariable long customerId) {
	 Customer c=cService.deleteCustomer(customerId);
	 return c;
 }
 @PutMapping("/editcustomer/{customerId}")
 public Customer editCustomer(@RequestBody Customer c,@PathVariable  long customerId) {
	 return cService.editCustomer(c, customerId);
 }
 @GetMapping("/getcustomer/{customerId}")
 public Optional<Customer>  getCustomerById(@PathVariable long customerId) {
	 Optional<Customer>  c=cService.getCustomerById(customerId);
	 return c;
 }
 @PostMapping("/login")
 public Customer login(@RequestBody Customer c) {
	 return cService.login(c.getEmail(), c.getPassword());
 }
 @GetMapping("/getbyemail/{email}")
 public Customer findByEmail(@PathVariable String email) {
	 return cService.findByEmail(email);
 }
 @GetMapping("/getbyrole/{role}")
 public Customer findByRole(@PathVariable String role) {
	 return cService.findByRole(role);
 }
}
