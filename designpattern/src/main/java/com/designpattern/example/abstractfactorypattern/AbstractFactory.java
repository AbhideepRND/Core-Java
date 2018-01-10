package com.designpattern.example.abstractfactorypattern;

import com.designpattern.example.factorypattern.classObj.IClass;

public class AbstractFactory {

	public static IClass getFactoryClass(AbstractFactoryPattern pattern){
		return pattern.getAbstarctClass();
	}
}
