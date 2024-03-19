package com.tka.DatabaseDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Family {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String aadharno;
	String  passportno;
	String drivinglicno;
	
	public Family() {
		
	}
	public Family(String aadharno, String passportno, String drivinglicno) {
		super();
		this.aadharno = aadharno;
		this.passportno = passportno;
		this.drivinglicno = drivinglicno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAadharno() {
		return aadharno;
	}
	public void setAadharno(String aadharno) {
		this.aadharno = aadharno;
	}
	public String getPassportno() {
		return passportno;
	}
	public void setPassportno(String passportno) {
		this.passportno = passportno;
	}
	public String getDrivinglicno() {
		return drivinglicno;
	}
	public void setDrivinglicno(String drivinglicno) {
		this.drivinglicno = drivinglicno;
	}
	@Override
	public String toString() {
		return "Family [id=" + id + ", aadharno=" + aadharno + ", passportno=" + passportno + ", drivinglicno="
				+ drivinglicno + "]";
	}
	
	
}
