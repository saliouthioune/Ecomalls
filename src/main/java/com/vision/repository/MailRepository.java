package com.vision.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vision.model.Mail;
@Repository
public interface MailRepository extends JpaRepository<Mail,Long>{

}
