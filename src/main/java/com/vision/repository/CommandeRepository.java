package com.vision.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vision.model.*;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long>{
@Query("Select count(comdId) from Commande c where c.customer.email=?1")
public long getCommandeofCustomer(String email);
@Query("Select sum(c.product.price*c.quantity) from Commande c where c.customer.customerId=?1")
public long getmontant(long customerId);
}
