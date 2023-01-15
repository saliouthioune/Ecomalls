package com.vision.message;
import com.vision.repository.*;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vision.model.Mail;
@CrossOrigin(origins={ "http://localhost:3000", "http://localhost:8000", "http://localhost:8081","http://localhost:4200" })
@RestController
public class SenderEmailController {
	@Autowired
	private MailRepository mRepo;
	@Autowired
	private JavaMailSender javaMailSender;
	SimpleMailMessage mail = new SimpleMailMessage();

	@PostMapping(value = "/email/{emaila}/{emailc}")
	public void sendEmail(@RequestBody Mail email,@PathVariable String emaila,@PathVariable String emailc) throws Exception {
       
        mail.setFrom(emaila);
        mail.setTo(emailc);
        mail.setSubject(email.getEmailSubject());
        mail.setText(email.getEmailContent()+LocalDate.now()+"at "+LocalTime.now());
        javaMailSender.send(mail);
        email.setEmailSource(emaila);
        email.setEmailDest(emailc);
        mRepo.save(email);
    }
}
