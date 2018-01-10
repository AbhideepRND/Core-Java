package com.designpattern.example.builderfactory;

import java.io.IOException;

import com.designpattern.example.builderfactory.DatabasePropertyFile.DatabaseType;
import com.designpattern.example.builderfactory.factorypattern.FactoryPatternImpl;
import com.designpattern.example.builderfactory.factorypattern.IFactoryPattern;
import com.designpattern.example.builderfactory.pattern.DatabaseBuilder;
import com.designpattern.example.builderfactory.pattern.ReadPropertyDatabaseProperty;
import com.designpattern.example.builderfactory.pattern.ReadXMLDatabaseProperty;

public class MainBuilderProperty {

	public static void main(String[] args) throws IOException {
		DatabaseBuilder builder = new ReadPropertyDatabaseProperty();
		builder.createDataProp();
		builder.setDataType(DatabaseType.mysql);
		IFactoryPattern pattern = new FactoryPatternImpl();
		builder.readPropertyFile("D:/Study Doc/config.properties", pattern);
		DatabasePropertyFile dataProp = builder.getDataProp();
		System.out.println(dataProp.getDatabaseUrl());
		
		DatabaseBuilder builder2 = new ReadXMLDatabaseProperty();
		builder2.createDataProp();
		builder2.setDataType(DatabaseType.oracle);
		builder2.readPropertyFile("D:/Study Doc/config.xml", pattern);
		DatabasePropertyFile dataProp1 = builder2.getDataProp();
		System.out.println(dataProp1.getDatabaseUrl());
		
		
	}
}
