package com.vision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vision.model.Category;
import com.vision.repository.CategoryRepository;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
   @Autowired
   private CategoryRepository cRepo;
	@Override
	public Category addCategory(Category cat) {
		// TODO Auto-generated method stub
		return cRepo.save(cat);
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return cRepo.findAll();
	}

}
