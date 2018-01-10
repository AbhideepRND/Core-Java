package com.designpattern.example.abstractfactorypattern;

import com.designpattern.example.factorypattern.classObj.ClassB;
import com.designpattern.example.factorypattern.classObj.IClass;

public class AbstractFactoryClassB implements AbstractFactoryPattern{

	public IClass getAbstarctClass() {
		// TODO Auto-generated method stub
		return new ClassB();
	}

	
}
