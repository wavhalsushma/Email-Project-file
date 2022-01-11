package model;

import java.util.ArrayList;

public class EmailDetails {
	String emailid;
	String to;
	String from;
	String subject ;
	String emailbody;
	String compose;
	

	public String getCompose () {
		return compose ;
	}

	public void setCompose(String compose ) {
		this.compose = compose ;
	}

	public String getInbox() {
		return inbox;
	}

	public void setInbox(String inbox) {
		this.inbox = inbox;
	}
	String inbox;
	//Default Constructor
	public EmailDetails() {
		super();
	}
	
	//getter and setter
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String eid) {
		this.emailid = eid;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmailbody() {
		return emailbody;
	}
	public void setEmailbody(String emailbody) {
		this.emailbody = emailbody;
	}

	
	


		
	}
	

