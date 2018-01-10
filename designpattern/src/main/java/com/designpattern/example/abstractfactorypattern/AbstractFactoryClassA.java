package com.designpattern.example.abstractfactorypattern;

import com.designpattern.example.factorypattern.classObj.ClassA;
import com.designpattern.example.factorypattern.classObj.IClass;

public class AbstractFactoryClassA implements AbstractFactoryPattern{

	public IClass getAbstarctClass() {
		// TODO Auto-generated method stub
		return new ClassA();
	}
	
}
