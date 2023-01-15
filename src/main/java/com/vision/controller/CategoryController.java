package com.vision.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import com.vision.service.*;
import com.vision.model.*;
@CrossOrigin(origins="*")
@RestController
public class CategoryController {
   @Autowired
   private CategoryServiceImpl cService;
   @PostMapping("/addcategory")
   public Category addCategory(@RequestBody Category cat) {
	   return cService.addCategory(cat);
   }
   @GetMapping("/getallcategory")
   public List<Category> getAllCategory(){
	   return cService.getAllCategory();
   }
   
}
