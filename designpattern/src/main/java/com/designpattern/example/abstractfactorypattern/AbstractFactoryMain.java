package com.designpattern.example.abstractfactorypattern;

import com.designpattern.example.factorypattern.classObj.IClass;

public class AbstractFactoryMain {

	public static void main(String[] args) {
		IClass factoryClass = AbstractFactory.getFactoryClass(new AbstractFactoryClassA());
		
	}
}
