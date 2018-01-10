package com.designpattern.example.prototypepattern;

public abstract class Car {

	protected String name;
	
	public Car(String name){
		this.name = name;
	}
	
	public abstract String getCarName();
}
