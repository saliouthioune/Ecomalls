package com.vision.service;
import com.vision.model.*;
import java.util.*;
public interface CommandeService {
//public Commande addCommande(Commande c);
public List<Commande> getAllCommand();
public  Commande  updateOrderStatus(long comdId,String comstatus);
public Commande addOrder(long customerId,long productId);
public long getCommandeofCustomer(String email);
public long getMontant(long customerId);
}
