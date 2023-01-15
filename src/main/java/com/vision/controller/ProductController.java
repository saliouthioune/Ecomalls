package com.vision.controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.vision.service.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import com.vision.model.*;
import com.vision.repository.*;
@CrossOrigin(origins={ "http://localhost:3000", "http://localhost:8000", "http://localhost:8081","http://localhost:4200" })
@RestController
public class ProductController {
  @Autowired
  private ProductServiceImpl pService;
  @Autowired
  private ProductRepository pRepo;
  private byte[] image;
  @GetMapping("/getAllproducts")
  public List<Product> getAll() {
	  return pService.getAllproduct();	
	}
  @PostMapping("/addproduct")
  public void addProduct(@RequestBody Product p) throws IOException{
	  p.setImage(this.image);
	  pService.addProduct(p);
	  this.image=null;
  }
  @PostMapping("/upload")
  public void uplodaImage(@RequestParam("imageFile") MultipartFile file) throws IOException{
	  this.image=file.getBytes();
  }
  @DeleteMapping("/deleteproduct/{productId}")
  public Product deleteProduct(@PathVariable long productId) {
	  Product p= pService.deleteProduct(productId);
	  return p;
  }
  @PutMapping("/editproduct/{productId}")
  public Product editProduct(@RequestBody Product p,@PathVariable long productId) {
	 return pService.editProduct(p, productId);
	  
  }
  @GetMapping("/getproductById/{productId}")
  public Optional<Product> getProductById(@PathVariable long productId) {
	  return pService.getProductById(productId);
	}
}
