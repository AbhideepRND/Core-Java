package com.designpattern.example.bridgepattern;

public class PersonEntity extends Audit{
	
	private String name;
	private String dept;
	
	public PersonEntity(String username) {
		super.setUser(username);
	}
	public PersonEntity(){ 
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
}

