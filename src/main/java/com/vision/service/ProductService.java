package com.vision.service;
import java.io.IOException;
import java.util.*;
import com.vision.model.*;
public interface ProductService {
public List<Product> getAllproduct();
public void addProduct(Product p) throws IOException;
public Product deleteProduct(long productId);
public Product editProduct(Product p,long productId);
public Optional<Product> getProductById(long productId);
}
