package com.designpattern.example.factorypattern;

import com.designpattern.example.factorypattern.classObj.IClass;

/**
 * 
 * Factory class structure 
 *
 */
public interface IFactoryDesign {

	IClass getFactoryClass(FactoryInd ind);
}
