package com.starter.demo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
	
@Document(collection = "clientDetails")
public class Client {
	
	@Id
	private int id;
	private String name;
	private String Tin;
	private Date dob;
	

	public Client(int clientId, String name, String tin, Date dob) {
		super();
		this.id = clientId;
		this.name = name;
		Tin = tin;
		this.dob = dob;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getClientId() {
		return id;
	}
	public void setClientId(int clientId) {
		this.id = clientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTin() {
		return Tin;
	}
	public void setTin(String tin) {
		Tin = tin;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	
	
}
