package com.designpattern.example.prototypepattern;

public class Luxuary extends Car{

	public Luxuary(String name) {
		super(name);
	}

	@Override
	public String getCarName() {
		return name;
	}
	
}
