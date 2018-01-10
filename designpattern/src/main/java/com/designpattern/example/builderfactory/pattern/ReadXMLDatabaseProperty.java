package com.designpattern.example.builderfactory.pattern;

import java.io.IOException;
import java.util.Properties;

import com.designpattern.example.builderfactory.DatabasePropertyFile.DatabaseType;
import com.designpattern.example.builderfactory.FileType;
import com.designpattern.example.builderfactory.factorypattern.IFactoryPattern;
import com.designpattern.example.builderfactory.factorypattern.IFileReader;

public class ReadXMLDatabaseProperty extends DatabaseBuilder{

	@Override
	public void setDataType(DatabaseType dataType) {
		dataProp.setDataType(dataType);
	}

	@Override
	public void readPropertyFile(String fileName, IFactoryPattern factory) throws IOException {
		final IFileReader fileProp = factory.getFileProp(fileName, FileType.XML);
		final Properties property = fileProp.getProperty(fileName);
		dataProp.setConnectionUrl(property.getProperty("connectionUrl"));
		dataProp.setDatabase(property.getProperty("database"));
		dataProp.setPort(property.getProperty("port"));
		
		
		
	}

	
}

