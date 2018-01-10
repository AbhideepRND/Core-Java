package com.designpattern.example.builderfactory.factorypattern;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class XMLFileReaderImpl implements IFileReader{

	Properties prop = new Properties();
	
	public Properties getProperty(String filename) throws IOException {
		final FileInputStream fileInput = new FileInputStream(new File(filename));
		final Properties properties = new Properties(); 
		properties.loadFromXML(fileInput);
		fileInput.close();

		final Enumeration enuKeys = properties.keys();
		while (enuKeys.hasMoreElements()) {
			String key = (String) enuKeys.nextElement();
			String value = properties.getProperty(key);
			prop.setProperty(key, value);
		}
		return prop;
	}

	
}
