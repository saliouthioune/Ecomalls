package com.vision.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vision.repository.*;
import com.vision.model.Customer;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
   @Autowired
   private CustomerRepository cRepo;
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return cRepo.findAll();
	}

	@Override
	public Customer addCustomer(Customer c) {
		// TODO Auto-generated method stub
		Customer cus=new Customer();
		List<Customer> cs=cRepo.findAll();
		for(Customer cc:cs) {
			if(cc.getAddress()==cus.getAddress()&&cc.getAge()==cus.getAge()&&cc.getBathdate()==cus.getBathdate()&&cc.getFirstname()==cus.getFirstname()&&
					cc.getLastname()==cus.getLastname()&&cc.getPhone()==cus.getPhone()&&cus.getPassword()==cus.getPassword()&&cc.getEmail()==cus.getEmail()) {
				new Exception("Customer already exist");
			}
		}
		cus.setCustomerId(this.generatedId());
		cus.setAddress(c.getAddress());
		cus.setAge(c.getAge());
		cus.setFirstname(c.getFirstname());
		cus.setLastname(c.getLastname());
		cus.setPassword(c.getPassword());
		cus.setPhone(c.getPhone());
		cus.setSexe(c.getSexe());
		cus.setEmail(c.getEmail());
		cus.setBathdate(c.getBathdate());
		cus.setRole("customer");
		return cRepo.save(cus);
	}

	@Override
	public Customer deleteCustomer(long customerId) {
		// TODO Auto-generated method stub
		Customer c=cRepo.getById(customerId);
		cRepo.delete(c);
		return c;
	}

	@Override
	public Customer editCustomer(Customer c, long customerId) {
		// TODO Auto-generated method stub
		Customer cs=cRepo.getById(customerId);
		cs.setAddress(c.getAddress());
		cs.setAge(c.getAge());
		cs.setBathdate(c.getBathdate());
		cs.setEmail(c.getEmail());
		cs.setFirstname(c.getFirstname());
		cs.setLastname(c.getLastname());
		cs.setPhone(c.getPhone());
		cs.setPassword(c.getPassword());
		cs.setSexe(c.getSexe());
		cs.setRole(c.getRole());
		cRepo.save(cs);
		return cs;
	}

	@Override
	public Optional<Customer>  getCustomerById(long customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> c=cRepo.findById(customerId);
		return c;
	}

	@Override
	public int generatedId() {
		// TODO Auto-generated method stub
		int tempId=100;
		long c=cRepo.getcountOfCustomer();
		if(c>0) {
			int temp=cRepo.getMaxOfCustomer();
			tempId=temp+1;
		}
		return tempId;
	}

	@Override
	public Customer login(String email, String password) {
		// TODO Auto-generated method stub
		return cRepo.findByEmailAndPassword(email,password);
	}

	@Override
	public Customer findByEmail(String email) {
		// TODO Auto-generated method stub
		return cRepo.findByEmail(email);
	}

	@Override
	public Customer findByRole(String role) {
		// TODO Auto-generated method stub
		return cRepo.findByRole(role);
	}

}
