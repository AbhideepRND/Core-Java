package com.designpattern.example.builderfactory.factorypattern;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReaderImpl implements IFileReader{

	final Properties prop = new Properties();
	
	public Properties getProperty(String filename) throws IOException {
		InputStream input = new FileInputStream(filename);
		prop.load(input);
		return prop;
	}

	
}
