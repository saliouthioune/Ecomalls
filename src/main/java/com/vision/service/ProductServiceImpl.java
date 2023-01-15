package com.vision.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vision.repository.*;
import com.vision.model.Product;
import java.io.*;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired
    private ProductRepository pRepo;
	@Override
	public List<Product> getAllproduct() {
		// TODO Auto-generated method stub
		return pRepo.findAll();
	}
	@Override
	public void addProduct(Product p) throws IOException{
		// TODO Auto-generated method stub
		Product pro=new Product();
		List<Product> ps=pRepo.findAll();
		for(Product pp:ps) {
			if(pp.getName().equals(pro.getName()) && pp.getPrice()==pro.getPrice()&&pp.getCategory().getCatId()==pro.getCategory().getCatId() && pp.getImage()==pro.getImage()&&pp.getStatus()==pro.getStatus())
				new Exception("Product already exist");
		}
		pro.setName(p.getName());
		pro.setPrice(p.getPrice());
		pro.setCategory(p.getCategory());
		pro.setImage(p.getImage());
		pro.setStatus("activer");
		pRepo.save(pro);
	}
	@Override
	public Product deleteProduct(long productId) {
		// TODO Auto-generated method stub
		Product p=pRepo.getById(productId);
		pRepo.delete(p);
		return p;
	}
	@Override
	public Product editProduct(Product p,long productId) {
		// TODO Auto-generated method stub
		Product pp=pRepo.getById(productId);
		pp.setName(p.getName());
		pp.setPrice(p.getPrice());
		 pRepo.save(pp);
		 return pp;
	}
	@Override
	public Optional<Product> getProductById(long productId) {
		// TODO Auto-generated method stub
		Optional<Product> p=pRepo.findById(productId);
		return p;
	}

}
