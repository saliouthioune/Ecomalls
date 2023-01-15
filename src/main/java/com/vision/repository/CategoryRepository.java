package com.vision.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vision.model.*;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{

}
