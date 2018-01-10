package com.designpattern.example.prototypepattern;

public class Person implements PrototypeCapable{

	@Override
	public PrototypeCapable clone() throws CloneNotSupportedException {
		return (PrototypeCapable) super.clone();
	}

	
}
