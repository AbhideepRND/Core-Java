package com.designpattern.example.builderfactory.factorypattern;

import com.designpattern.example.builderfactory.FileType;

public class FactoryPatternImpl implements IFactoryPattern{

	public IFileReader getFileProp(String filename, FileType type) {

		if(FileType.XML.equals(type)){
			return new XMLFileReaderImpl();
		}
		else{
			return new PropertyFileReaderImpl();	
		}
	}

}
