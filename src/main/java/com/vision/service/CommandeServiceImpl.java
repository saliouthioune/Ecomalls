package com.vision.service;

import java.util.List;
import java.util.*;
import com.vision.model.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.mail.javamail.JavaMailSender;
import com.vision.repository.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Transactional
@Service
public class CommandeServiceImpl implements CommandeService{
	@Autowired
    private CommandeRepository cRepo;
	@Autowired
    private CustomerRepository custRepo;
	@Autowired
    private ProductRepository pRepo;
	@Autowired
	private JavaMailSender javaMailSender;
	SimpleMailMessage mail=new SimpleMailMessage(); 
//	@Override
//	public Commande addCommande(Commande c) {
//		// TODO Auto-generated method stub
//		Commande com=new Commande();
//		List<Commande> acs=cRepo.findAll();
//		for(Commande cc:acs) {
//			if(cc.getCustomer()==com.getCustomer()&&cc.getProduct()==com.getProduct()) {
//				new Exception("Commande already exixte"+c);
//			}
//		}
//		com.setStatus("PLACED");
//		com.setCustomer(c.getCustomer());
//		com.setProduct(c.getProduct());
//		com.setDatecomd(new Date());
//		//com.setQuantity(c.getQuantity());
//		return cRepo.save(com);
//	}

	@Override
	public List<Commande> getAllCommand() {
		// TODO Auto-generated method stub
		//List<Commande> cs=cRepo.findAll();	
		return cRepo.findAll();
	}

	@Override
	public Commande updateOrderStatus(long comdId, String comstatus) {
		// TODO Auto-generated method stub
		 Commande  c=cRepo.getById(comdId);
		 if(comstatus.equals("Accepter")) {
			 c.setStatus("Accepter");
		 }
		 else if(comstatus.equals("Rejeter")){
			 c.setStatus("Rejeter");
		 }
		 else if(comstatus.equals("Delivrer")) {
			 c.setStatus("Delivrer");
		 }
		return cRepo.save(c);
	}

	@Override
	public Commande addOrder(long customerId, long productId) {
		// TODO Auto-generated method stub
		int i=0;
		Commande com=new Commande();
		Customer customer=new Customer();
		Product product =new Product();
		customer=custRepo.getById(customerId);
		product=pRepo.getById(productId);
		product.setStatus("desactiver");
		com.setCustomer(customer);
		com.setProduct(product);
		com.setStatus("Placer");
		com.setDatecomd(new Date());
		com.setQuantity(i+1);
		pRepo.save(product);
		 //sending a mail about the placed order
	    mail.setTo(customer.getEmail());
		mail.setSubject("Thanks for ordering in ELEFoods");
		mail.setText("Dear Customer,"+"\n Your order has been received on "+LocalDate.now()+" at "+LocalTime.now()
					+"\n	You will be updated about your Delivery soon!!");
		javaMailSender.send(mail);
		return cRepo.save(com);
	}

	@Override
	public long getCommandeofCustomer(String email) {
		// TODO Auto-generated method stub
		return cRepo.getCommandeofCustomer(email);
	}

	@Override
	public long getMontant(long customerId) {
		// TODO Auto-generated method stub
		return cRepo.getmontant(customerId);
	}

}
