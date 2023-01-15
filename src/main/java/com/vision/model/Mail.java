package com.vision.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mail")
public class Mail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long mailId;
	private String emailSubject;
	private String emailContent;
	private String emailSource;
	private String emailDest;
	public Mail(String emailSubject, String emailContent) {
		super();
		this.emailSubject = emailSubject;
		this.emailContent = emailContent;
	}
	public String getEmailSubject() {
		return emailSubject;
	}
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	public String getEmailContent() {
		return emailContent;
	}
	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}
	public long getMailId() {
		return mailId;
	}
	public void setMailId(long mailId) {
		this.mailId = mailId;
	}
	
	public String getEmailSource() {
		return emailSource;
	}
	public void setEmailSource(String emailSource) {
		this.emailSource = emailSource;
	}
	public String getEmailDest() {
		return emailDest;
	}
	public void setEmailDest(String emailDest) {
		this.emailDest = emailDest;
	}
	
	
}
