package com.designpattern.example.factorypattern;

import com.designpattern.example.factorypattern.classObj.ClassA;
import com.designpattern.example.factorypattern.classObj.ClassB;
import com.designpattern.example.factorypattern.classObj.IClass;

/**
 * 
 * Factory class implementation 
 *
 */
public class FactoryDesignImpl implements IFactoryDesign{

	public IClass getFactoryClass(FactoryInd ind) {
	
		if(ind.equals(FactoryInd.ClassA)){
			return new ClassA();
		}	
		
		if(ind.equals(FactoryInd.ClassB)){
			return new ClassB();
		}
		
		return null;
	}

	
}
