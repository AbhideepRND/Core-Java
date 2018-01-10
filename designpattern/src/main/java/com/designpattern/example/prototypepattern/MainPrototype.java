package com.designpattern.example.prototypepattern;


public class MainPrototype {

	public static void main(String[] args) throws CloneNotSupportedException {
		final PrototypeCapable p =new Person();
		PrototypeCapable clone = p.clone();
	}
}
