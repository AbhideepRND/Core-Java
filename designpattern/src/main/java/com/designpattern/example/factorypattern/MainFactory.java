package com.designpattern.example.factorypattern;

import com.designpattern.example.factorypattern.classObj.IClass;

public class MainFactory {

	public static void main(String[] args) {
		IFactoryDesign d= new FactoryDesignImpl();
		IClass factoryClass = d.getFactoryClass(FactoryInd.ClassA);
		System.out.println(factoryClass.getMessage());
	}

}
