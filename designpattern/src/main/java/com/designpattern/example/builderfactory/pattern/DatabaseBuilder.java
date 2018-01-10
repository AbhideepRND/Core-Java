package com.designpattern.example.builderfactory.pattern;

import java.io.IOException;

import com.designpattern.example.builderfactory.DatabasePropertyFile;
import com.designpattern.example.builderfactory.DatabasePropertyFile.DatabaseType;
import com.designpattern.example.builderfactory.factorypattern.IFactoryPattern;

public abstract class DatabaseBuilder {

	protected DatabasePropertyFile dataProp;
	
	public DatabasePropertyFile getDataProp() {
		return dataProp;
	}
	public void createDataProp() {
		dataProp = new DatabasePropertyFile();
	}
	
	public abstract void setDataType(DatabaseType dataType); 
	public abstract void readPropertyFile(String fileName,IFactoryPattern factory) throws IOException;

	
}
