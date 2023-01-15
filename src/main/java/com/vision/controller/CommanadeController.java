package com.vision.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vision.model.Commande;
import com.vision.service.*;
@CrossOrigin(origins="*")
@RestController
public class CommanadeController {
  @Autowired
  private CommandeServiceImpl cService;
//  @PostMapping("/addcommande")
//  public Commande addCommande(@RequestBody Commande commande) {
//	  return cService.addCommande(commande);
//  }
  @GetMapping("/getallcommande")
  public List<Commande> getAllCommade(){
	  return cService.getAllCommand();
  }
  @GetMapping("/updatecomdsatus/{comdId}/{comstatus}")
  public Commande updateOrderStatus(@PathVariable long comdId,@PathVariable String comstatus) {
	  return cService.updateOrderStatus(comdId, comstatus);
  }
  @PostMapping("/addorder/{customerId}/{productId}")
  public Commande addOrder(@PathVariable long customerId,@PathVariable long productId) {
	  return cService.addOrder(customerId, productId);
  }
  @GetMapping("/get/{email}")
  public long getCommandeofCustomer(@PathVariable  String email) {
	  return cService.getCommandeofCustomer(email);
  }
  @GetMapping("/sum/{customerId}")
  public long getMontant(@PathVariable  long customerId) {
	  return cService.getMontant(customerId);
  }
}
